package com.mio.wechat.gzh.bean.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BatchUserList {
	
	@JsonProperty("user_list")
	private List<BatchgetUser> userList;

	public List<BatchgetUser> getUserList() {
		return userList;
	}

	public void setUserList(List<BatchgetUser> userList) {
		this.userList = userList;
	}
	
	

}
