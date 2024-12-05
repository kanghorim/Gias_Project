 package com.loglog.api.commons.beans;

import java.util.List;

/**
 * 사용자 Bean
 * 
 * @author SJG
 */
public class UserBean extends CommonBean {

	/**그리드 번호*/
	private String No;
	/*맴버 코드*/
	private String memberCode;
	/* 맴버 아이디*/
	private String id;
	/*맴버 비밀번호*/
	private String memberPassword;
	/*맴버 이름*/
	private String memberName;
	/*맴버 부서*/
	private String dept;
	/*생성 날짜*/
	private String createAt;
	/*수정 날짜*/
	private String updateAt;
	/*승인자*/
	private String approver;
	/*상태값*/
	private int state;
	/*부서코드*/
	private String organizationCode;
	/*권한*/
	private String privilege;
	/*핸드폰 번호*/
	private String phonNumber;
	
	/**기업 이름*/
	private String organizationName;
	
	/**유저마다 승인된 스탠다드 코드 리스트 형식임*/
	private String approvedStandard;
	
	/**유저마다 승인된 스탠다드 코드 리스트 형식임*/
	private List<String> approvedStandardList;
	
	private List<List<String>> approvedStandardListList;
	
	/**승인된 org코드 리스트 조회*/
	private List<String> approvedOrgCodeList;
	
	
	public List<String> getApprovedOrgCodeList() {
		return approvedOrgCodeList;
	}
	public void setApprovedOrgCodeList(List<String> approvedOrgCodeList) {
		this.approvedOrgCodeList = approvedOrgCodeList;
	}
	public List<List<String>> getApprovedStandardListList() {
		return approvedStandardListList;
	}
	public void setApprovedStandardListList(List<List<String>> approvedStandardListList) {
		this.approvedStandardListList = approvedStandardListList;
	}
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public String getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
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
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public String getPhonNumber() {
		return phonNumber;
	}
	public void setPhonNumber(String phonNumber) {
		this.phonNumber = phonNumber;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
	public String getApprovedStandard() {
		return approvedStandard;
	}
	public void setApprovedStandard(String approvedStandard) {
		this.approvedStandard = approvedStandard;
	}
	public List<String> getApprovedStandardList() {
		return approvedStandardList;
	}
	public void setApprovedStandardList(List<String> approvedStandardList) {
		this.approvedStandardList = approvedStandardList;
	}
	
}