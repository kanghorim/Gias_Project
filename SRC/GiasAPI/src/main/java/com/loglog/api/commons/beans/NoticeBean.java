 package com.loglog.api.commons.beans;

/**
 * 사용자 Bean
 * 
 * @author SJG
 */
public class NoticeBean extends CommonBean {
	
	/* 공지사항 코드*/
	private String noticeCode;
	/* 공지사항 생성 날짜*/
	private String createAt;
	/* 공지사항 수정 날짜*/
	private String updateAt;
	/* 공지사항 제목*/
	private String noticeTitle;
	/* 공지사항 내용*/
	private String noticeContent;
	/* 공지사항 작성자 코드*/
	private String memberCode;
	/*공지사항 순번*/
	private String No;
	/*공지사항 작성자 이름*/
	private String memberName;
	/* 공지사항 검색어*/
	private String search;
	/* 검색어 코드 ex) 제목검색인지 내용검색인지 둘 다인지 */
	private String typeCd;
	/**기관 코드*/
	private String organizationCode;
	/**기관 이름*/
	private String organizationName;
	
	private String noticeFile;
	
	private String noticeFileName;
	
	private String targetOrgCode;
	
	private String checkFile;
	
	private String userGrade;
	
	public String getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}
	public String getCheckFile() {
		return checkFile;
	}
	public void setCheckFile(String checkFile) {
		this.checkFile = checkFile;
	}
	public String getTargetOrgCode() {
		return targetOrgCode;
	}
	public void setTargetOrgCode(String targetOrgCode) {
		this.targetOrgCode = targetOrgCode;
	}
	public String getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}
	
	public String getNoticeFileName() {
		return noticeFileName;
	}
	public void setNoticeFileName(String noticeFileName) {
		this.noticeFileName = noticeFileName;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getTypeCd() {
		return typeCd;
	}
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getNoticeCode() {
		return noticeCode;
	}
	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
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
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	
	
}