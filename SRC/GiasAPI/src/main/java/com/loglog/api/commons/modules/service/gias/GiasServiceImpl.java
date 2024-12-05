package com.loglog.api.commons.modules.service.gias;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loglog.api.commons.beans.GiasBean;
import com.loglog.api.commons.beans.SelectGiasListBean;
import com.loglog.api.commons.daos.GiasDao;


@Service
public class GiasServiceImpl implements GiasService {

	@Value("${repository.path}")
	private String RESPOSITORY_PATH;
	// 보드 이미지 폴더 경로
	@Value("${upload.gias.path}")
	private String UPLOAD_GIAS_PATH;
		
	@Autowired
	private GiasDao giasDao;
	
	/**화면 들어가면 가장먼저 보여지는 도메인 리스트 */
	public List<GiasBean> selectDomain(GiasBean giasBean)throws Exception{
		return giasDao.selectDomain(giasBean);
	}
	
	/**도메인 클릭시 출력되는 프린스플 리스트 */
	public List<GiasBean> selectPrinciple(GiasBean giasBean)throws Exception{
		return giasDao.selectPrinciple(giasBean);
	}
	
	/**프린스플 클릭시 출력되는 스탠다드 리스트 */
	public List<GiasBean> selectStandard(GiasBean giasBean)throws Exception{
		return giasDao.selectStandard(giasBean);
	}
	
	/**스탠다드 클릭시 출력되는 평가항목 리스트 */
	public List<GiasBean> selectEvaluation(GiasBean giasBean)throws Exception{
		return giasDao.selectEvaluation(giasBean);
	} 
	
	/**입력사항 저장*/
	public int insertGias(SelectGiasListBean selectGiasListBean)throws Exception{
//		GiasBean giasMemberData = giasDao.selectMemberOrg(giasBean);
//		String memberOrg = giasMemberData.getOrganizationCode();
//		String memberOrgName = giasMemberData.getOrganizationName();
//		
//		giasBean.setOrganizationCode(memberOrg);
//		giasBean.setOrganizationName(memberOrgName);
		return giasDao.insertGias(selectGiasListBean);
	}
	
	/** 입력사항 저장 + 파일 */
	public int updateGiasFile(SelectGiasListBean selectGiasListBean, List<MultipartFile> giasInputFiles) throws Exception {
	    // 파일 저장 경로 설정
	    String root = RESPOSITORY_PATH + UPLOAD_GIAS_PATH + selectGiasListBean.getOrganizationCode() + "/" + selectGiasListBean.getEvaluationCode();

	    // 디렉터리 생성
	    File directory = new File(root);
	    if (!directory.exists()) {
	        directory.mkdirs();
	    }

	    List<String> filePaths = new ArrayList<>();

	    // 모든 파일 처리
	    for (MultipartFile giasInputFile : giasInputFiles) {
	        if (giasInputFile != null && !giasInputFile.isEmpty()) {
	            String originalFilename = giasInputFile.getOriginalFilename();
	            String savedFilePath = root + "/" + originalFilename; // 절대 경로
	            String relativeFilePath = UPLOAD_GIAS_PATH + selectGiasListBean.getOrganizationCode() + "/" + selectGiasListBean.getEvaluationCode() + "/" + originalFilename; // 상대 경로

	            File destFile = new File(savedFilePath);
	            giasInputFile.transferTo(destFile);

	            // 리스트에 파일 경로 추가
	            filePaths.add(relativeFilePath);
	        }
	    }

	    // 경로 리스트를 Bean에 동적으로 저장
	    for (int i = 0; i < filePaths.size() && i < 7; i++) {
	        String methodName = "setEvaluationFile" + (i + 1);
	        SelectGiasListBean.class.getMethod(methodName, String.class)
	            .invoke(selectGiasListBean, filePaths.get(i));
	    }

	    System.out.println("저장된 파일 경로들: " + filePaths);
	    return giasDao.updateGiasFile(selectGiasListBean);
	}



	@Override
	public GiasBean selectMemberOrg(GiasBean giasBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**회원이 입력사항에 저장한 것이 있으면 저장한 입력사항 조회 */
	public List<GiasBean> selectEvlOrg(SelectGiasListBean selectGiasListBean)throws Exception{
		return giasDao.selectEvlOrg(selectGiasListBean);
	}
	
	/**품질평가 삭제*/
	public int deleteGias(GiasBean giasBean)throws Exception{
		return giasDao.deleteGias(giasBean);
	}
	
	/**평가원 품질평가 승인해줄때 팝업에 나오는 리스트*/
	public List<SelectGiasListBean> selectStandardList(SelectGiasListBean selectGiasListBean)throws Exception{
		return giasDao.selectStandardList(selectGiasListBean);
	}
	
	/** selectMemberApprove의 결과인 스탠다드 항목으로 평가항목들을 조회함 */
	public List<SelectGiasListBean> selectApproveEvaluation(SelectGiasListBean selectGiasListBean) throws Exception {
	    // selectMemberApprove 결과를 가져옴
	    List<String> rawOrgAppList = giasDao.selectMemberApprove(selectGiasListBean);
	    //System.out.println("평가원에게 승인된 평가목록 : " + rawOrgAppList);

	    // 결과가 null이거나 비어 있을 경우 대비
	    if (rawOrgAppList == null || rawOrgAppList.isEmpty()) {
	        //System.out.println("승인된 평가목록이 없습니다.");
	        selectGiasListBean.setApprovedStandardSet(Collections.emptySet());
	        return giasDao.selectApproveEvaluation(selectGiasListBean);
	    }

	    // JSON 문자열을 리스트로 변환
	    ObjectMapper objectMapper = new ObjectMapper();
	    List<List<String>> parsedOrgAppList = new ArrayList<>();

	    for (String json : rawOrgAppList) {
	        if (json != null && !json.trim().isEmpty()) {
	            List<String> parsedList = objectMapper.readValue(json, new TypeReference<List<String>>() {});
	            parsedOrgAppList.add(parsedList);
	        }
	    }

	    // 중첩 리스트 병합
	    Set<String> mergedSet = parsedOrgAppList.stream()
	                                            .flatMap(List::stream)
	                                            .collect(Collectors.toSet());
	    //System.out.println("String이 리스트로 바뀌는 것 확인: " + mergedSet);

	    // 병합된 Set을 Bean에 설정
	    selectGiasListBean.setApprovedStandardSet(mergedSet);
	    return giasDao.selectApproveEvaluation(selectGiasListBean);
	}

	/** 기업별로 품질평가 진행도 확인 */
	public List<SelectGiasListBean> orgApproveEvaluation(SelectGiasListBean selectGiasListBean)throws Exception{
		return giasDao.orgApproveEvaluation(selectGiasListBean);
	}
	
	/** 괸라자가 보는 기관별 품질관리 저장데이터 불러오기 */
	public List<GiasBean> selectEvlOrgList(SelectGiasListBean selectGiasListBean)throws Exception{
		return giasDao.selectEvlOrgList(selectGiasListBean);
	}
	
	/**관리자가 수정하는 품질평가*/
	public int updateGiasAdmin(SelectGiasListBean selectGiasListBean)throws Exception{
		return giasDao.updateGiasAdmin(selectGiasListBean);
	}
	
	/**평가원이가 수정하는 품질평가*/
	public int updateGiasMember(SelectGiasListBean selectGiasListBean)throws Exception{
		return giasDao.updateGiasMember(selectGiasListBean);
	}
	
	/**맴버 코드로 evaluation_organization 테이블안에 저장된 org_code를 가져옴*/
	public List<String> getSavedMemberOrg(String memberCode)throws Exception{
		return giasDao.getSavedMemberOrg(memberCode);
	}
	
	/**입력사항 수정하기전에 경로 전부 삭제*/
	public int deleteAllFilePaths(String orgCode, String evlCode)throws Exception{
		//System.out.println("기업코드 : " + orgCode);
		//System.out.println("평가코드 : " + evlCode);
		return giasDao.deleteAllFilePaths(orgCode,evlCode);
	}
	
	/** 유지시킬 파일경로 리매칭*/
	public int updateFilePath(String orgCode, String evlCode,List<String> filesToKeep)throws Exception{
		
		return giasDao.updateFilePath(orgCode, evlCode,filesToKeep);
		
	}
	
	/** 입력사항 저장 + 파일 */
	public int updateGiasUpdateFile(String orgCode, String evlCode, List<MultipartFile> giasInputFiles) throws Exception {
	    // 파일 저장 경로 설정
	    String root = RESPOSITORY_PATH + UPLOAD_GIAS_PATH + orgCode + "/" + evlCode;

	    // 디렉터리 생성
	    File directory = new File(root);
	    if (!directory.exists()) {
	        directory.mkdirs();
	    }

	    // 기존 파일 상태 조회
	    List<String> existingFilePaths = new ArrayList<>();
	    Map<String, Object> resultMap = giasDao.getExistingFilePaths(orgCode, evlCode);

	    if (resultMap != null) {
	        for (int i = 1; i <= 7; i++) {
	            String key = "evaluation_file_" + i;
	            if (resultMap.containsKey(key) && resultMap.get(key) != null) {
	                existingFilePaths.add(resultMap.get(key).toString());
	            } else {
	                existingFilePaths.add(null); // 없는 경우 null로 처리
	            }
	        }
	    }

	    System.out.println("빈자리 확인: " + existingFilePaths);

	    // 빈 자리 확인 (evaluation_file_1 ~ evaluation_file_7)
	    Map<Integer, String> availableSlots = new HashMap<>();
	    for (int i = 0; i < 7; i++) {
	        if (i >= existingFilePaths.size() || existingFilePaths.get(i) == null) {
	            availableSlots.put(i + 1, "evaluation_file_" + (i + 1));
	        }
	    }

	    System.out.println("사용 가능한 슬롯: " + availableSlots);

	    // 새로운 파일 처리
	    Map<String, String> updatedFilePaths = new HashMap<>();
	    for (MultipartFile giasInputFile : giasInputFiles) {
	        if (giasInputFile != null && !giasInputFile.isEmpty()) {
	            if (availableSlots.isEmpty()) {
	                System.err.println("빈 슬롯이 부족하여 파일을 저장할 수 없습니다.");
	                break;
	            }

	            String originalFilename = giasInputFile.getOriginalFilename();
	            String savedFilePath = root + "/" + originalFilename; // 절대 경로
	            String relativeFilePath = UPLOAD_GIAS_PATH + orgCode + "/" + evlCode + "/" + originalFilename; // 상대 경로

	            File destFile = new File(savedFilePath);
	            giasInputFile.transferTo(destFile);

	            // 빈 자리 중 첫 번째 슬롯에 경로 추가
	            Integer slotKey = new ArrayList<>(availableSlots.keySet()).get(0); // 첫 번째 슬롯 선택
	            updatedFilePaths.put(availableSlots.get(slotKey), relativeFilePath);

	            availableSlots.remove(slotKey); // 사용된 슬롯 제거
	        }
	    }

	    // 파일 경로 DB 업데이트
	    return giasDao.updateFilePaths(orgCode, evlCode, updatedFilePaths);
	}


	
	/**품질평가에 등록된 데이터 일괄 다운로드*/
	public List<String> getAllFilePathsForOrganization(String organizationCode)throws Exception{
		List<String> resultList = giasDao.getAllFilePathsForOrganization(organizationCode);
		System.out.println("서비스 결과" + resultList );
		return resultList;
	}

}
