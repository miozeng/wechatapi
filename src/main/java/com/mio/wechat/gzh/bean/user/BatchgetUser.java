package com.mio.wechat.gzh.bean.user;

public class BatchgetUser {
	
	private String openid;
	
	private String lang;
	
	

	public BatchgetUser() {
		super();
	}

	public BatchgetUser(String openid ) {
		super();
		this.openid = openid;
		this.lang = "zh_CN";
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
	

}
