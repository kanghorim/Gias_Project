package com.loglog.api.config.intercepter;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.loglog.api.commons.constants.Constants;




public class CommonInterceptor extends HandlerInterceptorAdapter   {

	private String VERSION_BUILD_DATE;
	
	public CommonInterceptor(String versionBuildDate) {
		this.VERSION_BUILD_DATE = versionBuildDate;
	}
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	
    	request.getSession().setAttribute(Constants.VER_BUILD_DATE, VERSION_BUILD_DATE);
    	
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
    }
    
}