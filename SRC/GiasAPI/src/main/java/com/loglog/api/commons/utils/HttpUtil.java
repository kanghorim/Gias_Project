package com.loglog.api.commons.utils;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;


public class HttpUtil {


	/**
	 * 객체를 JSON 문자열로 POST 방식으로 전송한다.
	 * @param url
	 * @param object
	 */
	public static void sendObject2Json(String url, Object object) {

		try {
			URL u = new URL(url);
			HttpURLConnection httpCon = (HttpURLConnection) u.openConnection();
			httpCon.setRequestProperty("Content-Type", "application/json; charset=EUC-KR");
			httpCon.setDoOutput(true);
			httpCon.setDoInput(true);
			httpCon.setRequestMethod("POST");
			OutputStream raw = httpCon.getOutputStream();
			//OutputStream buffered = new BufferedOutputStream(raw);
			//OutputStreamWriter out = new OutputStreamWriter(buffered,"UTF-8");
			//OutputStreamWriter out = new OutputStreamWriter(buffered);
			//Object -> JSON
			String jsonStr = new Gson().toJson(object);
			System.out.println("ready to send : " + url);
			System.out.println("converted json data: \n" + jsonStr);
			//전송
			raw.write(jsonStr.getBytes("EUC-KR"));
			raw.flush();
			raw.close();

			// read the response
			System.out.println(httpCon.getResponseCode());
			System.out.println(httpCon.getResponseMessage());

			InputStream in = new BufferedInputStream(httpCon.getInputStream());
			String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
			System.out.println(result);
			in.close();
			httpCon.disconnect();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 객체를 GET 파라미터 형식의 POST 방식으로 전송한다.
	 * @param url
	 * @param object
	 */
	public static void sendObject2Post(String url, Object object) {

		try {
			URL u = new URL(url);
			HttpURLConnection httpCon = (HttpURLConnection) u.openConnection();
			httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpCon.setDoOutput(true);
			httpCon.setDoInput(true);
			httpCon.setRequestMethod("POST");
			OutputStream raw = httpCon.getOutputStream();
			//OutputStream buffered = new BufferedOutputStream(raw);
			//OutputStreamWriter out = new OutputStreamWriter(buffered,"UTF-8");
			//OutputStreamWriter out = new OutputStreamWriter(buffered);
			//Object -> JSON
			String jsonStr = new Gson().toJson(object);
			System.out.println("ready to send : " + url);
			System.out.println("converted json data: \n" + jsonStr);
			
			StringBuilder sb = new StringBuilder();
		    JSONObject json = new JSONObject(jsonStr);
		    Iterator<String> keys = json.keys();
		    //sb.append("?"); //start of query args
		    while (keys.hasNext()) {
		        String key = keys.next();
		        sb.append(key);
		        sb.append("=");
		        sb.append( URLEncoder.encode((String)json.get(key), "EUC-KR") );
		        sb.append("&"); //To allow for another argument.
		    }
		    String queryStr = sb.toString();
			
		    System.out.println( "json to query :" + queryStr );
			
			//전송
			raw.write(queryStr.getBytes("EUC-KR"));
			raw.flush();
			raw.close();

			// read the response
			System.out.println(httpCon.getResponseCode());
			System.out.println(httpCon.getResponseMessage());

			InputStream in = new BufferedInputStream(httpCon.getInputStream());
			String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
			System.out.println(result);
			in.close();
			httpCon.disconnect();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * 객체를 GET 파라미터 형식의 POST 방식으로 전송한다.
	 * @param url
	 * @param object
	 */
	public static void send2PostOrderId(String url, String moduleId, String orderId, String userId) {

		try {
			URL u = new URL(url);
			HttpURLConnection httpCon = (HttpURLConnection) u.openConnection();
			httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpCon.setDoOutput(true);
			httpCon.setDoInput(true);
			httpCon.setRequestMethod("POST");
			OutputStream raw = httpCon.getOutputStream();
			System.out.println("ready to send : " + url);

		    String queryStr = "moduleId=" + moduleId + "&" + "orderId=" + orderId + "&" + "userId=" + userId;
			
		    System.out.println( "json to query :" + queryStr );
			
			//전송
			raw.write(queryStr.getBytes("EUC-KR"));
			raw.flush();
			raw.close();

			// read the response
			System.out.println(httpCon.getResponseCode());
			System.out.println(httpCon.getResponseMessage());

			InputStream in = new BufferedInputStream(httpCon.getInputStream());
			String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
			System.out.println(result);
			in.close();
			httpCon.disconnect();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/**  클라이언트 ip 추출
	PROXY SERVER 또는 LOAD BALANCER를 거치는 경우 ip가 접속하기 직전의 ip로 들어오게 된다.
	PROXY SERVER 또는 LOAD BALANCER를 거칠 경우 reuqest header의 HTTP_X_FORWARDED_FOR 키워드에 정보를 남김으로
	먼저 확인 후 없을 경우 request.getRemoteAddr()로 ip를 추출한다. */
	public static String getClientIp(HttpServletRequest request) throws Exception {
		String ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		if ( StringUtils.isEmpty( ip ) ) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	
    /**
     * multipartfile 전송
     * @param reqUrl
     * @param mFile
     */
    public static void sendMultipart2Post(String reqUrl, MultipartFile mFile) {
        String CrLf = "\r\n";
        String boundary = "--12o90amo23koeq8d";
        try {
            File f = CommonUtils.multipartToFile(mFile);
            // Set up connection to uploading file
            HttpURLConnection con = (HttpURLConnection)(new URL(reqUrl).openConnection());
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setUseCaches(false);
            con.setChunkedStreamingMode(1024);
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);
            
            // data Sending
            DataOutputStream os = new DataOutputStream(con.getOutputStream());
            String header =  "--" + boundary + CrLf
                    + "Content-Disposition: form-data;name=\"uploadedfile\";filename=\""+f.getName()+"\"" + CrLf
                    + "Content-Type: text/plain"+CrLf
                    + CrLf;
            
            os.write(header.getBytes());
            
            FileInputStream uploader = new FileInputStream(f);
            int read_size = 1024;
            int remain_size;
            
            while ((remain_size = uploader.available()) > 0) {
                byte[] read_data;
                read_data = remain_size >= read_size ? new byte[read_size] : new byte[remain_size];
                uploader.read(read_data);
                os.write(read_data);
                os.flush();
            }
            os.write(("--" + boundary + "--" + CrLf).getBytes());
            os.write(("--" + boundary + "--" + CrLf).getBytes());
            os.flush();
            os.close();
            uploader.close();
            
            InputStream is = con.getInputStream();
            StringBuilder response = new StringBuilder();
            byte[] respBuffer = new byte[4096];
            while (is.read(respBuffer) >= 0)
            {
                response.append(new String(respBuffer).trim());
            }
            is.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    public static boolean requestGetUrl(String reqUrl) {
        boolean result = false;
        try {
            URL u = new URL(reqUrl);
            HttpURLConnection httpCon = (HttpURLConnection) u.openConnection();
            httpCon.setRequestProperty("Content-Type", "application/json; charset=EUC-KR");
            httpCon.setDoOutput(true);
            httpCon.setDoInput(true);
            httpCon.setRequestMethod("GET");
            OutputStream raw = httpCon.getOutputStream();
            raw.flush();
            int httpResponseCode = httpCon.getResponseCode();
            if(httpResponseCode == HttpURLConnection.HTTP_OK || httpResponseCode == HttpURLConnection.HTTP_CREATED) {
                result = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}//end class