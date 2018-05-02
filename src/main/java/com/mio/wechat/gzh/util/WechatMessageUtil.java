package com.mio.wechat.gzh.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mio.wechat.gzh.bean.msg.Articles;
import com.mio.wechat.gzh.bean.msg.BaseWechatMessage;
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
import com.thoughtworks.xstream.XStream;

public class WechatMessageUtil {
	// 各种消息类型,除了扫带二维码事件
		/**
		 * 文本消息
		 */
		public static final String MESSAGE_TEXT = "text";
		/**
		 * 图片消息
		 */
		public static final String MESSAtGE_IMAGE = "image";
		/**
		 * 图文消息
		 */
		public static final String MESSAGE_NEWS = "news";
		/**
		 * 语音消息
		 */
		public static final String MESSAGE_VOICE = "voice";
		/**
		 * 视频消息
		 */
		public static final String MESSAGE_VIDEO = "video";
		/**
		 * 小视频消息
		 */
		public static final String MESSAGE_SHORTVIDEO = "shortvideo";
		/**
		 * 视频消息
		 */
		public static final String MESSAGE_MUSIC = "music";
		/**
		 * 地理位置消息
		 */
		public static final String MESSAGE_LOCATION = "location";
		/**
		 * 链接消息
		 */
		public static final String MESSAGE_LINK = "link";
		/**
		 * 事件推送消息
		 */
		public static final String MESSAGE_EVENT = "event";
		/**
		 * 事件推送消息中,事件类型，subscribe(订阅)
		 */
		public static final String MESSAGE_EVENT_SUBSCRIBE = "subscribe";
		/**
		 * 事件推送消息中,事件类型，unsubscribe(取消订阅)
		 */
		public static final String MESSAGE_EVENT_UNSUBSCRIBE = "unsubscribe";
		/**
		 * 事件推送消息中,上报地理位置事件
		 */
		public static final String MESSAGE_EVENT_LOCATION_UP = "LOCATION";
		/**
		 * 事件推送消息中,自定义菜单事件,点击菜单拉取消息时的事件推送
		 */
		public static final String MESSAGE_EVENT_CLICK = "CLICK";
		/**
		 * 事件推送消息中,自定义菜单事件,点击菜单跳转链接时的事件推送
		 */
		public static final String MESSAGE_EVENT_VIEW = "VIEW";
		
		/**
		 * 事件推送消息中,群发结果
		 */
		public static final String MESSAGE_JOB_END_FINISH ="MASSSENDJOBFINISH";

		/**
		 * 将xml转化为Map集合
		 * 
		 * @param request
		 * @return
		 */
		public static Map<String, String> xmlToMap(HttpServletRequest request) {
			Map<String, String> map = new HashMap<String, String>();
			SAXReader reader = new SAXReader();
			InputStream ins = null;
			try {
				ins = request.getInputStream();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Document doc = null;
			try {
				doc = reader.read(ins);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
			Element root = doc.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> list = root.elements();
			for (Element e : list) {
				map.put(e.getName(), e.getText());
			}
			try {
				ins.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return map;
		}
		
		/**
		 * 文本消息转化为xml
		 * 
		 * @param textMessage
		 * @return
		 */
		public static String messageToXml(BaseWechatMessage message) {
			XStream xstream = new XStream();
			xstream.alias("xml", message.getClass());
			if(message instanceof  NewsMessage){
				xstream.alias("item", Articles.class);
			}
			xstream.processAnnotations(message.getClass());
			return xstream.toXML(message);

		}
		
		public static void main(String[] args) {
			TextMessage textMessage = new TextMessage();
			textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
			textMessage.setToUserName("fromUserName");
			textMessage.setFromUserName("toUserName");
			textMessage.setCreateTime(System.currentTimeMillis());
			textMessage.setContent("yes i got U text msg");
			String responseMessage = WechatMessageUtil.messageToXml(textMessage);
			System.out.println(responseMessage);
			
        	PicMessage picMessage = new PicMessage();
        	picMessage.setMsgType(WechatMessageUtil.MESSAtGE_IMAGE);
        	picMessage.setToUserName("fromUserName");
        	picMessage.setFromUserName("toUserName");
        	picMessage.setCreateTime(System.currentTimeMillis());
        	Image image = new Image();
        	image.setMediaId("mediaId");
        	picMessage.setImage(image);
			responseMessage = WechatMessageUtil.messageToXml(picMessage);
			System.out.println(responseMessage);
			
			VoiceMessage voiceMessage = new VoiceMessage();
        	voiceMessage.setMsgType(WechatMessageUtil.MESSAGE_VOICE);
        	voiceMessage.setToUserName("fromUserName");
        	voiceMessage.setFromUserName("toUserName");
        	voiceMessage.setCreateTime(System.currentTimeMillis());
        	Voice voice = new Voice();
        	voice.setMediaId("mediaId");
        	voiceMessage.setVoice(voice);
        	 responseMessage = WechatMessageUtil.messageToXml(voiceMessage);
			System.out.println(responseMessage);
			
			VideoMessage videoMessage = new VideoMessage();
        	videoMessage.setMsgType(WechatMessageUtil.MESSAGE_VIDEO);
        	videoMessage.setToUserName("fromUserName");
        	videoMessage.setFromUserName("toUserName");
			videoMessage.setCreateTime(System.currentTimeMillis());
			Video video =new Video();
			video.setMediaId("mediaId");
			video.setTitle("测试");
			video.setDescription("test send video msg");
			videoMessage.setVideo(video);
			responseMessage = WechatMessageUtil.messageToXml(videoMessage);
			System.out.println(responseMessage);
			
			MusicMessage musicMessage = new MusicMessage();
        	musicMessage.setMsgType(WechatMessageUtil.MESSAGE_MUSIC);
        	musicMessage.setToUserName("fromUserName");
        	musicMessage.setFromUserName("toUserName");
        	musicMessage.setCreateTime(System.currentTimeMillis());
        	Music music = new Music();
        	music.setTitle("音乐");
        	music.setDescription("test send music");
        	music.setMusicURL("http://www.phpos.net/music/xsg.mp3");
        	music.sethQMusicUrl("hQMusicUrl");
        	music.setThumbMediaId("thumbMediaId");
        	musicMessage.setMusic(music);
			responseMessage = WechatMessageUtil.messageToXml(musicMessage);
			System.out.println(responseMessage);
			
			NewsMessage newsMessage = new NewsMessage();
        	newsMessage.setMsgType(WechatMessageUtil.MESSAGE_NEWS);
        	newsMessage.setToUserName("fromUserName");
        	newsMessage.setFromUserName("toUserName");
        	newsMessage.setCreateTime(System.currentTimeMillis());
        	List<Articles> articles = new ArrayList<Articles>();
        	Articles article = new Articles();
        	article.setTitle("test");
        	article.setDescription("这是一个文章");
        	article.setUrl("www.baidu.com");
        	article.setPicUrl("http://thinkshare.duapp.com/images/suzhou.jpg");
        	Articles article2 = new Articles();
        	article2.setTitle("test");
        	article2.setDescription("这是一个文章");
        	article2.setUrl("www.baidu.com");
        	article2.setPicUrl("http://thinkshare.duapp.com/images/suzhou.jpg");
        	articles.add(article);
        	articles.add(article2);
        	newsMessage.setArticleCount(1);
        	newsMessage.setArticles(articles);;
			responseMessage = WechatMessageUtil.messageToXml(newsMessage);
			System.out.println(responseMessage);
		}
}
