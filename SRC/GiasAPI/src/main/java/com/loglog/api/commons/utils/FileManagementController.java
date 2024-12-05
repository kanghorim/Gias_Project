package com.loglog.api.commons.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.jpeg.JpegDirectory;

@Controller
public class FileManagementController {
    
	/*
    @Value("#{server['repository.path.admin']}")
    private String REPOSITORY_PATH_ADMIN;
    @Value("#{server['repository.path.user']}")
    private String REPOSITORY_PATH_USER;
    @Value("#{server['repository.path.mobile']}")
    private String REPOSITORY_PATH_MOBILE;
    @Value("#{config['upload.summernote.path']}")
    private String SUMMERNOTE_PATH;
    @Value("#{config['server.url.img']}")
    private String SERVER_URL_IMG;
	 */
    
    
    /**
     * 리스트 파일 처리
     * @param request
     * @param flag
     * @param rootPath
     * @param path
     * @return
     * @throws Exception
     */
    /*
    public static List<FileBean> handleFileUploadList(HttpServletRequest request, String path, String serverUrl) throws Exception {
        MultipartHttpServletRequest mhsRequest = (MultipartHttpServletRequest)request;
        MultiValueMap<String, MultipartFile> mv = mhsRequest.getMultiFileMap();
        Iterator<String> keys = mv.keySet().iterator();
        List<FileBean> listFileBean = new ArrayList<FileBean>();
        int flag = 1;
        while( keys.hasNext() ) {
            
            String key = keys.next(); 
            List<MultipartFile> mpfList = mv.get(key);
            for(MultipartFile mpf : mpfList) {
                if(mpf.getBytes().length > 0) {
                    FileBean fileBean = new FileBean();
                    fileBean.setFileCnt(flag);
                    fileBean.setFileOriginName(mpf.getOriginalFilename());
                    fileBean.setFileSize(Integer.toString(mpf.getBytes().length));
                    fileBean.setContentType(mpf.getContentType());
                    //파일 업로드 처리
                    Map<String, Object> map = uploadFile(mpf, path, serverUrl);
                    fileBean.setFileName(map.get("fileName").toString());
                    fileBean.setFilePath(path + "/" + map.get("filePath"));
                    fileBean.setMFile(mpf);
                    listFileBean.add(fileBean);
                }
                
            }
            flag++;
        }
                
        return listFileBean;
    }
    
    /**
     * 리스트 파일 처리
     * @param request
     * @param flag
     * @param rootPath
     * @param path
     * @return
     * @throws Exception
     */
    /*
    public static List<FileBean> handleFileUploadList(HttpServletRequest request, String path, List<String> fileNameList, String reqName, String serverUrl) throws Exception {
        MultipartHttpServletRequest mhsRequest = (MultipartHttpServletRequest)request;
        MultiValueMap<String, MultipartFile> mv = mhsRequest.getMultiFileMap();
        Iterator<String> keys = mv.keySet().iterator();
        List<FileBean> listFileBean = new ArrayList<FileBean>();
        int flag = 1;
        while( keys.hasNext() ) {
            String key = keys.next(); 
            List<MultipartFile> mpfList = mv.get(key);
            reqName = reqName.replace(Constants.FILE_FORM_NAMES,"");
            if(!reqName.equals(key) && !key.contains(reqName)) {
                flag++;
                continue;
            }
            for(MultipartFile mpf : mpfList) {
                for(String name : fileNameList) {
                    if(mpf.getBytes().length > 0 && mpf.getOriginalFilename().equals(name)) {
                        FileBean fileBean = new FileBean();
                        fileBean.setFileCnt(flag);
                        fileBean.setFileOriginName(mpf.getOriginalFilename());
                        fileBean.setFileSize(Integer.toString(mpf.getBytes().length));
                        fileBean.setContentType(mpf.getContentType());
                        //파일 업로드 처리
                        Map<String, Object> map = uploadFile(mpf, path, serverUrl);
                        fileBean.setFileName(map.get("fileName").toString());
                        fileBean.setFilePath(path + "/" + map.get("filePath"));
                        fileBean.setMFile(mpf);
                        fileBean.setFileType(Integer.toString(flag));
                        listFileBean.add(fileBean);
                    }
                }
                
            }
            
        }
        
        return listFileBean;
    }
    
    /**
     * 단건 파일 업로드 처리
     * @param request
     * @param rootPath
     * @param path
     * @return
     * @throws Exception
     */
    /*
    public static FileBean handleFileUploadOne(HttpServletRequest request, String path, String serverUrl) throws Exception{
        FileBean fileBean = new FileBean();
        try {
            MultipartHttpServletRequest mhsRequest = (MultipartHttpServletRequest)request;          // 해당 request를 파일 request로 변환
            MultiValueMap<String, MultipartFile> mv = mhsRequest.getMultiFileMap();                 // multipartfile만 맵에 담는다.
            Iterator<String> keys = mv.keySet().iterator();                                         // 해당 맵의 key들만 담는다.
            while( keys.hasNext() ) {
                String key = keys.next();                                                   // 키값
                List<MultipartFile> mpfList = mv.get(key);                                  // 키값으로 파일 리스트 추출
                for(MultipartFile mpf : mpfList) {
                    if(mpf.getBytes().length > 0) {
                        fileBean.setFileCnt(1);                                             // 파일 순번(단일 파일 업로드 이므로 순서는 무조건 1이다)
                        fileBean.setFileOriginName(mpf.getOriginalFilename());              // 원본 파일 명 세팅
                        fileBean.setFileSize(Integer.toString(mpf.getBytes().length));      // 파일 크기(바이트)
                        fileBean.setContentType(mpf.getContentType());                      // 파일 형식
                        
                        Map<String, Object> map = uploadFile(mpf, path, serverUrl);            // 파일 업로드
                        fileBean.setFileName(map.get("fileName").toString());               // 파일명
                        fileBean.setFilePath(path + "/" + map.get("filePath"));             // 파일 경로
                        fileBean.setMFile(mpf);                                             // multipart파일 세팅
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return fileBean;
    }
    
    /**
     * 넘겨진 파일과 경로로 해당 경로에 파일을 업로드 하는 메서드
     * @param mFile
     * @param path
     * @return
     * @throws Exception
     */
    public static Map<String, Object> uploadFile(MultipartFile mFile, String path, String serverUrl) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        
        try {
            SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );             // 날짜 포멧
            Date currentTime = new Date ();                                                             // 현재 날짜 세팅
            String nowDate = formatter.format ( currentTime );                                          // 현자 날짜를 포멧에 맞춰서 변환
            String originFileName = mFile.getOriginalFilename();                                        // 실제 파일 이름
            String fileExt = mFile.getOriginalFilename()
                    .substring( mFile.getOriginalFilename().lastIndexOf(".")+1  );      // 확장자
            String fileName = UUID.randomUUID().toString()+"."+fileExt;                                 // 실제 경로에 저장될 임의의 파일명 세팅
            String uploadPath = path + "/" + nowDate + "/";                                             // 실제 저장 경로
            
            // 파일 서버로 전송
            HttpUtil.sendMultipart2Post(serverUrl+"/file/getFile?uploadPath="+uploadPath+"&fileName="+fileName, mFile);
            byte[] bytes = mFile.getBytes();                                                            // 파일 크기
            
            map.put("fileOriginName", originFileName);                                                  // 파일 원본 명
            map.put("filePath"      , nowDate + "/");                                                   // 파일 저장 경로
            map.put("fileSize"      , bytes.length);                                                    // 파일 크기
            map.put("fileName"      , fileName);                                                        // 저장될 파일 명
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
            
        
        return map;
    }
    
    /**
     * 넘겨진 경로와 이름으로 파일을 찾아 해당 이름으로 다운로드 하는 메서드
     * @param mav
     * @param path
     * @param originName
     * @return
     * @throws Exception
     */
    /*
    @RequestMapping("/downloadFile")
    public ModelAndView downloadFile(ModelAndView mav, String path, boolean isDelete) throws Exception{
        path = URLDecoder.decode(path, "UTF-8");                // 인코딩 된 url을 다시 decoding한다.
        String[] names = path.split("&");                       // 해당 경로값 중 파라미터 인자값을 빼오기 위해 &로 구분하여 나눈다.
        if(names.length > 0) {                                  // 값이 있다면
            path = names[0];                                    // 경로는 제일 처음에 있으므로
            String originName = null;
            String type=null;
            for(int i=0; i< names.length; i++) {
                for(int j=0; j<names.length; j++) {
                    if(names[i].startsWith("originName")) {             // 원본파일 명이 있다면
                        String originNames[] = names[i].split("=");     // url 파라미터가 ? = ? 으로 매칭되기 때문에 =을 구분자로 나눈다.
                        if(originNames.length > 1) {                    // 값이 없는 채로 들어올 수 있으므로 길이값을 체크한다.정상적이라면 length 는 2
                            originName = originNames[1];                // 두번째 값이 value이므로 배열의 두번째값을 원본파일 명에 세팅
                            continue;
                        }
                    }else if(names[i].startsWith("type")) {             // 해당 타입을 정해준다.
                        String types[] = names[i].split("=");           // url 파라미터가 ? = ? 으로 매칭되기 때문에 =을 구분자로 나눈다.
                        if(types.length > 1) {                          // 값이 없는 채로 들어올 수 있으므로 길이값을 체크한다.정상적이라면 length 는 2
                            type = types[1];                            // 두번째 값이 value이므로 배열의 두번째값을 해당 타입에 세팅
                            continue;
                        }
                    }
                }
            }
            
            if(Constants.SERVER_ADMIN.equals(type)) {                   // 관리자
                path = REPOSITORY_PATH_ADMIN + path;
            }else if(Constants.SERVER_MOBILE.equals(type)) {            // 모바일
                path = REPOSITORY_PATH_MOBILE + path;
            }else if(Constants.SERVER_USER.equals(type)){               // user 가 default
                path = REPOSITORY_PATH_USER + path;
            }
            
            File downloadFile = new File(path);                         // 다운로드 할 파일을 세팅
            
            mav.setViewName("download");                                // 스프링 viewResolver가 찾아갈 bean명을 선언
            mav.addObject("downloadFile", downloadFile);                // 다운로드할 파일도 넘겨준다.
            mav.addObject("fileName", originName);                      // 다운로드 할 때 세팅할 이름을 정해준다.
            if(isDelete) {                                              // 삭제 여부
                mav.addObject("isDelete",true);                         // 삭제 여부를 정해주면 해당 클래스가 실행 될때 thread가 돌며 정해진 시간 이후에 해당 파일을 삭제한다.
            }
            
        }
        
        return mav;
    }
    
    /**
     * 해당 파일을 이동 시켜주는 메서드
     * @param originFilePath
     * @param copyFilePath
     * @return
     */
    public static boolean copyAndRename(String originFilePath, String copyFilePath) throws Exception {
        boolean result = true;
        File oriFile = new File(originFilePath);            // 원본 파일
        File copyFile = new File(copyFilePath);             // 복사 파일
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            if(copyFile.exists()) {                         // 해당 경로에 파일이 있다면 복사 파일이 해당 경로에 들어가야 하므로 
                //deleteFile(copyFilePath);                   // 해당 파일을 삭제 시킨다.
            }
            fis = new FileInputStream(oriFile);             // 원본 파일을 읽어 들인다.
            fos = new FileOutputStream(copyFile);
            int fileByte = 0;
            while((fileByte = fis.read()) != -1 ){          // 원본파일을 끝까지 읽어 들인다.
                fos.write(fileByte);                        // 복사할 곳에 쓴다.
            }
        } catch (Exception e ) {
            e.printStackTrace();
            result = false;
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
        
        return result;
    }
    
    /**
     * 넘겨진 파라미터로 파일을 찾아 삭제하는 메서드
     * @param file
     * @return
     * @throws Exception
     */
    public static boolean deleteFile(String file, String serverUrl) throws Exception{
        boolean result = false;
        result = HttpUtil.requestGetUrl(serverUrl + "/file/deleteFile?file="+file);
        return result;
    }
    
    /*
    @RequestMapping("/file/deleteFile")
    public void deleteRequestFile(String file) throws Exception {
        File deleteFile = new File(REPOSITORY_PATH_ADMIN+file);
        if(deleteFile.exists()) {
            deleteFile.delete();
        }
    }
    
    /**
     * summernote 파일 업로드 기능
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    /*
    @RequestMapping("/summernote/uploadFile")
    @ResponseBody
    public Map<String, Object> uploadFile( MultipartFile file, HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        
        UUID uuid = UUID.randomUUID();

        // 업로드할 파일 이름
        String org_filename = file.getOriginalFilename();
        String str_filename = uuid.toString() + org_filename;
        
        String filepath = REPOSITORY_PATH_USER + SUMMERNOTE_PATH + File.separator + str_filename;
        System.out.println();
        File f = new File(filepath);
        if (!f.exists()) {
            f.getParentFile().mkdirs();
            if(!f.exists()) {
                f.mkdirs();
            }
        }
        file.transferTo(f);
        map.put("img_name", SUMMERNOTE_PATH + File.separator + str_filename);
        return map;
    }
    
    /**
     * 파일 서버 담당하는 메서드(요청된 파일 저장)
     * @param request
     * @param uploadPath
     * @param fileName
     * @throws Exception
     */
    /*
    @RequestMapping("/file/getFile")
    public void getFiles(MultipartHttpServletRequest request, String uploadPath,String fileName) throws Exception {
    	
    	System.out.println("======================> Start(FileManagementController) /file/getFile <=========================");
    	
        Iterator<String> keys = request.getFileNames();
        while(keys.hasNext()) {
            MultipartFile mpf = request.getFile(keys.next());
            if(mpf.getSize() > 0) {
                //if(mpf.getSize() > 1048576) { //1MB
            	//if(mpf.getSize() > 700000) { //700KB
            		//reSizeImg(mpf, fileName, REPOSITORY_PATH_ADMIN + uploadPath, 0, 0);
            	//}else {
                    File file = new File(REPOSITORY_PATH_ADMIN + uploadPath + fileName);
                    if(file.getParentFile().mkdirs()) { 
                        try { 
                            file.createNewFile();
                        }catch(IOException e) { 
                            e.printStackTrace(); 
                            throw e; 
                        }
                    }
                    try {
                        mpf.transferTo(file); 
                        
                        reSizeImg(file, fileName, REPOSITORY_PATH_ADMIN + uploadPath, 0, 0);
                    }catch (Exception e) { 
                        e.printStackTrace(); 
                        throw e;
                    }
                }
            //}
        }//end while
        
        System.out.println("======================> End(FileManagementController) /file/getFile <=========================");
    }
    
    /**
     * 파일을 덮어쓴다.
     * (크롭이나, 로테이트등 기존 파일에 변화가 있을때 사용됨) 
     */
    /*
    @RequestMapping("/file/overWriteFiles")
    @ResponseBody
    public Map<String, Object> overWriteFiles(MultipartHttpServletRequest request) throws Exception {
    	Map<String, Object> rtnMap = new HashMap<String, Object>();
    	List<FileMngBean> resultList = new ArrayList<FileMngBean>();
    	
    	System.out.println("======================> Start /file/overWriteFiles <=========================");
    	
        Iterator<String> keys = request.getFileNames();
        while(keys.hasNext()) {
            MultipartFile mpf = request.getFile(keys.next());
            if(mpf.getSize() > 0) {
            	try {
            		String filePathInfo = URLDecoder.decode(mpf.getName(), "UTF-8");
            		String fileNameInfo = mpf.getOriginalFilename();            		
            		System.out.println("filePathInfo: " + filePathInfo);
            		System.out.println("fileNameInfo: " + fileNameInfo);
            		String query = filePathInfo.split("\\?")[1];
                    final Map<String, String> map = Splitter.on('&').trimResults().withKeyValueSeparator('=').split(query);
                    System.out.println(map);
            		
                    //파일 덮어쓰기 작업
            		String fileOverwritePath = REPOSITORY_PATH_ADMIN + map.get("path"); //실제 서버상의 물리적 경로
            		System.out.println("fileOverwritePath: " + fileOverwritePath);
            		File file = new File(fileOverwritePath);
                    mpf.transferTo(file);
                    
                    //DB상의 변경된 파일 사이즈도 update 한다.
                    FileMngBean fmb = new FileMngBean();
                    int width = 0, height = 0;
                    try {
                    	width = Integer.parseInt(map.get("w"));
                    }catch(Exception e) {e.printStackTrace();}
                    try {
                    	height = Integer.parseInt(map.get("h"));
                    }catch(Exception e) {e.printStackTrace();}
                    
                    //화면으로부터 요청온 이미지 사이즈로 강제로 리사이즈 시킨다.(단, 값이 0보다 클경우만)
                    String reFilePath = fileOverwritePath.replaceAll(file.getName(), "");
                    long fileSize = reSizeImg(file, file.getName(), reFilePath, width, height);
                    fmb.setFileName(file.getName());
                    fmb.setFileSize(fileSize+"");
                    fmb.setFilePath(map.get("path"));
                    fileMngDao.updateFileSizeWithFileName(fmb);
                    
                    //덮어쓰기에 성공한 파일목록 작성
                    resultList.add(fmb);
                }catch (Exception e) { 
                    e.printStackTrace(); 
                    throw e;
                }
            }
        }
        
        System.out.println("======================> End /file/overWriteFiles <=========================");
        
        rtnMap.put("resultList", resultList);
        rtnMap.put(Constants.RESULT, Constants.OK);
        rtnMap.put(Constants.RESULT_MSG, "파일을 성공적으로 OverWrite 하였습니다.");
        return rtnMap;
    }
    */
    
    public File reSizeImg(MultipartFile mFile, String fileName, String filePath, int width, int height) throws IOException {        
        File file = CommonUtils.multipartToFile(mFile);
        File files = reSizeImg(file, fileName, filePath, width, height);
        return files;
    }
    
    public File reSizeImg(File file, String fileName, String filePath, int width, int height) throws IOException {
        String imgFormat = fileName.substring(fileName.lastIndexOf(".") + 1);
                
        Image image;
        int w = 0;
        int h = 0;
        long resizedFileSize = 0;
        final int CUT_VAL = 300;
        File resizedFile = new File("");
        
        try {
            image = ImageIO.read(file);
            final int imageWidth = image.getWidth(null);
            final int imageHeight = image.getHeight(null);
            
            //width 또는 height 값이 1920px 넘을때만 리사이징 작업을 한다.
            if( (width == 0 && height == 0) && (imageWidth < CUT_VAL && imageHeight < CUT_VAL) ) {
            	return file;
            }
                        
            //가로가 큰지, 세로가 큰지, 같은지를 계산한다
            if(imageWidth > imageHeight) { //가로가 크다 
            	w = CUT_VAL;
            	h = (int)Math.ceil( (imageHeight * w) / imageWidth ); 
            }
            else if(imageHeight > imageWidth) { //세로가 크다
            	h = CUT_VAL;
            	w = (int)Math.ceil( (imageWidth * h) / imageHeight );
            }
            else { //같다
            	w = imageWidth - CUT_VAL;
            	h = imageHeight - CUT_VAL;
            }
            
            //사용자가 지정한 이미지 사이즈로 강제 변환한다.
            if(width > 0) {
            	w = width;
            }
            if(height > 0) {
            	h = height;
            }
            
            System.out.println("Original Image ==> W:" + imageWidth + ", H:" + imageHeight + " ***Resized Image ==> W:" + w + ", H:" + h);
                        
            // 이미지 리사이즈
            // Image.SCALE_DEFAULT : 기본 이미지 스케일링 알고리즘 사용
            // Image.SCALE_FAST    : 이미지 부드러움보다 속도 우선
            // Image.SCALE_REPLICATE : ReplicateScaleFilter 클래스로 구체화 된 이미지 크기 조절 알고리즘
            // Image.SCALE_SMOOTH  : 속도보다 이미지 부드러움을 우선
            // Image.SCALE_AREA_AVERAGING  : 평균 알고리즘 사용
            Image resizeImage = image.getScaledInstance(w, h, Image.SCALE_REPLICATE);
 
            // 새 이미지  저장하기
            BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            
            Graphics g = newImage.getGraphics();
            
            g.drawImage(resizeImage, 0, 0, null);
            g.dispose();
            File transFile = new File(filePath+ fileName);
            if(transFile.getParentFile().mkdirs()) {
                transFile.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(filePath+fileName);
            ImageIO.write(newImage, imgFormat, out);
            out.close();
            
            resizedFile = new File(filePath+fileName);
            resizedFileSize = resizedFile.length();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resizedFile;
    }
    
    /**
     * 이미지 리사이즈 & 리사이즈시 돌아가는 문제 수정
     * @param file
     * @param fileName
     * @param filePath
     * @param maxWidth
     * @param maxHeight
     * @return
     * @throws Exception
     */
    public static File reSizeImgAndRotate(File file, String fileName, String filePath, int maxWidth, int maxHeight) throws Exception {
    	//파일을 읽는다.
    	String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
    	
    	// 원본 파일의 Orientation 정보를 읽는다.
    	int orientation = 1; // 회전정보, 1. 0도, 3. 180도, 6. 270도, 8. 90도 회전한 정보
    	Metadata metadata; // 이미지 메타 데이터 객체
    	Directory directory; // 이미지의 Exif 데이터를 읽기 위한 객체
    	JpegDirectory jpegDirectory; // JPG 이미지 정보를 읽기 위한 객체
     
    	try {
    		metadata = ImageMetadataReader.readMetadata(file);
    		directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
    		jpegDirectory = metadata.getFirstDirectoryOfType(JpegDirectory.class);
    		if(directory != null){
    			orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION); // 회전정보
    		}
     
    	}catch (Exception e) {
    		e.printStackTrace();
    		orientation=1;
    	}
     
    	//imageFile
    	BufferedImage srcImg = ImageIO.read(file);
    	// 회전 시킨다.
    	switch (orientation) {
    	case 6:
    		srcImg = Scalr.rotate(srcImg, Scalr.Rotation.CW_90, null); 
    		break;
    	case 1:
    		break;
    	case 3:
    		srcImg = Scalr.rotate(srcImg, Scalr.Rotation.CW_180, null);
    		break;
    	case 8:
    		srcImg = Scalr.rotate(srcImg, Scalr.Rotation.CW_270, null);
    		break;
    	default:
    		orientation=1;
    		break;
    	}
     
    	BufferedImage destImg = Scalr.resize(srcImg, maxWidth, maxHeight);
    	// 썸네일을 생성하여 저장, 파일명 뒤에 _THUMB 추가
    	File thumbFile = new File(filePath+fileName);
    	ImageIO.write(destImg, fileExt, thumbFile);
    	
    	return thumbFile;
    }
    
    public static File multipartToFile(MultipartFile mFile) throws Exception {
    	//----------------------> 파일 사이즈 줄인다. Start <-----------------------------//
		String fileOrgName = mFile.getOriginalFilename();// 섬네일 원본 파일 명
		String imgTempPath = System.getProperty("catalina.base") + "/temp/";
		
		//if(profileFile.getSize() > 1048576) { //1MB
		File file = new File(imgTempPath + fileOrgName);
		if(file.exists()) {
			file.delete();
			file = new File(imgTempPath + fileOrgName);
	    }
        if(file.getParentFile().mkdirs()) {
            try {
                file.createNewFile();
            }catch(IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
        
        try {
        	mFile.transferTo(file);
            
        	return file;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
		//----------------------> 파일 사이즈 줄인다. End <-----------------------------//
    }
    
}
