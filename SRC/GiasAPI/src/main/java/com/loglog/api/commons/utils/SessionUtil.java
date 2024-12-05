//package com.loglog.api.commons.utils;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.loglog.api.commons.beans.UserBean;
//import com.loglog.api.commons.constants.Constants;
//
///**
// * 세션  Util
// * 
// * @author SJG
// */
//public class SessionUtil {
//	
//	/**
//	 * 세션에서 adminBean을 제거한다
//	 */
//	public static void removeAdminBean(HttpServletRequest request){
//		request.getSession().removeAttribute(Constants.SESSION_ADMIN_BEAN);
//	}
//
//	
//	/**
//	 * 세션에서 sellerBean을 제거한다
//	 */
//	public static void removeSellerBean(HttpServletRequest request){
//		request.getSession().removeAttribute(Constants.SESSION_SELLER_BEAN);
//	}
//	
//	/**
//	 * 세션에 userBean을 셋팅한다.
//	 */
//	public static void setUserBean(HttpServletRequest request, UserBean userBean){
//		request.getSession().setAttribute(Constants.SESSION_USER_BEAN, userBean);
//	}
//
//	/**
//	 * 세션에서 userBean을 가져온다.
//	 */
//	public static UserBean getUserBean(HttpServletRequest request){
//		return (UserBean)request.getSession().getAttribute(Constants.SESSION_USER_BEAN);
//	}
//	
//	/**
//	 * 세션에서 userId를 가져온다.
//	 */
//	public static String getUserId(HttpServletRequest request){
//		UserBean userBean = (UserBean)request.getSession().getAttribute(Constants.SESSION_USER_BEAN);
//		String userId = null;
//		if ( userBean != null ){
//			userId = userBean.getUserPhone();
//		}
//		return userId;
//	}
//
//	/**
//	 * 세션에서 userName를 가져온다.
//	 */
//	public static String getUserName(HttpServletRequest request){
//		UserBean userBean = (UserBean)request.getSession().getAttribute(Constants.SESSION_USER_BEAN);
//		String userName = null;
//		if ( userBean != null ){
//			userName = userBean.getUserNm();
//		}
//		return userName;
//	}
//	
//	/**
//	 * 세션에서 userBean을 제거한다
//	 */
//	public static void removeUserBean(HttpServletRequest request){
//		request.getSession().removeAttribute(Constants.SESSION_USER_BEAN);
//	}
//	
//		
//	/**
//	 * 세션에서 orderBean을 제거한다
//	 */
//	public static void removeOrderBean(HttpServletRequest request){
//		request.getSession().removeAttribute(Constants.SESSION_ORDER_BEAN);
//	}
//	
//	///////
//	/**
//	 * 세션에 userBean을 셋팅한다.
//	 */
//	public static void setUpdateFlag(HttpServletRequest request, boolean updateFlag){
//		request.getSession().setAttribute(Constants.UPDATE_FLAG, updateFlag);
//	}
//
//	/**
//	 * 세션에서 userBean을 가져온다.
//	 */
//	public static boolean getUpdateFlag(HttpServletRequest request){
//		Object val = request.getSession().getAttribute(Constants.UPDATE_FLAG);
//		if(val == null) {
//			return false;
//		}
//		return (boolean) val;
//	}
//	
//	/**
//	 * 세션에 공유자 아이디를 셋팅한다. TODO DELETE
//	 */
//	public static void setRecommenderId(HttpServletRequest request, String recommenderId){
//		request.getSession().setAttribute(Constants.SESSION_RECOMMENDER_ID, recommenderId);
//	}
//	
//	/**
//	 * 세션에서 공유자 아이디를 가져온다. TODO DELETE
//	 */
//	public static String getRecommenderId(HttpServletRequest request){
//		return (String)request.getSession().getAttribute(Constants.SESSION_RECOMMENDER_ID);
//	}
//	
//	
//	/**
//	 * 세션에 공유자 Map을 셋팅한다.
//	 */
//	public static void setSnsMap(HttpServletRequest request, Map<String, Object> snsMap){
//		request.getSession().setAttribute(Constants.SESSION_SNS_MAP, snsMap);
//	}
//	
//	/**
//	 * 세션에서 공유자 Map을 가져온다.
//	 */
//	public static Map<String, Object> getSnsMap(HttpServletRequest request){
//		return (Map<String, Object>)request.getSession().getAttribute(Constants.SESSION_SNS_MAP);
//	}
//	
//	/**
//	 * 세션에서 공유자 Map을 제거한다
//	 */
//	public static void removeSnsMap(HttpServletRequest request){
//		request.getSession().removeAttribute(Constants.SESSION_SNS_MAP);
//	}
//	
//}
