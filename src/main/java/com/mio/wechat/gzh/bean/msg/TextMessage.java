package com.mio.wechat.gzh.bean.msg;

public class TextMessage extends BaseWechatMessage {
	/**
	 * 文本消息内容
	 */
	private String Content;
	
	public String getContent() {
		return Content;
	}
	
	public void setContent(String content) {
		Content = content;
	}
}
