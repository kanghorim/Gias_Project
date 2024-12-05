 package com.loglog.api.commons.beans;

/**
 * 사용자 Bean
 * 
 * @author SJG
 */
public class GiasBean extends CommonBean {
	
	/* 도메인 코드*/
	private int domainCode;
	/* 도메인 이름*/
	private String domainName;
	
	/*프린스플 코드*/
	private int principleCode;
	/*프린스플 이름*/
	private String principleName;
	
	/*스탠다드 코드*/
	private int standardCode;
	/*스탠다드 이름*/
	private String standardName;
	
	/*평가사항 코드*/
	private String evaluationCode;
	/*평가사항 이름*/
	private String evaluationName;
	
	/*공단 코드*/
	private String organizationCode;
	/*공단 이름*/
	private String organizationName;
	
	/*공단 평가 내용*/
	private String evaluationContent;
	/*공단 평가 점수*/
	private String evaluationScore;
	
	/**저장하는 맴버 코드*/
	private String memberCode;
	
	
	/**평가 내용*/
	private String evlContent1_1_1;
	private String evlContent1_1_2;
	private String evlContent1_1_3;
	private String evlContent1_1_4;
	private String evlContent1_1_5;
	private String evlContent1_2_1;
	private String evlContent1_2_2;
	private String evlContent1_2_3;
	private String evlContent1_2_4;
	private String evlContent1_2_5;
	private String evlContent1_3_1;
	private String evlContent1_3_2;
	private String evlContent1_3_3;
	private String evlContent1_3_4;
	private String evlContent2_1_1;
	private String evlContent2_1_2;
	private String evlContent2_1_3;
	private String evlContent2_1_4;
	private String evlContent2_1_5;
	private String evlContent2_2_1;
	private String evlContent2_2_2;
	private String evlContent2_2_3;
	private String evlContent2_2_4;
	private String evlContent2_2_5;
	private String evlContent2_3_1;
	private String evlContent2_3_2;
	private String evlContent2_3_3;
	private String evlContent2_3_4;
	private String evlContent3_1_1;
	private String evlContent3_1_2;
	private String evlContent3_1_3;
	private String evlContent3_1_4;
	private String evlContent3_1_5;
	private String evlContent3_2_1;
	private String evlContent3_2_2;
	private String evlContent3_2_3;
	private String evlContent3_2_4;
	private String evlContent3_2_5;
	private String evlContent4_1_1;
	private String evlContent4_1_2;
	private String evlContent4_1_3;
	private String evlContent4_1_4;
	private String evlContent4_2_1;
	private String evlContent4_2_2;
	private String evlContent4_2_3;
	private String evlContent4_2_4;
	private String evlContent4_2_5;
	private String evlContent4_3_1;
	private String evlContent4_3_2;
	private String evlContent4_3_3;
	private String evlContent5_1_1;
	private String evlContent5_1_2;
	private String evlContent5_1_3;
	private String evlContent5_2_1;
	private String evlContent5_2_2;
	private String evlContent5_2_3;
	private String evlContent5_2_4;
	private String evlContent5_2_5;
	private String evlContent6_1_1;
	private String evlContent6_1_2;
	private String evlContent6_1_3;
	private String evlContent6_1_4;
	private String evlContent6_1_5;
	private String evlContent6_2_1;
	private String evlContent6_2_2;
	private String evlContent6_2_3;
	private String evlContent6_2_4;
	private String evlContent6_2_5;
	private String evlContent6_3_1;
	private String evlContent6_3_2;
	private String evlContent6_3_3;
	private String evlContent6_3_4;
	private String evlContent7_1_1;
	private String evlContent7_1_2;
	private String evlContent7_1_3;
	private String evlContent7_1_4;
	private String evlContent7_2_1;
	private String evlContent7_2_2;
	private String evlContent7_2_3;
	private String evlContent7_2_4;
	private String evlContent8_1_1;
	private String evlContent8_1_2;
	private String evlContent8_1_3;
	private String evlContent8_1_4;
	private String evlContent8_2_1;
	private String evlContent8_2_2;
	private String evlContent8_2_3;
	private String evlContent8_2_4;
	private String evlContent8_2_5;
	private String evlContent8_3_1;
	private String evlContent8_3_2;
	private String evlContent8_3_3;
	private String evlContent8_4_1;
	private String evlContent8_4_2;
	private String evlContent8_4_3;
	private String evlContent8_4_4;
	private String evlContent9_1_1;
	private String evlContent9_1_2;
	private String evlContent9_1_3;
	private String evlContent9_2_1;
	private String evlContent9_2_2;
	private String evlContent9_2_3;
	private String evlContent9_2_4;
	private String evlContent9_2_5;
	private String evlContent9_3_1;
	private String evlContent9_3_2;
	private String evlContent9_3_3;
	private String evlContent9_3_4;
	private String evlContent9_4_1;
	private String evlContent9_4_2;
	private String evlContent9_4_3;
	private String evlContent9_4_4;
	private String evlContent9_4_5;
	private String evlContent9_5_1;
	private String evlContent9_5_2;
	private String evlContent9_5_3;
	private String evlContent9_5_4;
	private String evlContent9_5_5;
	private String evlContent10_1_1;
	private String evlContent10_1_2;
	private String evlContent10_1_3;
	private String evlContent10_1_4;
	private String evlContent10_1_5;
	private String evlContent10_2_1;
	private String evlContent10_2_2;
	private String evlContent10_2_3;
	private String evlContent10_2_4;
	private String evlContent10_2_5;
	private String evlContent10_3_1;
	private String evlContent10_3_2;
	private String evlContent10_3_3;
	private String evlContent10_3_4;
	private String evlContent11_1_1;
	private String evlContent11_1_2;
	private String evlContent11_1_3;
	private String evlContent11_1_4;
	private String evlContent11_1_5;
	private String evlContent11_2_1;
	private String evlContent11_2_2;
	private String evlContent11_2_3;
	private String evlContent11_2_4;
	private String evlContent11_2_5;
	private String evlContent11_3_1;
	private String evlContent11_3_2;
	private String evlContent11_3_3;
	private String evlContent11_3_4;
	private String evlContent11_4_1;
	private String evlContent11_4_2;
	private String evlContent11_4_3;
	private String evlContent11_4_4;
	private String evlContent11_5_1;
	private String evlContent11_5_2;
	private String evlContent11_5_3;
	private String evlContent11_5_4;
	private String evlContent11_5_5;
	private String evlContent12_1_1;
	private String evlContent12_1_2;
	private String evlContent12_1_3;
	private String evlContent12_1_4;
	private String evlContent12_1_5;
	private String evlContent12_2_1;
	private String evlContent12_2_2;
	private String evlContent12_2_3;
	private String evlContent12_2_4;
	private String evlContent12_2_5;
	private String evlContent12_3_1;
	private String evlContent12_3_2;
	private String evlContent12_3_3;
	private String evlContent12_3_4;
	private String evlContent12_3_5;
	private String evlContent13_1_1;
	private String evlContent13_1_2;
	private String evlContent13_1_3;
	private String evlContent13_1_4;
	private String evlContent13_1_5;
	private String evlContent13_2_1;
	private String evlContent13_2_2;
	private String evlContent13_2_3;
	private String evlContent13_2_4;
	private String evlContent13_2_5;
	private String evlContent13_3_1;
	private String evlContent13_3_2;
	private String evlContent13_3_3;
	private String evlContent13_3_4;
	private String evlContent13_4_1;
	private String evlContent13_4_2;
	private String evlContent13_4_3;
	private String evlContent13_4_4;
	private String evlContent13_5_1;
	private String evlContent13_5_2;
	private String evlContent13_5_3;
	private String evlContent13_6_1;
	private String evlContent13_6_2;
	private String evlContent13_6_3;
	private String evlContent13_6_4;
	private String evlContent14_1_1;
	private String evlContent14_1_2;
	private String evlContent14_1_3;
	private String evlContent14_1_4;
	private String evlContent14_1_5;
	private String evlContent14_2_1;
	private String evlContent14_2_2;
	private String evlContent14_2_3;
	private String evlContent14_3_1;
	private String evlContent14_3_2;
	private String evlContent14_3_3;
	private String evlContent14_4_1;
	private String evlContent14_4_2;
	private String evlContent14_4_3;
	private String evlContent14_4_4;
	private String evlContent14_5_1;
	private String evlContent14_5_2;
	private String evlContent14_5_3;
	private String evlContent14_5_4;
	private String evlContent14_6_1;
	private String evlContent14_6_2;
	private String evlContent14_6_3;
	private String evlContent14_6_4;
	private String evlContent15_1_1;
	private String evlContent15_1_2;
	private String evlContent15_1_3;
	private String evlContent15_1_4;
	private String evlContent15_2_1;
	private String evlContent15_2_2;
	private String evlContent15_2_3;
	private String evlContent15_2_4;
	
	/**평가 점수*/
    private String evlScore1_1_1;
	private String evlScore1_1_2;
	private String evlScore1_1_3;
	private String evlScore1_1_4;
	private String evlScore1_1_5;
	private String evlScore1_2_1;
	private String evlScore1_2_2;
	private String evlScore1_2_3;
	private String evlScore1_2_4;
	private String evlScore1_2_5;
	private String evlScore1_3_1;
	private String evlScore1_3_2;
	private String evlScore1_3_3;
	private String evlScore1_3_4;
	private String evlScore2_1_1;
	private String evlScore2_1_2;
	private String evlScore2_1_3;
	private String evlScore2_1_4;
	private String evlScore2_1_5;
	private String evlScore2_2_1;
	private String evlScore2_2_2;
	private String evlScore2_2_3;
	private String evlScore2_2_4;
	private String evlScore2_2_5;
	private String evlScore2_3_1;
	private String evlScore2_3_2;
	private String evlScore2_3_3;
	private String evlScore2_3_4;
	private String evlScore3_1_1;
	private String evlScore3_1_2;
	private String evlScore3_1_3;
	private String evlScore3_1_4;
	private String evlScore3_1_5;
	private String evlScore3_2_1;
	private String evlScore3_2_2;
	private String evlScore3_2_3;
	private String evlScore3_2_4;
	private String evlScore3_2_5;
	private String evlScore4_1_1;
	private String evlScore4_1_2;
	private String evlScore4_1_3;
	private String evlScore4_1_4;
	private String evlScore4_2_1;
	private String evlScore4_2_2;
	private String evlScore4_2_3;
	private String evlScore4_2_4;
	private String evlScore4_2_5;
	private String evlScore4_3_1;
	private String evlScore4_3_2;
	private String evlScore4_3_3;
	private String evlScore5_1_1;
	private String evlScore5_1_2;
	private String evlScore5_1_3;
	private String evlScore5_2_1;
	private String evlScore5_2_2;
	private String evlScore5_2_3;
	private String evlScore5_2_4;
	private String evlScore5_2_5;
	private String evlScore6_1_1;
	private String evlScore6_1_2;
	private String evlScore6_1_3;
	private String evlScore6_1_4;
	private String evlScore6_1_5;
	private String evlScore6_2_1;
	private String evlScore6_2_2;
	private String evlScore6_2_3;
	private String evlScore6_2_4;
	private String evlScore6_2_5;
	private String evlScore6_3_1;
	private String evlScore6_3_2;
	private String evlScore6_3_3;
	private String evlScore6_3_4;
	private String evlScore7_1_1;
	private String evlScore7_1_2;
	private String evlScore7_1_3;
	private String evlScore7_1_4;
	private String evlScore7_2_1;
	private String evlScore7_2_2;
	private String evlScore7_2_3;
	private String evlScore7_2_4;
	private String evlScore8_1_1;
	private String evlScore8_1_2;
	private String evlScore8_1_3;
	private String evlScore8_1_4;
	private String evlScore8_2_1;
	private String evlScore8_2_2;
	private String evlScore8_2_3;
	private String evlScore8_2_4;
	private String evlScore8_2_5;
	private String evlScore8_3_1;
	private String evlScore8_3_2;
	private String evlScore8_3_3;
	private String evlScore8_4_1;
	private String evlScore8_4_2;
	private String evlScore8_4_3;
	private String evlScore8_4_4;
	private String evlScore9_1_1;
	private String evlScore9_1_2;
	private String evlScore9_1_3;
	private String evlScore9_2_1;
	private String evlScore9_2_2;
	private String evlScore9_2_3;
	private String evlScore9_2_4;
	private String evlScore9_2_5;
	private String evlScore9_3_1;
	private String evlScore9_3_2;
	private String evlScore9_3_3;
	private String evlScore9_3_4;
	private String evlScore9_4_1;
	private String evlScore9_4_2;
	private String evlScore9_4_3;
	private String evlScore9_4_4;
	private String evlScore9_4_5;
	private String evlScore9_5_1;
	private String evlScore9_5_2;
	private String evlScore9_5_3;
	private String evlScore9_5_4;
	private String evlScore9_5_5;
	private String evlScore10_1_1;
	private String evlScore10_1_2;
	private String evlScore10_1_3;
	private String evlScore10_1_4;
	private String evlScore10_1_5;
	private String evlScore10_2_1;
	private String evlScore10_2_2;
	private String evlScore10_2_3;
	private String evlScore10_2_4;
	private String evlScore10_2_5;
	private String evlScore10_3_1;
	private String evlScore10_3_2;
	private String evlScore10_3_3;
	private String evlScore10_3_4;
	private String evlScore11_1_1;
	private String evlScore11_1_2;
	private String evlScore11_1_3;
	private String evlScore11_1_4;
	private String evlScore11_1_5;
	private String evlScore11_2_1;
	private String evlScore11_2_2;
	private String evlScore11_2_3;
	private String evlScore11_2_4;
	private String evlScore11_2_5;
	private String evlScore11_3_1;
	private String evlScore11_3_2;
	private String evlScore11_3_3;
	private String evlScore11_3_4;
	private String evlScore11_4_1;
	private String evlScore11_4_2;
	private String evlScore11_4_3;
	private String evlScore11_4_4;
	private String evlScore11_5_1;
	private String evlScore11_5_2;
	private String evlScore11_5_3;
	private String evlScore11_5_4;
	private String evlScore11_5_5;
	private String evlScore12_1_1;
	private String evlScore12_1_2;
	private String evlScore12_1_3;
	private String evlScore12_1_4;
	private String evlScore12_1_5;
	private String evlScore12_2_1;
	private String evlScore12_2_2;
	private String evlScore12_2_3;
	private String evlScore12_2_4;
	private String evlScore12_2_5;
	private String evlScore12_3_1;
	private String evlScore12_3_2;
	private String evlScore12_3_3;
	private String evlScore12_3_4;
	private String evlScore12_3_5;
	private String evlScore13_1_1;
	private String evlScore13_1_2;
	private String evlScore13_1_3;
	private String evlScore13_1_4;
	private String evlScore13_1_5;
	private String evlScore13_2_1;
	private String evlScore13_2_2;
	private String evlScore13_2_3;
	private String evlScore13_2_4;
	private String evlScore13_2_5;
	private String evlScore13_3_1;
	private String evlScore13_3_2;
	private String evlScore13_3_3;
	private String evlScore13_3_4;
	private String evlScore13_4_1;
	private String evlScore13_4_2;
	private String evlScore13_4_3;
	private String evlScore13_4_4;
	private String evlScore13_5_1;
	private String evlScore13_5_2;
	private String evlScore13_5_3;
	private String evlScore13_6_1;
	private String evlScore13_6_2;
	private String evlScore13_6_3;
	private String evlScore13_6_4;
	private String evlScore14_1_1;
	private String evlScore14_1_2;
	private String evlScore14_1_3;
	private String evlScore14_1_4;
	private String evlScore14_1_5;
	private String evlScore14_2_1;
	private String evlScore14_2_2;
	private String evlScore14_2_3;
	private String evlScore14_3_1;
	private String evlScore14_3_2;
	private String evlScore14_3_3;
	private String evlScore14_4_1;
	private String evlScore14_4_2;
	private String evlScore14_4_3;
	private String evlScore14_4_4;
	private String evlScore14_5_1;
	private String evlScore14_5_2;
	private String evlScore14_5_3;
	private String evlScore14_5_4;
	private String evlScore14_6_1;
	private String evlScore14_6_2;
	private String evlScore14_6_3;
	private String evlScore14_6_4;
	private String evlScore15_1_1;
	private String evlScore15_1_2;
	private String evlScore15_1_3;
	private String evlScore15_1_4;
	private String evlScore15_2_1;
	private String evlScore15_2_2;
	private String evlScore15_2_3;
	private String evlScore15_2_4;
	
	
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public int getDomainCode() {
		return domainCode;
	}
	public void setDomainCode(int domainCode) {
		this.domainCode = domainCode;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public int getPrincipleCode() {
		return principleCode;
	}
	public void setPrincipleCode(int principleCode) {
		this.principleCode = principleCode;
	}
	public String getPrincipleName() {
		return principleName;
	}
	public void setPrincipleName(String principleName) {
		this.principleName = principleName;
	}
	public int getStandardCode() {
		return standardCode;
	}
	public void setStandardCode(int standardCode) {
		this.standardCode = standardCode;
	}
	public String getStandardName() {
		return standardName;
	}
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
	
	
	public String getEvaluationCode() {
		return evaluationCode;
	}
	public void setEvaluationCode(String evaluationCode) {
		this.evaluationCode = evaluationCode;
	}
	public String getEvaluationName() {
		return evaluationName;
	}
	public void setEvaluationName(String evaluationName) {
		this.evaluationName = evaluationName;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public String getEvlContent1_1_1() {
		return evlContent1_1_1;
	}
	public void setEvlContent1_1_1(String evlContent1_1_1) {
		this.evlContent1_1_1 = evlContent1_1_1;
	}
	public String getEvlContent1_1_2() {
		return evlContent1_1_2;
	}
	public void setEvlContent1_1_2(String evlContent1_1_2) {
		this.evlContent1_1_2 = evlContent1_1_2;
	}
	public String getEvlContent1_1_3() {
		return evlContent1_1_3;
	}
	public void setEvlContent1_1_3(String evlContent1_1_3) {
		this.evlContent1_1_3 = evlContent1_1_3;
	}
	public String getEvlContent1_1_4() {
		return evlContent1_1_4;
	}
	public void setEvlContent1_1_4(String evlContent1_1_4) {
		this.evlContent1_1_4 = evlContent1_1_4;
	}
	public String getEvlContent1_1_5() {
		return evlContent1_1_5;
	}
	public void setEvlContent1_1_5(String evlContent1_1_5) {
		this.evlContent1_1_5 = evlContent1_1_5;
	}
	public String getEvlContent1_2_1() {
		return evlContent1_2_1;
	}
	public void setEvlContent1_2_1(String evlContent1_2_1) {
		this.evlContent1_2_1 = evlContent1_2_1;
	}
	public String getEvlContent1_2_2() {
		return evlContent1_2_2;
	}
	public void setEvlContent1_2_2(String evlContent1_2_2) {
		this.evlContent1_2_2 = evlContent1_2_2;
	}
	public String getEvlContent1_2_3() {
		return evlContent1_2_3;
	}
	public void setEvlContent1_2_3(String evlContent1_2_3) {
		this.evlContent1_2_3 = evlContent1_2_3;
	}
	public String getEvlContent1_2_4() {
		return evlContent1_2_4;
	}
	public void setEvlContent1_2_4(String evlContent1_2_4) {
		this.evlContent1_2_4 = evlContent1_2_4;
	}
	public String getEvlContent1_2_5() {
		return evlContent1_2_5;
	}
	public void setEvlContent1_2_5(String evlContent1_2_5) {
		this.evlContent1_2_5 = evlContent1_2_5;
	}
	public String getEvlContent1_3_1() {
		return evlContent1_3_1;
	}
	public void setEvlContent1_3_1(String evlContent1_3_1) {
		this.evlContent1_3_1 = evlContent1_3_1;
	}
	public String getEvlContent1_3_2() {
		return evlContent1_3_2;
	}
	public void setEvlContent1_3_2(String evlContent1_3_2) {
		this.evlContent1_3_2 = evlContent1_3_2;
	}
	public String getEvlContent1_3_3() {
		return evlContent1_3_3;
	}
	public void setEvlContent1_3_3(String evlContent1_3_3) {
		this.evlContent1_3_3 = evlContent1_3_3;
	}
	public String getEvlContent1_3_4() {
		return evlContent1_3_4;
	}
	public void setEvlContent1_3_4(String evlContent1_3_4) {
		this.evlContent1_3_4 = evlContent1_3_4;
	}
	public String getEvlContent2_1_1() {
		return evlContent2_1_1;
	}
	public void setEvlContent2_1_1(String evlContent2_1_1) {
		this.evlContent2_1_1 = evlContent2_1_1;
	}
	public String getEvlContent2_1_2() {
		return evlContent2_1_2;
	}
	public void setEvlContent2_1_2(String evlContent2_1_2) {
		this.evlContent2_1_2 = evlContent2_1_2;
	}
	public String getEvlContent2_1_3() {
		return evlContent2_1_3;
	}
	public void setEvlContent2_1_3(String evlContent2_1_3) {
		this.evlContent2_1_3 = evlContent2_1_3;
	}
	public String getEvlContent2_1_4() {
		return evlContent2_1_4;
	}
	public void setEvlContent2_1_4(String evlContent2_1_4) {
		this.evlContent2_1_4 = evlContent2_1_4;
	}
	public String getEvlContent2_1_5() {
		return evlContent2_1_5;
	}
	public void setEvlContent2_1_5(String evlContent2_1_5) {
		this.evlContent2_1_5 = evlContent2_1_5;
	}
	public String getEvlContent2_2_1() {
		return evlContent2_2_1;
	}
	public void setEvlContent2_2_1(String evlContent2_2_1) {
		this.evlContent2_2_1 = evlContent2_2_1;
	}
	public String getEvlContent2_2_2() {
		return evlContent2_2_2;
	}
	public void setEvlContent2_2_2(String evlContent2_2_2) {
		this.evlContent2_2_2 = evlContent2_2_2;
	}
	public String getEvlContent2_2_3() {
		return evlContent2_2_3;
	}
	public void setEvlContent2_2_3(String evlContent2_2_3) {
		this.evlContent2_2_3 = evlContent2_2_3;
	}
	public String getEvlContent2_2_4() {
		return evlContent2_2_4;
	}
	public void setEvlContent2_2_4(String evlContent2_2_4) {
		this.evlContent2_2_4 = evlContent2_2_4;
	}
	public String getEvlContent2_2_5() {
		return evlContent2_2_5;
	}
	public void setEvlContent2_2_5(String evlContent2_2_5) {
		this.evlContent2_2_5 = evlContent2_2_5;
	}
	public String getEvlContent2_3_1() {
		return evlContent2_3_1;
	}
	public void setEvlContent2_3_1(String evlContent2_3_1) {
		this.evlContent2_3_1 = evlContent2_3_1;
	}
	public String getEvlContent2_3_2() {
		return evlContent2_3_2;
	}
	public void setEvlContent2_3_2(String evlContent2_3_2) {
		this.evlContent2_3_2 = evlContent2_3_2;
	}
	public String getEvlContent2_3_3() {
		return evlContent2_3_3;
	}
	public void setEvlContent2_3_3(String evlContent2_3_3) {
		this.evlContent2_3_3 = evlContent2_3_3;
	}
	public String getEvlContent2_3_4() {
		return evlContent2_3_4;
	}
	public void setEvlContent2_3_4(String evlContent2_3_4) {
		this.evlContent2_3_4 = evlContent2_3_4;
	}
	public String getEvlScore1_1_1() {
		return evlScore1_1_1;
	}
	public void setEvlScore1_1_1(String evlScore1_1_1) {
		this.evlScore1_1_1 = evlScore1_1_1;
	}
	public String getEvlScore1_1_2() {
		return evlScore1_1_2;
	}
	public void setEvlScore1_1_2(String evlScore1_1_2) {
		this.evlScore1_1_2 = evlScore1_1_2;
	}
	public String getEvlScore1_1_3() {
		return evlScore1_1_3;
	}
	public void setEvlScore1_1_3(String evlScore1_1_3) {
		this.evlScore1_1_3 = evlScore1_1_3;
	}
	public String getEvlScore1_1_4() {
		return evlScore1_1_4;
	}
	public void setEvlScore1_1_4(String evlScore1_1_4) {
		this.evlScore1_1_4 = evlScore1_1_4;
	}
	public String getEvlScore1_1_5() {
		return evlScore1_1_5;
	}
	public void setEvlScore1_1_5(String evlScore1_1_5) {
		this.evlScore1_1_5 = evlScore1_1_5;
	}
	public String getEvlScore1_2_1() {
		return evlScore1_2_1;
	}
	public void setEvlScore1_2_1(String evlScore1_2_1) {
		this.evlScore1_2_1 = evlScore1_2_1;
	}
	public String getEvlScore1_2_2() {
		return evlScore1_2_2;
	}
	public void setEvlScore1_2_2(String evlScore1_2_2) {
		this.evlScore1_2_2 = evlScore1_2_2;
	}
	public String getEvlScore1_2_3() {
		return evlScore1_2_3;
	}
	public void setEvlScore1_2_3(String evlScore1_2_3) {
		this.evlScore1_2_3 = evlScore1_2_3;
	}
	public String getEvlScore1_2_4() {
		return evlScore1_2_4;
	}
	public void setEvlScore1_2_4(String evlScore1_2_4) {
		this.evlScore1_2_4 = evlScore1_2_4;
	}
	public String getEvlScore1_2_5() {
		return evlScore1_2_5;
	}
	public void setEvlScore1_2_5(String evlScore1_2_5) {
		this.evlScore1_2_5 = evlScore1_2_5;
	}
	public String getEvlScore1_3_1() {
		return evlScore1_3_1;
	}
	public void setEvlScore1_3_1(String evlScore1_3_1) {
		this.evlScore1_3_1 = evlScore1_3_1;
	}
	public String getEvlScore1_3_2() {
		return evlScore1_3_2;
	}
	public void setEvlScore1_3_2(String evlScore1_3_2) {
		this.evlScore1_3_2 = evlScore1_3_2;
	}
	public String getEvlScore1_3_3() {
		return evlScore1_3_3;
	}
	public void setEvlScore1_3_3(String evlScore1_3_3) {
		this.evlScore1_3_3 = evlScore1_3_3;
	}
	public String getEvlScore1_3_4() {
		return evlScore1_3_4;
	}
	public void setEvlScore1_3_4(String evlScore1_3_4) {
		this.evlScore1_3_4 = evlScore1_3_4;
	}
	public String getEvlScore2_1_1() {
		return evlScore2_1_1;
	}
	public void setEvlScore2_1_1(String evlScore2_1_1) {
		this.evlScore2_1_1 = evlScore2_1_1;
	}
	public String getEvlScore2_1_2() {
		return evlScore2_1_2;
	}
	public void setEvlScore2_1_2(String evlScore2_1_2) {
		this.evlScore2_1_2 = evlScore2_1_2;
	}
	public String getEvlScore2_1_3() {
		return evlScore2_1_3;
	}
	public void setEvlScore2_1_3(String evlScore2_1_3) {
		this.evlScore2_1_3 = evlScore2_1_3;
	}
	public String getEvlScore2_1_4() {
		return evlScore2_1_4;
	}
	public void setEvlScore2_1_4(String evlScore2_1_4) {
		this.evlScore2_1_4 = evlScore2_1_4;
	}
	public String getEvlScore2_1_5() {
		return evlScore2_1_5;
	}
	public void setEvlScore2_1_5(String evlScore2_1_5) {
		this.evlScore2_1_5 = evlScore2_1_5;
	}
	public String getEvlScore2_2_1() {
		return evlScore2_2_1;
	}
	public void setEvlScore2_2_1(String evlScore2_2_1) {
		this.evlScore2_2_1 = evlScore2_2_1;
	}
	public String getEvlScore2_2_2() {
		return evlScore2_2_2;
	}
	public void setEvlScore2_2_2(String evlScore2_2_2) {
		this.evlScore2_2_2 = evlScore2_2_2;
	}
	public String getEvlScore2_2_3() {
		return evlScore2_2_3;
	}
	public void setEvlScore2_2_3(String evlScore2_2_3) {
		this.evlScore2_2_3 = evlScore2_2_3;
	}
	public String getEvlScore2_2_4() {
		return evlScore2_2_4;
	}
	public void setEvlScore2_2_4(String evlScore2_2_4) {
		this.evlScore2_2_4 = evlScore2_2_4;
	}
	public String getEvlScore2_2_5() {
		return evlScore2_2_5;
	}
	public void setEvlScore2_2_5(String evlScore2_2_5) {
		this.evlScore2_2_5 = evlScore2_2_5;
	}
	public String getEvlScore2_3_1() {
		return evlScore2_3_1;
	}
	public void setEvlScore2_3_1(String evlScore2_3_1) {
		this.evlScore2_3_1 = evlScore2_3_1;
	}
	public String getEvlScore2_3_2() {
		return evlScore2_3_2;
	}
	public void setEvlScore2_3_2(String evlScore2_3_2) {
		this.evlScore2_3_2 = evlScore2_3_2;
	}
	public String getEvlScore2_3_3() {
		return evlScore2_3_3;
	}
	public void setEvlScore2_3_3(String evlScore2_3_3) {
		this.evlScore2_3_3 = evlScore2_3_3;
	}
	public String getEvlScore2_3_4() {
		return evlScore2_3_4;
	}
	public void setEvlScore2_3_4(String evlScore2_3_4) {
		this.evlScore2_3_4 = evlScore2_3_4;
	}
	public String getEvaluationContent() {
		return evaluationContent;
	}
	public void setEvaluationContent(String evaluationContent) {
		this.evaluationContent = evaluationContent;
	}
	public String getEvaluationScore() {
		return evaluationScore;
	}
	public void setEvaluationScore(String evaluationScore) {
		this.evaluationScore = evaluationScore;
	}
	public String getEvlContent3_1_1() {
		return evlContent3_1_1;
	}
	public void setEvlContent3_1_1(String evlContent3_1_1) {
		this.evlContent3_1_1 = evlContent3_1_1;
	}
	public String getEvlContent3_1_2() {
		return evlContent3_1_2;
	}
	public void setEvlContent3_1_2(String evlContent3_1_2) {
		this.evlContent3_1_2 = evlContent3_1_2;
	}
	public String getEvlContent3_1_3() {
		return evlContent3_1_3;
	}
	public void setEvlContent3_1_3(String evlContent3_1_3) {
		this.evlContent3_1_3 = evlContent3_1_3;
	}
	public String getEvlContent3_1_4() {
		return evlContent3_1_4;
	}
	public void setEvlContent3_1_4(String evlContent3_1_4) {
		this.evlContent3_1_4 = evlContent3_1_4;
	}
	public String getEvlContent3_1_5() {
		return evlContent3_1_5;
	}
	public void setEvlContent3_1_5(String evlContent3_1_5) {
		this.evlContent3_1_5 = evlContent3_1_5;
	}
	public String getEvlContent3_2_1() {
		return evlContent3_2_1;
	}
	public void setEvlContent3_2_1(String evlContent3_2_1) {
		this.evlContent3_2_1 = evlContent3_2_1;
	}
	public String getEvlContent3_2_2() {
		return evlContent3_2_2;
	}
	public void setEvlContent3_2_2(String evlContent3_2_2) {
		this.evlContent3_2_2 = evlContent3_2_2;
	}
	public String getEvlContent3_2_3() {
		return evlContent3_2_3;
	}
	public void setEvlContent3_2_3(String evlContent3_2_3) {
		this.evlContent3_2_3 = evlContent3_2_3;
	}
	public String getEvlContent3_2_4() {
		return evlContent3_2_4;
	}
	public void setEvlContent3_2_4(String evlContent3_2_4) {
		this.evlContent3_2_4 = evlContent3_2_4;
	}
	public String getEvlContent3_2_5() {
		return evlContent3_2_5;
	}
	public void setEvlContent3_2_5(String evlContent3_2_5) {
		this.evlContent3_2_5 = evlContent3_2_5;
	}
	public String getEvlContent4_1_1() {
		return evlContent4_1_1;
	}
	public void setEvlContent4_1_1(String evlContent4_1_1) {
		this.evlContent4_1_1 = evlContent4_1_1;
	}
	public String getEvlContent4_1_2() {
		return evlContent4_1_2;
	}
	public void setEvlContent4_1_2(String evlContent4_1_2) {
		this.evlContent4_1_2 = evlContent4_1_2;
	}
	public String getEvlContent4_1_3() {
		return evlContent4_1_3;
	}
	public void setEvlContent4_1_3(String evlContent4_1_3) {
		this.evlContent4_1_3 = evlContent4_1_3;
	}
	public String getEvlContent4_1_4() {
		return evlContent4_1_4;
	}
	public void setEvlContent4_1_4(String evlContent4_1_4) {
		this.evlContent4_1_4 = evlContent4_1_4;
	}
	public String getEvlContent4_2_1() {
		return evlContent4_2_1;
	}
	public void setEvlContent4_2_1(String evlContent4_2_1) {
		this.evlContent4_2_1 = evlContent4_2_1;
	}
	public String getEvlContent4_2_2() {
		return evlContent4_2_2;
	}
	public void setEvlContent4_2_2(String evlContent4_2_2) {
		this.evlContent4_2_2 = evlContent4_2_2;
	}
	public String getEvlContent4_2_3() {
		return evlContent4_2_3;
	}
	public void setEvlContent4_2_3(String evlContent4_2_3) {
		this.evlContent4_2_3 = evlContent4_2_3;
	}
	public String getEvlContent4_2_4() {
		return evlContent4_2_4;
	}
	public void setEvlContent4_2_4(String evlContent4_2_4) {
		this.evlContent4_2_4 = evlContent4_2_4;
	}
	public String getEvlContent4_2_5() {
		return evlContent4_2_5;
	}
	public void setEvlContent4_2_5(String evlContent4_2_5) {
		this.evlContent4_2_5 = evlContent4_2_5;
	}
	public String getEvlContent4_3_1() {
		return evlContent4_3_1;
	}
	public void setEvlContent4_3_1(String evlContent4_3_1) {
		this.evlContent4_3_1 = evlContent4_3_1;
	}
	public String getEvlContent4_3_2() {
		return evlContent4_3_2;
	}
	public void setEvlContent4_3_2(String evlContent4_3_2) {
		this.evlContent4_3_2 = evlContent4_3_2;
	}
	public String getEvlContent4_3_3() {
		return evlContent4_3_3;
	}
	public void setEvlContent4_3_3(String evlContent4_3_3) {
		this.evlContent4_3_3 = evlContent4_3_3;
	}
	public String getEvlContent5_1_1() {
		return evlContent5_1_1;
	}
	public void setEvlContent5_1_1(String evlContent5_1_1) {
		this.evlContent5_1_1 = evlContent5_1_1;
	}
	public String getEvlContent5_1_2() {
		return evlContent5_1_2;
	}
	public void setEvlContent5_1_2(String evlContent5_1_2) {
		this.evlContent5_1_2 = evlContent5_1_2;
	}
	public String getEvlContent5_1_3() {
		return evlContent5_1_3;
	}
	public void setEvlContent5_1_3(String evlContent5_1_3) {
		this.evlContent5_1_3 = evlContent5_1_3;
	}
	public String getEvlContent5_2_1() {
		return evlContent5_2_1;
	}
	public void setEvlContent5_2_1(String evlContent5_2_1) {
		this.evlContent5_2_1 = evlContent5_2_1;
	}
	public String getEvlContent5_2_2() {
		return evlContent5_2_2;
	}
	public void setEvlContent5_2_2(String evlContent5_2_2) {
		this.evlContent5_2_2 = evlContent5_2_2;
	}
	public String getEvlContent5_2_3() {
		return evlContent5_2_3;
	}
	public void setEvlContent5_2_3(String evlContent5_2_3) {
		this.evlContent5_2_3 = evlContent5_2_3;
	}
	public String getEvlContent5_2_4() {
		return evlContent5_2_4;
	}
	public void setEvlContent5_2_4(String evlContent5_2_4) {
		this.evlContent5_2_4 = evlContent5_2_4;
	}
	public String getEvlContent5_2_5() {
		return evlContent5_2_5;
	}
	public void setEvlContent5_2_5(String evlContent5_2_5) {
		this.evlContent5_2_5 = evlContent5_2_5;
	}
	public String getEvlContent6_1_1() {
		return evlContent6_1_1;
	}
	public void setEvlContent6_1_1(String evlContent6_1_1) {
		this.evlContent6_1_1 = evlContent6_1_1;
	}
	public String getEvlContent6_1_2() {
		return evlContent6_1_2;
	}
	public void setEvlContent6_1_2(String evlContent6_1_2) {
		this.evlContent6_1_2 = evlContent6_1_2;
	}
	public String getEvlContent6_1_3() {
		return evlContent6_1_3;
	}
	public void setEvlContent6_1_3(String evlContent6_1_3) {
		this.evlContent6_1_3 = evlContent6_1_3;
	}
	public String getEvlContent6_1_4() {
		return evlContent6_1_4;
	}
	public void setEvlContent6_1_4(String evlContent6_1_4) {
		this.evlContent6_1_4 = evlContent6_1_4;
	}
	public String getEvlContent6_1_5() {
		return evlContent6_1_5;
	}
	public void setEvlContent6_1_5(String evlContent6_1_5) {
		this.evlContent6_1_5 = evlContent6_1_5;
	}
	public String getEvlContent6_2_1() {
		return evlContent6_2_1;
	}
	public void setEvlContent6_2_1(String evlContent6_2_1) {
		this.evlContent6_2_1 = evlContent6_2_1;
	}
	public String getEvlContent6_2_2() {
		return evlContent6_2_2;
	}
	public void setEvlContent6_2_2(String evlContent6_2_2) {
		this.evlContent6_2_2 = evlContent6_2_2;
	}
	public String getEvlContent6_2_3() {
		return evlContent6_2_3;
	}
	public void setEvlContent6_2_3(String evlContent6_2_3) {
		this.evlContent6_2_3 = evlContent6_2_3;
	}
	public String getEvlContent6_2_4() {
		return evlContent6_2_4;
	}
	public void setEvlContent6_2_4(String evlContent6_2_4) {
		this.evlContent6_2_4 = evlContent6_2_4;
	}
	public String getEvlContent6_2_5() {
		return evlContent6_2_5;
	}
	public void setEvlContent6_2_5(String evlContent6_2_5) {
		this.evlContent6_2_5 = evlContent6_2_5;
	}
	public String getEvlContent6_3_1() {
		return evlContent6_3_1;
	}
	public void setEvlContent6_3_1(String evlContent6_3_1) {
		this.evlContent6_3_1 = evlContent6_3_1;
	}
	public String getEvlContent6_3_2() {
		return evlContent6_3_2;
	}
	public void setEvlContent6_3_2(String evlContent6_3_2) {
		this.evlContent6_3_2 = evlContent6_3_2;
	}
	public String getEvlContent6_3_3() {
		return evlContent6_3_3;
	}
	public void setEvlContent6_3_3(String evlContent6_3_3) {
		this.evlContent6_3_3 = evlContent6_3_3;
	}
	public String getEvlContent6_3_4() {
		return evlContent6_3_4;
	}
	public void setEvlContent6_3_4(String evlContent6_3_4) {
		this.evlContent6_3_4 = evlContent6_3_4;
	}
	public String getEvlContent7_1_1() {
		return evlContent7_1_1;
	}
	public void setEvlContent7_1_1(String evlContent7_1_1) {
		this.evlContent7_1_1 = evlContent7_1_1;
	}
	public String getEvlContent7_1_2() {
		return evlContent7_1_2;
	}
	public void setEvlContent7_1_2(String evlContent7_1_2) {
		this.evlContent7_1_2 = evlContent7_1_2;
	}
	public String getEvlContent7_1_3() {
		return evlContent7_1_3;
	}
	public void setEvlContent7_1_3(String evlContent7_1_3) {
		this.evlContent7_1_3 = evlContent7_1_3;
	}
	public String getEvlContent7_1_4() {
		return evlContent7_1_4;
	}
	public void setEvlContent7_1_4(String evlContent7_1_4) {
		this.evlContent7_1_4 = evlContent7_1_4;
	}
	public String getEvlContent7_2_1() {
		return evlContent7_2_1;
	}
	public void setEvlContent7_2_1(String evlContent7_2_1) {
		this.evlContent7_2_1 = evlContent7_2_1;
	}
	public String getEvlContent7_2_2() {
		return evlContent7_2_2;
	}
	public void setEvlContent7_2_2(String evlContent7_2_2) {
		this.evlContent7_2_2 = evlContent7_2_2;
	}
	public String getEvlContent7_2_3() {
		return evlContent7_2_3;
	}
	public void setEvlContent7_2_3(String evlContent7_2_3) {
		this.evlContent7_2_3 = evlContent7_2_3;
	}
	public String getEvlContent7_2_4() {
		return evlContent7_2_4;
	}
	public void setEvlContent7_2_4(String evlContent7_2_4) {
		this.evlContent7_2_4 = evlContent7_2_4;
	}
	public String getEvlContent8_1_1() {
		return evlContent8_1_1;
	}
	public void setEvlContent8_1_1(String evlContent8_1_1) {
		this.evlContent8_1_1 = evlContent8_1_1;
	}
	public String getEvlContent8_1_2() {
		return evlContent8_1_2;
	}
	public void setEvlContent8_1_2(String evlContent8_1_2) {
		this.evlContent8_1_2 = evlContent8_1_2;
	}
	public String getEvlContent8_1_3() {
		return evlContent8_1_3;
	}
	public void setEvlContent8_1_3(String evlContent8_1_3) {
		this.evlContent8_1_3 = evlContent8_1_3;
	}
	public String getEvlContent8_1_4() {
		return evlContent8_1_4;
	}
	public void setEvlContent8_1_4(String evlContent8_1_4) {
		this.evlContent8_1_4 = evlContent8_1_4;
	}
	public String getEvlContent8_2_1() {
		return evlContent8_2_1;
	}
	public void setEvlContent8_2_1(String evlContent8_2_1) {
		this.evlContent8_2_1 = evlContent8_2_1;
	}
	public String getEvlContent8_2_2() {
		return evlContent8_2_2;
	}
	public void setEvlContent8_2_2(String evlContent8_2_2) {
		this.evlContent8_2_2 = evlContent8_2_2;
	}
	public String getEvlContent8_2_3() {
		return evlContent8_2_3;
	}
	public void setEvlContent8_2_3(String evlContent8_2_3) {
		this.evlContent8_2_3 = evlContent8_2_3;
	}
	public String getEvlContent8_2_4() {
		return evlContent8_2_4;
	}
	public void setEvlContent8_2_4(String evlContent8_2_4) {
		this.evlContent8_2_4 = evlContent8_2_4;
	}
	public String getEvlContent8_2_5() {
		return evlContent8_2_5;
	}
	public void setEvlContent8_2_5(String evlContent8_2_5) {
		this.evlContent8_2_5 = evlContent8_2_5;
	}
	public String getEvlContent8_3_1() {
		return evlContent8_3_1;
	}
	public void setEvlContent8_3_1(String evlContent8_3_1) {
		this.evlContent8_3_1 = evlContent8_3_1;
	}
	public String getEvlContent8_3_2() {
		return evlContent8_3_2;
	}
	public void setEvlContent8_3_2(String evlContent8_3_2) {
		this.evlContent8_3_2 = evlContent8_3_2;
	}
	public String getEvlContent8_3_3() {
		return evlContent8_3_3;
	}
	public void setEvlContent8_3_3(String evlContent8_3_3) {
		this.evlContent8_3_3 = evlContent8_3_3;
	}
	public String getEvlContent8_4_1() {
		return evlContent8_4_1;
	}
	public void setEvlContent8_4_1(String evlContent8_4_1) {
		this.evlContent8_4_1 = evlContent8_4_1;
	}
	public String getEvlContent8_4_2() {
		return evlContent8_4_2;
	}
	public void setEvlContent8_4_2(String evlContent8_4_2) {
		this.evlContent8_4_2 = evlContent8_4_2;
	}
	public String getEvlContent8_4_3() {
		return evlContent8_4_3;
	}
	public void setEvlContent8_4_3(String evlContent8_4_3) {
		this.evlContent8_4_3 = evlContent8_4_3;
	}
	public String getEvlContent8_4_4() {
		return evlContent8_4_4;
	}
	public void setEvlContent8_4_4(String evlContent8_4_4) {
		this.evlContent8_4_4 = evlContent8_4_4;
	}
	public String getEvlContent9_1_1() {
		return evlContent9_1_1;
	}
	public void setEvlContent9_1_1(String evlContent9_1_1) {
		this.evlContent9_1_1 = evlContent9_1_1;
	}
	public String getEvlContent9_1_2() {
		return evlContent9_1_2;
	}
	public void setEvlContent9_1_2(String evlContent9_1_2) {
		this.evlContent9_1_2 = evlContent9_1_2;
	}
	public String getEvlContent9_1_3() {
		return evlContent9_1_3;
	}
	public void setEvlContent9_1_3(String evlContent9_1_3) {
		this.evlContent9_1_3 = evlContent9_1_3;
	}
	public String getEvlContent9_2_1() {
		return evlContent9_2_1;
	}
	public void setEvlContent9_2_1(String evlContent9_2_1) {
		this.evlContent9_2_1 = evlContent9_2_1;
	}
	public String getEvlContent9_2_2() {
		return evlContent9_2_2;
	}
	public void setEvlContent9_2_2(String evlContent9_2_2) {
		this.evlContent9_2_2 = evlContent9_2_2;
	}
	public String getEvlContent9_2_3() {
		return evlContent9_2_3;
	}
	public void setEvlContent9_2_3(String evlContent9_2_3) {
		this.evlContent9_2_3 = evlContent9_2_3;
	}
	public String getEvlContent9_2_4() {
		return evlContent9_2_4;
	}
	public void setEvlContent9_2_4(String evlContent9_2_4) {
		this.evlContent9_2_4 = evlContent9_2_4;
	}
	public String getEvlContent9_2_5() {
		return evlContent9_2_5;
	}
	public void setEvlContent9_2_5(String evlContent9_2_5) {
		this.evlContent9_2_5 = evlContent9_2_5;
	}
	public String getEvlContent9_3_1() {
		return evlContent9_3_1;
	}
	public void setEvlContent9_3_1(String evlContent9_3_1) {
		this.evlContent9_3_1 = evlContent9_3_1;
	}
	public String getEvlContent9_3_2() {
		return evlContent9_3_2;
	}
	public void setEvlContent9_3_2(String evlContent9_3_2) {
		this.evlContent9_3_2 = evlContent9_3_2;
	}
	public String getEvlContent9_3_3() {
		return evlContent9_3_3;
	}
	public void setEvlContent9_3_3(String evlContent9_3_3) {
		this.evlContent9_3_3 = evlContent9_3_3;
	}
	public String getEvlContent9_3_4() {
		return evlContent9_3_4;
	}
	public void setEvlContent9_3_4(String evlContent9_3_4) {
		this.evlContent9_3_4 = evlContent9_3_4;
	}
	public String getEvlContent9_4_1() {
		return evlContent9_4_1;
	}
	public void setEvlContent9_4_1(String evlContent9_4_1) {
		this.evlContent9_4_1 = evlContent9_4_1;
	}
	public String getEvlContent9_4_2() {
		return evlContent9_4_2;
	}
	public void setEvlContent9_4_2(String evlContent9_4_2) {
		this.evlContent9_4_2 = evlContent9_4_2;
	}
	public String getEvlContent9_4_3() {
		return evlContent9_4_3;
	}
	public void setEvlContent9_4_3(String evlContent9_4_3) {
		this.evlContent9_4_3 = evlContent9_4_3;
	}
	public String getEvlContent9_4_4() {
		return evlContent9_4_4;
	}
	public void setEvlContent9_4_4(String evlContent9_4_4) {
		this.evlContent9_4_4 = evlContent9_4_4;
	}
	public String getEvlContent9_4_5() {
		return evlContent9_4_5;
	}
	public void setEvlContent9_4_5(String evlContent9_4_5) {
		this.evlContent9_4_5 = evlContent9_4_5;
	}
	public String getEvlContent9_5_1() {
		return evlContent9_5_1;
	}
	public void setEvlContent9_5_1(String evlContent9_5_1) {
		this.evlContent9_5_1 = evlContent9_5_1;
	}
	public String getEvlContent9_5_2() {
		return evlContent9_5_2;
	}
	public void setEvlContent9_5_2(String evlContent9_5_2) {
		this.evlContent9_5_2 = evlContent9_5_2;
	}
	public String getEvlContent9_5_3() {
		return evlContent9_5_3;
	}
	public void setEvlContent9_5_3(String evlContent9_5_3) {
		this.evlContent9_5_3 = evlContent9_5_3;
	}
	public String getEvlContent9_5_4() {
		return evlContent9_5_4;
	}
	public void setEvlContent9_5_4(String evlContent9_5_4) {
		this.evlContent9_5_4 = evlContent9_5_4;
	}
	public String getEvlContent9_5_5() {
		return evlContent9_5_5;
	}
	public void setEvlContent9_5_5(String evlContent9_5_5) {
		this.evlContent9_5_5 = evlContent9_5_5;
	}
	public String getEvlContent10_1_1() {
		return evlContent10_1_1;
	}
	public void setEvlContent10_1_1(String evlContent10_1_1) {
		this.evlContent10_1_1 = evlContent10_1_1;
	}
	public String getEvlContent10_1_2() {
		return evlContent10_1_2;
	}
	public void setEvlContent10_1_2(String evlContent10_1_2) {
		this.evlContent10_1_2 = evlContent10_1_2;
	}
	public String getEvlContent10_1_3() {
		return evlContent10_1_3;
	}
	public void setEvlContent10_1_3(String evlContent10_1_3) {
		this.evlContent10_1_3 = evlContent10_1_3;
	}
	public String getEvlContent10_1_4() {
		return evlContent10_1_4;
	}
	public void setEvlContent10_1_4(String evlContent10_1_4) {
		this.evlContent10_1_4 = evlContent10_1_4;
	}
	public String getEvlContent10_1_5() {
		return evlContent10_1_5;
	}
	public void setEvlContent10_1_5(String evlContent10_1_5) {
		this.evlContent10_1_5 = evlContent10_1_5;
	}
	public String getEvlContent10_2_1() {
		return evlContent10_2_1;
	}
	public void setEvlContent10_2_1(String evlContent10_2_1) {
		this.evlContent10_2_1 = evlContent10_2_1;
	}
	public String getEvlContent10_2_2() {
		return evlContent10_2_2;
	}
	public void setEvlContent10_2_2(String evlContent10_2_2) {
		this.evlContent10_2_2 = evlContent10_2_2;
	}
	public String getEvlContent10_2_3() {
		return evlContent10_2_3;
	}
	public void setEvlContent10_2_3(String evlContent10_2_3) {
		this.evlContent10_2_3 = evlContent10_2_3;
	}
	public String getEvlContent10_2_4() {
		return evlContent10_2_4;
	}
	public void setEvlContent10_2_4(String evlContent10_2_4) {
		this.evlContent10_2_4 = evlContent10_2_4;
	}
	public String getEvlContent10_2_5() {
		return evlContent10_2_5;
	}
	public void setEvlContent10_2_5(String evlContent10_2_5) {
		this.evlContent10_2_5 = evlContent10_2_5;
	}
	public String getEvlContent10_3_1() {
		return evlContent10_3_1;
	}
	public void setEvlContent10_3_1(String evlContent10_3_1) {
		this.evlContent10_3_1 = evlContent10_3_1;
	}
	public String getEvlContent10_3_2() {
		return evlContent10_3_2;
	}
	public void setEvlContent10_3_2(String evlContent10_3_2) {
		this.evlContent10_3_2 = evlContent10_3_2;
	}
	public String getEvlContent10_3_3() {
		return evlContent10_3_3;
	}
	public void setEvlContent10_3_3(String evlContent10_3_3) {
		this.evlContent10_3_3 = evlContent10_3_3;
	}
	public String getEvlContent10_3_4() {
		return evlContent10_3_4;
	}
	public void setEvlContent10_3_4(String evlContent10_3_4) {
		this.evlContent10_3_4 = evlContent10_3_4;
	}
	public String getEvlContent11_1_1() {
		return evlContent11_1_1;
	}
	public void setEvlContent11_1_1(String evlContent11_1_1) {
		this.evlContent11_1_1 = evlContent11_1_1;
	}
	public String getEvlContent11_1_2() {
		return evlContent11_1_2;
	}
	public void setEvlContent11_1_2(String evlContent11_1_2) {
		this.evlContent11_1_2 = evlContent11_1_2;
	}
	public String getEvlContent11_1_3() {
		return evlContent11_1_3;
	}
	public void setEvlContent11_1_3(String evlContent11_1_3) {
		this.evlContent11_1_3 = evlContent11_1_3;
	}
	public String getEvlContent11_1_4() {
		return evlContent11_1_4;
	}
	public void setEvlContent11_1_4(String evlContent11_1_4) {
		this.evlContent11_1_4 = evlContent11_1_4;
	}
	public String getEvlContent11_1_5() {
		return evlContent11_1_5;
	}
	public void setEvlContent11_1_5(String evlContent11_1_5) {
		this.evlContent11_1_5 = evlContent11_1_5;
	}
	public String getEvlContent11_2_1() {
		return evlContent11_2_1;
	}
	public void setEvlContent11_2_1(String evlContent11_2_1) {
		this.evlContent11_2_1 = evlContent11_2_1;
	}
	public String getEvlContent11_2_2() {
		return evlContent11_2_2;
	}
	public void setEvlContent11_2_2(String evlContent11_2_2) {
		this.evlContent11_2_2 = evlContent11_2_2;
	}
	public String getEvlContent11_2_3() {
		return evlContent11_2_3;
	}
	public void setEvlContent11_2_3(String evlContent11_2_3) {
		this.evlContent11_2_3 = evlContent11_2_3;
	}
	public String getEvlContent11_2_4() {
		return evlContent11_2_4;
	}
	public void setEvlContent11_2_4(String evlContent11_2_4) {
		this.evlContent11_2_4 = evlContent11_2_4;
	}
	public String getEvlContent11_2_5() {
		return evlContent11_2_5;
	}
	public void setEvlContent11_2_5(String evlContent11_2_5) {
		this.evlContent11_2_5 = evlContent11_2_5;
	}
	public String getEvlContent11_3_1() {
		return evlContent11_3_1;
	}
	public void setEvlContent11_3_1(String evlContent11_3_1) {
		this.evlContent11_3_1 = evlContent11_3_1;
	}
	public String getEvlContent11_3_2() {
		return evlContent11_3_2;
	}
	public void setEvlContent11_3_2(String evlContent11_3_2) {
		this.evlContent11_3_2 = evlContent11_3_2;
	}
	public String getEvlContent11_3_3() {
		return evlContent11_3_3;
	}
	public void setEvlContent11_3_3(String evlContent11_3_3) {
		this.evlContent11_3_3 = evlContent11_3_3;
	}
	public String getEvlContent11_3_4() {
		return evlContent11_3_4;
	}
	public void setEvlContent11_3_4(String evlContent11_3_4) {
		this.evlContent11_3_4 = evlContent11_3_4;
	}
	public String getEvlContent11_4_1() {
		return evlContent11_4_1;
	}
	public void setEvlContent11_4_1(String evlContent11_4_1) {
		this.evlContent11_4_1 = evlContent11_4_1;
	}
	public String getEvlContent11_4_2() {
		return evlContent11_4_2;
	}
	public void setEvlContent11_4_2(String evlContent11_4_2) {
		this.evlContent11_4_2 = evlContent11_4_2;
	}
	public String getEvlContent11_4_3() {
		return evlContent11_4_3;
	}
	public void setEvlContent11_4_3(String evlContent11_4_3) {
		this.evlContent11_4_3 = evlContent11_4_3;
	}
	public String getEvlContent11_4_4() {
		return evlContent11_4_4;
	}
	public void setEvlContent11_4_4(String evlContent11_4_4) {
		this.evlContent11_4_4 = evlContent11_4_4;
	}
	public String getEvlContent11_5_1() {
		return evlContent11_5_1;
	}
	public void setEvlContent11_5_1(String evlContent11_5_1) {
		this.evlContent11_5_1 = evlContent11_5_1;
	}
	public String getEvlContent11_5_2() {
		return evlContent11_5_2;
	}
	public void setEvlContent11_5_2(String evlContent11_5_2) {
		this.evlContent11_5_2 = evlContent11_5_2;
	}
	public String getEvlContent11_5_3() {
		return evlContent11_5_3;
	}
	public void setEvlContent11_5_3(String evlContent11_5_3) {
		this.evlContent11_5_3 = evlContent11_5_3;
	}
	public String getEvlContent11_5_4() {
		return evlContent11_5_4;
	}
	public void setEvlContent11_5_4(String evlContent11_5_4) {
		this.evlContent11_5_4 = evlContent11_5_4;
	}
	public String getEvlContent11_5_5() {
		return evlContent11_5_5;
	}
	public void setEvlContent11_5_5(String evlContent11_5_5) {
		this.evlContent11_5_5 = evlContent11_5_5;
	}
	public String getEvlContent12_1_1() {
		return evlContent12_1_1;
	}
	public void setEvlContent12_1_1(String evlContent12_1_1) {
		this.evlContent12_1_1 = evlContent12_1_1;
	}
	public String getEvlContent12_1_2() {
		return evlContent12_1_2;
	}
	public void setEvlContent12_1_2(String evlContent12_1_2) {
		this.evlContent12_1_2 = evlContent12_1_2;
	}
	public String getEvlContent12_1_3() {
		return evlContent12_1_3;
	}
	public void setEvlContent12_1_3(String evlContent12_1_3) {
		this.evlContent12_1_3 = evlContent12_1_3;
	}
	public String getEvlContent12_1_4() {
		return evlContent12_1_4;
	}
	public void setEvlContent12_1_4(String evlContent12_1_4) {
		this.evlContent12_1_4 = evlContent12_1_4;
	}
	public String getEvlContent12_1_5() {
		return evlContent12_1_5;
	}
	public void setEvlContent12_1_5(String evlContent12_1_5) {
		this.evlContent12_1_5 = evlContent12_1_5;
	}
	public String getEvlContent12_2_1() {
		return evlContent12_2_1;
	}
	public void setEvlContent12_2_1(String evlContent12_2_1) {
		this.evlContent12_2_1 = evlContent12_2_1;
	}
	public String getEvlContent12_2_2() {
		return evlContent12_2_2;
	}
	public void setEvlContent12_2_2(String evlContent12_2_2) {
		this.evlContent12_2_2 = evlContent12_2_2;
	}
	public String getEvlContent12_2_3() {
		return evlContent12_2_3;
	}
	public void setEvlContent12_2_3(String evlContent12_2_3) {
		this.evlContent12_2_3 = evlContent12_2_3;
	}
	public String getEvlContent12_2_4() {
		return evlContent12_2_4;
	}
	public void setEvlContent12_2_4(String evlContent12_2_4) {
		this.evlContent12_2_4 = evlContent12_2_4;
	}
	public String getEvlContent12_2_5() {
		return evlContent12_2_5;
	}
	public void setEvlContent12_2_5(String evlContent12_2_5) {
		this.evlContent12_2_5 = evlContent12_2_5;
	}
	public String getEvlContent12_3_1() {
		return evlContent12_3_1;
	}
	public void setEvlContent12_3_1(String evlContent12_3_1) {
		this.evlContent12_3_1 = evlContent12_3_1;
	}
	public String getEvlContent12_3_2() {
		return evlContent12_3_2;
	}
	public void setEvlContent12_3_2(String evlContent12_3_2) {
		this.evlContent12_3_2 = evlContent12_3_2;
	}
	public String getEvlContent12_3_3() {
		return evlContent12_3_3;
	}
	public void setEvlContent12_3_3(String evlContent12_3_3) {
		this.evlContent12_3_3 = evlContent12_3_3;
	}
	public String getEvlContent12_3_4() {
		return evlContent12_3_4;
	}
	public void setEvlContent12_3_4(String evlContent12_3_4) {
		this.evlContent12_3_4 = evlContent12_3_4;
	}
	public String getEvlContent12_3_5() {
		return evlContent12_3_5;
	}
	public void setEvlContent12_3_5(String evlContent12_3_5) {
		this.evlContent12_3_5 = evlContent12_3_5;
	}
	public String getEvlContent13_1_1() {
		return evlContent13_1_1;
	}
	public void setEvlContent13_1_1(String evlContent13_1_1) {
		this.evlContent13_1_1 = evlContent13_1_1;
	}
	public String getEvlContent13_1_2() {
		return evlContent13_1_2;
	}
	public void setEvlContent13_1_2(String evlContent13_1_2) {
		this.evlContent13_1_2 = evlContent13_1_2;
	}
	public String getEvlContent13_1_3() {
		return evlContent13_1_3;
	}
	public void setEvlContent13_1_3(String evlContent13_1_3) {
		this.evlContent13_1_3 = evlContent13_1_3;
	}
	public String getEvlContent13_1_4() {
		return evlContent13_1_4;
	}
	public void setEvlContent13_1_4(String evlContent13_1_4) {
		this.evlContent13_1_4 = evlContent13_1_4;
	}
	public String getEvlContent13_1_5() {
		return evlContent13_1_5;
	}
	public void setEvlContent13_1_5(String evlContent13_1_5) {
		this.evlContent13_1_5 = evlContent13_1_5;
	}
	public String getEvlContent13_2_1() {
		return evlContent13_2_1;
	}
	public void setEvlContent13_2_1(String evlContent13_2_1) {
		this.evlContent13_2_1 = evlContent13_2_1;
	}
	public String getEvlContent13_2_2() {
		return evlContent13_2_2;
	}
	public void setEvlContent13_2_2(String evlContent13_2_2) {
		this.evlContent13_2_2 = evlContent13_2_2;
	}
	public String getEvlContent13_2_3() {
		return evlContent13_2_3;
	}
	public void setEvlContent13_2_3(String evlContent13_2_3) {
		this.evlContent13_2_3 = evlContent13_2_3;
	}
	public String getEvlContent13_2_4() {
		return evlContent13_2_4;
	}
	public void setEvlContent13_2_4(String evlContent13_2_4) {
		this.evlContent13_2_4 = evlContent13_2_4;
	}
	public String getEvlContent13_2_5() {
		return evlContent13_2_5;
	}
	public void setEvlContent13_2_5(String evlContent13_2_5) {
		this.evlContent13_2_5 = evlContent13_2_5;
	}
	public String getEvlContent13_3_1() {
		return evlContent13_3_1;
	}
	public void setEvlContent13_3_1(String evlContent13_3_1) {
		this.evlContent13_3_1 = evlContent13_3_1;
	}
	public String getEvlContent13_3_2() {
		return evlContent13_3_2;
	}
	public void setEvlContent13_3_2(String evlContent13_3_2) {
		this.evlContent13_3_2 = evlContent13_3_2;
	}
	public String getEvlContent13_3_3() {
		return evlContent13_3_3;
	}
	public void setEvlContent13_3_3(String evlContent13_3_3) {
		this.evlContent13_3_3 = evlContent13_3_3;
	}
	public String getEvlContent13_3_4() {
		return evlContent13_3_4;
	}
	public void setEvlContent13_3_4(String evlContent13_3_4) {
		this.evlContent13_3_4 = evlContent13_3_4;
	}
	public String getEvlContent13_4_1() {
		return evlContent13_4_1;
	}
	public void setEvlContent13_4_1(String evlContent13_4_1) {
		this.evlContent13_4_1 = evlContent13_4_1;
	}
	public String getEvlContent13_4_2() {
		return evlContent13_4_2;
	}
	public void setEvlContent13_4_2(String evlContent13_4_2) {
		this.evlContent13_4_2 = evlContent13_4_2;
	}
	public String getEvlContent13_4_3() {
		return evlContent13_4_3;
	}
	public void setEvlContent13_4_3(String evlContent13_4_3) {
		this.evlContent13_4_3 = evlContent13_4_3;
	}
	public String getEvlContent13_4_4() {
		return evlContent13_4_4;
	}
	public void setEvlContent13_4_4(String evlContent13_4_4) {
		this.evlContent13_4_4 = evlContent13_4_4;
	}
	public String getEvlContent13_5_1() {
		return evlContent13_5_1;
	}
	public void setEvlContent13_5_1(String evlContent13_5_1) {
		this.evlContent13_5_1 = evlContent13_5_1;
	}
	public String getEvlContent13_5_2() {
		return evlContent13_5_2;
	}
	public void setEvlContent13_5_2(String evlContent13_5_2) {
		this.evlContent13_5_2 = evlContent13_5_2;
	}
	public String getEvlContent13_5_3() {
		return evlContent13_5_3;
	}
	public void setEvlContent13_5_3(String evlContent13_5_3) {
		this.evlContent13_5_3 = evlContent13_5_3;
	}
	public String getEvlContent13_6_1() {
		return evlContent13_6_1;
	}
	public void setEvlContent13_6_1(String evlContent13_6_1) {
		this.evlContent13_6_1 = evlContent13_6_1;
	}
	public String getEvlContent13_6_2() {
		return evlContent13_6_2;
	}
	public void setEvlContent13_6_2(String evlContent13_6_2) {
		this.evlContent13_6_2 = evlContent13_6_2;
	}
	public String getEvlContent13_6_3() {
		return evlContent13_6_3;
	}
	public void setEvlContent13_6_3(String evlContent13_6_3) {
		this.evlContent13_6_3 = evlContent13_6_3;
	}
	public String getEvlContent13_6_4() {
		return evlContent13_6_4;
	}
	public void setEvlContent13_6_4(String evlContent13_6_4) {
		this.evlContent13_6_4 = evlContent13_6_4;
	}
	public String getEvlContent14_1_1() {
		return evlContent14_1_1;
	}
	public void setEvlContent14_1_1(String evlContent14_1_1) {
		this.evlContent14_1_1 = evlContent14_1_1;
	}
	public String getEvlContent14_1_2() {
		return evlContent14_1_2;
	}
	public void setEvlContent14_1_2(String evlContent14_1_2) {
		this.evlContent14_1_2 = evlContent14_1_2;
	}
	public String getEvlContent14_1_3() {
		return evlContent14_1_3;
	}
	public void setEvlContent14_1_3(String evlContent14_1_3) {
		this.evlContent14_1_3 = evlContent14_1_3;
	}
	public String getEvlContent14_1_4() {
		return evlContent14_1_4;
	}
	public void setEvlContent14_1_4(String evlContent14_1_4) {
		this.evlContent14_1_4 = evlContent14_1_4;
	}
	public String getEvlContent14_1_5() {
		return evlContent14_1_5;
	}
	public void setEvlContent14_1_5(String evlContent14_1_5) {
		this.evlContent14_1_5 = evlContent14_1_5;
	}
	public String getEvlContent14_2_1() {
		return evlContent14_2_1;
	}
	public void setEvlContent14_2_1(String evlContent14_2_1) {
		this.evlContent14_2_1 = evlContent14_2_1;
	}
	public String getEvlContent14_2_2() {
		return evlContent14_2_2;
	}
	public void setEvlContent14_2_2(String evlContent14_2_2) {
		this.evlContent14_2_2 = evlContent14_2_2;
	}
	public String getEvlContent14_2_3() {
		return evlContent14_2_3;
	}
	public void setEvlContent14_2_3(String evlContent14_2_3) {
		this.evlContent14_2_3 = evlContent14_2_3;
	}
	public String getEvlContent14_3_1() {
		return evlContent14_3_1;
	}
	public void setEvlContent14_3_1(String evlContent14_3_1) {
		this.evlContent14_3_1 = evlContent14_3_1;
	}
	public String getEvlContent14_3_2() {
		return evlContent14_3_2;
	}
	public void setEvlContent14_3_2(String evlContent14_3_2) {
		this.evlContent14_3_2 = evlContent14_3_2;
	}
	public String getEvlContent14_3_3() {
		return evlContent14_3_3;
	}
	public void setEvlContent14_3_3(String evlContent14_3_3) {
		this.evlContent14_3_3 = evlContent14_3_3;
	}
	public String getEvlContent14_4_1() {
		return evlContent14_4_1;
	}
	public void setEvlContent14_4_1(String evlContent14_4_1) {
		this.evlContent14_4_1 = evlContent14_4_1;
	}
	public String getEvlContent14_4_2() {
		return evlContent14_4_2;
	}
	public void setEvlContent14_4_2(String evlContent14_4_2) {
		this.evlContent14_4_2 = evlContent14_4_2;
	}
	public String getEvlContent14_4_3() {
		return evlContent14_4_3;
	}
	public void setEvlContent14_4_3(String evlContent14_4_3) {
		this.evlContent14_4_3 = evlContent14_4_3;
	}
	public String getEvlContent14_4_4() {
		return evlContent14_4_4;
	}
	public void setEvlContent14_4_4(String evlContent14_4_4) {
		this.evlContent14_4_4 = evlContent14_4_4;
	}
	public String getEvlContent14_5_1() {
		return evlContent14_5_1;
	}
	public void setEvlContent14_5_1(String evlContent14_5_1) {
		this.evlContent14_5_1 = evlContent14_5_1;
	}
	public String getEvlContent14_5_2() {
		return evlContent14_5_2;
	}
	public void setEvlContent14_5_2(String evlContent14_5_2) {
		this.evlContent14_5_2 = evlContent14_5_2;
	}
	public String getEvlContent14_5_3() {
		return evlContent14_5_3;
	}
	public void setEvlContent14_5_3(String evlContent14_5_3) {
		this.evlContent14_5_3 = evlContent14_5_3;
	}
	public String getEvlContent14_5_4() {
		return evlContent14_5_4;
	}
	public void setEvlContent14_5_4(String evlContent14_5_4) {
		this.evlContent14_5_4 = evlContent14_5_4;
	}
	public String getEvlContent14_6_1() {
		return evlContent14_6_1;
	}
	public void setEvlContent14_6_1(String evlContent14_6_1) {
		this.evlContent14_6_1 = evlContent14_6_1;
	}
	public String getEvlContent14_6_2() {
		return evlContent14_6_2;
	}
	public void setEvlContent14_6_2(String evlContent14_6_2) {
		this.evlContent14_6_2 = evlContent14_6_2;
	}
	public String getEvlContent14_6_3() {
		return evlContent14_6_3;
	}
	public void setEvlContent14_6_3(String evlContent14_6_3) {
		this.evlContent14_6_3 = evlContent14_6_3;
	}
	public String getEvlContent14_6_4() {
		return evlContent14_6_4;
	}
	public void setEvlContent14_6_4(String evlContent14_6_4) {
		this.evlContent14_6_4 = evlContent14_6_4;
	}
	public String getEvlContent15_1_1() {
		return evlContent15_1_1;
	}
	public void setEvlContent15_1_1(String evlContent15_1_1) {
		this.evlContent15_1_1 = evlContent15_1_1;
	}
	public String getEvlContent15_1_2() {
		return evlContent15_1_2;
	}
	public void setEvlContent15_1_2(String evlContent15_1_2) {
		this.evlContent15_1_2 = evlContent15_1_2;
	}
	public String getEvlContent15_1_3() {
		return evlContent15_1_3;
	}
	public void setEvlContent15_1_3(String evlContent15_1_3) {
		this.evlContent15_1_3 = evlContent15_1_3;
	}
	public String getEvlContent15_1_4() {
		return evlContent15_1_4;
	}
	public void setEvlContent15_1_4(String evlContent15_1_4) {
		this.evlContent15_1_4 = evlContent15_1_4;
	}
	public String getEvlContent15_2_1() {
		return evlContent15_2_1;
	}
	public void setEvlContent15_2_1(String evlContent15_2_1) {
		this.evlContent15_2_1 = evlContent15_2_1;
	}
	public String getEvlContent15_2_2() {
		return evlContent15_2_2;
	}
	public void setEvlContent15_2_2(String evlContent15_2_2) {
		this.evlContent15_2_2 = evlContent15_2_2;
	}
	public String getEvlContent15_2_3() {
		return evlContent15_2_3;
	}
	public void setEvlContent15_2_3(String evlContent15_2_3) {
		this.evlContent15_2_3 = evlContent15_2_3;
	}
	public String getEvlContent15_2_4() {
		return evlContent15_2_4;
	}
	public void setEvlContent15_2_4(String evlContent15_2_4) {
		this.evlContent15_2_4 = evlContent15_2_4;
	}
	public String getEvlScore3_1_1() {
		return evlScore3_1_1;
	}
	public void setEvlScore3_1_1(String evlScore3_1_1) {
		this.evlScore3_1_1 = evlScore3_1_1;
	}
	public String getEvlScore3_1_2() {
		return evlScore3_1_2;
	}
	public void setEvlScore3_1_2(String evlScore3_1_2) {
		this.evlScore3_1_2 = evlScore3_1_2;
	}
	public String getEvlScore3_1_3() {
		return evlScore3_1_3;
	}
	public void setEvlScore3_1_3(String evlScore3_1_3) {
		this.evlScore3_1_3 = evlScore3_1_3;
	}
	public String getEvlScore3_1_4() {
		return evlScore3_1_4;
	}
	public void setEvlScore3_1_4(String evlScore3_1_4) {
		this.evlScore3_1_4 = evlScore3_1_4;
	}
	public String getEvlScore3_1_5() {
		return evlScore3_1_5;
	}
	public void setEvlScore3_1_5(String evlScore3_1_5) {
		this.evlScore3_1_5 = evlScore3_1_5;
	}
	public String getEvlScore3_2_1() {
		return evlScore3_2_1;
	}
	public void setEvlScore3_2_1(String evlScore3_2_1) {
		this.evlScore3_2_1 = evlScore3_2_1;
	}
	public String getEvlScore3_2_2() {
		return evlScore3_2_2;
	}
	public void setEvlScore3_2_2(String evlScore3_2_2) {
		this.evlScore3_2_2 = evlScore3_2_2;
	}
	public String getEvlScore3_2_3() {
		return evlScore3_2_3;
	}
	public void setEvlScore3_2_3(String evlScore3_2_3) {
		this.evlScore3_2_3 = evlScore3_2_3;
	}
	public String getEvlScore3_2_4() {
		return evlScore3_2_4;
	}
	public void setEvlScore3_2_4(String evlScore3_2_4) {
		this.evlScore3_2_4 = evlScore3_2_4;
	}
	public String getEvlScore3_2_5() {
		return evlScore3_2_5;
	}
	public void setEvlScore3_2_5(String evlScore3_2_5) {
		this.evlScore3_2_5 = evlScore3_2_5;
	}
	public String getEvlScore4_1_1() {
		return evlScore4_1_1;
	}
	public void setEvlScore4_1_1(String evlScore4_1_1) {
		this.evlScore4_1_1 = evlScore4_1_1;
	}
	public String getEvlScore4_1_2() {
		return evlScore4_1_2;
	}
	public void setEvlScore4_1_2(String evlScore4_1_2) {
		this.evlScore4_1_2 = evlScore4_1_2;
	}
	public String getEvlScore4_1_3() {
		return evlScore4_1_3;
	}
	public void setEvlScore4_1_3(String evlScore4_1_3) {
		this.evlScore4_1_3 = evlScore4_1_3;
	}
	public String getEvlScore4_1_4() {
		return evlScore4_1_4;
	}
	public void setEvlScore4_1_4(String evlScore4_1_4) {
		this.evlScore4_1_4 = evlScore4_1_4;
	}
	public String getEvlScore4_2_1() {
		return evlScore4_2_1;
	}
	public void setEvlScore4_2_1(String evlScore4_2_1) {
		this.evlScore4_2_1 = evlScore4_2_1;
	}
	public String getEvlScore4_2_2() {
		return evlScore4_2_2;
	}
	public void setEvlScore4_2_2(String evlScore4_2_2) {
		this.evlScore4_2_2 = evlScore4_2_2;
	}
	public String getEvlScore4_2_3() {
		return evlScore4_2_3;
	}
	public void setEvlScore4_2_3(String evlScore4_2_3) {
		this.evlScore4_2_3 = evlScore4_2_3;
	}
	public String getEvlScore4_2_4() {
		return evlScore4_2_4;
	}
	public void setEvlScore4_2_4(String evlScore4_2_4) {
		this.evlScore4_2_4 = evlScore4_2_4;
	}
	public String getEvlScore4_2_5() {
		return evlScore4_2_5;
	}
	public void setEvlScore4_2_5(String evlScore4_2_5) {
		this.evlScore4_2_5 = evlScore4_2_5;
	}
	public String getEvlScore4_3_1() {
		return evlScore4_3_1;
	}
	public void setEvlScore4_3_1(String evlScore4_3_1) {
		this.evlScore4_3_1 = evlScore4_3_1;
	}
	public String getEvlScore4_3_2() {
		return evlScore4_3_2;
	}
	public void setEvlScore4_3_2(String evlScore4_3_2) {
		this.evlScore4_3_2 = evlScore4_3_2;
	}
	public String getEvlScore4_3_3() {
		return evlScore4_3_3;
	}
	public void setEvlScore4_3_3(String evlScore4_3_3) {
		this.evlScore4_3_3 = evlScore4_3_3;
	}
	public String getEvlScore5_1_1() {
		return evlScore5_1_1;
	}
	public void setEvlScore5_1_1(String evlScore5_1_1) {
		this.evlScore5_1_1 = evlScore5_1_1;
	}
	public String getEvlScore5_1_2() {
		return evlScore5_1_2;
	}
	public void setEvlScore5_1_2(String evlScore5_1_2) {
		this.evlScore5_1_2 = evlScore5_1_2;
	}
	public String getEvlScore5_1_3() {
		return evlScore5_1_3;
	}
	public void setEvlScore5_1_3(String evlScore5_1_3) {
		this.evlScore5_1_3 = evlScore5_1_3;
	}
	public String getEvlScore5_2_1() {
		return evlScore5_2_1;
	}
	public void setEvlScore5_2_1(String evlScore5_2_1) {
		this.evlScore5_2_1 = evlScore5_2_1;
	}
	public String getEvlScore5_2_2() {
		return evlScore5_2_2;
	}
	public void setEvlScore5_2_2(String evlScore5_2_2) {
		this.evlScore5_2_2 = evlScore5_2_2;
	}
	public String getEvlScore5_2_3() {
		return evlScore5_2_3;
	}
	public void setEvlScore5_2_3(String evlScore5_2_3) {
		this.evlScore5_2_3 = evlScore5_2_3;
	}
	public String getEvlScore5_2_4() {
		return evlScore5_2_4;
	}
	public void setEvlScore5_2_4(String evlScore5_2_4) {
		this.evlScore5_2_4 = evlScore5_2_4;
	}
	public String getEvlScore5_2_5() {
		return evlScore5_2_5;
	}
	public void setEvlScore5_2_5(String evlScore5_2_5) {
		this.evlScore5_2_5 = evlScore5_2_5;
	}
	public String getEvlScore6_1_1() {
		return evlScore6_1_1;
	}
	public void setEvlScore6_1_1(String evlScore6_1_1) {
		this.evlScore6_1_1 = evlScore6_1_1;
	}
	public String getEvlScore6_1_2() {
		return evlScore6_1_2;
	}
	public void setEvlScore6_1_2(String evlScore6_1_2) {
		this.evlScore6_1_2 = evlScore6_1_2;
	}
	public String getEvlScore6_1_3() {
		return evlScore6_1_3;
	}
	public void setEvlScore6_1_3(String evlScore6_1_3) {
		this.evlScore6_1_3 = evlScore6_1_3;
	}
	public String getEvlScore6_1_4() {
		return evlScore6_1_4;
	}
	public void setEvlScore6_1_4(String evlScore6_1_4) {
		this.evlScore6_1_4 = evlScore6_1_4;
	}
	public String getEvlScore6_1_5() {
		return evlScore6_1_5;
	}
	public void setEvlScore6_1_5(String evlScore6_1_5) {
		this.evlScore6_1_5 = evlScore6_1_5;
	}
	public String getEvlScore6_2_1() {
		return evlScore6_2_1;
	}
	public void setEvlScore6_2_1(String evlScore6_2_1) {
		this.evlScore6_2_1 = evlScore6_2_1;
	}
	public String getEvlScore6_2_2() {
		return evlScore6_2_2;
	}
	public void setEvlScore6_2_2(String evlScore6_2_2) {
		this.evlScore6_2_2 = evlScore6_2_2;
	}
	public String getEvlScore6_2_3() {
		return evlScore6_2_3;
	}
	public void setEvlScore6_2_3(String evlScore6_2_3) {
		this.evlScore6_2_3 = evlScore6_2_3;
	}
	public String getEvlScore6_2_4() {
		return evlScore6_2_4;
	}
	public void setEvlScore6_2_4(String evlScore6_2_4) {
		this.evlScore6_2_4 = evlScore6_2_4;
	}
	public String getEvlScore6_2_5() {
		return evlScore6_2_5;
	}
	public void setEvlScore6_2_5(String evlScore6_2_5) {
		this.evlScore6_2_5 = evlScore6_2_5;
	}
	public String getEvlScore6_3_1() {
		return evlScore6_3_1;
	}
	public void setEvlScore6_3_1(String evlScore6_3_1) {
		this.evlScore6_3_1 = evlScore6_3_1;
	}
	public String getEvlScore6_3_2() {
		return evlScore6_3_2;
	}
	public void setEvlScore6_3_2(String evlScore6_3_2) {
		this.evlScore6_3_2 = evlScore6_3_2;
	}
	public String getEvlScore6_3_3() {
		return evlScore6_3_3;
	}
	public void setEvlScore6_3_3(String evlScore6_3_3) {
		this.evlScore6_3_3 = evlScore6_3_3;
	}
	public String getEvlScore6_3_4() {
		return evlScore6_3_4;
	}
	public void setEvlScore6_3_4(String evlScore6_3_4) {
		this.evlScore6_3_4 = evlScore6_3_4;
	}
	public String getEvlScore7_1_1() {
		return evlScore7_1_1;
	}
	public void setEvlScore7_1_1(String evlScore7_1_1) {
		this.evlScore7_1_1 = evlScore7_1_1;
	}
	public String getEvlScore7_1_2() {
		return evlScore7_1_2;
	}
	public void setEvlScore7_1_2(String evlScore7_1_2) {
		this.evlScore7_1_2 = evlScore7_1_2;
	}
	public String getEvlScore7_1_3() {
		return evlScore7_1_3;
	}
	public void setEvlScore7_1_3(String evlScore7_1_3) {
		this.evlScore7_1_3 = evlScore7_1_3;
	}
	public String getEvlScore7_1_4() {
		return evlScore7_1_4;
	}
	public void setEvlScore7_1_4(String evlScore7_1_4) {
		this.evlScore7_1_4 = evlScore7_1_4;
	}
	public String getEvlScore7_2_1() {
		return evlScore7_2_1;
	}
	public void setEvlScore7_2_1(String evlScore7_2_1) {
		this.evlScore7_2_1 = evlScore7_2_1;
	}
	public String getEvlScore7_2_2() {
		return evlScore7_2_2;
	}
	public void setEvlScore7_2_2(String evlScore7_2_2) {
		this.evlScore7_2_2 = evlScore7_2_2;
	}
	public String getEvlScore7_2_3() {
		return evlScore7_2_3;
	}
	public void setEvlScore7_2_3(String evlScore7_2_3) {
		this.evlScore7_2_3 = evlScore7_2_3;
	}
	public String getEvlScore7_2_4() {
		return evlScore7_2_4;
	}
	public void setEvlScore7_2_4(String evlScore7_2_4) {
		this.evlScore7_2_4 = evlScore7_2_4;
	}
	public String getEvlScore8_1_1() {
		return evlScore8_1_1;
	}
	public void setEvlScore8_1_1(String evlScore8_1_1) {
		this.evlScore8_1_1 = evlScore8_1_1;
	}
	public String getEvlScore8_1_2() {
		return evlScore8_1_2;
	}
	public void setEvlScore8_1_2(String evlScore8_1_2) {
		this.evlScore8_1_2 = evlScore8_1_2;
	}
	public String getEvlScore8_1_3() {
		return evlScore8_1_3;
	}
	public void setEvlScore8_1_3(String evlScore8_1_3) {
		this.evlScore8_1_3 = evlScore8_1_3;
	}
	public String getEvlScore8_1_4() {
		return evlScore8_1_4;
	}
	public void setEvlScore8_1_4(String evlScore8_1_4) {
		this.evlScore8_1_4 = evlScore8_1_4;
	}
	public String getEvlScore8_2_1() {
		return evlScore8_2_1;
	}
	public void setEvlScore8_2_1(String evlScore8_2_1) {
		this.evlScore8_2_1 = evlScore8_2_1;
	}
	public String getEvlScore8_2_2() {
		return evlScore8_2_2;
	}
	public void setEvlScore8_2_2(String evlScore8_2_2) {
		this.evlScore8_2_2 = evlScore8_2_2;
	}
	public String getEvlScore8_2_3() {
		return evlScore8_2_3;
	}
	public void setEvlScore8_2_3(String evlScore8_2_3) {
		this.evlScore8_2_3 = evlScore8_2_3;
	}
	public String getEvlScore8_2_4() {
		return evlScore8_2_4;
	}
	public void setEvlScore8_2_4(String evlScore8_2_4) {
		this.evlScore8_2_4 = evlScore8_2_4;
	}
	public String getEvlScore8_2_5() {
		return evlScore8_2_5;
	}
	public void setEvlScore8_2_5(String evlScore8_2_5) {
		this.evlScore8_2_5 = evlScore8_2_5;
	}
	public String getEvlScore8_3_1() {
		return evlScore8_3_1;
	}
	public void setEvlScore8_3_1(String evlScore8_3_1) {
		this.evlScore8_3_1 = evlScore8_3_1;
	}
	public String getEvlScore8_3_2() {
		return evlScore8_3_2;
	}
	public void setEvlScore8_3_2(String evlScore8_3_2) {
		this.evlScore8_3_2 = evlScore8_3_2;
	}
	public String getEvlScore8_3_3() {
		return evlScore8_3_3;
	}
	public void setEvlScore8_3_3(String evlScore8_3_3) {
		this.evlScore8_3_3 = evlScore8_3_3;
	}
	public String getEvlScore8_4_1() {
		return evlScore8_4_1;
	}
	public void setEvlScore8_4_1(String evlScore8_4_1) {
		this.evlScore8_4_1 = evlScore8_4_1;
	}
	public String getEvlScore8_4_2() {
		return evlScore8_4_2;
	}
	public void setEvlScore8_4_2(String evlScore8_4_2) {
		this.evlScore8_4_2 = evlScore8_4_2;
	}
	public String getEvlScore8_4_3() {
		return evlScore8_4_3;
	}
	public void setEvlScore8_4_3(String evlScore8_4_3) {
		this.evlScore8_4_3 = evlScore8_4_3;
	}
	public String getEvlScore8_4_4() {
		return evlScore8_4_4;
	}
	public void setEvlScore8_4_4(String evlScore8_4_4) {
		this.evlScore8_4_4 = evlScore8_4_4;
	}
	public String getEvlScore9_1_1() {
		return evlScore9_1_1;
	}
	public void setEvlScore9_1_1(String evlScore9_1_1) {
		this.evlScore9_1_1 = evlScore9_1_1;
	}
	public String getEvlScore9_1_2() {
		return evlScore9_1_2;
	}
	public void setEvlScore9_1_2(String evlScore9_1_2) {
		this.evlScore9_1_2 = evlScore9_1_2;
	}
	public String getEvlScore9_1_3() {
		return evlScore9_1_3;
	}
	public void setEvlScore9_1_3(String evlScore9_1_3) {
		this.evlScore9_1_3 = evlScore9_1_3;
	}
	public String getEvlScore9_2_1() {
		return evlScore9_2_1;
	}
	public void setEvlScore9_2_1(String evlScore9_2_1) {
		this.evlScore9_2_1 = evlScore9_2_1;
	}
	public String getEvlScore9_2_2() {
		return evlScore9_2_2;
	}
	public void setEvlScore9_2_2(String evlScore9_2_2) {
		this.evlScore9_2_2 = evlScore9_2_2;
	}
	public String getEvlScore9_2_3() {
		return evlScore9_2_3;
	}
	public void setEvlScore9_2_3(String evlScore9_2_3) {
		this.evlScore9_2_3 = evlScore9_2_3;
	}
	public String getEvlScore9_2_4() {
		return evlScore9_2_4;
	}
	public void setEvlScore9_2_4(String evlScore9_2_4) {
		this.evlScore9_2_4 = evlScore9_2_4;
	}
	public String getEvlScore9_2_5() {
		return evlScore9_2_5;
	}
	public void setEvlScore9_2_5(String evlScore9_2_5) {
		this.evlScore9_2_5 = evlScore9_2_5;
	}
	public String getEvlScore9_3_1() {
		return evlScore9_3_1;
	}
	public void setEvlScore9_3_1(String evlScore9_3_1) {
		this.evlScore9_3_1 = evlScore9_3_1;
	}
	public String getEvlScore9_3_2() {
		return evlScore9_3_2;
	}
	public void setEvlScore9_3_2(String evlScore9_3_2) {
		this.evlScore9_3_2 = evlScore9_3_2;
	}
	public String getEvlScore9_3_3() {
		return evlScore9_3_3;
	}
	public void setEvlScore9_3_3(String evlScore9_3_3) {
		this.evlScore9_3_3 = evlScore9_3_3;
	}
	public String getEvlScore9_3_4() {
		return evlScore9_3_4;
	}
	public void setEvlScore9_3_4(String evlScore9_3_4) {
		this.evlScore9_3_4 = evlScore9_3_4;
	}
	public String getEvlScore9_4_1() {
		return evlScore9_4_1;
	}
	public void setEvlScore9_4_1(String evlScore9_4_1) {
		this.evlScore9_4_1 = evlScore9_4_1;
	}
	public String getEvlScore9_4_2() {
		return evlScore9_4_2;
	}
	public void setEvlScore9_4_2(String evlScore9_4_2) {
		this.evlScore9_4_2 = evlScore9_4_2;
	}
	public String getEvlScore9_4_3() {
		return evlScore9_4_3;
	}
	public void setEvlScore9_4_3(String evlScore9_4_3) {
		this.evlScore9_4_3 = evlScore9_4_3;
	}
	public String getEvlScore9_4_4() {
		return evlScore9_4_4;
	}
	public void setEvlScore9_4_4(String evlScore9_4_4) {
		this.evlScore9_4_4 = evlScore9_4_4;
	}
	public String getEvlScore9_4_5() {
		return evlScore9_4_5;
	}
	public void setEvlScore9_4_5(String evlScore9_4_5) {
		this.evlScore9_4_5 = evlScore9_4_5;
	}
	public String getEvlScore9_5_1() {
		return evlScore9_5_1;
	}
	public void setEvlScore9_5_1(String evlScore9_5_1) {
		this.evlScore9_5_1 = evlScore9_5_1;
	}
	public String getEvlScore9_5_2() {
		return evlScore9_5_2;
	}
	public void setEvlScore9_5_2(String evlScore9_5_2) {
		this.evlScore9_5_2 = evlScore9_5_2;
	}
	public String getEvlScore9_5_3() {
		return evlScore9_5_3;
	}
	public void setEvlScore9_5_3(String evlScore9_5_3) {
		this.evlScore9_5_3 = evlScore9_5_3;
	}
	public String getEvlScore9_5_4() {
		return evlScore9_5_4;
	}
	public void setEvlScore9_5_4(String evlScore9_5_4) {
		this.evlScore9_5_4 = evlScore9_5_4;
	}
	public String getEvlScore9_5_5() {
		return evlScore9_5_5;
	}
	public void setEvlScore9_5_5(String evlScore9_5_5) {
		this.evlScore9_5_5 = evlScore9_5_5;
	}
	public String getEvlScore10_1_1() {
		return evlScore10_1_1;
	}
	public void setEvlScore10_1_1(String evlScore10_1_1) {
		this.evlScore10_1_1 = evlScore10_1_1;
	}
	public String getEvlScore10_1_2() {
		return evlScore10_1_2;
	}
	public void setEvlScore10_1_2(String evlScore10_1_2) {
		this.evlScore10_1_2 = evlScore10_1_2;
	}
	public String getEvlScore10_1_3() {
		return evlScore10_1_3;
	}
	public void setEvlScore10_1_3(String evlScore10_1_3) {
		this.evlScore10_1_3 = evlScore10_1_3;
	}
	public String getEvlScore10_1_4() {
		return evlScore10_1_4;
	}
	public void setEvlScore10_1_4(String evlScore10_1_4) {
		this.evlScore10_1_4 = evlScore10_1_4;
	}
	public String getEvlScore10_1_5() {
		return evlScore10_1_5;
	}
	public void setEvlScore10_1_5(String evlScore10_1_5) {
		this.evlScore10_1_5 = evlScore10_1_5;
	}
	public String getEvlScore10_2_1() {
		return evlScore10_2_1;
	}
	public void setEvlScore10_2_1(String evlScore10_2_1) {
		this.evlScore10_2_1 = evlScore10_2_1;
	}
	public String getEvlScore10_2_2() {
		return evlScore10_2_2;
	}
	public void setEvlScore10_2_2(String evlScore10_2_2) {
		this.evlScore10_2_2 = evlScore10_2_2;
	}
	public String getEvlScore10_2_3() {
		return evlScore10_2_3;
	}
	public void setEvlScore10_2_3(String evlScore10_2_3) {
		this.evlScore10_2_3 = evlScore10_2_3;
	}
	public String getEvlScore10_2_4() {
		return evlScore10_2_4;
	}
	public void setEvlScore10_2_4(String evlScore10_2_4) {
		this.evlScore10_2_4 = evlScore10_2_4;
	}
	public String getEvlScore10_2_5() {
		return evlScore10_2_5;
	}
	public void setEvlScore10_2_5(String evlScore10_2_5) {
		this.evlScore10_2_5 = evlScore10_2_5;
	}
	public String getEvlScore10_3_1() {
		return evlScore10_3_1;
	}
	public void setEvlScore10_3_1(String evlScore10_3_1) {
		this.evlScore10_3_1 = evlScore10_3_1;
	}
	public String getEvlScore10_3_2() {
		return evlScore10_3_2;
	}
	public void setEvlScore10_3_2(String evlScore10_3_2) {
		this.evlScore10_3_2 = evlScore10_3_2;
	}
	public String getEvlScore10_3_3() {
		return evlScore10_3_3;
	}
	public void setEvlScore10_3_3(String evlScore10_3_3) {
		this.evlScore10_3_3 = evlScore10_3_3;
	}
	public String getEvlScore10_3_4() {
		return evlScore10_3_4;
	}
	public void setEvlScore10_3_4(String evlScore10_3_4) {
		this.evlScore10_3_4 = evlScore10_3_4;
	}
	public String getEvlScore11_1_1() {
		return evlScore11_1_1;
	}
	public void setEvlScore11_1_1(String evlScore11_1_1) {
		this.evlScore11_1_1 = evlScore11_1_1;
	}
	public String getEvlScore11_1_2() {
		return evlScore11_1_2;
	}
	public void setEvlScore11_1_2(String evlScore11_1_2) {
		this.evlScore11_1_2 = evlScore11_1_2;
	}
	public String getEvlScore11_1_3() {
		return evlScore11_1_3;
	}
	public void setEvlScore11_1_3(String evlScore11_1_3) {
		this.evlScore11_1_3 = evlScore11_1_3;
	}
	public String getEvlScore11_1_4() {
		return evlScore11_1_4;
	}
	public void setEvlScore11_1_4(String evlScore11_1_4) {
		this.evlScore11_1_4 = evlScore11_1_4;
	}
	public String getEvlScore11_1_5() {
		return evlScore11_1_5;
	}
	public void setEvlScore11_1_5(String evlScore11_1_5) {
		this.evlScore11_1_5 = evlScore11_1_5;
	}
	public String getEvlScore11_2_1() {
		return evlScore11_2_1;
	}
	public void setEvlScore11_2_1(String evlScore11_2_1) {
		this.evlScore11_2_1 = evlScore11_2_1;
	}
	public String getEvlScore11_2_2() {
		return evlScore11_2_2;
	}
	public void setEvlScore11_2_2(String evlScore11_2_2) {
		this.evlScore11_2_2 = evlScore11_2_2;
	}
	public String getEvlScore11_2_3() {
		return evlScore11_2_3;
	}
	public void setEvlScore11_2_3(String evlScore11_2_3) {
		this.evlScore11_2_3 = evlScore11_2_3;
	}
	public String getEvlScore11_2_4() {
		return evlScore11_2_4;
	}
	public void setEvlScore11_2_4(String evlScore11_2_4) {
		this.evlScore11_2_4 = evlScore11_2_4;
	}
	public String getEvlScore11_2_5() {
		return evlScore11_2_5;
	}
	public void setEvlScore11_2_5(String evlScore11_2_5) {
		this.evlScore11_2_5 = evlScore11_2_5;
	}
	public String getEvlScore11_3_1() {
		return evlScore11_3_1;
	}
	public void setEvlScore11_3_1(String evlScore11_3_1) {
		this.evlScore11_3_1 = evlScore11_3_1;
	}
	public String getEvlScore11_3_2() {
		return evlScore11_3_2;
	}
	public void setEvlScore11_3_2(String evlScore11_3_2) {
		this.evlScore11_3_2 = evlScore11_3_2;
	}
	public String getEvlScore11_3_3() {
		return evlScore11_3_3;
	}
	public void setEvlScore11_3_3(String evlScore11_3_3) {
		this.evlScore11_3_3 = evlScore11_3_3;
	}
	public String getEvlScore11_3_4() {
		return evlScore11_3_4;
	}
	public void setEvlScore11_3_4(String evlScore11_3_4) {
		this.evlScore11_3_4 = evlScore11_3_4;
	}
	public String getEvlScore11_4_1() {
		return evlScore11_4_1;
	}
	public void setEvlScore11_4_1(String evlScore11_4_1) {
		this.evlScore11_4_1 = evlScore11_4_1;
	}
	public String getEvlScore11_4_2() {
		return evlScore11_4_2;
	}
	public void setEvlScore11_4_2(String evlScore11_4_2) {
		this.evlScore11_4_2 = evlScore11_4_2;
	}
	public String getEvlScore11_4_3() {
		return evlScore11_4_3;
	}
	public void setEvlScore11_4_3(String evlScore11_4_3) {
		this.evlScore11_4_3 = evlScore11_4_3;
	}
	public String getEvlScore11_4_4() {
		return evlScore11_4_4;
	}
	public void setEvlScore11_4_4(String evlScore11_4_4) {
		this.evlScore11_4_4 = evlScore11_4_4;
	}
	public String getEvlScore11_5_1() {
		return evlScore11_5_1;
	}
	public void setEvlScore11_5_1(String evlScore11_5_1) {
		this.evlScore11_5_1 = evlScore11_5_1;
	}
	public String getEvlScore11_5_2() {
		return evlScore11_5_2;
	}
	public void setEvlScore11_5_2(String evlScore11_5_2) {
		this.evlScore11_5_2 = evlScore11_5_2;
	}
	public String getEvlScore11_5_3() {
		return evlScore11_5_3;
	}
	public void setEvlScore11_5_3(String evlScore11_5_3) {
		this.evlScore11_5_3 = evlScore11_5_3;
	}
	public String getEvlScore11_5_4() {
		return evlScore11_5_4;
	}
	public void setEvlScore11_5_4(String evlScore11_5_4) {
		this.evlScore11_5_4 = evlScore11_5_4;
	}
	public String getEvlScore11_5_5() {
		return evlScore11_5_5;
	}
	public void setEvlScore11_5_5(String evlScore11_5_5) {
		this.evlScore11_5_5 = evlScore11_5_5;
	}
	public String getEvlScore12_1_1() {
		return evlScore12_1_1;
	}
	public void setEvlScore12_1_1(String evlScore12_1_1) {
		this.evlScore12_1_1 = evlScore12_1_1;
	}
	public String getEvlScore12_1_2() {
		return evlScore12_1_2;
	}
	public void setEvlScore12_1_2(String evlScore12_1_2) {
		this.evlScore12_1_2 = evlScore12_1_2;
	}
	public String getEvlScore12_1_3() {
		return evlScore12_1_3;
	}
	public void setEvlScore12_1_3(String evlScore12_1_3) {
		this.evlScore12_1_3 = evlScore12_1_3;
	}
	public String getEvlScore12_1_4() {
		return evlScore12_1_4;
	}
	public void setEvlScore12_1_4(String evlScore12_1_4) {
		this.evlScore12_1_4 = evlScore12_1_4;
	}
	public String getEvlScore12_1_5() {
		return evlScore12_1_5;
	}
	public void setEvlScore12_1_5(String evlScore12_1_5) {
		this.evlScore12_1_5 = evlScore12_1_5;
	}
	public String getEvlScore12_2_1() {
		return evlScore12_2_1;
	}
	public void setEvlScore12_2_1(String evlScore12_2_1) {
		this.evlScore12_2_1 = evlScore12_2_1;
	}
	public String getEvlScore12_2_2() {
		return evlScore12_2_2;
	}
	public void setEvlScore12_2_2(String evlScore12_2_2) {
		this.evlScore12_2_2 = evlScore12_2_2;
	}
	public String getEvlScore12_2_3() {
		return evlScore12_2_3;
	}
	public void setEvlScore12_2_3(String evlScore12_2_3) {
		this.evlScore12_2_3 = evlScore12_2_3;
	}
	public String getEvlScore12_2_4() {
		return evlScore12_2_4;
	}
	public void setEvlScore12_2_4(String evlScore12_2_4) {
		this.evlScore12_2_4 = evlScore12_2_4;
	}
	public String getEvlScore12_2_5() {
		return evlScore12_2_5;
	}
	public void setEvlScore12_2_5(String evlScore12_2_5) {
		this.evlScore12_2_5 = evlScore12_2_5;
	}
	public String getEvlScore12_3_1() {
		return evlScore12_3_1;
	}
	public void setEvlScore12_3_1(String evlScore12_3_1) {
		this.evlScore12_3_1 = evlScore12_3_1;
	}
	public String getEvlScore12_3_2() {
		return evlScore12_3_2;
	}
	public void setEvlScore12_3_2(String evlScore12_3_2) {
		this.evlScore12_3_2 = evlScore12_3_2;
	}
	public String getEvlScore12_3_3() {
		return evlScore12_3_3;
	}
	public void setEvlScore12_3_3(String evlScore12_3_3) {
		this.evlScore12_3_3 = evlScore12_3_3;
	}
	public String getEvlScore12_3_4() {
		return evlScore12_3_4;
	}
	public void setEvlScore12_3_4(String evlScore12_3_4) {
		this.evlScore12_3_4 = evlScore12_3_4;
	}
	public String getEvlScore12_3_5() {
		return evlScore12_3_5;
	}
	public void setEvlScore12_3_5(String evlScore12_3_5) {
		this.evlScore12_3_5 = evlScore12_3_5;
	}
	public String getEvlScore13_1_1() {
		return evlScore13_1_1;
	}
	public void setEvlScore13_1_1(String evlScore13_1_1) {
		this.evlScore13_1_1 = evlScore13_1_1;
	}
	public String getEvlScore13_1_2() {
		return evlScore13_1_2;
	}
	public void setEvlScore13_1_2(String evlScore13_1_2) {
		this.evlScore13_1_2 = evlScore13_1_2;
	}
	public String getEvlScore13_1_3() {
		return evlScore13_1_3;
	}
	public void setEvlScore13_1_3(String evlScore13_1_3) {
		this.evlScore13_1_3 = evlScore13_1_3;
	}
	public String getEvlScore13_1_4() {
		return evlScore13_1_4;
	}
	public void setEvlScore13_1_4(String evlScore13_1_4) {
		this.evlScore13_1_4 = evlScore13_1_4;
	}
	public String getEvlScore13_1_5() {
		return evlScore13_1_5;
	}
	public void setEvlScore13_1_5(String evlScore13_1_5) {
		this.evlScore13_1_5 = evlScore13_1_5;
	}
	public String getEvlScore13_2_1() {
		return evlScore13_2_1;
	}
	public void setEvlScore13_2_1(String evlScore13_2_1) {
		this.evlScore13_2_1 = evlScore13_2_1;
	}
	public String getEvlScore13_2_2() {
		return evlScore13_2_2;
	}
	public void setEvlScore13_2_2(String evlScore13_2_2) {
		this.evlScore13_2_2 = evlScore13_2_2;
	}
	public String getEvlScore13_2_3() {
		return evlScore13_2_3;
	}
	public void setEvlScore13_2_3(String evlScore13_2_3) {
		this.evlScore13_2_3 = evlScore13_2_3;
	}
	public String getEvlScore13_2_4() {
		return evlScore13_2_4;
	}
	public void setEvlScore13_2_4(String evlScore13_2_4) {
		this.evlScore13_2_4 = evlScore13_2_4;
	}
	public String getEvlScore13_2_5() {
		return evlScore13_2_5;
	}
	public void setEvlScore13_2_5(String evlScore13_2_5) {
		this.evlScore13_2_5 = evlScore13_2_5;
	}
	public String getEvlScore13_3_1() {
		return evlScore13_3_1;
	}
	public void setEvlScore13_3_1(String evlScore13_3_1) {
		this.evlScore13_3_1 = evlScore13_3_1;
	}
	public String getEvlScore13_3_2() {
		return evlScore13_3_2;
	}
	public void setEvlScore13_3_2(String evlScore13_3_2) {
		this.evlScore13_3_2 = evlScore13_3_2;
	}
	public String getEvlScore13_3_3() {
		return evlScore13_3_3;
	}
	public void setEvlScore13_3_3(String evlScore13_3_3) {
		this.evlScore13_3_3 = evlScore13_3_3;
	}
	public String getEvlScore13_3_4() {
		return evlScore13_3_4;
	}
	public void setEvlScore13_3_4(String evlScore13_3_4) {
		this.evlScore13_3_4 = evlScore13_3_4;
	}
	public String getEvlScore13_4_1() {
		return evlScore13_4_1;
	}
	public void setEvlScore13_4_1(String evlScore13_4_1) {
		this.evlScore13_4_1 = evlScore13_4_1;
	}
	public String getEvlScore13_4_2() {
		return evlScore13_4_2;
	}
	public void setEvlScore13_4_2(String evlScore13_4_2) {
		this.evlScore13_4_2 = evlScore13_4_2;
	}
	public String getEvlScore13_4_3() {
		return evlScore13_4_3;
	}
	public void setEvlScore13_4_3(String evlScore13_4_3) {
		this.evlScore13_4_3 = evlScore13_4_3;
	}
	public String getEvlScore13_4_4() {
		return evlScore13_4_4;
	}
	public void setEvlScore13_4_4(String evlScore13_4_4) {
		this.evlScore13_4_4 = evlScore13_4_4;
	}
	public String getEvlScore13_5_1() {
		return evlScore13_5_1;
	}
	public void setEvlScore13_5_1(String evlScore13_5_1) {
		this.evlScore13_5_1 = evlScore13_5_1;
	}
	public String getEvlScore13_5_2() {
		return evlScore13_5_2;
	}
	public void setEvlScore13_5_2(String evlScore13_5_2) {
		this.evlScore13_5_2 = evlScore13_5_2;
	}
	public String getEvlScore13_5_3() {
		return evlScore13_5_3;
	}
	public void setEvlScore13_5_3(String evlScore13_5_3) {
		this.evlScore13_5_3 = evlScore13_5_3;
	}
	public String getEvlScore13_6_1() {
		return evlScore13_6_1;
	}
	public void setEvlScore13_6_1(String evlScore13_6_1) {
		this.evlScore13_6_1 = evlScore13_6_1;
	}
	public String getEvlScore13_6_2() {
		return evlScore13_6_2;
	}
	public void setEvlScore13_6_2(String evlScore13_6_2) {
		this.evlScore13_6_2 = evlScore13_6_2;
	}
	public String getEvlScore13_6_3() {
		return evlScore13_6_3;
	}
	public void setEvlScore13_6_3(String evlScore13_6_3) {
		this.evlScore13_6_3 = evlScore13_6_3;
	}
	public String getEvlScore13_6_4() {
		return evlScore13_6_4;
	}
	public void setEvlScore13_6_4(String evlScore13_6_4) {
		this.evlScore13_6_4 = evlScore13_6_4;
	}
	public String getEvlScore14_1_1() {
		return evlScore14_1_1;
	}
	public void setEvlScore14_1_1(String evlScore14_1_1) {
		this.evlScore14_1_1 = evlScore14_1_1;
	}
	public String getEvlScore14_1_2() {
		return evlScore14_1_2;
	}
	public void setEvlScore14_1_2(String evlScore14_1_2) {
		this.evlScore14_1_2 = evlScore14_1_2;
	}
	public String getEvlScore14_1_3() {
		return evlScore14_1_3;
	}
	public void setEvlScore14_1_3(String evlScore14_1_3) {
		this.evlScore14_1_3 = evlScore14_1_3;
	}
	public String getEvlScore14_1_4() {
		return evlScore14_1_4;
	}
	public void setEvlScore14_1_4(String evlScore14_1_4) {
		this.evlScore14_1_4 = evlScore14_1_4;
	}
	public String getEvlScore14_1_5() {
		return evlScore14_1_5;
	}
	public void setEvlScore14_1_5(String evlScore14_1_5) {
		this.evlScore14_1_5 = evlScore14_1_5;
	}
	public String getEvlScore14_2_1() {
		return evlScore14_2_1;
	}
	public void setEvlScore14_2_1(String evlScore14_2_1) {
		this.evlScore14_2_1 = evlScore14_2_1;
	}
	public String getEvlScore14_2_2() {
		return evlScore14_2_2;
	}
	public void setEvlScore14_2_2(String evlScore14_2_2) {
		this.evlScore14_2_2 = evlScore14_2_2;
	}
	public String getEvlScore14_2_3() {
		return evlScore14_2_3;
	}
	public void setEvlScore14_2_3(String evlScore14_2_3) {
		this.evlScore14_2_3 = evlScore14_2_3;
	}
	public String getEvlScore14_3_1() {
		return evlScore14_3_1;
	}
	public void setEvlScore14_3_1(String evlScore14_3_1) {
		this.evlScore14_3_1 = evlScore14_3_1;
	}
	public String getEvlScore14_3_2() {
		return evlScore14_3_2;
	}
	public void setEvlScore14_3_2(String evlScore14_3_2) {
		this.evlScore14_3_2 = evlScore14_3_2;
	}
	public String getEvlScore14_3_3() {
		return evlScore14_3_3;
	}
	public void setEvlScore14_3_3(String evlScore14_3_3) {
		this.evlScore14_3_3 = evlScore14_3_3;
	}
	public String getEvlScore14_4_1() {
		return evlScore14_4_1;
	}
	public void setEvlScore14_4_1(String evlScore14_4_1) {
		this.evlScore14_4_1 = evlScore14_4_1;
	}
	public String getEvlScore14_4_2() {
		return evlScore14_4_2;
	}
	public void setEvlScore14_4_2(String evlScore14_4_2) {
		this.evlScore14_4_2 = evlScore14_4_2;
	}
	public String getEvlScore14_4_3() {
		return evlScore14_4_3;
	}
	public void setEvlScore14_4_3(String evlScore14_4_3) {
		this.evlScore14_4_3 = evlScore14_4_3;
	}
	public String getEvlScore14_4_4() {
		return evlScore14_4_4;
	}
	public void setEvlScore14_4_4(String evlScore14_4_4) {
		this.evlScore14_4_4 = evlScore14_4_4;
	}
	public String getEvlScore14_5_1() {
		return evlScore14_5_1;
	}
	public void setEvlScore14_5_1(String evlScore14_5_1) {
		this.evlScore14_5_1 = evlScore14_5_1;
	}
	public String getEvlScore14_5_2() {
		return evlScore14_5_2;
	}
	public void setEvlScore14_5_2(String evlScore14_5_2) {
		this.evlScore14_5_2 = evlScore14_5_2;
	}
	public String getEvlScore14_5_3() {
		return evlScore14_5_3;
	}
	public void setEvlScore14_5_3(String evlScore14_5_3) {
		this.evlScore14_5_3 = evlScore14_5_3;
	}
	public String getEvlScore14_5_4() {
		return evlScore14_5_4;
	}
	public void setEvlScore14_5_4(String evlScore14_5_4) {
		this.evlScore14_5_4 = evlScore14_5_4;
	}
	public String getEvlScore14_6_1() {
		return evlScore14_6_1;
	}
	public void setEvlScore14_6_1(String evlScore14_6_1) {
		this.evlScore14_6_1 = evlScore14_6_1;
	}
	public String getEvlScore14_6_2() {
		return evlScore14_6_2;
	}
	public void setEvlScore14_6_2(String evlScore14_6_2) {
		this.evlScore14_6_2 = evlScore14_6_2;
	}
	public String getEvlScore14_6_3() {
		return evlScore14_6_3;
	}
	public void setEvlScore14_6_3(String evlScore14_6_3) {
		this.evlScore14_6_3 = evlScore14_6_3;
	}
	public String getEvlScore14_6_4() {
		return evlScore14_6_4;
	}
	public void setEvlScore14_6_4(String evlScore14_6_4) {
		this.evlScore14_6_4 = evlScore14_6_4;
	}
	public String getEvlScore15_1_1() {
		return evlScore15_1_1;
	}
	public void setEvlScore15_1_1(String evlScore15_1_1) {
		this.evlScore15_1_1 = evlScore15_1_1;
	}
	public String getEvlScore15_1_2() {
		return evlScore15_1_2;
	}
	public void setEvlScore15_1_2(String evlScore15_1_2) {
		this.evlScore15_1_2 = evlScore15_1_2;
	}
	public String getEvlScore15_1_3() {
		return evlScore15_1_3;
	}
	public void setEvlScore15_1_3(String evlScore15_1_3) {
		this.evlScore15_1_3 = evlScore15_1_3;
	}
	public String getEvlScore15_1_4() {
		return evlScore15_1_4;
	}
	public void setEvlScore15_1_4(String evlScore15_1_4) {
		this.evlScore15_1_4 = evlScore15_1_4;
	}
	public String getEvlScore15_2_1() {
		return evlScore15_2_1;
	}
	public void setEvlScore15_2_1(String evlScore15_2_1) {
		this.evlScore15_2_1 = evlScore15_2_1;
	}
	public String getEvlScore15_2_2() {
		return evlScore15_2_2;
	}
	public void setEvlScore15_2_2(String evlScore15_2_2) {
		this.evlScore15_2_2 = evlScore15_2_2;
	}
	public String getEvlScore15_2_3() {
		return evlScore15_2_3;
	}
	public void setEvlScore15_2_3(String evlScore15_2_3) {
		this.evlScore15_2_3 = evlScore15_2_3;
	}
	public String getEvlScore15_2_4() {
		return evlScore15_2_4;
	}
	public void setEvlScore15_2_4(String evlScore15_2_4) {
		this.evlScore15_2_4 = evlScore15_2_4;
	}
	
}