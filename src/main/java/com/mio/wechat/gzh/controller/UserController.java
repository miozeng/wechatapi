package com.mio.wechat.gzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mio.wechat.gzh.bean.common.LangEnum;
import com.mio.wechat.gzh.bean.user.UserInfoList;
import com.mio.wechat.gzh.bean.user.UserList;
import com.mio.wechat.gzh.bean.user.WechatUser;
import com.mio.wechat.gzh.service.WechatUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/menu", description = " 用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private WechatUserService wechatUserService;
	
	 @ApiOperation(value = "获取用户列表", notes = "获取帐号的关注者列表，关注者列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。一次拉取调用最多拉取10000")
	@GetMapping("/list")
	@ResponseBody
	public UserList list(@ApiParam(required=false, value="第一个拉取的OPENID，不填默认从头开始拉取")@RequestParam(required=false) String nextOpenid) {
		
		return wechatUserService.getUserList(nextOpenid);

	}
	
	 @ApiOperation(value = "批量获取用户基本信息", notes = "获取用户基本信息。最多支持一次拉取100条。")
	@GetMapping("/batchget")
	@ResponseBody
	public UserInfoList batchget(@ApiParam( value="	用户的标识，对当前公众号唯一,多个用;分割")@RequestParam String openIds) {
		
		return wechatUserService.batchGetUser(openIds);

	}
	
	 @ApiOperation(value = "获取用户基本信息", notes = "开发者可通过OpenID来获取用户基本信息。")
	@GetMapping("/info")
	@ResponseBody
	public WechatUser info(@ApiParam( value="普通用户的标识，对当前公众号唯一")@RequestParam String openId,
			@ApiParam( value="返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语")@RequestParam LangEnum lang) {
		
		return wechatUserService.getUserInfo(openId,lang);

	}
	
	
}
