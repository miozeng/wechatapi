package com.mio.wechat.gzh.bean.msg.sendall;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DelAll {
	
	@JsonProperty("msg_id")
	private String msgId;
	
	@JsonProperty("article_idx")
	private String articleIdx;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getArticleIdx() {
		return articleIdx;
	}

	public void setArticleIdx(String articleIdx) {
		this.articleIdx = articleIdx;
	}
	
	

}
