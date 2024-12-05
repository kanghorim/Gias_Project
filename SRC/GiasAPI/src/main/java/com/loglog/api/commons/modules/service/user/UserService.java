package com.loglog.api.commons.modules.service.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.loglog.api.commons.beans.PagingBean;
import com.loglog.api.commons.beans.UserBean;

public interface UserService {
	/**회원가입*/
	public int insertUser(UserBean userBean) throws Exception;
	
	/**user id가 중복인지 아닌지 체크*/
	public int checkUserId(UserBean userBean)throws Exception;

	/** 유저 로그인*/
	public UserBean loginUser(UserBean userBean)throws Exception;
	
	/** 회원관리 조회 */
	public List<UserBean> selectUser(UserBean userBean , PagingBean pagingBean) throws Exception;
	
	/** 회원관리 조회 */
	public int selectUserCount(UserBean userBean , PagingBean pagingBean) throws Exception;
	
	/** 회원 최초 승인*/
	public int updateFirstState(UserBean userBean)throws Exception;
	
	/** 회원 최초 이후 상태변경*/
	public int updateState(UserBean userBean)throws Exception;
	
	/**승인자가 있는지 없는지 체크*/
	public int checkApprover(UserBean userBean)throws Exception;
	
	/**회원 삭제*/
	public int deleteUser(UserBean userBean)throws Exception;
	
	/** 비밀번호 초기화*/
	public int userPwInit(UserBean userBean)throws Exception;
	
	/** 회원로그인 전에 이 회원이 활성화된 기관의 회원인지 아닌지 체크 */
	public int checkUserOrgState(UserBean userBean)throws Exception;
	
	/** 평가권한 배분 팝업에 유저의 평가권한 조회*/
	public List<String> approvedStandard(UserBean userBean)throws Exception;
	
	/** 평가권한 배분 수정하는 로직 */
	public int updateApprovedStandard(UserBean userBean)throws Exception;
	
	/** memberCode로 기관번호 알기*/
	public UserBean selectOrg(UserBean userBean);
	
	/**기업코드를 입력받아서 승인된 항목들을 전부 출력*/
	public List<String> selectApprovedStandard(UserBean userBean);
	
	/**회원별 저장된 평가리스트 조회*/
	public List<String> selectSavedOrgList(UserBean userBean)throws Exception;
	
	/** 회원별 작성한 평가 코드 조회*/
	public List<String> selectOrgCodeList(UserBean userBean)throws Exception;
	
	/** 평가원에게 승인된 항목들 삭제*/
	public int deleteApprovedOrg(UserBean userBean)throws Exception;
	
	/**회원별 데이터가 저장될 평가 리스트*/
	public List<String> selectAlertList(UserBean userBean)throws Exception;
	
}
