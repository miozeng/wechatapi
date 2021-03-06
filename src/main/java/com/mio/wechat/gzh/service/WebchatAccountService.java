package com.mio.wechat.gzh.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mio.wechat.gzh.bean.account.ActionInfo;
import com.mio.wechat.gzh.bean.account.ActionNameEnum;
import com.mio.wechat.gzh.bean.account.QrCodeInput;
import com.mio.wechat.gzh.bean.account.QrCodeReply;
import com.mio.wechat.gzh.bean.account.UrlAction;
import com.mio.wechat.gzh.bean.account.UrlReply;
import com.mio.wechat.gzh.util.WechatApiUtil;

@Service
public class WebchatAccountService  extends BaseWechatService{

	private static final Logger logger = LoggerFactory.getLogger(WebchatAccountService.class);
	
	public QrCodeReply qrcodeCreate(ActionNameEnum actionName, String sceneStr, String sceneId,Long expireSeconds){
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.QR_CODE, accessToken);
		logger.info(" qrcode Create url:"+url+"   actionName:"+actionName+"    sceneStr:"+sceneStr+"     sceneId:"+sceneId +"  expireSeconds:"+expireSeconds);
		QrCodeInput code = new QrCodeInput();
		code.setActionName(actionName);
		ActionInfo info = new ActionInfo();
		Map<String,Object> map = new HashMap<>();
		if(!StringUtils.isEmpty(sceneStr)){
			map.put("scene_str", sceneStr);
		}else{
			map.put("scene_id", sceneId);
		}
		if(expireSeconds != null){
			code.setExpireSeconds(expireSeconds.toString());
		}
		
		info.setScene(map);
		code.setActionInfo(info);
		QrCodeReply  reply = simpleRestTemplate.postForObject(url, code, QrCodeReply.class);
		return reply;
	}
	
	public UrlReply longtToShort(UrlAction urlAction){
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.SHORT_URL, accessToken);
		logger.info(" url longtToShort url:   "+url);
		UrlReply  reply = simpleRestTemplate.postForObject(url, urlAction, UrlReply.class);
		return reply;
	}
}
