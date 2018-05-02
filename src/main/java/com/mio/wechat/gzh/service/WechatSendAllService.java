package com.mio.wechat.gzh.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.mio.wechat.gzh.bean.common.WechatErrorMsg;
import com.mio.wechat.gzh.bean.msg.sendall.DelAll;
import com.mio.wechat.gzh.bean.msg.sendall.MsgTypeEnum;
import com.mio.wechat.gzh.bean.msg.sendall.SendAllArticle;
import com.mio.wechat.gzh.bean.msg.sendall.SendAllFilter;
import com.mio.wechat.gzh.bean.msg.sendall.SendAllReplay;
import com.mio.wechat.gzh.util.WechatApiUtil;

/**
 * 群发接口
 * @author admin
 *
 */
@Service
public class WechatSendAllService extends BaseWechatService{

	private static final Logger logger = LoggerFactory.getLogger(WechatSendAllService.class);
	@Autowired
	private RestTemplate simpleRestTemplate;
	
	public SendAllReplay  sendAllText(String content,String mediaId,Integer sendIgnoreReprint,MsgTypeEnum type,SendAllFilter filter){
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.MSG_SEND_ALL, accessToken);
		logger.info("url:"+url+"      content:"+content+"      mediaId:"
		+mediaId+"      sendIgnoreReprint:"+sendIgnoreReprint+"      type:"+type);
		Map<String,Object> msgmap = new HashMap<String, Object>();
		msgmap.put("filter", filter);
		msgmap.put("msgtype", type.toString());
		Map<String,String> map = new HashMap<String, String>();
		if(type.equals(MsgTypeEnum.mpnews)){
			map.put("media_id",mediaId);
			msgmap.put("send_ignore_reprint",sendIgnoreReprint);
		}else if(type.equals(MsgTypeEnum.text)){
			map.put("content",content);
		}else if(type.equals(MsgTypeEnum.wxcard)){
			map.put("card_id",mediaId);
		}else {
			map.put("media_id",mediaId);
		}
		msgmap.put(type.toString(), map);
		
		SendAllReplay ret = simpleRestTemplate.postForObject(url,msgmap, SendAllReplay.class);
		return ret;
	}
	
	
	public String uploadImg(MultipartFile file) throws IllegalStateException, IOException {
		//获取url
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.UPLOAD_IMG, accessToken) ;
		logger.info("url:"+url);
		//修改header
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("multipart/form-data");
		headers.setContentType(type);
		String cd = "filename=\"" + file.getOriginalFilename() + "\"";
		headers.add("Content-Disposition", cd);

		//生成临时文件读取文件
		String proClassPath = this.getClass().getResource("").getPath();
		String tempFileName = UUID.randomUUID() + file.getOriginalFilename();
		String tempFilePath = proClassPath + tempFileName;
		File tempFile = new File(tempFilePath);
		file.transferTo(tempFile);

		FileSystemResource resource = new FileSystemResource(tempFile);
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		param.add("media", resource);
	
		
		String  replay = simpleRestTemplate.postForObject(url, param, String.class);
		
		logger.info("return:"+replay);
		
		try {
	        tempFile.delete();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		return replay;
	}
	
	public String  uploadNews(List<SendAllArticle> articles){
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.UPLOAD_NEWS, accessToken);
		logger.info("url:"+url);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("articles",articles);
		
		String ret = simpleRestTemplate.postForObject(url,map, String.class);
		return ret;
	}

	
	public WechatErrorMsg  deleteAll(DelAll delAll){
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.DEL_MSG_ALL, accessToken);
		logger.info("url:"+url);
		
		WechatErrorMsg ret = simpleRestTemplate.postForObject(url,delAll, WechatErrorMsg.class);
		return ret;
	}
	
	public String  preview(String content,String mediaId,String cardExt,MsgTypeEnum type,String touser){
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.PREVIEW_MSG_ALL, accessToken);
		logger.info("url:"+url+"      content:"+content+"      mediaId:"
		+mediaId+"      cardExt:"+cardExt+"      type:"+type+"      touser:"+touser);
		Map<String,Object> msgmap = new HashMap<String, Object>();
		msgmap.put("touser", touser);
		msgmap.put("msgtype", type.toString());
		Map<String,String> map = new HashMap<String, String>();
		if(type.equals(MsgTypeEnum.text)){
			map.put("content",content);
		}else if(type.equals(MsgTypeEnum.wxcard)){
			map.put("card_id",mediaId);
			map.put("card_ext",cardExt);
		}else {
			map.put("media_id",mediaId);
		}
		msgmap.put(type.toString(), map);
		
		String ret = simpleRestTemplate.postForObject(url,msgmap, String.class);
		return ret;
	}
}
