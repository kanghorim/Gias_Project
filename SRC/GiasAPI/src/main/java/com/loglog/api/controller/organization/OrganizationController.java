package com.loglog.api.controller.organization;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loglog.api.commons.beans.NoticeBean;
import com.loglog.api.commons.beans.OrganizationBean;
import com.loglog.api.commons.beans.PagingBean;
import com.loglog.api.commons.beans.UserBean;
import com.loglog.api.commons.constants.Constants;
import com.loglog.api.commons.modules.service.organization.OrganizationService;


@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;
	
	/**
	 * 로그인
	 * @param userBean
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/org/selectOrgList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectOrgList(OrganizationBean organizationBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "기관조회에 실패했습니다.");
		try {
			List<OrganizationBean> resultList = organizationService.selectOrganization(organizationBean);
			if(resultList != null) {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "기관조회에 성공했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	@RequestMapping(value="/org/vueList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectOrgVueList(OrganizationBean organizationBean,PagingBean pagingBean, HttpServletRequest request) throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		
		int totalCount = organizationService.selectOrganizationCount(organizationBean,pagingBean);
		pagingBean.calcPage(totalCount);
		
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "기관조회에 실패했습니다.");
		try {
			List<OrganizationBean> resultList = organizationService.selectOrganizationList(organizationBean,pagingBean);
			if(resultList != null) {
				map.put("pagingBean", pagingBean);
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "기관조회에 성공했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	@RequestMapping(value="/org/updateState", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateState(@RequestBody OrganizationBean organizationBean, HttpServletRequest request) throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		
		int stateCount = 0;
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "상태 수정에 실패했습니다.");
		try {
			stateCount = organizationService.updateOrgState(organizationBean);
			if(stateCount > 0) {
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "상태 수정에 성공했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	@RequestMapping(value="/org/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> deleteOrg(@RequestBody List<OrganizationBean> organizationBean, HttpServletRequest request) throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		
		int resultDeleteCnt = 0;
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "기관 삭제에 실패했습니다.");
		try {
			for (OrganizationBean organizationCode : organizationBean) {
		        resultDeleteCnt += resultDeleteCnt = organizationService.deleteOrg(organizationCode);
		     }
			if(resultDeleteCnt > 0) {
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "기관 삭제에 성공했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	@RequestMapping(value="/org/orgApprovedStandard", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectApprovedStandard(@RequestBody OrganizationBean organizationBean, HttpServletRequest request) throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		String result = Constants.FAIL;
		try {
			List<String> resultString = organizationService.approvedStandard(organizationBean);
			if(resultString != null) {
				result = Constants.OK;
				map.put("data", resultString);
				map.put("result", result);
				map.put("resultMsg","기관의 평가권한 조회에 성공했습니다.");
			}else{
				map.put("result", result);
				map.put("resultMsg","기관의 평가권한 조회에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "아이디 또는 비밀번호가 다릅니다.");
		}
		return map;
	}
	
}
