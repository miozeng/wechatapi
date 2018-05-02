package com.mio.wechat.gzh.bean.msg.sendall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mio.wechat.gzh.bean.common.WechatErrorMsg;

public class SendAllReplay extends WechatErrorMsg{
	

	
	@JsonProperty("msg_id")
	private String msgId;
	
	@JsonProperty("msg_data_id")
	private String msgDataId;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgDataId() {
		return msgDataId;
	}

	public void setMsgDataId(String msgDataId) {
		this.msgDataId = msgDataId;
	}



	
	

}
