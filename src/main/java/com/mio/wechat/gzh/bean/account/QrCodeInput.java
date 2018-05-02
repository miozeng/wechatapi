package com.mio.wechat.gzh.bean.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QrCodeInput {

	@JsonProperty("expire_seconds")
	private String expireSeconds;
	
	@JsonProperty("action_name")
	private ActionNameEnum actionName;
	
	@JsonProperty("action_info")
	private ActionInfo actionInfo;

	public String getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(String expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public ActionNameEnum getActionName() {
		return actionName;
	}

	public void setActionName(ActionNameEnum actionName) {
		this.actionName = actionName;
	}

	public ActionInfo getActionInfo() {
		return actionInfo;
	}

	public void setActionInfo(ActionInfo actionInfo) {
		this.actionInfo = actionInfo;
	}
	
	
	
	
}
