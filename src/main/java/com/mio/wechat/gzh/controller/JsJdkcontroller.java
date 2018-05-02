package com.mio.wechat.gzh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mio.wechat.gzh.bean.common.JsapiTicket;
import com.mio.wechat.gzh.config.WechatProperties;
import com.mio.wechat.gzh.service.JsapiService;
import com.mio.wechat.gzh.util.SignUtil;
import com.mio.wechat.gzh.util.WechatApiUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/jsapi", description = "微信网页开发")
@RestController
@RequestMapping("/jsapi")
public class JsJdkcontroller {
	
	@Autowired
	private JsapiService jsapiService;
	
	@Autowired
	private WechatProperties wechatProperties;
	
	@ApiOperation(value = "jssdk config 所需要的签名等信息", notes = " 获取jssdk签名锁需要的信息，请在配置文件中配置wechat.mp.jsurl为“公众号设置”的“功能设置”里填写的“JS接口安全域名” ")
	@GetMapping(value = "/init")
	@ResponseBody
	public Map<String, String> init() {
		JsapiTicket jsapi = jsapiService.getJsapiTicket();
		String jsapi_ticket = jsapi.getTicket();
	    String url = wechatProperties.getJsurl();
		Map<String, String> ret = WechatApiUtil.RET;
		if(ret.get("url") == null){
			ret = SignUtil.sign(jsapi_ticket, url);
			ret.put("appId", wechatProperties.getAppId());
		}
		return ret;
	}
}
