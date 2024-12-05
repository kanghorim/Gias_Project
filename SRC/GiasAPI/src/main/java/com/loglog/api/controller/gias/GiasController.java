package com.loglog.api.controller.gias;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loglog.api.commons.beans.GiasBean;
import com.loglog.api.commons.beans.SelectGiasListBean;
import com.loglog.api.commons.constants.Constants;
import com.loglog.api.commons.modules.service.gias.GiasService;


@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GiasController {
	@Autowired
	private GiasService giasService;
	
	@Value("${repository.path}")
	private String RESPOSITORY_PATH;
	/**
	 * 로그인 
	 * @param userBean
	 * @param request
	 * @return
	 */
	//안씀
	@RequestMapping(value="/gias/selectGiasDomainAjax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectGiasDomain(GiasBean giasBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "도메인 조회에 실패했습니다.");
		try {
			List<GiasBean> resultList = giasService.selectDomain(giasBean);
			if(giasBean != null) {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "도메인 조회에 성공했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	//안씀
	@RequestMapping(value="/gias/selectGiasPrincipleAjax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectGiasPrinciple(GiasBean giasBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "프린스플 조회에 실패했습니다.");
		try {
			List<GiasBean> resultList = giasService.selectPrinciple(giasBean);
			if(resultList != null && !resultList.isEmpty()) {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "프린스플 조회에 성공했습니다.");
			}else {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "프린스플 데이터가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}

	@RequestMapping(value="/gias/selectGiasStandardAjax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectGiasStandard(SelectGiasListBean selectGiasListBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "스탠다드 조회에 실패했습니다.");
		try {
			List<SelectGiasListBean> resultList = giasService.selectStandardList(selectGiasListBean);
			if(resultList != null && !resultList.isEmpty()) {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "스탠다드 조회에 성공했습니다.");
			}else {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "스탠다드 데이터가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	//안씀
	@RequestMapping(value="/gias/selectGiasEvaluationAjax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectGiasEvaluation(GiasBean giasBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "평가내역 조회에 실패했습니다.");
		try {
			List<GiasBean> resultList = giasService.selectEvaluation(giasBean);
			if(resultList != null && !resultList.isEmpty()) {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "평가내역 조회에 성공했습니다.");
			}else {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "평가내역 데이터가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	
	@RequestMapping(value = "/gias/insertGias", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertGias2(
	        @RequestParam("data") String jsonData,
	        MultipartHttpServletRequest request) { // MultipartHttpServletRequest 사용
	    Map<String, Object> map = new HashMap<>();
	    map.put(Constants.RESULT, Constants.FAIL);
	    map.put(Constants.RESULT_MSG, "품질평가 저장에 실패했습니다.");
	    int resultCnt = 0;
	    try {
	        // JSON 문자열 파싱
	        ObjectMapper objectMapper = new ObjectMapper();
	        List<SelectGiasListBean> giasData = objectMapper.readValue(jsonData, new TypeReference<List<SelectGiasListBean>>() {});

	        for (SelectGiasListBean giasEntry : giasData) {
	        	resultCnt += giasService.insertGias(giasEntry);
	            String evaluationCode = giasEntry.getEvaluationCode();
	            System.out.println("evaluationCode: " + evaluationCode);

	            // 파일 가져오기
	            List<MultipartFile> evaluationFiles = request.getFiles("files[" + evaluationCode + "][]");

	            if (!evaluationFiles.isEmpty()) {
	            	resultCnt += giasService.updateGiasFile(giasEntry, evaluationFiles);
	            } else {
	                System.out.println("No files found for evaluationCode: " + evaluationCode);
	            }
	        }
	        if(resultCnt > 0) {
	        	map.put(Constants.RESULT, Constants.OK);
		        map.put(Constants.RESULT_MSG, "품질평가 저장에 성공했습니다.");
	        }else {
	        	map.put(Constants.RESULT, Constants.FAIL);
		        map.put(Constants.RESULT_MSG, "품질평가 저장에 실패했습니다.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put(Constants.RESULT, Constants.FAIL);
	        map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
	    }
	    return map;
	}
	
	@RequestMapping(value = "/gias/updateGias", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateGias(@RequestParam("data") String jsonData, 
	                                      String checkString, 
	                                      String memberCode,
	                                      MultipartHttpServletRequest request
	                                     ) {
	    
	    Map<String, Object> map = new HashMap<>();
	    map.put(Constants.RESULT, Constants.FAIL);
	    map.put(Constants.RESULT_MSG, "품질평가 수정에 실패했습니다.");
	    int resultCnt = 0;

	    try {
	        // JSON 문자열 파싱
	        ObjectMapper objectMapper = new ObjectMapper();
	        List<SelectGiasListBean> giasData = objectMapper.readValue(jsonData, new TypeReference<List<SelectGiasListBean>>() {});

	        // 저장된 데이터 (기존 평가 데이터)
	        List<String> savedEvaluationCodes = giasService.getSavedMemberOrg(memberCode);
	        //System.out.println("평가원이 저장한 품질평가 목록: " + savedEvaluationCodes);

	        // 새로 받은 데이터와 기존 데이터 비교
	        List<SelectGiasListBean> newEntries = giasData.stream()
	            .filter(entry -> !savedEvaluationCodes.contains(entry.getEvaluationCode())) // 새 데이터
	            .collect(Collectors.toList());

	        List<SelectGiasListBean> updateEntries = giasData.stream()
	            .filter(entry -> savedEvaluationCodes.contains(entry.getEvaluationCode())) // 기존 데이터
	            .collect(Collectors.toList());

	        //System.out.println("새로 삽입할 평가코드 목록: " + newEntries);
	        //System.out.println("수정할 평가코드 목록: " + updateEntries);

	        // 데이터 삽입 및 수정 처리
	        if ("Admin".equals(checkString)) {
	            System.out.println("관리자가 수정함");
	            for (SelectGiasListBean giasEntry : giasData) {
	                resultCnt += giasService.updateGiasAdmin(giasEntry); // 기존 데이터 수정
	            }
	        } else {
	            System.out.println("평가원이 수정함");
	            for (SelectGiasListBean giasEntry : updateEntries) {
	                resultCnt += giasService.updateGiasMember(giasEntry); // 기존 데이터 수정
	            	
	            }
	            
	            if(!newEntries.isEmpty()) {
	            	for (SelectGiasListBean newEntry : newEntries) {
		                resultCnt += giasService.insertGias(newEntry); // 새 데이터 삽입 
		            }
	            }
	  
	        }

	        // 결과 처리
	        if (resultCnt > 0) {
	            map.put(Constants.RESULT, Constants.OK);
	            map.put(Constants.RESULT_MSG, "품질평가 수정에 성공했습니다.");
	        } else {
	            map.put(Constants.RESULT, Constants.FAIL);
	            map.put(Constants.RESULT_MSG, "품질평가 수정에 실패했습니다.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put(Constants.RESULT, Constants.FAIL);
	        map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
	    }
	    return map;
	}
	
	
	@RequestMapping(value = "/gias/updateGiasFile", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateGiasFile(
	        @RequestParam("keepFiles") String keepFilesJson,
	        @RequestParam("organizationCode") String orgCode,
	        MultipartHttpServletRequest request) { 
	    Map<String, Object> map = new HashMap<>();
	    map.put(Constants.RESULT, Constants.FAIL);
	    map.put(Constants.RESULT_MSG, "품질평가 파일수정에 실패했습니다.");
	    int resultCnt = 0;

	    try {
	        // JSON 문자열 파싱
	        ObjectMapper objectMapper = new ObjectMapper();

	        Map<String, List<String>> keepFiles = objectMapper.readValue(keepFilesJson, new TypeReference<Map<String, List<String>>>() {});

	        // 유지할 파일 처리 및 삭제 로직
	        for (Map.Entry<String, List<String>> entry : keepFiles.entrySet()) {
	            String evaluationCode = entry.getKey(); // keepFiles의 키를 evaluationCode로 사용
	            List<String> filesToKeep = entry.getValue();

                // evaluationCode에 할당된 모든 이미지 삭제
                resultCnt += giasService.deleteAllFilePaths(orgCode, evaluationCode);

                // 유지할 파일 경로만 다시 할당 (로직은 추가해야 함)
                resultCnt += giasService.updateFilePath(orgCode,evaluationCode,filesToKeep);

                //System.out.println("유지할 파일 처리 완료: " + filesToKeep);
                
                List<MultipartFile> evaluationFiles = request.getFiles("files[" + evaluationCode + "][]");

	            if (!evaluationFiles.isEmpty()) {
	            	resultCnt += giasService.updateGiasUpdateFile(orgCode,evaluationCode, evaluationFiles);
	            } else {
	                //System.out.println("No files found for evaluationCode: " + evaluationCode);
	            }
	            
	        }

	        if (resultCnt > 0) {
	            map.put(Constants.RESULT, Constants.OK);
	            map.put(Constants.RESULT_MSG, "품질평가 파일수정에 성공했습니다.");
	        } else {
	            map.put(Constants.RESULT, Constants.FAIL);
	            map.put(Constants.RESULT_MSG, "품질평가 파일수정에 실패했습니다.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put(Constants.RESULT, Constants.FAIL);
	        map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
	    }

	    return map;
	}


	
	@RequestMapping(value="/gias/evlOrgList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectGiasOrgList(SelectGiasListBean selectGiasListBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "사용자의 품질평가 데이터 조회에 실패했습니다.");
		try {
			List<GiasBean> resultList = giasService.selectEvlOrg(selectGiasListBean);
			if(resultList != null && !resultList.isEmpty()) {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "사용자의 품질평가 데이터 조회에 성공했습니다.");
			}else {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "사용자의 품질평가 데이터 조회에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	@RequestMapping(value="/gias/adminEvlOrgList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectAdminGiasOrgList(SelectGiasListBean selectGiasListBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "기관의 품질평가 데이터 조회에 실패했습니다.");
		try {
			List<GiasBean> resultList = giasService.selectEvlOrgList(selectGiasListBean);
			if(resultList != null && !resultList.isEmpty()) {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "기관의 품질평가 데이터 조회에 성공했습니다.");
			}else {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "기관의 품질평가 데이터 조회에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}


	
	@RequestMapping(value="/gias/memberApprove", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectMemberApprove(SelectGiasListBean selectGiasListBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "사용자의 품질평가 데이터 조회에 실패했습니다.");
		try {
			List<SelectGiasListBean> resultList = giasService.selectApproveEvaluation(selectGiasListBean);

			if(resultList != null && !resultList.isEmpty()) {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "사용자의 품질평가 데이터 조회에 성공했습니다.");
			}else {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "사용자의 품질평가 데이터 조회에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	
	@RequestMapping(value="/gias/giasAllData", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectOrgApprove(SelectGiasListBean selectGiasListBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "사용자의 품질평가 데이터 조회에 실패했습니다.");
		try {
			List<SelectGiasListBean> resultList = giasService.orgApproveEvaluation(selectGiasListBean);

			if(resultList != null && !resultList.isEmpty()) {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "사용자의 품질평가 데이터 조회에 성공했습니다.");
			}else {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "사용자의 품질평가 데이터 조회에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	@RequestMapping(value = "/gias/download-all-files", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadAllFiles(
	        @RequestParam String organizationCode,
	        HttpServletRequest request) throws Exception {
	    try {
	        // Root directory 설정
	        String rootPath = request.getServletContext().getRealPath("/temp");
	        File tempDir = new File(rootPath);
	        if (!tempDir.exists()) {
	            tempDir.mkdirs(); // 디렉토리 생성
	            System.out.println("임시 디렉토리 생성: " + rootPath);
	        } else {
	            System.out.println("임시 디렉토리 확인: " + rootPath);
	        }

	        // ZIP 파일 생성
	        File zipFile = new File(tempDir, organizationCode + "_files.zip");
	        System.out.println("ZIP 파일 경로: " + zipFile.getAbsolutePath());

	        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
	            List<String> filePaths = giasService.getAllFilePathsForOrganization(organizationCode);
	            System.out.println("파일 경로 리스트: " + filePaths);

	            for (String filePath : filePaths) {
	                if (filePath == null || filePath.trim().isEmpty()) {
	                    System.out.println("무시된 파일 경로: " + filePath);
	                    continue;
	                }

	                // 절대 경로 계산
	                File file = new File(RESPOSITORY_PATH + filePath);
	                System.out.println("절대 경로: " + file.getAbsolutePath() + ", 존재 여부: " + file.exists());
	                if (!file.exists()) {
	                    System.out.println("파일이 존재하지 않습니다: " + file.getAbsolutePath());
	                    continue;
	                }

	                // ZIP 경로 정의
	                String zipEntryName = filePath.startsWith("/") ? filePath.substring(1) : filePath; // ZIP 내 경로 유지
	                System.out.println("ZIP 경로에 추가 중: " + zipEntryName);

	                try (FileInputStream fis = new FileInputStream(file)) {
	                    zos.putNextEntry(new ZipEntry(zipEntryName));
	                    byte[] buffer = new byte[1024];
	                    int length;
	                    int totalBytes = 0; // 파일 크기 확인
	                    while ((length = fis.read(buffer)) > 0) {
	                        zos.write(buffer, 0, length);
	                        totalBytes += length;
	                    }
	                    zos.closeEntry();
	                    System.out.println("ZIP 엔트리에 파일 추가 완료: " + zipEntryName + ", 크기: " + totalBytes + " bytes");
	                } catch (IOException e) {
	                    System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
	                }
	            }
	        } catch (IOException e) {
	            System.err.println("ZIP 파일 생성 중 오류 발생: " + e.getMessage());
	            throw e;
	        }

	        // 최종 ZIP 파일 확인
	        if (zipFile.exists() && zipFile.length() > 0) {
	            System.out.println("ZIP 파일 생성 완료: " + zipFile.getAbsolutePath() + ", 크기: " + zipFile.length());
	        } else {
	            System.err.println("ZIP 파일 생성 실패 또는 빈 파일 생성");
	            throw new IOException("ZIP 파일 생성 실패");
	        }

	        // 파일 다운로드 처리
	        Resource resource = new FileSystemResource(zipFile);
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + zipFile.getName() + "\"")
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .contentLength(zipFile.length())
	                .body(resource);

	    } catch (Exception e) {
	        System.err.println("파일 다운로드 처리 중 오류 발생: " + e.getMessage());
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}


	// zip파일 안에 쓸대없는 경로 제거를 추가한 코드인데 작동안함 일단 기존 로직 유지함
	@RequestMapping(value = "/gias/download-all-files2", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadAllFiles2(
	        @RequestParam String organizationCode,
	        HttpServletRequest request) {
	    try {
	        // Root directory 설정
	        String rootPath = request.getServletContext().getRealPath("/temp");
	        File tempDir = new File(rootPath);
	        if (!tempDir.exists()) {
	            tempDir.mkdirs(); // 디렉토리 생성
	            System.out.println("임시 디렉토리 생성: " + rootPath);
	        } else {
	            System.out.println("임시 디렉토리 확인: " + rootPath);
	        }

	        // ZIP 파일 생성
	        File zipFile = new File(tempDir, organizationCode + "_files.zip");
	        System.out.println("ZIP 파일 경로: " + zipFile.getAbsolutePath());

	        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile))) {
	            List<String> filePaths = giasService.getAllFilePathsForOrganization(organizationCode);
	            System.out.println("파일 경로 리스트: " + filePaths);

	            // 중복 방지 Set
	            Set<String> addedEntries = new HashSet<>();

	            for (String filePath : filePaths) {
	                if (filePath == null || filePath.trim().isEmpty()) {
	                    System.out.println("무시된 파일 경로: " + filePath);
	                    continue;
	                }

	                // 절대 경로 계산
	                File file = new File(RESPOSITORY_PATH + filePath);
	                if (!file.exists() || !file.isFile()) {
	                    System.out.println("파일이 존재하지 않거나 잘못된 파일입니다: " + file.getAbsolutePath());
	                    continue;
	                }

	                // ZIP 경로 간소화
	                String basePathToRemove = "up_imgs/gias_file/" + organizationCode + "/";
	                String zipEntryName = filePath.replaceFirst("^" + basePathToRemove, "");
	                if (addedEntries.contains(zipEntryName)) {
	                    System.out.println("중복된 ZIP 엔트리 건너뜀: " + zipEntryName);
	                    continue;
	                }
	                addedEntries.add(zipEntryName);

	                // 파일 추가
	                try (FileInputStream fis = new FileInputStream(file)) {
	                    ZipEntry zipEntry = new ZipEntry(zipEntryName);
	                    zos.putNextEntry(zipEntry);

	                    byte[] buffer = new byte[1024];
	                    int bytesRead;
	                    while ((bytesRead = fis.read(buffer)) > 0) {
	                        zos.write(buffer, 0, bytesRead);
	                    }
	                    zos.closeEntry();
	                    System.out.println("ZIP 엔트리에 파일 추가 완료: " + zipEntryName);
	                } catch (IOException e) {
	                    System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
	                }
	            }
	            zos.flush(); // 버퍼 내용 비우기
	        }

	        // ZIP 파일 확인
	        if (zipFile.exists() && zipFile.length() > 0) {
	            System.out.println("ZIP 파일 생성 완료: " + zipFile.getAbsolutePath() + ", 크기: " + zipFile.length());
	        } else {
	            throw new IOException("ZIP 파일 생성 실패 또는 파일 크기가 0입니다.");
	        }

	        // 다운로드 처리
	        Resource resource = new FileSystemResource(zipFile);
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + zipFile.getName() + "\"")
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .contentLength(zipFile.length())
	                .body(resource);

	    } catch (Exception e) {
	        System.err.println("파일 다운로드 처리 중 오류 발생: " + e.getMessage());
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	
}
