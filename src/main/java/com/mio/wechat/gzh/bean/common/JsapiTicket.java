package com.mio.wechat.gzh.bean.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsapiTicket extends WechatErrorMsg{
	
	private String ticket;
	
	@JsonProperty("expires_in")
	private String expiresIn;


	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	

}
