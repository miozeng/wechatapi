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

import com.mio.wechat.gzh.config.WechatProperties;
import com.mio.wechat.gzh.service.WebchatMsgService;
import com.mio.wechat.gzh.util.Sha1Util;


@RestController
public class SignatureController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WebchatMsgService webchatMsgService;
	
	@Autowired
	private WechatProperties wechatProperties;
	
	@GetMapping(value = "/portal")
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
	

	@PostMapping(value = "/portal")
	@ResponseBody
	public void wechatServicePost( PrintWriter out, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String responseMessage = webchatMsgService.processRequest(request);
		response.setCharacterEncoding("utf-8");
		out.print(responseMessage);
		out.flush();
	}
	

}
