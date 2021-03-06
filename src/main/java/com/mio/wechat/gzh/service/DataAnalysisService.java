package com.mio.wechat.gzh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mio.wechat.gzh.bean.analysis.ArticleMethodEnum;
import com.mio.wechat.gzh.bean.analysis.InterMethodEnum;
import com.mio.wechat.gzh.bean.analysis.MsgMethodEnum;
import com.mio.wechat.gzh.bean.analysis.SearchDate;
import com.mio.wechat.gzh.bean.analysis.UserMethodEnum;
import com.mio.wechat.gzh.util.WechatApiUtil;

/*
 * 数据统计分析
 */
@Service
public class DataAnalysisService extends BaseWechatService{

	private static final Logger logger = LoggerFactory.getLogger(DataAnalysisService.class);
	
	@Autowired
	private RestTemplate simpleRestTemplate;
	
	public String  dcUser(String start,String end,UserMethodEnum method){
		String accessToken = this.getAccessToken();
		String url = null;
		if("getusersummary".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_USER_SUMMARY, accessToken);
		}else{
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_USER_CUMULATE, accessToken);
		}
		logger.info("datacube user url: "+url +"start: "+start+"end: "+end+"method:"+method);
		SearchDate searchDate = new SearchDate();
		searchDate.setBeginDate(start);
		searchDate.setEndDate(end);
		String ret = simpleRestTemplate.postForObject(url,searchDate, String.class);
		logger.info("return: "+ret);
		return ret;
	}
	
	public String  dcArticle(String start,String end,ArticleMethodEnum method){
		String accessToken = this.getAccessToken();
		String url = null;
		if("getarticlesummary".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_ARTICLE_SUMMARY, accessToken);
		}else if("getarticletotal".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_ARTICLE_TOTAL, accessToken);
		}else if("getuserread".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_ARTICLE_READE, accessToken);
		}else if("getuserreadhour".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_ARTICLE_READHOUR, accessToken);
		}else if("getusershare".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_ARTICLE_SHARE, accessToken);
		}else{
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_ARTICLE_SHAREHOUR, accessToken);
		}
		
		logger.info("datacube article url: "+url +"start: "+start+"end: "+end);
		SearchDate searchDate = new SearchDate();
		searchDate.setBeginDate(start);
		searchDate.setEndDate(end);
		String ret = simpleRestTemplate.postForObject(url,searchDate, String.class);
		logger.info("return: "+ret);
		return ret;
	}
	
	public String  dcMsg(String start,String end,MsgMethodEnum method){
		String accessToken = this.getAccessToken();
		String url = null;
		if("getupstreammsg".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_UPSTREAM_MSG, accessToken);
		}else if("getupstreammsghour".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_MSG_HOUR, accessToken);
		}else if("getupstreammsgweek".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_MSG_WEEK, accessToken);
		}else if("getupstreammsgmonth".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_MSG_MONTH, accessToken);
		}else if("getupstreammsgdist".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_MSG_DIST, accessToken);
		}else if("getupstreammsgdistweek".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_MSG_DITEWEEK, accessToken);
		}else{
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_MSG_DISTMONTH, accessToken);
		}
		
		logger.info("datacube message url: "+url +"start: "+start+"end: "+end);
		SearchDate searchDate = new SearchDate();
		searchDate.setBeginDate(start);
		searchDate.setEndDate(end);
		String ret = simpleRestTemplate.postForObject(url,searchDate, String.class);
		logger.info("return: "+ret);
		return ret;
	}
	
	public String  dcInter(String start,String end,InterMethodEnum method){
		String accessToken = this.getAccessToken();
		String url = null;
		if("getinterfacesummary".equals(method)){
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_INTER_SUMMARY, accessToken);
		}else{
			 url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DC_INTER_SUMMARYHOUR, accessToken);
		}
		logger.info("datacube interface url: "+url +"start: "+start+"end: "+end);
		SearchDate searchDate = new SearchDate();
		searchDate.setBeginDate(start);
		searchDate.setEndDate(end);
		String ret = simpleRestTemplate.postForObject(url,searchDate, String.class);
		logger.info("return: "+ret);
		return ret;
	}
	

	


	
	
}
