package com.loglog.api.commons.daos;

import java.util.List;
import java.util.Map;

import com.loglog.api.commons.beans.GiasBean;
import com.loglog.api.commons.beans.SelectGiasListBean;
/**
 * 사용자 DAO
 * 
 * @author SJG
 */
public interface GiasDao {
	
	/**화면 들어가면 가장먼저 보여지는 도메인 리스트 */
	public List<GiasBean> selectDomain(GiasBean giasBean);
	
	/**도메인 클릭시 출력되는 프린스플 리스트 */
	public List<GiasBean> selectPrinciple(GiasBean giasBean);
	
	/**프린스플 클릭시 출력되는 스탠다드 리스트 */
	public List<GiasBean> selectStandard(GiasBean giasBean);
	
	/**스탠다드 클릭시 출력되는 평가항목 리스트 */
	public List<GiasBean> selectEvaluation(GiasBean giasBean);
	
	/**입력사항 저장*/
	public int insertGias(SelectGiasListBean selectGiasListBean);
	
	/**입력사항 저장한후에 파일을 저장함*/
	public int updateGiasFile(SelectGiasListBean selectGiasListBean);
	
	/**입력사항 수정하기전에 경로 전부 삭제*/
	public int deleteAllFilePaths(String orgCode, String evlCode);
	
	/**저장하는 맴버의 기관코드와 기관 이름 가져오기*/
	public GiasBean selectMemberOrg(GiasBean giasBean);
	
	/**회원이 입력사항에 저장한 것이 있으면 저장한 입력사항 조회 */
	public List<GiasBean> selectEvlOrg(SelectGiasListBean selectGiasListBean);
	 
	/**품질평가 삭제*/
	public int deleteGias(GiasBean giasBean);
	
	/**평가원 품질평가 승인해줄때 팝업에 나오는 리스트*/
	public List<SelectGiasListBean> selectStandardList(SelectGiasListBean selectGiasListBean);
	
	/** 평가원의 승인된 스탠다드 항목들을 가져옴*/
	public List<String> selectMemberApprove(SelectGiasListBean selectGiasListBean);
	
	/**selectMemberApprove의 결과인 스탠다드 항목으로 평가항목들을 조회함 */
	public List<SelectGiasListBean> selectApproveEvaluation(SelectGiasListBean selectGiasListBean);
	
	/** 기업별로 품질평가 진행도 확인 */
	public List<SelectGiasListBean> orgApproveEvaluation(SelectGiasListBean selectGiasListBean);
	
	/** 괸라자가 보는 기관별 품질관리 저장데이터 불러오기 */
	public List<GiasBean> selectEvlOrgList(SelectGiasListBean selectGiasListBean);
	
	/**관리자가 수정하는 품질평가*/
	public int updateGiasAdmin(SelectGiasListBean selectGiasListBean);
	
	/** 평가원이 수정하는 품질평가*/
	public int updateGiasMember(SelectGiasListBean selectGiasListBean);
	
	/**맴버 코드로 evaluation_organization 테이블안에 저장된 org_code를 가져옴*/
	public List<String> getSavedMemberOrg(String memberCode);
	
	/**유지시킬 파일경로 다시 업데이트*/
	public int updateFilePath(String orgCode, String evlCode,List<String> filesToKeep);
	
	/**파일 수정에 새로운 파일이 들어온다면*/
	public int saveNewFilePath(String orgCode, String evlCode,List<String> filesToKeep);
	
	// 현재 파일 상태 조회
	public Map<String, Object> getExistingFilePaths(String orgCode, String evlCode);
	
	// 파일 경로 업데이트
	public int updateFilePaths(String orgCode, String evalCode, Map<String, String> updatedFilePaths);
	
	/**품질평가에 등록된 데이터 일괄 다운로드*/
	public List<String> getAllFilePathsForOrganization(String organizationCode);
}