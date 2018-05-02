package com.mio.wechat.gzh.bean.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mio.wechat.gzh.bean.common.WechatErrorMsg;

public class UserInfoList extends WechatErrorMsg{
	
	@JsonProperty("user_info_list")
	private List<WechatUser> userInfoList;

	public List<WechatUser> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<WechatUser> userInfoList) {
		this.userInfoList = userInfoList;
	}
	
	

}
