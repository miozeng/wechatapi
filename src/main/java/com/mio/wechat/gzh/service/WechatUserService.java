package com.mio.wechat.gzh.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.mio.wechat.gzh.bean.common.LangEnum;
import com.mio.wechat.gzh.bean.user.BatchgetUser;
import com.mio.wechat.gzh.bean.user.UserInfoList;
import com.mio.wechat.gzh.bean.user.UserList;
import com.mio.wechat.gzh.bean.user.WechatUser;
import com.mio.wechat.gzh.util.WechatApiUtil;

/**
 * 用户管理
 * @author admin
 *
 */
@Service
public class WechatUserService extends BaseWechatService{

	private static final Logger logger = LoggerFactory.getLogger(WechatUserService.class);
	@Autowired
	private RestTemplate simpleRestTemplate;
	
	public WechatUser  getUserInfo(String openId,LangEnum lang){
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.GET_USER_INFO, accessToken) ;
		url = url.replace("OPENID", openId);
		url = url.replace("LANG", lang.toString());
		logger.info("url:"+url);
		WechatUser user =  simpleRestTemplate.getForObject(url, WechatUser.class);
		return user;
	}

	public UserInfoList  batchGetUser(String openIds){
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.BATCHGET_USER, accessToken) ;
		List<BatchgetUser> users = new ArrayList<BatchgetUser>();
		String[] ids = openIds.split(";");
		for (String id : ids) {
			BatchgetUser user = new BatchgetUser(id);
			users.add(user);
		}
		logger.info("url:"+url+"   openIds:"+openIds);
		UserInfoList ret = simpleRestTemplate.postForObject(url,users, UserInfoList.class);
	
		logger.info(ret.toString());
		return ret;
	}
	
	public UserList  getUserList(String nextOpenid){
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.GET_USER_LIST, accessToken) ;
		if(StringUtils.isEmpty(nextOpenid)){
			url = url.replace("NEXT_OPENID", "");
		}else{
			url = url.replace("NEXT_OPENID", nextOpenid);
		}
		logger.info("url:"+url);
		UserList ret = simpleRestTemplate.getForObject(url, UserList.class);
		logger.info(ret.toString());
		return ret;
	}

}
