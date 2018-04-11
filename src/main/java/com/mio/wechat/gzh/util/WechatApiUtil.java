package com.mio.wechat.gzh.util;

import java.util.HashMap;
import java.util.Map;

public class WechatApiUtil {

	public static String GET_ACCESS_TOKEN =  "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	public static String MENU_CREATE =  "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	public static String MENU_SEARCH =  "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	public static String MENU_DELETE =  "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	public static String CONDITIONAL_MENU_ADD =  "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
		
	public static String CONDITIONAL_MENU_DELETE =  "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
	
	public static String CONDITIONAL_MENU_MATCH =  "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";
	
	public static String GET_JSAPI_TICKET =  "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	public static String ACCESS_TOKEN = "";
	
	public static Map<String, String> RET = new HashMap<String, String>();
	
	public static String repleaceAccessToken(String url,String accessToken){
		String nurl = url.replace("ACCESS_TOKEN", accessToken);
		return nurl;
	}
	
}
