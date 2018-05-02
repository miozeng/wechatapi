package com.mio.wechat.gzh.bean.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserList {

	private String total;
	
	private String count;
	
	private UserListData data;
	
	@JsonProperty("next_openid")
	private String nextOpenid;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public UserListData getData() {
		return data;
	}

	public void setData(UserListData data) {
		this.data = data;
	}

	public String getNextOpenid() {
		return nextOpenid;
	}

	public void setNextOpenid(String nextOpenid) {
		this.nextOpenid = nextOpenid;
	}
	
	
}
