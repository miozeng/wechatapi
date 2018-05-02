package com.mio.wechat.gzh.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mio.wechat.gzh.bean.common.WechatErrorMsg;
import com.mio.wechat.gzh.util.WechatApiUtil;

@Service
public class WebchatMenuService extends BaseWechatService{

	private static final Logger logger = LoggerFactory.getLogger(WebchatMsgService.class);
	

//	@Autowired
//	private RestTemplate simpleRestTemplate;
	
//	public WechatErrorMsg createMenu( WechatMenu menu) {
//		String accessToken = this.getAccessToken();
//		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.MENU_CREATE, accessToken) ;
//		logger.info(" createMenu url:" +url);
//		return simpleRestTemplate.postForObject(url, menu, WechatErrorMsg.class);
//	}
//	
	public WechatErrorMsg initMenu( String  path) {
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.MENU_CREATE, accessToken) ;
		String content= this.readFile(path);
		logger.info(" initMenu url:" +url+"\n content:" +content);
		return simpleRestTemplate.postForObject(url, content, WechatErrorMsg.class);
	}
	
	public String searchMenu( ) {
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.MENU_SEARCH, accessToken) ;
		logger.info(" search Menu url:" +url);
		return simpleRestTemplate.getForObject(url, String.class);
	}
	
	public WechatErrorMsg delMenu( ) {
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.MENU_DELETE, accessToken) ;
		logger.info(" del Menu url:" +url);
		return simpleRestTemplate.getForObject(url, WechatErrorMsg.class);
	}	
	
	
	public String initConditional( String  path) {
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.CONDITIONAL_MENU_ADD, accessToken) ;
		String content= this.readFile(path);
		logger.info(" initMenu url:" +url+"\n content:" +content);
		return simpleRestTemplate.postForObject(url, content, String.class);
	}
	
	public String matchConditional(String userId ) {
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.CONDITIONAL_MENU_MATCH, accessToken) ;
		Map<String,String> map =new HashMap<>();
		map.put("user_id", userId);
		logger.info(" search Menu url:" +url +"   user_id:"+ userId);
		return simpleRestTemplate.postForObject(url,map, String.class);
	}
	
	public WechatErrorMsg delConditional(String menuid ) {
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.CONDITIONAL_MENU_DELETE, accessToken) ;
		logger.info(" del Menu url:" +url);
		Map<String,String> map =new HashMap<>();
		map.put("menuid", menuid);
		logger.info(" search Menu url:" +url +"   menuid:"+ menuid);
		return simpleRestTemplate.postForObject(url, map, WechatErrorMsg.class);
	}
	
	public String searchMenuInfo( ) {
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.MENU_INFO, accessToken) ;
		logger.info(" search Menu info:" +url);
		return simpleRestTemplate.getForObject(url, String.class);
	}
	
	 public  String readFile(String path){
	        String laststr="";
	        File file=new File(path);// 打开文件  
	        BufferedReader reader=null;
	        try{
	            FileInputStream in = new FileInputStream(file);
	            reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));// 读取文件  
	            String tempString=null;
	            while((tempString=reader.readLine())!=null){
	                laststr=laststr+tempString;
	            }
	            reader.close();
	        }catch(IOException e){
	            e.printStackTrace();
	        }finally{
	            if(reader!=null){
	                try{
	                    reader.close();
	                }catch(IOException el){
	                }  
	            }  
	        }
	        return laststr;
	    }
}
