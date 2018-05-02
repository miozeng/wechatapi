package com.mio.wechat.gzh.bean.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * <xml>
 * <ToUserName>< ![CDATA[toUser] ]></ToUserName>
 * <FromUserName>< ![CDATA[fromUser] ]></FromUserName>
 * <CreateTime>12345678</CreateTime>
 * <MsgType>< ![CDATA[voice] ]></MsgType>
 * <Voice><MediaId>< ![CDATA[media_id] ]></MediaId></Voice></xml>
 * @author admin
 *
 */
public class VoiceMessage extends BaseWechatMessage{


	@XStreamAsAttribute//以属性的形式出现
	@XStreamAlias("Voice")
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	



	
	





	
}
