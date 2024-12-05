package com.loglog.api.commons.daos;

import java.util.List;
import java.util.Map;

import com.loglog.api.commons.beans.OrganizationBean;
import com.loglog.api.commons.beans.UserBean;

/**
 * 사용자 DAO
 * 
 * @author SJG
 */
public interface OrganizationDao {
	
	/** 기관 콤보박스 조회*/
	public List<OrganizationBean> selectOrganization(OrganizationBean organizationBean);
	
	/** 기관 콤보박스 조회*/
	public List<OrganizationBean> selectOrganizationList(Map<String,Object> parameter);
	
	/** 기관 콤보박스 조회*/
	public int selectOrganizationCount(Map<String,Object> parameter);
	
	/**기관 상태창 업데이트*/
	public int updateOrgState(OrganizationBean organizationBean);
	
	/**기관 상태창 업데이트*/
	public int deleteOrg(OrganizationBean organizationBean);
	
	/** 평가권한 배분 팝업에 기관의 평가권한 조회*/
	public List<String> approvedStandard(OrganizationBean organizationBean);
	
}