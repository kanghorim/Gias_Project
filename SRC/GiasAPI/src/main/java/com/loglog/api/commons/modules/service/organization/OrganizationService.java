package com.loglog.api.commons.modules.service.organization;

import java.util.List;
import java.util.Map;

import com.loglog.api.commons.beans.OrganizationBean;
import com.loglog.api.commons.beans.PagingBean;
import com.loglog.api.commons.beans.UserBean;

public interface OrganizationService {
	
	/** 기관 관리 조회*/
	public List<OrganizationBean> selectOrganization(OrganizationBean organizationBean)throws Exception;
	
	/** 기관 콤보박스 조회*/
	public List<OrganizationBean> selectOrganizationList(OrganizationBean organizationBean,PagingBean pagingBean)throws Exception;
	
	/** 기관 콤보박스 조회*/
	public int selectOrganizationCount(OrganizationBean organizationBean,PagingBean pagingBean)throws Exception;
	
	
	/**기관 상태창 업데이트*/
	public int updateOrgState(OrganizationBean organizationBean)throws Exception;
	
	/**기관 상태창 업데이트*/
	public int deleteOrg(OrganizationBean organizationBean)throws Exception;
	
	/** 평가권한 배분 팝업에 유저의 평가권한 조회*/
	public List<String> approvedStandard(OrganizationBean organizationBean)throws Exception;
	
}
