package com.mio.wechat.gzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mio.wechat.gzh.bean.account.ActionNameEnum;
import com.mio.wechat.gzh.bean.account.QrCodeReply;
import com.mio.wechat.gzh.bean.account.UrlAction;
import com.mio.wechat.gzh.bean.account.UrlReply;
import com.mio.wechat.gzh.service.WebchatAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/account", description = "账号管理")
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private WebchatAccountService webchatAccountService;
	
	  @ApiOperation(value = "生成带参数的二维码", notes = "")
	  @GetMapping("/create")
	  @ResponseBody// 
	  public QrCodeReply qrcodeCreate(@ApiParam(value="二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值，")  @RequestParam ActionNameEnum actionName, 
			  @ApiParam(required= false,value="场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，")   @RequestParam(required= false)String sceneStr,
			  @ApiParam(required= false,value="场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）")  @RequestParam(required= false) String sceneId,
			  @ApiParam(required= false,value="该二维码有效时间,以秒为单位。 最大不超过2592000（即30天）") @RequestParam(required= false) Long expireSeconds)   {
		  return webchatAccountService.qrcodeCreate(actionName,sceneStr,sceneId,expireSeconds);
	  }
	  
	  

	  @ApiOperation(value = "长链接转短链接接口", notes = "action	是	此处填long2short，代表长链接转短链接\n\r"
	  		+ "long_url	是	需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url\n\r")
	  @PostMapping("/shortUrl")
	  @ResponseBody
	  public UrlReply shortUrl(@RequestBody UrlAction urlAction) {
		  return webchatAccountService.longtToShort(urlAction);
	  }
	  
}
