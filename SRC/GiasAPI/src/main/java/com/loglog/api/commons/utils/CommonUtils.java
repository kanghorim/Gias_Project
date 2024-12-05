package com.loglog.api.commons.utils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

/**
 * 공통사용  Util
 * 
 * @author PCH
 */
public class CommonUtils {

	/**
	 * 자릿수만큼 랜덤숫자 생성 반환한다.
	 * 
	 * @author PCH
	 * @param loopCount 자릿수
	 * @return 자릿수만큼 랜덤숫자 생성 반환
	 */
	public static String getRandomNum(int loopCount){
		String str = "";
		int d = 0;
		for (int i = 1; i <= loopCount; i++){
			Random r = new Random();
			d = r.nextInt(9);
			str = str + Integer.toString(d);
		}
		return str;
	}
	 
	private static final char[] chars;
	
	static {
        StringBuilder buffer = new StringBuilder();
        for (char ch = '0'; ch <= '9'; ++ch)
            buffer.append(ch);
        for (char ch = 'a'; ch <= 'z'; ++ch)
            buffer.append(ch);
        for (char ch = 'A'; ch <= 'Z'; ++ch)
            buffer.append(ch);
        chars = buffer.toString().toCharArray();
    }
 
    /**
     * 자릿수만큼 랜덤 문자열(숫자포함) 생성 및 반환한다
     * @param length 자릿수
     * @return 자릿수만큼 랜덤 문자열 반환
     */
    public static String random(int length) {
        if (length < 1)
            throw new IllegalArgumentException("length < 1: " + length);
 
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
            randomString.append(chars[random.nextInt(chars.length)]);
        }
        return randomString.toString();
    }
    
    /**userId/sellerId 특수문자로 변경*/
	public static String convertEmail(String email) throws Exception{
		String str = "";
		int flag = email.indexOf('@');
		
		for (int i = 0; i < email.length(); i++) {
			if (i<3) {
				str += email.charAt(i);
			}else{
				if (i<flag) {
					str += '*';
				} else if (i==flag) {
					str += '@';
				}else{
					str += email.charAt(i);
				}
			}
		}
		return str;
	}

	/**
	 * 비밀번호 암호화하는 메서드
	 * @author PCH
	 * @param pw 인코딩 전의 비밀번호
	 * @return encodingPassword 인코딩 된 비밀번호
	 */
	public static String encode(String pw) {
		String encodingPassword = BCrypt.hashpw(pw, BCrypt.gensalt());		
		return encodingPassword;
		
	}
	
	/**
	 * 사용자가 입력한 값과 암호화된 비밀번호가 맞는지 확인하는 메서드
	 * @author PCH
	 * @param password 사용자가 입력한 비밀번호
	 * @param hashedPassword 암호화 되어있는 비밀번호
	 * @return true 일치, false 불일치
	 */
	public static Boolean chkPassword(String password, String hashedPassword){
		
		return BCrypt.checkpw(password, hashedPassword);
	}
	
	
	/** 
	 * 카테고리 아이디 자릿수로 카테고리 레벨을 반환한다.
	 * 1레벨 - 1~2자리
	 * 2레벨 - 4~5자리
	 * 3레벨 - 6~7자리
	 * 4레벨 - 8~9자리
	 */
	public static String getCategoryLevel(String categoryId){
		String categoryLevel = "";
		int categoryIdLength = categoryId.length();
		if ( categoryIdLength == 1 || categoryIdLength == 2 ){
			categoryLevel = "1";
		} else if ( categoryIdLength == 4 || categoryIdLength == 5 ){
			categoryLevel = "2";
		} else if ( categoryIdLength == 6 || categoryIdLength == 7 ){
			categoryLevel = "3";
		} else if ( categoryIdLength == 8 || categoryIdLength == 9 ){
			categoryLevel = "4";
		}
		return categoryLevel;
	}
	
	/**
	 * client ip 가져오기
	 * @param request
	 * @return String ip
	 */
	public static String getClientIp(HttpServletRequest request) {  
        
		request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        
		String ip = request.getHeader("X-FORWARDED-FOR");
        
		if (ip == null){
            ip = request.getRemoteAddr();
        }
        
        return ip;
    }
	
	
	/**
	 * 천단위 콤마 표시 반환
	 * @param request
	 * @return String ip
	 */
	public static String getThousandComma(String strVal) {  
        
		if(strVal == null || strVal.length() == 0) return "0";
		
		String strResult = strVal; //출력할 결과를 저장할 변수
        Pattern p = Pattern.compile("(^[+-]?\\d+)(\\d{3})"); //정규표현식 
        Matcher regexMatcher = p.matcher(strVal); 
        
        try {
            //int cnt = 0;
            while(regexMatcher.find()) {
                            
                strResult = regexMatcher.replaceAll("$1,$2"); //치환 : 그룹1 + "," + 그룹2
                
                //System.out.println("과정("+ (++cnt) +"):"+strResult);
                
                //치환된 문자열로 다시 matcher객체 얻기 
                //regexMatcher = p.matcher(strResult); 
                regexMatcher.reset(strResult); 
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strResult;
    }
	
	/**
	 * 이름 가운데 부분만 마스킹 처리 (앞1글자, 제일마지막 1글자는 제외)
	 * @param name
	 * @return string
	 */
	public static String maskingName(String name) {
		
	    if( StringUtils.isNotEmpty(name) ) {
	    	StringBuffer sb = new StringBuffer();
	        for(int i = 0; i < name.length(); i++) {
	        	String str = name.substring(i, i+1);
	        	if(i == 0) {
	        		sb.append(str);
	        	} else if( i+1 == name.length() && name.length() != 2) {
	        		sb.append(str);
	        	} else {
	        		sb.append("*");
	        	}
	        }
	        return sb.toString();
	    } else {
	    	return name;
	    }
	
	}
	
	/**
	 * Object 를 Integer 로 캐스팅 한다.
	 * @param obj
	 * @return Integer
	 */
	public static Integer getCastObject2Int(Object obj) {
		Integer rtnInt = 0;
		
		if(obj == null) return rtnInt;
		try {
			if(obj instanceof String) {
				rtnInt = Integer.parseInt( (String)obj );
			}
			else if(obj instanceof Integer) {
				rtnInt = (Integer)obj;
			}
			else if(obj instanceof Long) {
				rtnInt = (int)((long)obj);
			}
			else if(obj instanceof Float) {
				rtnInt = (int)((float)obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtnInt;
	}

	/**
	 * 
	 * @return
	*/
	public synchronized static boolean getImageUrlVerify(String imgUrl) {
		boolean isBoolRtn = false;
		HttpURLConnection urlConn = null;
		try {
			URL url = new URL(imgUrl);
			URLConnection con = url.openConnection();
			urlConn = (HttpURLConnection)con;
			con.setConnectTimeout(200);
			urlConn.setReadTimeout(200);
			
			int responseCode = urlConn.getResponseCode();
			if(urlConn.getResponseCode() == 200) {
				System.out.println("responseCode: " + responseCode);
				System.out.println("imageUrlVerifyUrl: " + imgUrl);			 
				isBoolRtn = true;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return isBoolRtn;
	}
	
	/**
	 * multipart 파일을 일반 file로 변환
	 * @param file
	 * @author LSG
	 * @return
	 */
	public static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		
		File convFile = new File( multipart.getOriginalFilename());
		
		multipart.transferTo(convFile);
		
		return convFile;
	}
	
}