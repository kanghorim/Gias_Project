package com.loglog.api.controller.user;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loglog.api.commons.beans.PagingBean;
import com.loglog.api.commons.beans.UserBean;
import com.loglog.api.commons.constants.Constants;
import com.loglog.api.commons.modules.service.user.UserService;


@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserService userService;
	

	/**
	 * 로그인
	 * @param userBean
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/user/join", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userJoin(@RequestBody UserBean userBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "오류발생");
		int resultCnt = 0;
		try {
			int checkID = userService.checkUserId(userBean);
			if(checkID > 0) {
				map.put(Constants.RESULT, Constants.FAIL);
				map.put(Constants.RESULT_MSG, "중복된 아이디가 존재합니다.");
			}else {
				resultCnt = userService.insertUser(userBean);
			}
			if(resultCnt > 0) {
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "회원가입 처리 곧 진행 될것 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "실패했어요");
		}
		return map;
	}
	
	@RequestMapping(value="/user/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userlogin(@RequestBody UserBean userBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "오류발생");
		int checkUserOrgState = 0; // 로그인한 유저의 기관이 비활성인지 활성인지 체크
		
		try {
			checkUserOrgState = userService.checkUserOrgState(userBean);
			if(checkUserOrgState == 0) { // 0이면 기관이 차단된 상황이다.
				map.put(Constants.RESULT, Constants.FAIL);
				map.put(Constants.RESULT_MSG, "현재 당신의 기관은 비활성화 상태입니다.");
			}else {
				UserBean resultBean = userService.loginUser(userBean);
				if(resultBean.getState() != 1) {
					map.put(Constants.RESULT, Constants.FAIL);
					map.put(Constants.RESULT_MSG, "승인처리가 안된 회원입니다.");
				}else{
					map.put("data", resultBean);
					map.put(Constants.RESULT, Constants.OK);
					map.put(Constants.RESULT_MSG, "로그인에 성공했습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "아이디 또는 비밀번호가 다릅니다.");
		}
		return map;
	}

	@RequestMapping(value="/user/userList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> userList(UserBean userBean,PagingBean pagingBean, HttpServletRequest request) throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		String result = Constants.FAIL;
		int totalCount = userService.selectUserCount(userBean,pagingBean);
		pagingBean.calcPage(totalCount);
		try {
			List<UserBean> resultList = userService.selectUser(userBean,pagingBean);
			if(resultList != null) {
				result = Constants.OK;
				map.put("pagingBean", pagingBean);
				map.put("data", resultList);
				map.put("result", result);
				map.put("resultMsg","평가원관리  조회에 성공했습니다.");
			}else{
				map.put("result", result);
				map.put("resultMsg","평가원관리 조회에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "아이디 또는 비밀번호가 다릅니다.");
		}
		return map;
	}
	
	@RequestMapping(value="/user/updateState", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userUpdateState(@RequestBody UserBean userBean, HttpServletRequest request) throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		String result = Constants.FAIL;
		int checkApprover = 0;
		try {
			int updateState = userService.updateState(userBean);
			
			if(updateState >0) {
				result = Constants.OK;
				map.put(Constants.RESULT, Constants.OK);
				map.put("resultMsg","상태 수정에 성공했습니다.");
			}else {
				result = Constants.FAIL;
				map.put(Constants.RESULT, Constants.FAIL);
				map.put("resultMsg","상태 수정에 실패했습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "치명적 오류");
		}
		return map;
	}
	
	@RequestMapping(value="/user/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> userDelete(@RequestBody List<UserBean> userBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		int resultDeleteCnt = 0;
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "회원 삭제에 실패했습니다.");
		try {
			for (UserBean memberCode : userBean) {
		        resultDeleteCnt += userService.deleteUser(memberCode);
		     }
			
			if(resultDeleteCnt > 0) {
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "회원 삭제에 성공했습니다.");
			}else {
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "회원 삭제에 실패했습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	@RequestMapping(value="/user/pwInit", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userPwInit(@RequestBody UserBean userBean, HttpServletRequest request) throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		String result = Constants.FAIL;
		try {
			System.out.println("안뜨나" + userBean.getMemberCode());
			int updateState = userService.userPwInit(userBean);
			if(updateState >0) {
				result = Constants.OK;
				map.put(Constants.RESULT, Constants.OK);
				map.put("resultMsg","비밀번호 초기화에 성공했습니다.");
			}else {
				result = Constants.FAIL;
				map.put(Constants.RESULT, Constants.FAIL);
				map.put("resultMsg","비밀번호 초기화에 실패했습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "치명적 오류");
		}
		return map;
	}
	
	@RequestMapping(value="/user/userApprovedStandard", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectApprovedStandard(@RequestBody UserBean userBean, HttpServletRequest request) throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		String result = Constants.FAIL;
		try {
			List<String> resultString = userService.approvedStandard(userBean);
			if(resultString != null) {
				result = Constants.OK;
				map.put("data", resultString);
				map.put("result", result);
				map.put("resultMsg","평가권한 조회에 성공했습니다.");
			}else{
				map.put("result", result);
				map.put("resultMsg","평가권한 조회에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "아이디 또는 비밀번호가 다릅니다.");
		}
		return map;
	}
	
	@RequestMapping(value = "/user/updateApprovedStandard", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateApprovedStandard(@RequestBody UserBean userBean, HttpServletRequest request) throws Exception {
	    Map<String, Object> map = new HashMap<>();
	    String result = Constants.FAIL;

	    try {
	        // 조직 코드 가져오기
	        UserBean orgBean = userService.selectOrg(userBean); // 파라미터는 맴버코드
	
	        String orgName = orgBean.getOrganizationName();
	        orgBean.setMemberCode(userBean.getMemberCode());
	        
	        // 기존 승인된 평가권한 리스트 가져오기 파라미터는 맴버코드와 기관코드 
	        List<String> rawOrgAppList = userService.selectApprovedStandard(orgBean); 
	        ObjectMapper objectMapper = new ObjectMapper();
	        //System.out.println("입력받은 맴버코드를 제외한 권한 승인된 항목들" + rawOrgAppList);
	        // JSON 파싱
	        List<List<String>> parsedOrgAppList = new ArrayList<>();
	        
	        if (rawOrgAppList != null && !rawOrgAppList.isEmpty()) {
	            for (String json : rawOrgAppList) {
	                if (json != null && !json.trim().isEmpty()) {
	                    List<String> parsedList = objectMapper.readValue(json, new TypeReference<List<String>>() {});
	                    parsedOrgAppList.add(parsedList);
	                }
	            }
	        }

	        // 중첩 리스트 병합
	        Set<String> mergedSet = parsedOrgAppList.stream()
	                                                .flatMap(List::stream)
	                                                .collect(Collectors.toSet());

	        // 사용자 입력 리스트
	        List<String> inputList = userBean.getApprovedStandardList();

	        // 중복 확인
	        Set<String> duplicates = new HashSet<>();
	        for (String input : inputList) {
	            if (mergedSet.contains(input)) {
	                duplicates.add(input);
	            }
	        }

	        System.out.println("중복된 원소: " + duplicates);

	        // 중복 원소 처리
	        if (!duplicates.isEmpty()) {
	            result = Constants.FAIL;
	            map.put("result", result);
	            map.put("resultMsg", orgName+"기관에"+ duplicates+"항목이 중복입니다.");
	            //map.put("duplicates", duplicates);
	        } else {
	            // 업데이트 로직 (예: 성공 처리)
	            int resultString = userService.updateApprovedStandard(userBean);
	            if (resultString > 0) {
	                result = Constants.OK;
	                map.put("result", result);
	                map.put("resultMsg", "평가권한 수정에 성공했습니다.");
	            } else {
	                map.put("result", result);
	                map.put("resultMsg", "평가권한 수정에 실패했습니다.");
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put(Constants.RESULT, Constants.FAIL);
	        map.put(Constants.RESULT_MSG, "처리 중 오류가 발생했습니다.");
	    }

	    return map;
	}
	
	@RequestMapping(value = "/user/updateApprovedStandardBeFor", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateApprovedStandard2(@RequestBody UserBean userBean, HttpServletRequest request) throws Exception {
	    Map<String, Object> map = new HashMap<>();
	    String result = Constants.FAIL;
	    int restsultCnt = 0;
	    try {
	        // 회원별 작성한 스탠다드 코드 조회
	    	List<String> rawOrgAppList= userService.selectSavedOrgList(userBean); // 파라미터는 맴버코드
	    	List<String> inputList = userBean.getApprovedStandardList();
	    	
	    	 // inputList에 없는 rawOrgAppList 원소를 필터링
	        List<String> missingFromInputList = new ArrayList<>(rawOrgAppList);
	        missingFromInputList.removeAll(inputList);
	        
	        userBean.setApprovedOrgCodeList(missingFromInputList);
	        List<String> deleteOrgCodeList = userService.selectOrgCodeList(userBean);
	        userBean.setApprovedOrgCodeList(deleteOrgCodeList);
	        // 중복 원소 처리
	        if (!deleteOrgCodeList.isEmpty()) {
	        	restsultCnt = userService.deleteApprovedOrg(userBean);
	        	if(restsultCnt > 0) {
	        		result = Constants.OK;
		            map.put("result", result);
		            map.put("resultMsg", "평가 삭제 완료");
	        	}
	            //map.put("duplicates", duplicates);
	        } else {
	            // 업데이트 로직 (예: 성공 처리)
	            //int resultString = userService.updateApprovedStandard(userBean);
                map.put("result", result);
                map.put("resultMsg", "삭제할 평가가 없음");
	            
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put(Constants.RESULT, Constants.FAIL);
	        map.put(Constants.RESULT_MSG, "처리 중 오류가 발생했습니다.");
	    }

	    return map;
	}
	
	@RequestMapping(value = "/user/checkUpdateApprovedStandardBeFor", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateApprovedStandard3(@RequestBody UserBean userBean, HttpServletRequest request) throws Exception {
	    Map<String, Object> map = new HashMap<>();
	    String result = Constants.FAIL;
	    try {
	        // 회원별 작성한 스탠다드 코드 조회 전부 조회함
	    	List<String> rawOrgAppList= userService.selectAlertList(userBean); // 파라미터는 맴버코드
	    	List<String> inputList = userBean.getApprovedStandardList();
	    	System.out.println("기존의 입력값이 있는 스탠다드: " + rawOrgAppList);
	    	System.out.println("유지시킬 데이터: " +inputList );
	    	 // inputList에 없는 rawOrgAppList 원소를 필터링
	        List<String> missingFromInputList = new ArrayList<>(rawOrgAppList);
	        missingFromInputList.removeAll(inputList);
	        
	        System.out.println("삭제 시킬 데이터들:" + missingFromInputList );
	        // 중복 원소 처리
	        if (!missingFromInputList.isEmpty()) {
	        
        		result = Constants.OK;
	            map.put("data", missingFromInputList);
	            map.put("result", result);
	            map.put("resultMsg", missingFromInputList + "항목들이 이미 저장되어 있습니다. 삭제하시겠습니까?");
	        	
	            //map.put("duplicates", duplicates);
	        } else {
	            // 업데이트 로직 (예: 성공 처리)
	            //int resultString = userService.updateApprovedStandard(userBean);
                map.put("result", result);
                map.put("resultMsg", "삭제할 평가가 없음");
	            
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        map.put(Constants.RESULT, Constants.FAIL);
	        map.put(Constants.RESULT_MSG, "처리 중 오류가 발생했습니다.");
	    }

	    return map;
	}

}
