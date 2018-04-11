package com.mio.wechat.gzh.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mio.wechat.gzh.bean.msg.TextMessage;
import com.mio.wechat.gzh.util.WechatMessageUtil;

@Service
public class WebchatMsgService extends BaseWechatService {

	private static final Logger logger = LoggerFactory.getLogger(WebchatMsgService.class);
	
	public String processRequest(HttpServletRequest request) {
		Map<String, String> map = WechatMessageUtil.xmlToMap(request);
		logger.info(map.toString());
		// 发送方帐号（一个OpenID）
		String fromUserName = map.get("FromUserName");
		// 开发者微信号
		String toUserName = map.get("ToUserName");
		// 消息类型
		String msgType = map.get("MsgType");
		// 默认回复一个"success"
		String responseMessage = "success";
		// 对消息进行处理
		if (WechatMessageUtil.MESSAGE_TEXT.equals(msgType)) {// 文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(System.currentTimeMillis());
			textMessage.setContent("yes i got U msg");
			responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
		}
		if (WechatMessageUtil.MESSAGE_LOCATION.equals(msgType)) {// 地里位置消息
			TextMessage textMessage = new TextMessage();
			textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(System.currentTimeMillis());
			textMessage.setContent("Location_X："+map.get("Location_X")+"Location_Y："+map.get("Location_Y"));
			responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
		}
		if (WechatMessageUtil.MESSAGE_EVENT.equals(msgType)) {//点击事件
			String eventKey = map.get("EventKey");
			if("clickBtn1".equals(eventKey)){
				
			}else{
				
			}
			TextMessage textMessage = new TextMessage();
			textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(System.currentTimeMillis());
			textMessage.setContent("EventKey:"+map.get("EventKey"));
			responseMessage = WechatMessageUtil.textMessageToXml(textMessage);
		}
		logger.info(responseMessage);
		return responseMessage;

	}
	
}
