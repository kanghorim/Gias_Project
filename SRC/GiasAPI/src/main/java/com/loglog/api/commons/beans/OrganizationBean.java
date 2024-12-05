 package com.loglog.api.commons.beans;

import java.util.List;

/**
 * 사용자 Bean
 * 
 * @author SJG
 */
public class OrganizationBean extends CommonBean {
	
	/**기업코드*/
	private String organizationCode;
	/** 기업 이름*/
	private String organizationName;
	/** 가입날*/
	private String joinDate;
	/** 승인자*/
	private String approver;
	/** 상태값 0 :  비활성 , 1: 활성*/
	private int state;
	/** 번호*/
	private String No;
	/**승인자 이름*/
	private String memberName;
	
	/**기관이 평가항목 개수들 확인 항목 224개 현황 개선사항 점수 3개 합치면 672개 */
	private String giasState;
	
	public String getGiasState() {
		return giasState;
	}
	public void setGiasState(String giasState) {
		this.giasState = giasState;
	}
	/** 기관별로 승인된 품질평가 스탠다드 항목이 몆개인지 확인 총52개가 승인되면 전부 승인된 것임*/
	private String approverCount;
	
	/**기관마다 승인된 스탠다드 코드 리스트 형식임*/
	private List<String> approvedStandardList;
	
	public List<String> getApprovedStandardList() {
		return approvedStandardList;
	}
	public void setApprovedStandardList(List<String> approvedStandardList) {
		this.approvedStandardList = approvedStandardList;
	}
	public String getApproverCount() {
		return approverCount;
	}
	public void setApproverCount(String approverCount) {
		this.approverCount = approverCount;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
}