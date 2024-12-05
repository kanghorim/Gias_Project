 package com.loglog.api.commons.beans;

import java.util.List;
import java.util.Set;

/**
 * 사용자 Bean
 * 
 * @author SJG
 */
public class SelectGiasListBean extends CommonBean {
	
	private String domainCode;
	private String domainName;
	private String principleCode;
	private String principleName;
	private String standardCode;
	private String standardName;
	private String evaluationCode;
	private String evaluationName;
	private String evaluationContent;
	private String organizationCode;
	private String evaluationCurrent;
	private String evaluationImp;
	private String evaluationScore;
	private String memberCode;
	private String approvedStandard;
	private String evaluationFile1;
	private String evaluationFile2;
	private String evaluationFile3;
	private String evaluationFile4;
	private String evaluationFile5;
	private String evaluationFile6;
	private String evaluationFile7;
	private String checkAdminMember;
	
	private List<String> evaluationCodeList;
	
	
	
	public List<String> getEvaluationCodeList() {
		return evaluationCodeList;
	}
	public void setEvaluationCodeList(List<String> evaluationCodeList) {
		this.evaluationCodeList = evaluationCodeList;
	}
	public String getCheckAdminMember() {
		return checkAdminMember;
	}
	public void setCheckAdminMember(String checkAdminMember) {
		this.checkAdminMember = checkAdminMember;
	}
	public String getEvaluationFile1() {
		return evaluationFile1;
	}
	public void setEvaluationFile1(String evaluationFile1) {
		this.evaluationFile1 = evaluationFile1;
	}
	public String getEvaluationFile2() {
		return evaluationFile2;
	}
	public void setEvaluationFile2(String evaluationFile2) {
		this.evaluationFile2 = evaluationFile2;
	}
	public String getEvaluationFile3() {
		return evaluationFile3;
	}
	public void setEvaluationFile3(String evaluationFile3) {
		this.evaluationFile3 = evaluationFile3;
	}
	public String getEvaluationFile4() {
		return evaluationFile4;
	}
	public void setEvaluationFile4(String evaluationFile4) {
		this.evaluationFile4 = evaluationFile4;
	}
	public String getEvaluationFile5() {
		return evaluationFile5;
	}
	public void setEvaluationFile5(String evaluationFile5) {
		this.evaluationFile5 = evaluationFile5;
	}
	public String getEvaluationFile6() {
		return evaluationFile6;
	}
	public void setEvaluationFile6(String evaluationFile6) {
		this.evaluationFile6 = evaluationFile6;
	}
	public String getEvaluationFile7() {
		return evaluationFile7;
	}
	public void setEvaluationFile7(String evaluationFile7) {
		this.evaluationFile7 = evaluationFile7;
	}
	private List<String> approvedStandardList;
	private Set<String> approvedStandardSet; // 필드 추가
	
	public String getEvaluationContent() {
		return evaluationContent;
	}
	public void setEvaluationContent(String evaluationContent) {
		this.evaluationContent = evaluationContent;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getEvaluationCurrent() {
		return evaluationCurrent;
	}
	public void setEvaluationCurrent(String evaluationCurrent) {
		this.evaluationCurrent = evaluationCurrent;
	}
	public String getEvaluationImp() {
		return evaluationImp;
	}
	public void setEvaluationImp(String evaluationImp) {
		this.evaluationImp = evaluationImp;
	}
	public String getDomainCode() {
		return domainCode;
	}
	public void setDomainCode(String domainCode) {
		this.domainCode = domainCode;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getPrincipleCode() {
		return principleCode;
	}
	public void setPrincipleCode(String principleCode) {
		this.principleCode = principleCode;
	}
	public String getPrincipleName() {
		return principleName;
	}
	public void setPrincipleName(String principleName) {
		this.principleName = principleName;
	}
	public String getEvaluationName() {
		return evaluationName;
	}
	public void setEvaluationName(String evaluationName) {
		this.evaluationName = evaluationName;
	}
	public Set<String> getApprovedStandardSet() {
		return approvedStandardSet;
	}
	public void setApprovedStandardSet(Set<String> approvedStandardSet) {
		this.approvedStandardSet = approvedStandardSet;
	}
	public List<String> getApprovedStandardList() {
		return approvedStandardList;
	}
	public void setApprovedStandardList(List<String> approvedStandardList) {
		this.approvedStandardList = approvedStandardList;
	}
	public String getApprovedStandard() {
		return approvedStandard;
	}
	public void setApprovedStandard(String approvedStandard) {
		this.approvedStandard = approvedStandard;
	}
	public String getEvaluationCode() {
		return evaluationCode;
	}
	public void setEvaluationCode(String evaluationCode) {
		this.evaluationCode = evaluationCode;
	}
	public String getEvaluationScore() {
		return evaluationScore;
	}
	public void setEvaluationScore(String evaluationScore) {
		this.evaluationScore = evaluationScore;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getStandardCode() {
		return standardCode;
	}
	public void setStandardCode(String standardCode) {
		this.standardCode = standardCode;
	}
	public String getStandardName() {
		return standardName;
	}
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
	
	
}