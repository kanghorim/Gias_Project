package com.loglog.api.commons.modules.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loglog.api.commons.beans.PagingBean;
import com.loglog.api.commons.beans.UserBean;
import com.loglog.api.commons.daos.UserDao;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	 @Autowired
	private ObjectMapper objectMapper; // DI로 ObjectMapper 주입
	
	/** 회원가입 */
	public int insertUser(UserBean userBean) throws Exception {
		return userDao.insertUser(userBean);
	}

	
	/**user id가 중복인지 아닌지 체크*/
	public int checkUserId(UserBean userBean)throws Exception{
		return userDao.checkUserId(userBean);
	}
	
	/** 유저 로그인*/
	public UserBean loginUser(UserBean userBean)throws Exception{
		return userDao.loginUser(userBean);
	}
	
	/** 회원관리 조회 */
	public List<UserBean> selectUser(UserBean userBean , PagingBean pagingBean) throws Exception{
		Map<String, Object> parameter = new HashMap<String, Object>();
    	parameter.put("pageNo", pagingBean.getPageNo());
		parameter.put("startRow", pagingBean.getStartRow());
		parameter.put("countPerRecord", pagingBean.getCountPerRecord());
		parameter.put("typeCd",pagingBean.getTypeCd());
		parameter.put("search", pagingBean.getSearch());
		parameter.put("searchKind", pagingBean.getSearchKind());
		
		List<UserBean> userList =  userDao.selectUser(parameter);
		
		for (UserBean bean : userList) {
	        String updateAt = bean.getUpdateAt();
	        if (updateAt != null) {
	            // updateAt을 문자열로 변환한 후 앞의 10자리만 잘라서 사용
	            String formattedDate = updateAt.toString().substring(0, 10);
	            bean.setUpdateAt(formattedDate);
	        }
	    }
		
		return userList;
	}
	
	/** 회원관리 조회 */
	public int selectUserCount(UserBean userBean , PagingBean pagingBean) throws Exception{
		Map<String, Object> parameter = new HashMap<String, Object>();
    	parameter.put("pageNo", pagingBean.getPageNo());
		parameter.put("startRow", pagingBean.getStartRow());
		parameter.put("countPerRecord", pagingBean.getCountPerRecord());
		parameter.put("typeCd",pagingBean.getTypeCd());
		parameter.put("search", pagingBean.getSearch());
		parameter.put("searchKind", pagingBean.getSearchKind());
		return userDao.selectUserCount(parameter);
	}
	
	/** 회원 최초 승인*/
	public int updateFirstState(UserBean userBean)throws Exception{
		return userDao.updateFirstState(userBean);
	}
	
	/** 회원 최초 이후 상태변경*/
	public int updateState(UserBean userBean)throws Exception{
		return userDao.updateState(userBean);
	}
	
	/**승인자가 있는지 없는지 체크*/
	public int checkApprover(UserBean userBean)throws Exception{
		return userDao.checkApprover(userBean);
	}
	
	/**회원 삭제*/
	public int deleteUser(UserBean userBean)throws Exception{
		return userDao.deleteUser(userBean);
	}
	
	/** 비밀번호 초기화*/
	public int userPwInit(UserBean userBean)throws Exception{
		return userDao.userPwInit(userBean);
	}
	
	/** 회원로그인 전에 이 회원이 활성화된 기관의 회원인지 아닌지 체크 */
	public int checkUserOrgState(UserBean userBean) throws Exception{
		return userDao.checkUserOrgState(userBean);
	}
	
	/** 평가권한 배분 팝업에 유저의 평가권한 조회*/
	public List<String> approvedStandard(UserBean userBean) throws Exception {
	    // 데이터베이스에서 JSON 문자열 가져오기
	    String jsonString = userDao.approvedStandard(userBean);

	    // JSON 문자열이 null 또는 빈 값이면 빈 리스트 반환
	    if (jsonString == null || jsonString.isEmpty() || jsonString.equals("[]")) {
	        return List.of(); // 빈 리스트 반환
	    }

	    // JSON 문자열을 List<String>으로 변환하여 반환
	    return objectMapper.readValue(jsonString, new TypeReference<List<String>>() {});
	}
	
	public int updateApprovedStandard(UserBean userBean) {
	    try {
	        System.out.println("리스트 확인: " + userBean.getApprovedStandardList());

	        // List<String>을 JSON 문자열로 변환
	        ObjectMapper objectMapper = new ObjectMapper();
	        String approvedStandardJson = objectMapper.writeValueAsString(userBean.getApprovedStandardList());
	        System.out.println("JSON 변환 결과: " + approvedStandardJson);

	        // JSON 문자열을 approvedStandard에 설정
	        userBean.setApprovedStandard(approvedStandardJson);

	        // DB 업데이트 실행
	        return userDao.updateApprovedStandard(userBean);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("JSON 변환 실패", e);
	    }
	}
	
	
	/** memberCode로 기관번호 알기*/
	public UserBean selectOrg(UserBean userBean) {
		return userDao.selectOrg(userBean);
	}
	
	/**기업코드를 입력받아서 승인된 항목들을 전부 출력*/
	public List<String> selectApprovedStandard(UserBean userBean){
		return userDao.selectApprovedStandard(userBean);
	}
	
	/**회원별 저장된 평가리스트 조회*/
	public List<String> selectSavedOrgList(UserBean userBean)throws Exception{
		return userDao.selectSavedOrgList(userBean);
	}
	
	/** 회원별 작성한 평가 코드 조회*/
	public List<String> selectOrgCodeList(UserBean userBean)throws Exception{
		return userDao.selectOrgCodeList(userBean);
	}
	
	/** 평가원에게 승인된 항목들 삭제*/
	public int deleteApprovedOrg(UserBean userBean)throws Exception{
		return userDao.deleteApprovedOrg(userBean);
	}
	
	/**회원별 데이터가 저장될 평가 리스트*/
	public List<String> selectAlertList(UserBean userBean)throws Exception{
		return userDao.selectAlertList(userBean);
	}

}
