package com.mio.wechat.gzh.bean.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WechatButton implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7219841998146019857L;

	private String name;

	private String type;
	private String key;
	private List<WechatButton> sub_button = new ArrayList<>();;
	private String url;
	private String appid;
	private String pagepath;
	private String media_id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

	public List<WechatButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<WechatButton> sub_button) {
		this.sub_button = sub_button;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}




	
}
