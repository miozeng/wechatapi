package com.mio.wechat.gzh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mio.wechat.gzh.bean.common.ServerIpReply;
import com.mio.wechat.gzh.bean.msg.Articles;
import com.mio.wechat.gzh.bean.msg.Image;
import com.mio.wechat.gzh.bean.msg.Music;
import com.mio.wechat.gzh.bean.msg.MusicMessage;
import com.mio.wechat.gzh.bean.msg.NewsMessage;
import com.mio.wechat.gzh.bean.msg.PicMessage;
import com.mio.wechat.gzh.bean.msg.TextMessage;
import com.mio.wechat.gzh.bean.msg.Video;
import com.mio.wechat.gzh.bean.msg.VideoMessage;
import com.mio.wechat.gzh.bean.msg.Voice;
import com.mio.wechat.gzh.bean.msg.VoiceMessage;
import com.mio.wechat.gzh.util.WechatApiUtil;
import com.mio.wechat.gzh.util.WechatMessageUtil;

@Service
public class WebchatMsgService extends AbstractMsgService{
	
	private static final Logger logger = LoggerFactory.getLogger(WebchatMsgService.class);
	
	@Override
	public String textMsg(Map<String, String> map) {
		String fromUserName = map.get("FromUserName");
		String toUserName = map.get("ToUserName");
		String content = map.get("Content");
		if("音乐".equals(content)){
			MusicMessage musicMessage = new MusicMessage();
	    	musicMessage.setMsgType(WechatMessageUtil.MESSAGE_MUSIC);
	    	musicMessage.setToUserName(fromUserName);
	    	musicMessage.setFromUserName(toUserName);
	    	musicMessage.setCreateTime(System.currentTimeMillis());
	    	Music music = new Music();
	    	music.setTitle("音乐");
	    	music.setDescription("eeeee");
	    	music.setMusicURL("http://sc1.111ttt.cn:8282/2018/1/03m/13/396131232171.m4a?tflag=1519095601&pin=6cd414115fdb9a950d827487b16b5f97#.mp3");
	    	music.sethQMusicUrl("http://sc1.111ttt.cn:8282/2018/1/03m/13/396131232171.m4a?tflag=1519095601&pin=6cd414115fdb9a950d827487b16b5f97#.mp3");
	    	music.setThumbMediaId("wjrYVzN9Wq_WlGEDpWBkkFsXNrYMtAMwzIfVCnIUnNI");
	    	musicMessage.setMusic(music);
	    	return WechatMessageUtil.messageToXml(musicMessage);
		}else{
			TextMessage textMessage = new TextMessage();
			textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(System.currentTimeMillis());
			textMessage.setContent("yes i got U text msg");
			return  WechatMessageUtil.messageToXml(textMessage);
		}
	
	}

	@Override
	public String voiceMsg(Map<String, String> map) {
		String fromUserName = map.get("FromUserName");
		String toUserName = map.get("ToUserName");
		String mediaId = map.get("MediaId");
    	VoiceMessage voiceMessage = new VoiceMessage();
    	voiceMessage.setMsgType(WechatMessageUtil.MESSAGE_VOICE);
    	voiceMessage.setToUserName(fromUserName);
    	voiceMessage.setFromUserName(toUserName);
    	voiceMessage.setCreateTime(System.currentTimeMillis());
    	Voice voice = new Voice();
    	voice.setMediaId(mediaId);
    	voiceMessage.setVoice(voice);
    	return WechatMessageUtil.messageToXml(voiceMessage);
	}

	@Override
	public String imageMsg(Map<String, String> map) {
		String fromUserName = map.get("FromUserName");
		String toUserName = map.get("ToUserName");
		String mediaId = map.get("MediaId");
    	PicMessage picMessage = new PicMessage();
    	picMessage.setMsgType(WechatMessageUtil.MESSAtGE_IMAGE);
    	picMessage.setToUserName(fromUserName);
    	picMessage.setFromUserName(toUserName);
    	picMessage.setCreateTime(System.currentTimeMillis());
    	Image image = new Image();
    	image.setMediaId(mediaId);
    	picMessage.setImage(image);
    	return WechatMessageUtil.messageToXml(picMessage);
	}


	@Override
	public String vedioMsg(Map<String, String> map) {//回复视频，失败中
		String fromUserName = map.get("FromUserName");
		String toUserName = map.get("ToUserName");
		String mediaId = map.get("MediaId");
    	VideoMessage videoMessage = new VideoMessage();
    	videoMessage.setMsgType(WechatMessageUtil.MESSAGE_VIDEO);
    	videoMessage.setToUserName(fromUserName);
    	videoMessage.setFromUserName(toUserName);
		videoMessage.setCreateTime(System.currentTimeMillis());
		Video video =new Video();
		video.setMediaId(mediaId);
		video.setTitle("测试");
		video.setDescription("test send video msg");
		videoMessage.setVideo(video);
		return WechatMessageUtil.messageToXml(videoMessage);
	}

	@Override
	public String locationMsg(Map<String, String> map) {//回复音乐
		String fromUserName = map.get("FromUserName");
		String toUserName = map.get("ToUserName");
		MusicMessage musicMessage = new MusicMessage();
    	musicMessage.setMsgType(WechatMessageUtil.MESSAGE_MUSIC);
    	musicMessage.setToUserName(fromUserName);
    	musicMessage.setFromUserName(toUserName);
    	musicMessage.setCreateTime(System.currentTimeMillis());
    	Music music = new Music();
    	music.setTitle("音乐");
    	music.setDescription("Location_X："+map.get("Location_X")+"Location_Y："+map.get("Location_Y"));
    	music.setMusicURL("http://www.phpos.net/music/xsg.mp3");
    	music.sethQMusicUrl("http://www.phpos.net/music/xsg.mp3");
    	music.setThumbMediaId("wjrYVzN9Wq_WlGEDpWBkkFsXNrYMtAMwzIfVCnIUnNI");
    	musicMessage.setMusic(music);
    	return WechatMessageUtil.messageToXml(musicMessage);
	}


	@Override
	public String clickEvent(Map<String, String> map) {
		String fromUserName = map.get("FromUserName");
		String toUserName = map.get("ToUserName");
		String eventKey = map.get("EventKey");
		if("clickBtn1".equals(eventKey)){// 图文消息
			NewsMessage newsMessage = new NewsMessage();
        	newsMessage.setMsgType(WechatMessageUtil.MESSAGE_NEWS);
        	newsMessage.setToUserName(fromUserName);
        	newsMessage.setFromUserName(toUserName);
        	newsMessage.setCreateTime(System.currentTimeMillis());
        	List<Articles> articles = new ArrayList<Articles>();
        	Articles article = new Articles();
        	article.setTitle("test");
        	article.setDescription("这是一个文章");
        	article.setUrl("www.baidu.com");
        	article.setPicUrl("https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=d757200dc4fcc3cea0cdc161f32cbded/279759ee3d6d55fb22bcda0961224f4a20a4dda3.jpg");
        	articles.add(article);
        	newsMessage.setArticleCount(1);
        	newsMessage.setArticles(articles);;
        	return WechatMessageUtil.messageToXml(newsMessage);
		}
		return null;
	}

	@Override
	public String locationEvent(Map<String, String> map) {
		String msgType= map.get("MsgType");
		String event= map.get("Event");
		String latitude= map.get("Latitude");
		String longitude= map.get("Longitude");
		String precision= map.get("Precision");
		logger.info("get user location MsgType:{}  Event:{}  Latitude:{}  Longitude:{} Precision:{}",
				msgType,event,latitude,longitude,precision);
		return null;
	}
	
	public ServerIpReply getServerIp(){
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.GET_SERVER_IP, accessToken) ;
		return simpleRestTemplate.getForObject(url, ServerIpReply.class);
	}


}
