package com.loglog.api.commons.modules.service.organization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loglog.api.commons.beans.OrganizationBean;
import com.loglog.api.commons.beans.PagingBean;
import com.loglog.api.commons.daos.OrganizationDao;


@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDao organizationDao;
	
	 @Autowired
	private ObjectMapper objectMapper; // DI로 ObjectMapper 주입
	 
	/** 기관 관리 조회*/
	public List<OrganizationBean> selectOrganization(OrganizationBean organizationBean)throws Exception{
		return organizationDao.selectOrganization(organizationBean);
	}
	
	/** 기관 콤보박스 조회*/
	public List<OrganizationBean> selectOrganizationList(OrganizationBean organizationBean,PagingBean pagingBean)throws Exception{
		Map<String, Object> parameter = new HashMap<String, Object>();
    	parameter.put("pageNo", pagingBean.getPageNo());
		parameter.put("startRow", pagingBean.getStartRow());
		parameter.put("countPerRecord", pagingBean.getCountPerRecord());
		parameter.put("typeCd",pagingBean.getTypeCd());
		parameter.put("search", pagingBean.getSearch());
		return organizationDao.selectOrganizationList(parameter);
	}
	
	/** 기관 콤보박스 조회*/
	public int selectOrganizationCount(OrganizationBean organizationBean,PagingBean pagingBean)throws Exception{
		Map<String, Object> parameter = new HashMap<String, Object>();
    	parameter.put("pageNo", pagingBean.getPageNo());
		parameter.put("startRow", pagingBean.getStartRow());
		parameter.put("countPerRecord", pagingBean.getCountPerRecord());
		parameter.put("typeCd",pagingBean.getTypeCd());
		parameter.put("search", pagingBean.getSearch());
		
		return organizationDao.selectOrganizationCount(parameter);
	}
	
	/**기관 상태창 업데이트*/
	public int updateOrgState(OrganizationBean organizationBean)throws Exception{
		return organizationDao.updateOrgState(organizationBean);
	}
	
	/**기관 상태창 업데이트*/
	public int deleteOrg(OrganizationBean organizationBean)throws Exception{
		return organizationDao.deleteOrg(organizationBean);
	}
	
	/** 평가권한 배분 팝업에 유저의 평가권한 조회 */
	public List<String> approvedStandard(OrganizationBean organizationBean) throws Exception {
	    // 데이터베이스에서 JSON 문자열 가져오기
	    List<String> jsonStringList = organizationDao.approvedStandard(organizationBean);

	    // 반환할 결과 리스트
	    List<String> result = new ArrayList<>();

	    // JSON 문자열이 null이거나 비어 있으면 빈 리스트 반환
	    if (jsonStringList == null || jsonStringList.isEmpty()) {
	        return result;
	    }

	    // JSON 문자열 각각을 List<String>으로 변환
	    ObjectMapper objectMapper = new ObjectMapper();
	    for (String jsonString : jsonStringList) {
	        if (jsonString != null && !jsonString.isEmpty() && !jsonString.equals("[]")) {
	            // JSON 문자열을 파싱하여 리스트에 추가
	            List<String> parsedList = objectMapper.readValue(jsonString, new TypeReference<List<String>>() {});
	            result.addAll(parsedList);
	        }
	    }

	    return result;
	}

}
