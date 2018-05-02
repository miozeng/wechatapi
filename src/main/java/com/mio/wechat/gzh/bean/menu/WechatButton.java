package com.mio.wechat.gzh.bean.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WechatButton implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7219841998146019857L;

	private String name;

	private String type;
	private String key;
	
	@JsonProperty("sub_button")
	private List<WechatButton> subButton = new ArrayList<>();
	
	private String url;
	
	private String appid;
	
	private String pagepath;
	
	@JsonProperty("media_id")
	private String mediaId;

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

	public List<WechatButton> getSubButton() {
		return subButton;
	}

	public void setSubButton(List<WechatButton> subButton) {
		this.subButton = subButton;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}





	
}
