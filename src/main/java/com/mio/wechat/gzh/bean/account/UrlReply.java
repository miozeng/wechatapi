package com.mio.wechat.gzh.bean.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mio.wechat.gzh.bean.common.WechatErrorMsg;

public class UrlReply extends WechatErrorMsg{


	
	@JsonProperty("short_url")
	private String shortUrl;

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	
}
