package com.loglog.api.commons.beans;

import lombok.Data;

/**
 * 리스트의 페이징을 처리하는 Bean
 * 
 * @author SJW
 */
@Data
public class PagingBean {
	
	/** 페이지 표시여부 */
	private Boolean allowsPaging = true;

	/** 페이지당 보여줄 레코드수 (변경가능하게 set/get 추가함) */
	private int countPerRecord = 10;
	/** all: 모든 레코드를 표시한다. **/
	private String countPerRecordTypeCd;
	
	/** 한 화면에 보여줄 페이지 수 (변경가능하게 set/get 추가함) */
	private int countPerPage = 10;
	
	/** 인덱스에 보여줄 공지사항 수 (변경가능하게 set/get 추가함) */
	private int countPerNoti = 15;
	
	/** 전체 레코드수 */
	private int totalRecordCount;
	/** 전체 페이지 수 */
	private int totalPageCount;
	/** 요청 페이지 */
	private int pageNo;
	/** DB 시작 로우 번호 */
	private int startRow;
	/** DB 종료 로우 번호 */
	private int endRow;
	
	/** 전체 페이지의 그룹갯수 */
	private int totalGroupCount;
	/** 현재 페이지의 그룹번호 (그룹번호는 1부터 시작) */
	private int groupNo;
	/** 시작 페이지 번호 */
	private int pageStartNo;
	/** 끝 페이지 번호 */
	private int pageEndNo;
	
	/** 검색어 */
	private String search;
	/** 검색 종류 */
	private String searchKind;
	/** 탭 구분자 */
	private String tapType;
	/** 정렬 문자열 */
	private String orderByStr;
	
	/** 공지 타입 코드 */
	private String typeCd;
	
	/** 1대1 판매자 및 적립금 문의 기간 */
	private String period;
	/** 1대1 판매자 문의 답변유형 */
	private String replyYn;
	/** 1대1 문의 및 조회 할때 사용자 ID */
	private String sellerUserId;
	
	/** 사용자ID */
	private String userId;
	/** 판매자 ID */
	private String sellerId;
	/** 관리자ID*/
	private String adminId;
	
	/** 적립금 입출금유형 */
	private String inYn;
	
	/** 적립금 조회시 주문번호 */
	private String orderId;
	/** 적립금 조회시 주문딜번호 */
	private String orderDealId;
	
	/** 판매자 주문/배송관리 조회 시작 날 */
	/** 검색문의 시작일 */
	private String startDt;
	/** 판매자 주문/배송관리 조회 끝 날 */
	/** 검색문의 종료일 */
	private String endDt;
	
	/** 딜명 **/
	private String dealName;
	/** 딜아이디 */
	private String dealId;
	
	/** 공동구매 정산 아이디 */
	private String calGroupId;
	
	/** 주문 상태 코드 */
	private String orderStatusCd;
	
	/** 쿠폰 검색시 필요한 정보 */
	private String couponStatus1;
	private String couponStatus2;
	private String couponStatus3;
	
	/** 검색시 필요한 키워드 */
	private String searchKeyword;
	
	/**	게시판 유형 코드 */
	private String bdTypeCd;
	/**	게시물 고유번호 */
	private int bdNo;
	
	/** 교육신청 번호 */
	private int eduNo;
	
	public Boolean getAllowsPaging() {
		return allowsPaging;
	}

	public void setAllowsPaging(Boolean allowsPaging) {
		this.allowsPaging = allowsPaging;
	}

	public int getCountPerRecord() {
		return countPerRecord;
	}

	public void setCountPerRecord(int countPerRecord) {
		this.countPerRecord = countPerRecord;
	}

	public String getCountPerRecordTypeCd() {
		return countPerRecordTypeCd;
	}

	public void setCountPerRecordTypeCd(String countPerRecordTypeCd) {
		this.countPerRecordTypeCd = countPerRecordTypeCd;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getCountPerNoti() {
		return countPerNoti;
	}

	public void setCountPerNoti(int countPerNoti) {
		this.countPerNoti = countPerNoti;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getTotalGroupCount() {
		return totalGroupCount;
	}

	public void setTotalGroupCount(int totalGroupCount) {
		this.totalGroupCount = totalGroupCount;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getPageStartNo() {
		return pageStartNo;
	}

	public void setPageStartNo(int pageStartNo) {
		this.pageStartNo = pageStartNo;
	}

	public int getPageEndNo() {
		return pageEndNo;
	}

	public void setPageEndNo(int pageEndNo) {
		this.pageEndNo = pageEndNo;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearchKind() {
		return searchKind;
	}

	public void setSearchKind(String searchKind) {
		this.searchKind = searchKind;
	}

	public String getTapType() {
		return tapType;
	}

	public void setTapType(String tapType) {
		this.tapType = tapType;
	}

	public String getOrderByStr() {
		return orderByStr;
	}

	public void setOrderByStr(String orderByStr) {
		this.orderByStr = orderByStr;
	}

	public String getTypeCd() {
		return typeCd;
	}

	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getReplyYn() {
		return replyYn;
	}

	public void setReplyYn(String replyYn) {
		this.replyYn = replyYn;
	}

	public String getSellerUserId() {
		return sellerUserId;
	}

	public void setSellerUserId(String sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getInYn() {
		return inYn;
	}

	public void setInYn(String inYn) {
		this.inYn = inYn;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDealId() {
		return orderDealId;
	}

	public void setOrderDealId(String orderDealId) {
		this.orderDealId = orderDealId;
	}

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getCalGroupId() {
		return calGroupId;
	}

	public void setCalGroupId(String calGroupId) {
		this.calGroupId = calGroupId;
	}

	public String getOrderStatusCd() {
		return orderStatusCd;
	}

	public void setOrderStatusCd(String orderStatusCd) {
		this.orderStatusCd = orderStatusCd;
	}

	public String getCouponStatus1() {
		return couponStatus1;
	}

	public void setCouponStatus1(String couponStatus1) {
		this.couponStatus1 = couponStatus1;
	}

	public String getCouponStatus2() {
		return couponStatus2;
	}

	public void setCouponStatus2(String couponStatus2) {
		this.couponStatus2 = couponStatus2;
	}

	public String getCouponStatus3() {
		return couponStatus3;
	}

	public void setCouponStatus3(String couponStatus3) {
		this.couponStatus3 = couponStatus3;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getBdTypeCd() {
		return bdTypeCd;
	}

	public void setBdTypeCd(String bdTypeCd) {
		this.bdTypeCd = bdTypeCd;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public int getEduNo() {
		return eduNo;
	}

	public void setEduNo(int eduNo) {
		this.eduNo = eduNo;
	}

	/**
	 * 화면에 표시할 페이지를 계산한다.
	 * @param totalRecordCount : 전체 레코드 갯수
	 */
	public void calcPage(int totalRecordCount) {
		//페이지 디폴트값은 무조건 1 이다.
		this.pageNo = pageNo == 0 ? 1 : pageNo;
		this.totalRecordCount = totalRecordCount;
		
		//전체 페이지 갯수
		totalPageCount  = calculateTotalPageCount(totalRecordCount, countPerRecord);
		//DB에서 가져올 시작행 번호
		//startRow = ((pageNo - 1) * countPerRecord) + 1;
		// mysql limit 를 사용하므로 +1은 사용안한다.
		startRow = (pageNo - 1) * countPerRecord;
		//DB에서 가져올 끝행 번호
		endRow =  pageNo * countPerRecord;
		
		
		//전체 페이징 그룹 갯수
		totalGroupCount = calculateTotalPageCount( totalPageCount, countPerPage );
		//현재 페이지의 소속 그룹번호
		groupNo = calculateTotalPageCount(pageNo, countPerPage);
		//시작, 끝 페이지번호 구하기
		//게시물총수가 0일때는 스타트번호를 0으로 줌
		if(totalRecordCount == 0){
			pageStartNo = 0;
		} else {
			pageStartNo = ((groupNo - 1) * countPerPage) + 1;
		}
		pageEndNo = groupNo * countPerPage;
		
		//마지막 페이지 번호보다 같거나 크다면 더이상의 페이지가 없는것이기 때문에 전체 페이지 갯수를 대입해준다.
		if(pageEndNo >= totalPageCount) {
			pageEndNo = totalPageCount;
		}
	}
	
	/**
	 * 전체 레코드 개수에 대한 화면에 표시할 페이징 계산
	 * @param totalCount
	 * @return
	 */
	private int calculateTotalPageCount(int totalRecordCount , int countPerPage){
		int totalPageCount = 0;
		if(totalRecordCount > 0){
			totalPageCount = totalRecordCount / countPerPage;
			if( (totalRecordCount % countPerPage) > 0 ){
				totalPageCount ++;
			}
		}
		return totalPageCount;
	}

}
