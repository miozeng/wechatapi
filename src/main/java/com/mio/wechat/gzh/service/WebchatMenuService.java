package com.mio.wechat.gzh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mio.wechat.gzh.bean.menu.WechatSearchMenu;
import com.mio.wechat.gzh.bean.token.WechatRetMsg;
import com.mio.wechat.gzh.util.WechatApiUtil;

@Service
public class WebchatMenuService extends BaseWechatService{

	private static final Logger logger = LoggerFactory.getLogger(WebchatMsgService.class);
	

	@Autowired
	private RestTemplate simpleRestTemplate;
	
	public WechatRetMsg createMenu( Object menu) {
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.MENU_CREATE, accessToken) ;
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded; charset=UTF-8");
		headers.setContentType(type);
		System.out.println(type);
		HttpEntity<String> requestEntity = new HttpEntity<String>(menu.toString(),  headers);
		
		
		return simpleRestTemplate.postForObject(url, requestEntity, WechatRetMsg.class);
	}
	
	public WechatRetMsg delMenu( ) {
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.MENU_DELETE, accessToken) ;
		
		return simpleRestTemplate.getForObject(url, WechatRetMsg.class);
	}	
	
	public WechatSearchMenu searchMenu( ) {
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.MENU_SEARCH, accessToken) ;
		
		return simpleRestTemplate.getForObject(url, WechatSearchMenu.class);
	}
}
