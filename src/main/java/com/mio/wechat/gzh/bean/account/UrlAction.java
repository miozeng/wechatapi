package com.mio.wechat.gzh.bean.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlAction {

	private String action;
	
	@JsonProperty("long_url")
	private String longUrl;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	
	
}
