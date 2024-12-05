package com.loglog.api.commons.modules.service.gias;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.loglog.api.commons.beans.GiasBean;
import com.loglog.api.commons.beans.SelectGiasListBean;
import com.loglog.api.commons.beans.UserBean;

public interface GiasService {
	
	/**화면 들어가면 가장먼저 보여지는 도메인 리스트 */
	public List<GiasBean> selectDomain(GiasBean giasBean)throws Exception;
	
	/**도메인 클릭시 출력되는 프린스플 리스트 */
	public List<GiasBean> selectPrinciple(GiasBean giasBean)throws Exception;
	
	/**프린스플 클릭시 출력되는 스탠다드 리스트 */
	public List<GiasBean> selectStandard(GiasBean giasBean)throws Exception;
	
	/**스탠다드 클릭시 출력되는 평가항목 리스트 */
	public List<GiasBean> selectEvaluation(GiasBean giasBean)throws Exception;
	
	/**저장하는 맴버의 기관코드와 기관 이름 가져오기*/
	public GiasBean selectMemberOrg(GiasBean giasBean)throws Exception;
	
	/**입력사항 저장*/
	public int insertGias(SelectGiasListBean selectGiasListBean)throws Exception;
	
	/**입력사항 저장+파일*/
	public int updateGiasFile(SelectGiasListBean selectGiasListBean ,List<MultipartFile> giasInputFile)throws Exception;
	
	/**입력사항 수정+파일수정*/
	public int updateGiasUpdateFile(String orgCode, String evlCode ,List<MultipartFile> giasInputFile)throws Exception;
	
	/**회원이 입력사항에 저장한 것이 있으면 저장한 입력사항 조회 */
	public List<GiasBean> selectEvlOrg(SelectGiasListBean selectGiasListBean)throws Exception;
	
	/**품질평가 삭제*/
	public int deleteGias(GiasBean giasBean)throws Exception;
	
	/**평가원 품질평가 승인해줄때 팝업에 나오는 리스트*/
	public List<SelectGiasListBean> selectStandardList(SelectGiasListBean selectGiasListBean)throws Exception;
	
	/**selectMemberApprove의 결과인 스탠다드 항목으로 평가항목들을 조회함 */
	public List<SelectGiasListBean> selectApproveEvaluation(SelectGiasListBean selectGiasListBean)throws Exception;
	
	/** 기업별로 품질평가 진행도 확인 */
	public List<SelectGiasListBean> orgApproveEvaluation(SelectGiasListBean selectGiasListBean)throws Exception;
	
	/** 괸라자가 보는 기관별 품질관리 저장데이터 불러오기 */
	public List<GiasBean> selectEvlOrgList(SelectGiasListBean selectGiasListBean)throws Exception;
	
	/**관리자가 수정하는 품질평가*/
	public int updateGiasAdmin(SelectGiasListBean selectGiasListBean)throws Exception;
	
	/**관리자가 수정하는 품질평가*/
	public int updateGiasMember(SelectGiasListBean selectGiasListBean)throws Exception;
	
	/**맴버 코드로 evaluation_organization 테이블안에 저장된 org_code를 가져옴*/
	public List<String> getSavedMemberOrg(String memberCode)throws Exception;
	
	/**입력사항 수정하기전에 경로 전부 삭제*/
	public int deleteAllFilePaths(String orgCode, String evlCode)throws Exception;
	
	/** 유지시킬 파일경로 리매칭*/
	public int updateFilePath(String orgCode, String evlCode,List<String> filesToKeep)throws Exception;
	
	/**품질평가에 등록된 데이터 일괄 다운로드*/
	public List<String> getAllFilePathsForOrganization(String organizationCode)throws Exception;
}
