package com.loglog.api.commons.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.loglog.api.commons.utils.UAgentInfo;

/**
 * PC 나 Mobile 로 들어오는 Request를 보고 해당 OS의 URL로 맵핑하여 이동시킨다.
 * @author SJW
 *
 */
public class UrlTranferInterceptor extends HandlerInterceptorAdapter {

	public static final Map<String, String> URI_MOBILE_2_PC = new HashMap<String, String>();
	public static final Map<String, String> URI_PC_2_MOBILE = new HashMap<String, String>();
	private static UAgentInfo mUAgentInfo = new UAgentInfo();
	
	@Value("#{server['server.url.user']}")
	public String SHOWPUN_PC_URL;
	@Value("#{server['server.url.mobile']}")
	public String SHOWPUN_MOBILE_URL;
	

	static {
		//PC 에서 들어온 URL을 Mobile로 매핑해서 이동시킬때 사용한다.
		URI_PC_2_MOBILE.put("/myPage/orderHistList.ans", "/myPage/myPageMain.ans");		//마이페이지
		URI_PC_2_MOBILE.put("/cs/selectNotiList.ans", "/mainMenu/noticeList.ans"); 		//고객센터 - 공지 리스트
		URI_PC_2_MOBILE.put("/cs/selectFaqList.ans", "/mainMenu/faqList.ans"); 			//고객센터 - 자주하는 질문
		
		//Mobile 에서 들어온 URL을 PC로 매핑해서 이동시킬때 사용한다.
		URI_MOBILE_2_PC.put("/myPage/myPageMain.ans", "/myPage/orderHistList.ans");		//마이페이지
		URI_MOBILE_2_PC.put("/mainMenu/noticeList.ans", "/cs/selectNotiList.ans");		//고객센터 - 공지 리스트
	}

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		mUAgentInfo.setUAgentInfo(request.getHeader("user-agent"), request.getHeader("accept"));
		
		String reqUri = request.getRequestURI();
		String queryStr = request.getQueryString() == null ? "" : request.getQueryString();
		
		if( StringUtils.indexOf(reqUri, "Ajax") >= 0 ) return true;
		
		System.out.println("isMobilePhone: " + mUAgentInfo.isMobilePhone);
		System.out.println("reqUri : " + reqUri);
		System.out.println("queryStr : " + queryStr);
		
		String moveUri = reqUri;
		
		//PC --> Mobile 로 이동
		if( mUAgentInfo.isMobilePhone ) {
			//맵핑 URI 처리
			if( StringUtils.isNotEmpty(URI_PC_2_MOBILE.get(reqUri)) ) {
				moveUri = URI_PC_2_MOBILE.get(reqUri);
				//Query처리
				if ( StringUtils.isNotEmpty(queryStr ) ) {
					moveUri += "?" + queryStr;
				}
				//이동
				response.sendRedirect(SHOWPUN_MOBILE_URL + moveUri);
				return false;
			}
		} 
		//Mobile --> PC 로 이동
		else {
			//맵핑 URI 처리
			if( StringUtils.isNotEmpty(URI_MOBILE_2_PC.get(reqUri)) ) {
				moveUri = URI_MOBILE_2_PC.get(reqUri);
				//Query처리
				if ( StringUtils.isNotEmpty(queryStr ) ) {
					moveUri += "?" + queryStr;
				}
				//이동
				response.sendRedirect(SHOWPUN_PC_URL + moveUri);
				return false;
			}
		}
					
		return true;
	}
	
}
