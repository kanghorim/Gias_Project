package com.loglog.api.commons.constants;

public final class Constants {
	
	public static final String OK = "ok";
	
	public static final String FAIL = "fail";
	
	public static final String WAIT = "wait";
	
	public static final String OK_PAY = "okPay";
	
	public static final String RESULT = "result";
	
	public static final String RESULT_MSG = "resultMsg";
	
	public static final String REDIRECT_MSG = "redirectMsg";
	
	public static final String RESULT_URL = "resultUrl";
	
	public static final String AUTH_TOKEN = "auth_token";
	
	public static final String SESSION_USER_ID = "userId";
	
	public static final String SESSION_ADMIN_BEAN = "adminBean";
	
	public static final String SESSION_SELLER_BEAN = "sellerBean";
	
	public static final String SESSION_USER_BEAN = "userBean";
	
    public static final String BASE_PACKAGE = "com.loglog.api";
    public static final String COMM_PACKAGE = "com.loglog.api.commons";
	
	/** 세션에 저장된 판매자의 구분코드를 저장 **/
	public static final String SESSION_SELLER_TYPE_CD = "sessionSellerTypeCd";
	
	/** 네이버 회원가입 임시 유져정보 저장 **/
	public static final String SESSION_NAVER_TEMP_USER_BEAN = "sessioNaverTempUserBean";
	
	public static final String SESSION_RECOMMENDER_ID = "recommenderId";
	
	public static final String SESSION_SNS_MAP = "snsMap";
	
	public static final String SESSION_ORDER_BEAN = "orderBean";
	
	/** 나이스 SMS 요청시 세션에 저장하는 요청번호(고유번호) **/
	public static final String SESSION_SMS_NICE_REQ_NUMBER = "sessionSmsNiceReqNumber";
	
	public static final String USER_FORM = "1";
	
	public static final String SELLER_FORM = "2";
	
	public static final String ADMIN_FORM = "3";
	
	public static final String UPDATE_FLAG = "updateFlag";
	
	public static final String CHECK_PW_LOCATION = "chkPwLocation";
	
	public static final String CATE_LEVEL2_LIST = "cateLevel2List";
	
	/** 서버 키 - 사용자 */
	public static final String SERVER_USER = "U";
	/** 서버 키 - 판매자 */
	public static final String SERVER_SELLER = "S";
	/** 서버 키 - 관리자 */
	public static final String SERVER_ADMIN = "A";
	/** 서버 키 - 모바일 */
	public static final String SERVER_MOBILE = "M";
	
	
	/** 메일전송 방식 - 네이버웍스 **/
	public static final int MAIL_TYPE_NAVER_WORKS = 1;
	/** 메일전송 방식 - 지메일 **/
	public static final int MAIL_TYPE_GMAIL = 2;
	
	
	/** 나이스 SMS 인증시 사용자 ID를 세션에 저장할때 사용하는 키 **/
	public static final String NICE_SESSION_USER_ID = "niceSessionUserId";
	/** 나이스 SMS 인증시 사용자 이름을 세션에 저장할때 사용하는 키 **/
	public static final String NICE_SESSION_USER_NAME = "niceSessionUserName";
	

	public static final String VER_BUILD_DATE = "VER_BUILD_DATE";
	
}
