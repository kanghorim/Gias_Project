package com.loglog.api.commons.daos;

import java.util.List;
import java.util.Map;

import com.loglog.api.commons.beans.UserBean;

/**
 * 사용자 DAO
 * 
 * @author SJG
 */
public interface UserDao {
	
	/** 회원가입 */
	public int insertUser(UserBean userBean);
	
	/**user id가 중복인지 아닌지 체크*/
	public int checkUserId(UserBean userBean);
	
	/** 유저 로그인*/
	public UserBean loginUser(UserBean userBean);
	
	/**회원 정보 조회 */
	public List<UserBean> selectUser(Map<String,Object> parameter);
	
	/**회원 갯수*/
	public int selectUserCount(Map<String,Object> parameter);
	
	/** 회원 최초 승인*/
	public int updateFirstState(UserBean userBean);
	
	/** 회원 최초 이후 상태변경*/
	public int updateState(UserBean userBean);
	
	/**승인자가 있는지 없는지 체크*/
	public int checkApprover(UserBean userBean);
	
	/**회원 삭제*/
	public int deleteUser(UserBean userBean);
	
	/** 비밀번호 초기화*/
	public int userPwInit(UserBean userBean);
	
	/** 회원로그인 전에 이 회원이 활성화된 기관의 회원인지 아닌지 체크 */
	public int checkUserOrgState(UserBean userBean);
	
	/** 평가권한 배분 팝업에 유저의 평가권한 조회*/
	public String approvedStandard(UserBean userBean);
	
	/** 평가권한 배분 수정하는 로직 */
	public int updateApprovedStandard(UserBean userBean);
	
	/** memberCode로 기관번호 알기*/
	public UserBean selectOrg(UserBean userBean);
	
	public List<String> selectApprovedStandard(UserBean userBean);
	
	/**회원별 저장된 평가리스트 조회*/
	public List<String> selectSavedOrgList(UserBean userBean);
	
	/** 회원별 작성한 평가 코드 조회*/
	public List<String> selectOrgCodeList(UserBean userBean);
	
	/** 평가원에게 승인된 항목들 삭제*/
	public int deleteApprovedOrg(UserBean userBean);
	
	/**회원별 데이터가 저장될 평가 리스트*/
	public List<String> selectAlertList(UserBean userBean);
	
}