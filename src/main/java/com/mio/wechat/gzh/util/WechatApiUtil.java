package com.mio.wechat.gzh.util;

import java.util.HashMap;
import java.util.Map;

public class WechatApiUtil {

	public static String GET_ACCESS_TOKEN =  "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	public static String GET_SERVER_IP =  "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
	
	//===========================menu===================================
	public static String MENU_CREATE =  "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	public static String MENU_SEARCH =  "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	public static String MENU_DELETE =  "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	public static String CONDITIONAL_MENU_ADD =  "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
		
	public static String CONDITIONAL_MENU_DELETE =  "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
	
	public static String CONDITIONAL_MENU_MATCH =  "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";
	
	public static String MENU_INFO =  "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";
	
	
	//======jsdk=====
	public static String GET_JSAPI_TICKET =  "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	//========material================
	
	public static String ADD_MATERICAL =  "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
	
	public static String BATCHGET_MATERICAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	
	//=======================send all======================
	
	public static String MSG_SEND_ALL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
	
	public static String UPLOAD_IMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	
	public static String UPLOAD_NEWS = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
	
	public static String DEL_MSG_ALL = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";
	
	public static String PREVIEW_MSG_ALL ="https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
	
	//==========user=========================
	
	public static String GET_USER_LIST = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
	
	public static String GET_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=LANG";
	
	public static String BATCHGET_USER = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
	
	//======analysis=========
	public static String DC_USER_SUMMARY = "https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN";
	
	public static String DC_USER_CUMULATE = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN";
	
	public static String DC_ARTICLE_SUMMARY = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN";
	
	public static String DC_ARTICLE_TOTAL = "	https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN";
	
	public static String DC_ARTICLE_READE = "	https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN";
	
	public static String DC_ARTICLE_READHOUR = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=ACCESS_TOKEN";
	
	public static String DC_ARTICLE_SHARE = "https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN";
	
	public static String DC_ARTICLE_SHAREHOUR = "https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN";
	
	public static String DC_UPSTREAM_MSG = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN";
	
	public static String DC_MSG_HOUR = "https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=ACCESS_TOKEN";
	
	public static String DC_MSG_WEEK = "https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN";
	
	public static String DC_MSG_MONTH = "https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN";
	
	public static String DC_MSG_DIST = "https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=ACCESS_TOKEN";
	
	public static String DC_MSG_DITEWEEK = "https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN";
	
	public static String DC_MSG_DISTMONTH = "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN";
	
	public static String DC_INTER_SUMMARY = "https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=ACCESS_TOKEN";
	
	public static String DC_INTER_SUMMARYHOUR = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=ACCESS_TOKEN";
	
	//==========AI===========================
	public static String AI_ADD_VOICE = "http://api.weixin.qq.com/cgi-bin/media/voice/addvoicetorecofortext?access_token=ACCESS_TOKEN&format=mp3&voice_id=VOICE_ID&lang=LANG";
	
	public static String AI_QUERY_VOICE = "http://api.weixin.qq.com/cgi-bin/media/voice/queryrecoresultfortext?access_token=ACCESS_TOKEN&voice_id=VOICE_ID&lang=zh_CN";
	
	public static String AI_TRANSLATE_CONTENT = "http://api.weixin.qq.com/cgi-bin/media/voice/translatecontent?access_token=ACCESS_TOKEN&lfrom=LFROM&lto=LTO";
	
	public static String AI_SEMANTIC = "https://api.weixin.qq.com/semantic/semproxy/search?access_token=ACCESS_TOKEN";
	
	//================Account ==========================
	public static String QR_CODE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	
	public static String SHOW_QR_CODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	
	public static String SHORT_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
	//=====================shake==============================
	public static String SHAKE_REGISTER = "https://api.weixin.qq.com/shakearound/account/register?access_token=ACCESS_TOKEN";
	
	
	public static String ACCESS_TOKEN = "";
	
	public static Map<String, String> RET = new HashMap<String, String>();
	
	public static String repleaceAccessToken(String url,String accessToken){
		String nurl = url.replace("ACCESS_TOKEN", accessToken);
		return nurl;
	}
	
}
