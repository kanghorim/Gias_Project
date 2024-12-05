package com.loglog.api.commons.constants;

/**
 * TB_CODE 테이블 상수정의
 * 
 * @author SJW
 */
public class CodeConstant {
	
	/** 관리자 상태 코드- 가입심사중 - {@value} */
	public static final String ADMIN_STATUS_CD_1001 = "1001";
	/** 관리자 상태 코드- 정상이용 - {@value} */
	public static final String ADMIN_STATUS_CD_1000 = "1000";

	/** 판매자 상태 코드- 가입심사중 - {@value} */
	public static final String SELLER_STATUS_CD_1001 = "1001";
	/** 판매자 상태 코드- 정상이용 - {@value} */
	public static final String SELLER_STATUS_CD_1000 = "1000";
	
	
	/** 인증 상태 코드- 인증메일발송 - {@value} */
	public static final String AUTH_STATUS_CD_01 = "01";
	/** 인증 상태 코드- 인증확인 - {@value} */
	public static final String AUTH_STATUS_CD_02 = "02";
	/** 인증 상태 코드- 승인대기 - {@value} */
	public static final String AUTH_STATUS_CD_03 = "03";
	/** 인증 상태 코드- 정상이용 - {@value} */
	public static final String AUTH_STATUS_CD_04 = "04";
	/** 인증 상태 코드- 일시정지 - {@value} */
	public static final String AUTH_STATUS_CD_05 = "05";
	
	
	/** 주소 종류 코드- 일반주소 - {@value} */
	public static final String ADDR_TYPE_CD_01 = "01";
	/** 주소 종류 코드- 대표출고지 주소 - {@value} */
	public static final String ADDR_TYPE_CD_02 = "02";
	/** 주소 종류 코드- 대표 반품/교환지 주소 - {@value} */
	public static final String ADDR_TYPE_CD_03 = "03";
	
	/** 판매자 유형 코드- 사업자 판매 회원 - {@value} */
	public static final String SELLER_TYPE_CD_01 = "01";
	/** 판매자 유형 코드- 개인 판매 회원 - {@value} */
	public static final String SELLER_TYPE_CD_02 = "02";
	
	
	/** 사용자 상태 코드- 정상 이용 - {@value} */
	public static final String USER_STATUS_CD_1000 = "1000";
	
	/** 사용자 상태 코드- 가입 심사중 - {@value} */
	public static final String USER_STATUS_CD_1001 = "1001";
	/** 사용자 상태 코드- 메일 인증 대기 - {@value} */
	public static final String USER_STATUS_CD_2001 = "2001";
	/** 사용자 상태 코드- 활동 정지 - {@value} */
	public static final String USER_STATUS_CD_5001 = "5001";
	/** 사용자 상태 코드- 탈퇴 - {@value} */
	public static final String USER_STATUS_CD_9999 = "9999";
	/** 사용자 상태 코드- 탈퇴요청 - {@value} */
	public static final String USER_STATUS_CD_9001 = "9001";
	/** 사용자 상태 코드- 탈퇴반려 - {@value} */
	public static final String USER_STATUS_CD_9002 = "9002";
	

	/** 딜 상태 코드- 딜 등록대기 - {@value} */
	public static final String DEAL_STATUS_CD_100 = "100";
	/** 딜 상태 코드- 딜 심사요청 - {@value} */
	public static final String DEAL_STATUS_CD_101 = "101";
	/** 딜 상태 코드- 딜 심사중 - {@value} */
	public static final String DEAL_STATUS_CD_111 = "111";
	/** 딜 상태 코드- 딜 심사 반려 - {@value} */
	public static final String DEAL_STATUS_CD_121 = "121";
	/** 딜 상태 코드- 딜 진행중 - {@value} */
	public static final String DEAL_STATUS_CD_131 = "131";
	/** 딜 상태 코드- 딜 종료 - {@value} */
	public static final String DEAL_STATUS_CD_141 = "141";
	/** 딜 상태 코드- 딜 삭제 - {@value} */
	public static final String DEAL_STATUS_CD_191 = "191";
	
	/** 딜 상태 코드- 딜 수요조사 등록대기- {@value} */
	public static final String DEAL_STATUS_CD_200 = "200";
	/** 딜 상태 코드- 딜 수요조사 심사요청- {@value} */
	public static final String DEAL_STATUS_CD_201 = "201";
	/** 딜 상태 코드- 딜 수요조사 심사중 - {@value} */
	public static final String DEAL_STATUS_CD_211 = "211";
	/** 딜 상태 코드- 딜 수요조사 심사반려 - {@value} */
	public static final String DEAL_STATUS_CD_221 = "221";
	/** 딜 상태 코드- 딜 수요조사 진행중 - {@value} */
	public static final String DEAL_STATUS_CD_231 = "231";
	/** 딜 상태 코드- 딜 수요조사 종료 - {@value} */
	public static final String DEAL_STATUS_CD_241 = "241";
	/** 딜 상태 코드- 딜 수요조사 삭제 - {@value} */
	public static final String DEAL_STATUS_CD_291 = "291";
	
	/** 딜 상태 코드- 딜 공동구매 등록대기 - {@value} */
	public static final String DEAL_STATUS_CD_300 = "300";
	/** 딜 상태 코드- 딜 공동구매 심사요청 - {@value} */
	public static final String DEAL_STATUS_CD_301 = "301";
	/** 딜 상태 코드- 딜 공동구매 심사중 - {@value} */
	public static final String DEAL_STATUS_CD_311 = "311";
	/** 딜 상태 코드- 딜 공동구매 심사 반려 - {@value} */
	public static final String DEAL_STATUS_CD_321 = "321";
	/** 딜 상태 코드- 딜 공동구매 모집중 - {@value} */
	public static final String DEAL_STATUS_CD_331 = "331";
	/** 딜 상태 코드- 딜 공동구매 모집실패 처리중 - {@value} */
	public static final String DEAL_STATUS_CD_335 = "335";
	/** 딜 상태 코드- 딜 공동구매 모집종료 - {@value} */
	public static final String DEAL_STATUS_CD_341 = "341";
	/** 딜 상태 코드- 딜 공동구매 배송중 - {@value} */
	public static final String DEAL_STATUS_CD_351 = "351";
	/** 딜 상태 코드- 딜 공동구매 종료 - {@value} */
	public static final String DEAL_STATUS_CD_361 = "361";
	/** 딜 상태 코드- 딜 공동구매 모집실패 - {@value} */
	public static final String DEAL_STATUS_CD_381 = "381";
	/** 딜 상태 코드- 딜 공동구매 삭제 - {@value} */
	public static final String DEAL_STATUS_CD_391 = "391";
	
	/** 딜 타입 코드 - 판매딜  - {@value} */
	public static final String DEAL_TYPE_CD_1 = "1";
	/** 딜 타입 코드 - 수요조사딜  - {@value} */
	public static final String DEAL_TYPE_CD_2 = "2";
	/** 딜 타입 코드 - 공동구매딜  - {@value} */
	public static final String DEAL_TYPE_CD_3 = "3";
	
	/** 딜 타입별 상태 - 판매딜  - 판매자 - {@value} */
	public static final String[] DEAL_TYPE_1_CDS_SELLER = {"100","101","111","121","131","141"};
	/** 딜 타입별 상태 - 판매딜 - 관리자 - {@value} */
	public static final String[] DEAL_TYPE_1_CDS_ADMIN = {"100","101","111","121","131","141", "191"};
	
	/** 딜 타입별 상태 - 수요조사딜  - {@value} */
	public static final String[] DEAL_TYPE_2_CDS = {"201","211","221","231","241"};
	
	/** 딜 타입별 상태 - 공동구매딜  - 판매자 - {@value} */
	public static final String[] DEAL_TYPE_3_CDS_SELLER = {"300","301","311","321","331","335","341","351","361","381"};
	/** 딜 타입별 상태 - 공동구매 주문관리 딜  - 판매자 - {@value} */
	public static final String[] DEAL_TYPE_3_CDS_SELLER_GROUP = {"331","335","341","351","361","381"};
	/** 딜 타입별 상태 - 공동구매딜 - 관리자  - {@value} */
	public static final String[] DEAL_TYPE_3_CDS_ADMIN = {"300","301","311","321","331","335","341","351","361","381","391"};
	
	/** 옵션 타입 코드 - 기본 옵션 - {@value} */
	public static final String OPTION_TYPE_CD_1 = "1";
	/** 옵션 타입 코드 - 하위옵션 - {@value} */
	public static final String OPTION_TYPE_CD_2 = "2";
	/** 옵션 타입 코드 - 추가구성품 - {@value} */
	public static final String OPTION_TYPE_CD_3 = "3";
	
	
	/** 결제 수단 코드 - 신용카드 {@value} */
	public static final String PAY_MEANS_CD_CREDIT_CARD = "CREDIT_CARD";
	/** 결제 수단 코드 - 실시간계좌이체 {@value} */
	public static final String PAY_MEANS_CD_BANK = "BANK";
	/** 결제 수단 코드 - 무통장입금 {@value} */
	public static final String PAY_MEANS_CD_VIRTUAL_ACCOUNT = "VIRTUAL_ACCOUNT";
	/** 결제 수단 코드 - 휴대폰 {@value} */
	public static final String PAY_MEANS_CD_MOBILE = "MOBILE";
	/** 결제 수단 코드 - 카카오페이 {@value} */
	public static final String PAY_MEANS_CD_KAKAO_PAY= "KAKAO_PAY";
	
	
	/** 배송비 그룹 계산 방식 코드 - 묶음그룹에서 가장 작은 배송비로 부과 - {@value} */
	public static final String DELI_FEE_GROUP_CAL_TYPE_CD_01 = "01";
	/** 배송비 그룹 계산 방식 코드 - 묶음그룹에서 가장 큰 배송비로 부과 - {@value} */
	public static final String DELI_FEE_GROUP_CAL_TYPE_CD_02 = "02";
	
	
	/** 주문 상태 코드 - 주문접수 {@value} */
	public static final String ORDER_STATUS_CD_101 = "101";
	/** 주문 상태 코드 - 입금대기중 {@value} */
	public static final String ORDER_STATUS_CD_201 = "201";
	/** 주문 상태 코드 - 결제완료 {@value} */
	public static final String ORDER_STATUS_CD_301 = "301";
	/** 주문 상태 코드 - 배송준비중 {@value} */
	public static final String ORDER_STATUS_CD_401 = "401";
	/** 주문 상태 코드 - 배송중 {@value} */
	public static final String ORDER_STATUS_CD_501 = "501";
	/** 주문 상태 코드 - 배송완료 {@value} */
	public static final String ORDER_STATUS_CD_601 = "601";
	/** 주문 상태 코드 - 구매확정 {@value} */
	public static final String ORDER_STATUS_CD_701 = "701";
	/** 주문 상태 코드 - 주문취소접수 {@value} */
	public static final String ORDER_STATUS_CD_801 = "801";
	/** 주문 상태 코드 - 주문취소 {@value} */
	public static final String ORDER_STATUS_CD_901 = "901";
	
	
	/** 공동구매 주문 목록 상태 코드 - 판매자 {@value} */
	public static final String[] ORDER_STATUS_CDS_SELLER= {"301","401","501","601","701","901"};
	
	
	/** 회원 구분 코드 - 사용자 {@value} */
	public static final String MEMBER_TYPE_CD_1 = "1";
	/** 회원 구분 코드 - 판매자 {@value} */
	public static final String MEMBER_TYPE_CD_2 = "2";
	/** 회원 구분 코드 - 관리자 {@value} */
	public static final String MEMBER_TYPE_CD_3 = "3";

	
	/** 결제 상태 코드 - 결제대기 {@value} */
	public static final String PAY_STATUS_CD_101 = "101";
	/** 결제 상태 코드 - 입금대기 {@value} */
	public static final String PAY_STATUS_CD_201 = "201";
	/** 결제 상태 코드 - 결제완료 {@value} */
	public static final String PAY_STATUS_CD_301 = "301";
	/** 결제 상태 코드 - 결제완료(취소불가) {@value} */
	public static final String PAY_STATUS_CD_302 = "302";
	/** 결제 상태 코드 - 결제취소 {@value} */
	public static final String PAY_STATUS_CD_701 = "701";
	/** 결제 상태 코드 - 결제실패 {@value} */
	public static final String PAY_STATUS_CD_901 = "901";
	
	
	/** 게시 기간 코드 - 재고소진시까지 {@value} */
	public static final String INFORM_DT_CD_1 = "1";
	/** 게시 기간 코드 - 게시기간 {@value} */
	public static final String INFORM_DT_CD_2 = "2";
	
	
	/** 공지사항 타입 - 판매자 {@value} */
	public static final String NOTI_TYPE_S = "S";
	/** 공지사항 타입 - 사용자 {@value} */
	public static final String NOTI_TYPE_U = "U";
	
	/** 사용자 공지사항 탭 구분 - 공지 {@value} */
	public static final String NOTI_EVENT_N = "N";
	/** 사용자 공지사항 탭 구분 - 이벤트 {@value} */
	public static final String NOTI_EVENT_E = "E";
	
	/** 자주하는 질문 탭 구분 - 주문/배송 {@value} */
	public static final String FAQ_ORDER = "1";
	/** 자주하는 질문 탭 구분 - 취소/환불 {@value} */
	public static final String FAQ_CANCEL = "2";
	/** 자주하는 질문 탭 구분 - 서비스 {@value} */
	public static final String FAQ_SERVICE = "3";
	
	
	/** 발송 메일 주소 코드  - help {@value} */
	public static final String SEND_MAIL_CD_01 = "01";
	
	
	/** 다우 페이 카드 코드 - 신한카드 {@value} */
	public static final String DAOU_PAY_CARD_CD_CCLG = "CCLG";
	/** 다우 페이 카드 코드 - BC카드 {@value} */
	public static final String DAOU_PAY_CARD_CD_CCBC = "CCBC";
	/** 다우 페이 카드 코드 - 국민카드 {@value} */
	public static final String DAOU_PAY_CARD_CD_CCKM = "CCKM";
	/** 다우 페이 카드 코드 - 삼성카드 {@value} */
	public static final String DAOU_PAY_CARD_CD_CCSS = "CCSS";
	/** 다우 페이 카드 코드 - 현대카드 {@value} */
	public static final String DAOU_PAY_CARD_CD_CCDI = "CCDI";
	/** 다우 페이 카드 코드 - 롯데카드 {@value} */
	public static final String DAOU_PAY_CARD_CD_CCLO = "CCLO";
	/** 다우 페이 카드 코드 - 하나SK카드 {@value} */
	public static final String DAOU_PAY_CARD_CD_CCHN = "CCHN";
	/** 다우 페이 카드 코드 - 외환카드 {@value} */
	public static final String DAOU_PAY_CARD_CD_CCKE = "CCKE";
	/** 다우 페이 카드 코드 - NH농협카드 {@value} */
	public static final String DAOU_PAY_CARD_CD_CCNH = "CCNH";
	/** 다우 페이 카드 코드 - 시티카드 {@value} */
	public static final String DAOU_PAY_CARD_CD_CCCT = "CCCT";
	/** 다우 페이 카드 코드 - 우리카드 {@value} */
	public static final String DAOU_PAY_CARD_CD_CCPH = "CCPH";
	
	
	/** 다우 페이 상품 구분 코드 - 디지털 {@value} */
	public static final String DAOU_PAY_PRODUCT_TYPE_CD_1 = "1";
	/** 다우 페이 상품 구분 코드 - 실물 {@value} */
	public static final String DAOU_PAY_PRODUCT_TYPE_CD_2 = "2";
	
	
	/** 다우 페이 과금 유형 코드 - 일반 {@value} */
	public static final String DAOU_PAY_BILL_TYPE_CD_1 = "1";
	
	
	/** 다우 페이 입금만료일(가상계좌) {@value} */
	public static final String DAOU_PAY_DEPOSIT_END_DATE= "3";
	
	
	/** 다우 페이 현금영수증 발행여부 - 발행 {@value} */
	public static final String DAOU_PAY_CASH_RECEIPT_FLAG_1 = "1";
	/** 다우 페이 현금영수증 발행여부 - 미발행 {@value} */
	public static final String DAOU_PAY_CASH_RECEIPT_FLAG_2 = "2";
	
	
	/** 다우 페이 콜백 - 결제수단 - 신용카드 결과통보 {@value} */
	public static final String DAOU_PAY_PAY_METHOD_CD_CARD = "CARD";
	/** 다우 페이 콜백 - 결제수단 - 가상계좌 계좌발행 {@value} */
	public static final String DAOU_PAY_PAY_METHOD_CD_VACCOUNTISSUE = "VACCOUNTISSUE";
	/** 다우 페이 콜백 - 결제수단 - 가상계좌  결과통보 {@value} */
	public static final String DAOU_PAY_PAY_METHOD_CD_VACCOUNT = "VACCOUNT";
	/** 다우 페이 콜백 - 결제수단 - 계좌이체 결과통보 {@value} */
	public static final String DAOU_PAY_PAY_METHOD_CD_BANK = "BANK";
	
	
	/** 다우 페이 비과세 여부 코드 - 과세 {@value} */
	public static final String DAOU_PAY_TAX_FREE_CD_00 = "00";
	/** 다우 페이 비과세 여부 코드 - 비과세 {@value} */
	public static final String DAOU_PAY_TAX_FREE_CD_01 = "01";
	
	
	/** PG사 코드 - 다우페이 {@value} */
	public static final String PG_CD_DAOU = "DAOU";
	public static final String PG_CD_INICIS = "INICIS";
	
	
	/** 구매평 샘플 코드 - 매우좋아요 {@value} */
	public static final String BUY_EVAL_SAMPLE_CD_01 = "01";
	/** 구매평 샘플 코드 - 좋아요 {@value} */
	public static final String BUY_EVAL_SAMPLE_CD_02 = "02";
	/** 구매평 샘플 코드 - 보통입니다 {@value} */
	public static final String BUY_EVAL_SAMPLE_CD_03 = "03";
	/** 구매평 샘플 코드 - 별로입니다 {@value} */
	public static final String BUY_EVAL_SAMPLE_CD_04 = "04";
	/** 구매평 샘플 코드 - 매우별로 {@value} */
	public static final String BUY_EVAL_SAMPLE_CD_05 = "05";
	
	
	/** 적립금 구분 코드 - 구매확정 {@value} */
	public static final String SAVE_CASH_TYPE_CD_01 = "01";
	/** 적립금 구분 코드 - SNS 공유 {@value} */
	public static final String SAVE_CASH_TYPE_CD_02 = "02";
	/** 적립금 구분 코드 - 가격구간 할인 {@value} */
	public static final String SAVE_CASH_TYPE_CD_03 = "03";
	/** 적립금 구분 코드 - 구매후기  {@value} */
	public static final String SAVE_CASH_TYPE_CD_04 = "04";
	/** 적립금 구분 코드 - 인출신청  {@value} */
	public static final String SAVE_CASH_TYPE_CD_05 = "05";
	/** 적립금 구분 코드 - 인출완료  {@value} */
	public static final String SAVE_CASH_TYPE_CD_06 = "06";
	/** 적립금 구분 코드 - 인출불가  {@value} */
	public static final String SAVE_CASH_TYPE_CD_07 = "07";
	/** 적립금 구분 코드 - 인출취소  {@value} */
	public static final String SAVE_CASH_TYPE_CD_08 = "08";
	/** 적립금 구분 코드 - 결제  {@value} */
	public static final String SAVE_CASH_TYPE_CD_09 = "09";
	/** 적립금 구분 코드 - 결제취소  {@value} */
	public static final String SAVE_CASH_TYPE_CD_10 = "10";
	/** 적립금 구분 코드 - 구매평 {@value} */
	public static final String SAVE_CASH_TYPE_CD_11 = "11";
	/** 적립금 구분 코드 - 이벤트 {@value} */
	public static final String SAVE_CASH_TYPE_CD_30 = "30";
	/** 적립금 구분 코드 - 회원가입 {@value} */
	public static final String SAVE_CASH_TYPE_CD_40 = "40";
	/** 적립금 구분 코드 - 회원가입 추천인 ID {@value} */
	public static final String SAVE_CASH_TYPE_CD_41 = "41";
	
	/**쿠폰 타입 구분 코드
	
	
	/** 인출신청 상태 코드 - 신청 {@value} */
	public static final String WITHDRAW_REQUEST_STATUS_CD_01 = "01";
	/** 인출신청 상태 코드 - 처리완료 {@value} */
	public static final String WITHDRAW_REQUEST_STATUS_CD_02 = "02";
	/** 인출신청 상태 코드 - 불가 {@value} */
	public static final String WITHDRAW_REQUEST_STATUS_CD_03 = "03";
	/** 인출신청 상태 코드 - 취소 {@value} */
	public static final String WITHDRAW_REQUEST_STATUS_CD_04 = "04";
	
	
	/** 결제 타입 코드 - 주문 {@value} */
	public static final String PAY_TYPE_CD_ORDER = "ORDER";
	/** 결제 타입 코드 - 취소 {@value} */
	public static final String PAY_TYPE_CD_CANCEL = "CANCEL";
	/** 결제 타입 코드 - 재결제 {@value} */
	public static final String PAY_TYPE_CD_REPAY = "REPAY";
	
	/** SNS 유형 코드 - facebook {@value} */
	public static final String SNS_TYPE_CD_FACEBOOK = "01";
	/** SNS 유형 코드 - twitter {@value} */
	public static final String SNS_TYPE_CD_TWITTER= "02";
	/** SNS 유형 코드 - naver {@value} */
	public static final String SNS_TYPE_CD_NAVER= "03";
	/** SNS 유형 코드 - daumCafe {@value} */
	public static final String SNS_TYPE_CD_DAUMCAFE= "04";
	/** SNS 유형 코드 - tumblr {@value} */
	public static final String SNS_TYPE_CD_TUMBLR= "05";
	/** SNS 유형 코드 - pinterest {@value} */
	public static final String SNS_TYPE_CD_PINTEREST= "06";
	/** SNS 유형 코드 - google {@value} */
	public static final String SNS_TYPE_CD_GOOGLE= "07";
	/** SNS 유형 코드 - kakaoStory {@value} */
	public static final String SNS_TYPE_CD_KAKAOSTORY= "08";
	/** SNS 유형 코드 - band {@value} */
	public static final String SNS_TYPE_CD_BAND= "09";
	
	
	/** 추천인 유형 코드 - 없음 {@value} */
	public static final String RECOMMENDER_TYPE_CD_NONE = "00";
	/** 추천인 유형 코드 - 판매자 {@value} */
	public static final String RECOMMENDER_TYPE_CD_SELLER = "01";
	/** 추천인 유형 코드 - 일반사용자 {@value} */
	public static final String RECOMMENDER_TYPE_CD_USER = "02";
	
	/** 광고 딜 그룹 타입 코드 - 전체 {@value} */
	public static final String AD_DEAL_GRP_TYPE_CD_A = "A";
	/** 광고 딜 그룹 타입 코드 - PC {@value} */
	public static final String AD_DEAL_GRP_TYPE_CD_P = "P";
	/** 광고 딜 그룹 타입 코드 - 모바일 {@value} */
	public static final String AD_DEAL_GRP_TYPE_CD_M = "M";
	
	/** 정산 상태 코드 -  정산예정{@value} */
	public static final String CAL_STATUS_CD_101 = "101";
	/** 정산 상태 코드 -  정산완료{@value} */
	public static final String CAL_STATUS_CD_201 = "201";
	
	/** 송금 상태 코드 - 송금전{@value} */
	public static final String REMIT_STATUS_CD_101 = "101";
	/** 송금 상태 코드 - 송금완료{@value} */
	public static final String REMIT_STATUS_CD_201 = "201";
	
	/** 세금계산서 발행 코드 - 발행대기{@value} */
	public static final String TAX_BILL_PUB_CD_101 = "101";
	/** 세금계산서 발행 코드 - 발행완료{@value} */
	public static final String TAX_BILL_PUB_CD_201 = "201";
	
	
	/** 다우페이 결과 코드 - 성공 */
	public static final String DAOU_PAY_RESULT_CD_0000 = "0000";
	/** 다우페이 결과 코드 - 취소가능 금액 부족 */
	public static final String DAOU_PAY_RESULT_CD_9029 = "9029";
	/** 다우페이 결과 코드 - 이미 취소 되었습니다 */
	public static final String DAOU_PAY_RESULT_CD_9112 = "9112";
	/** 다우페이 결과 코드 - 예외상황-에러발생 */
	public static final String DAOU_PAY_RESULT_CD_9999 = "9999";
}