package com.mio.wechat.gzh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mio.wechat.gzh.bean.common.ServerIpReply;
import com.mio.wechat.gzh.config.WechatProperties;
import com.mio.wechat.gzh.service.WebchatMsgService;
import com.mio.wechat.gzh.util.Sha1Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "/", description = " 微信接口验证与接入")
@RestController
public class SignatureController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WebchatMsgService webchatMsgService;
	
	@Autowired
	private WechatProperties wechatProperties;
	
	@ApiOperation(value = "微信接入", notes = " 将此方法的url接入到微信接口配置信息里面 ")
	@GetMapping(value = "/wechat")
	@ResponseBody
	public String signature(
			@RequestParam(name = "signature", required = false) String signature,
			@RequestParam(name = "timestamp", required = false) String timestamp,
			@RequestParam(name = "nonce", required = false) String nonce,
			@RequestParam(name = "echostr", required = false) String echostr) {
		this.logger.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature,
				timestamp, nonce, echostr);

		if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
			throw new IllegalArgumentException("请求参数非法，请核实!");
		}
		if( Sha1Util.gen(wechatProperties.getToken(), timestamp, nonce).equals(signature)){
			System.out.println("ok");
			return echostr;
		}
		
//		if (this.wxService.checkSignature(timestamp, nonce, signature)) {
//			return echostr;
//		}

		return "非法请求";

	}
	
	@ApiOperation(value = "微信接入", notes = "用于接收微信事件与消息 ")
	@PostMapping(value = "/wechat")
	@ResponseBody
	public void wechatServicePost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		String responseMessage = webchatMsgService.processRequest(request);

		logger.info(responseMessage);
		PrintWriter out = response.getWriter();

		out.print(responseMessage);

		out.close();
	}
	
	@ApiOperation(value = "获取微信服务器IP地址", notes = "如果公众号基于安全等考虑，需要获知微信服务器的IP地址列表，以便进行相关限制，可以通过该接口获得微信服务器IP地址列表或者IP网段信息。 ")
	@GetMapping(value = "/getWechatIp")
	@ResponseBody
	public ServerIpReply getWechatIp() {
		this.logger.info("获取微信服务器IP地址");

		ServerIpReply ip= webchatMsgService.getServerIp();

		return ip;

	}
	

}
