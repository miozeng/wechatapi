package com.mio.wechat.gzh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mio.wechat.gzh.bean.common.WechatToken;
import com.mio.wechat.gzh.config.WechatProperties;
import com.mio.wechat.gzh.util.WechatApiUtil;


@Service
public class BaseWechatService {

	private static final Logger logger = LoggerFactory.getLogger(BaseWechatService.class);

	
	@Autowired
	public RestTemplate simpleRestTemplate;
	
	@Autowired
	public WechatProperties wechatProperties;
	
	public String getAccessToken() {
		String accessToken = WechatApiUtil.ACCESS_TOKEN;
		if(!"".equals(accessToken) && accessToken != null){
			logger.info(" ACCESS_TOKEN {} is exist;",accessToken);
			return accessToken;
		}
		WechatToken token = null;
		String token_url = WechatApiUtil.GET_ACCESS_TOKEN;
		token_url = token_url.replace("APPID", wechatProperties.getAppId());
		token_url = token_url.replace("APPSECRET", wechatProperties.getSecret());
		logger.info("get ACCESS_TOKEN APPID={} APPSECRET={}",wechatProperties.getAppId(),wechatProperties.getSecret());
		token = simpleRestTemplate.getForObject(token_url, WechatToken.class);
		WechatApiUtil.ACCESS_TOKEN = token.getAccess_token();
		return token.getAccess_token();
	}
	

}
