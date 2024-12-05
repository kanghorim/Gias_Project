package com.loglog.api.config.intercepter;
 
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.loglog.api.commons.constants.Constants;
import com.loglog.api.commons.utils.JwtTokenHelper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.micrometer.core.instrument.util.StringUtils;

public class TokenCheckInterceptor extends HandlerInterceptorAdapter   {
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	//return true;
    	//정상적인 토큰인지를 체크한다.
    	response.setContentType("application/json; charset=UTF-8");
        
        String result = "";
        String resultMsg = "";
        String authToken = "";
        
        String REQUEST_URL = request.getRequestURI();
        //String hostName = request.getHeader("Host");
        System.out.println(REQUEST_URL);
        
        if(REQUEST_URL.equals("/error")) {
        	result = Constants.FAIL;
            resultMsg = "요청에 실패하였습니다.";
        } else if(/**hostName.equals("/error") && */REQUEST_URL.equals("/main/requestSellerAjax")) {
        	result = Constants.OK;
        } else {
        	result = Constants.FAIL;
            resultMsg = "유효하지 않은 토큰 입니다.";
    		authToken = request.getHeader(HttpHeaders.AUTHORIZATION);
    		
    		if(StringUtils.isNotBlank(authToken)) {
    			authToken = authToken.replace("Bearer ", "");
        		
        		System.out.println("TokenCheckInterceptor - 조회된 token: " + authToken);

        		if( StringUtils.isNotEmpty(authToken) ) {
        			try {
        				Claims claims = JwtTokenHelper.parseClaims(authToken).getBody();
        	    		String id = claims.getId();
        	    		String issuer = claims.getIssuer();
        	    		String subject = claims.getSubject();
        	    		Date expiration = claims.getExpiration();
        	    		
        	    		System.out.println("ID: " + id);
        	    		System.out.println("Issuer: " + issuer);
        	    		System.out.println("Subject: " + subject);
        	    		System.out.println("Expiration: " + expiration);
        	    		
        				result = Constants.OK;
        				resultMsg = "유효한 토큰 입니다.";					
        			} catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
        				System.out.println(ex.getMessage());
        				resultMsg = "토큰형식이 유효하지 않습니다.";
        			} catch (ExpiredJwtException expiredEx) {
        				System.out.println(expiredEx.getMessage());
        				resultMsg = "유효기간이 만료된 토큰 입니다.";
        			}
        		}
    		}
        }
        
        if(result.equals(Constants.OK)) {
        	return true;
        } else {
        	PrintWriter writer = response.getWriter();
        	
        	String jsonMsg = "{\"" + Constants.RESULT + "\" : \"" + result + "\", \"" + Constants.RESULT_MSG + "\" : \"" + resultMsg + "\" , \"" + Constants.AUTH_TOKEN + "\" : \"" + authToken + "\"}";
        	response.sendError(401, jsonMsg);
            writer.write(jsonMsg); 
            writer.flush();
            writer.close();
            return false;
        }
		
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
    }
    
}