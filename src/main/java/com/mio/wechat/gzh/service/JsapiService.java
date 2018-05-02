package com.mio.wechat.gzh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mio.wechat.gzh.bean.common.JsapiTicket;
import com.mio.wechat.gzh.util.WechatApiUtil;

@Service
public class JsapiService extends BaseWechatService{
	
	@Autowired
	private RestTemplate simpleRestTemplate;
	
	public JsapiTicket getJsapiTicket( ) {
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.GET_JSAPI_TICKET, accessToken) ;
		
		return simpleRestTemplate.getForObject(url, JsapiTicket.class);
	}	
	
}
