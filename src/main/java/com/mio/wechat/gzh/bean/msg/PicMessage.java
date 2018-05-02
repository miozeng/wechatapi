package com.mio.wechat.gzh.bean.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 发送图片消息
 * <xml>
 * <ToUserName>< ![CDATA[toUser] ]></ToUserName>
 * <FromUserName>< ![CDATA[fromUser] ]></FromUserName>
 * <CreateTime>12345678</CreateTime>
 * <MsgType>< ![CDATA[image] ]></MsgType>
 * <Image><MediaId>< ![CDATA[media_id] ]></MediaId></Image>
 * </xml>
 * @author mio
 *
 */
public class PicMessage extends BaseWechatMessage{
	
	@XStreamAsAttribute//以属性的形式出现
	@XStreamAlias("Image")
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}





	
	
}
