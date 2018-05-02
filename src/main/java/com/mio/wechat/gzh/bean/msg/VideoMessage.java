package com.mio.wechat.gzh.bean.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * <xml>
 * <ToUserName>< ![CDATA[toUser] ]></ToUserName>
 * <FromUserName>< ![CDATA[fromUser] ]></FromUserName>
 * <CreateTime>12345678</CreateTime>
 * <MsgType>< ![CDATA[video] ]></MsgType>
 * <Video>
 * <MediaId>< ![CDATA[media_id] ]></MediaId>
 * <Title>< ![CDATA[title] ]></Title>
 * <Description>< ![CDATA[description] ]></Description>
 * </Video>
 *  </xml>
 * @author admin
 *
 */
public class VideoMessage extends BaseWechatMessage{

	@XStreamAsAttribute//以属性的形式出现
	@XStreamAlias("Video")
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
}
