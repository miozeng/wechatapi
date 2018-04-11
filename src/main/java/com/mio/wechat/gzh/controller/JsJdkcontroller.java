package com.mio.wechat.gzh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mio.wechat.gzh.bean.token.JsapiTicket;
import com.mio.wechat.gzh.config.WechatProperties;
import com.mio.wechat.gzh.service.JsapiService;
import com.mio.wechat.gzh.util.SignUtil;
import com.mio.wechat.gzh.util.WechatApiUtil;

@RestController
@RequestMapping("/jsapi")
public class JsJdkcontroller {
	
	@Autowired
	private JsapiService jsapiService;
	
	@Autowired
	private WechatProperties wechatProperties;
	
	@GetMapping(value = "/init")
	@ResponseBody
	public Map<String, String> init() {
		JsapiTicket jsapi = jsapiService.getJsapiTicket();
		String jsapi_ticket = jsapi.getTicket();
	    String url = "http://rrxgiv.natappfree.cc/main.html";
		Map<String, String> ret = WechatApiUtil.RET;
		if(ret.get("url") == null){
			ret = SignUtil.sign(jsapi_ticket, url);
			ret.put("appId", wechatProperties.getAppId());
		}
		return ret;
	}
}
