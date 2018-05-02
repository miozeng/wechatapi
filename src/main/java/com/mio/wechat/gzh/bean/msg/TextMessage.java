package com.mio.wechat.gzh.bean.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 *<xml>
 *   <ToUserName>< ![CDATA[toUser] ]></ToUserName>
 *   <FromUserName>< ![CDATA[fromUser] ]></FromUserName> 
 *   <CreateTime>12345678</CreateTime>
 *   <MsgType>< ![CDATA[text] ]></MsgType> 
 *   <Content>< ![CDATA[你好] ]></Content> 
 *</xml>
 */
public class TextMessage extends BaseWechatMessage {
	/**
	 * 文本消息内容
	 */
	@XStreamAlias("Content")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
