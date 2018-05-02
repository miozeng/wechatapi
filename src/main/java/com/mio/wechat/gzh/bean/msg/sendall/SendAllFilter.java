package com.mio.wechat.gzh.bean.msg.sendall;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendAllFilter {
	
	@JsonProperty("is_to_all")
	private boolean isToAll;
	
	@JsonProperty("tag_id")
	private Integer tagId;

	public boolean getIsToAll() {
		return isToAll;
	}

	public void setIsToAll(boolean isToAll) {
		this.isToAll = isToAll;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	
	
	

}
