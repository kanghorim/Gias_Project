package com.loglog.api.commons.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 상품 마스터 이미지 파일 유틸 함수
 * @author martin
 *
 */
public class FileProductImgUtil {
		
	/**
	 * 파일목록들을  폴더로 이동 처리 
	 * upload경로path 리턴
	 */
	// repositoryPath : /Users/martin/Documents/workspaceMeatoB/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/MeatToBAdmin
	// tempFolder : /product_img_temp
	// targetFilePaths : /product_img_temp/20160728/9e2783fe-0593-4bd9-9111-48bf0ce19f78.jpg
	
	public static List<String> moveTempFileToUploadFolder(String repositoryPath , String uploadFolderPath
												, String subUploadFolderName , List<String> targetFilePathList) throws IOException{
		
		List<String> uploadFiles = new ArrayList<String>();
		String moveFilePath = "";
		
		for(int i = 0 ; i < targetFilePathList.size() ; ++i){
			moveFilePath = moveFileFolder(repositoryPath, uploadFolderPath, subUploadFolderName, targetFilePathList.get(i));
			
			if(moveFilePath != null){
				uploadFiles.add(moveFilePath);
			}
			
		}//for i
			
		return uploadFiles;
	}

	/**
	 * 파일을 업로드 폴더로 이동 처리 원본 삭제 
	 * upload경로path 리턴
	 */
	public static String moveFileFolder(String repositoryPath , String uploadFolderPath
			, String subUploadFolderName , String targetFilePath) throws IOException{
	
		File fileTemp = null;
		String fullTempFilePath = "";
		
		File fileMove = null;
		String moveFilePath = "";
		String fullMoveFilePath = "";
		
		fullTempFilePath 	= repositoryPath + targetFilePath;
		fileTemp 			= new File(fullTempFilePath);
		moveFilePath		= uploadFolderPath + "/"+ subUploadFolderName + "/"+fileTemp.getName();
		fullMoveFilePath  	= repositoryPath + moveFilePath;
		
		fileMove 		    = new File( fullMoveFilePath);
		
		if(fileTemp.exists() == false) return null;
		
		FileUtils.copyFile(fileTemp, fileMove);
		fileTemp.delete();
		
		return moveFilePath;
		
	}
	
	/**
	 * 상품마스터 이미지 파일을 상품 이미지 폴더로 복사 처리 
	 * 복사된 경로 리턴
	 */
	public static String copyMasterImgFileToProductFolder(String masterImgFullPath , 
															String productRepositoryPath ,
															String productFolderPath , 
															String productId) throws IOException{
		String fullTargetPath = "";
		String targetPath = "";
		File fileMaster = new File(masterImgFullPath);
		File fileProduct  = null;
		
		if(fileMaster.exists() == false) return null;
		
		targetPath = productFolderPath +"/"+ productId+ "/" + fileMaster.getName();
		fullTargetPath = productRepositoryPath + targetPath;
		fileProduct = new File(fullTargetPath);
		
		FileUtils.copyFile(fileMaster, fileProduct);
		
		return targetPath;
		
	}
	
	
	
	/**
	 * 파일 갱신
	 */
	public static void updateUploadFile(String repositoryPath ,String uploadFolderPath,String subUploadFolderName,List<String> targetFilePaths){
		String fullUploadPath = repositoryPath + uploadFolderPath + "/" +subUploadFolderName;
		
		if(StringUtils.isEmpty(subUploadFolderName)) return;
		
		File folder = new File(fullUploadPath);
		if(! folder.exists()){
			return;
		}
		
		String[] fnameList = folder.list();
		int fCnt = fnameList.length;
		String childPath = "";
		boolean isExist = false;
		
		for(int i = 0; i < fCnt; i++) {
			childPath = fullUploadPath+"/"+fnameList[i];
			File f = new File(childPath);
		  
			if(f.isDirectory()) continue; //folder 라면 skip
			isExist = false;
			
			for(int j = 0 ; j < targetFilePaths.size() ; ++j){
				//targetFilePaths 목록에 파일명이 존재 여부 체크
				if( targetFilePaths.get(j).indexOf(f.getName()) >= 0){
					isExist = true;
					break;
				}
				
			}//for j
			
			//targetFilePaths 목록에 없는 파일 이면 삭제
			if(isExist == false){
				f.delete();
			}
	      
		}//for i
	    
		
	}
	
	
	/**
	 * 파일 삭제 
	 * @param imgFiles
	 */
	// targetFilePaths : /1/20160728/9e2783fe-0593-4bd9-9111-48bf0ce19f78.jpg
	public static void deleteUploadFile(String repositoryPath ,List<String> targetFilePaths){
		
		String tempImgPath = "";
		String fullPath = "";
		File fileDelete  = null;
		
		for(int i = 0 ; i < targetFilePaths.size() ; ++i){
			tempImgPath	 = targetFilePaths.get(i);
			fullPath 	 = repositoryPath + tempImgPath;
			fileDelete 	= new File(fullPath);
			if(fileDelete.exists() == false) continue;
			fileDelete.delete();
		}//for i
		
	}
	
	/**
	 * 업로드 폴더 삭제
	 * @param repositoryPath
	 * @param uploadFolderPath
	 * @param subUploadFolderName
	 */
	public static void deleteUploadFolder(String repositoryPath,String uploadFolderPath,String subUploadFolderName) throws Exception {
		
		if(StringUtils.isEmpty(subUploadFolderName)) return;
		
		String fullUploadPath = repositoryPath + uploadFolderPath + "/" +subUploadFolderName;
		File folder = new File(fullUploadPath);
		if (folder.exists()){
			deleteFolder(fullUploadPath);
		}
	}

	/** 자식 요소 삭제후 폴더 삭제 */	
	public static void deleteFolder(String parentPath) throws Exception {
		File file = new File(parentPath);
		String[] fnameList = file.list();
		int fCnt = fnameList.length;
		String childPath = "";

		for(int i = 0; i < fCnt; i++) {
			childPath = parentPath+"/"+fnameList[i];
			File f = new File(childPath);
			if( ! f.isDirectory()) {
				f.delete();   //파일이면 바로 삭제
			} else {
				deleteFolder(childPath);
			}
		}

		File f = new File(parentPath);
		f.delete();   //폴더는 맨 나중에 삭제
	}
	
	
	/** 파일 등록*/
	public static void multipartFileUpload(MultipartFile mf, String fileDir, String fileName) {
		
		File dir = new File(fileDir);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		if (mf != null && !mf.getOriginalFilename().equals("")) {

			//본래 파일명
			String originalfileName = mf.getOriginalFilename();
			System.out.println("원래 이름" + originalfileName);
			//저장되는 파일 이름
			if (!originalfileName.equals("")) {
				File uploadFile = new File(fileDir+"/"+fileName);
				try {
					//파일 저장
					mf.transferTo(uploadFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				} 
			}
			
		}//end if
		
	}
	
	
}
