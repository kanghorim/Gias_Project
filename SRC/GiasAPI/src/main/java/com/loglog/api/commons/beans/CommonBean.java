package com.loglog.api.commons.beans;

import java.io.Serializable;

/**
 * 공통 Bean
 * 
 * @author SJG
 */
public class CommonBean implements Serializable {

	/** 토큰 **/
	private String authToken;
	/** 생성날짜 **/
	private String regDt;
	/** 수정날짜 **/
	private String updDt;
	/** 로그인 후 이동할 URL */
	private String resultUrl;
	/** BASE Img URL */
	private String baseImgUrl;
	
	/** BASE Img URL2 */
	private String baseImgUrl2;
	
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getUpdDt() {
		return updDt;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	public String getResultUrl() {
		return resultUrl;
	}
	public void setResultUrl(String resultUrl) {
		this.resultUrl = resultUrl;
	}
	public String getBaseImgUrl() {
		return baseImgUrl;
	}
	public void setBaseImgUrl(String baseImgUrl) {
		this.baseImgUrl = baseImgUrl;
	}
	public String getBaseImgUrl2() {
		return baseImgUrl2;
	}
	public void setBaseImgUrl2(String baseImgUrl2) {
		this.baseImgUrl2 = baseImgUrl2;
	}
	
	
}
