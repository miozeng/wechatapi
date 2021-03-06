package com.mio.wechat.gzh.service;

import java.io.File;
import java.io.IOException;
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

import com.mio.wechat.gzh.util.WechatApiUtil;

@Service
public class MaterialService extends BaseWechatService{

	private static final Logger logger = LoggerFactory.getLogger(MaterialService.class);
	@Autowired
	private RestTemplate simpleRestTemplate;
	
	public String addMaterial(MultipartFile file,String mtype) throws IllegalStateException, IOException {
		//获取url
		String accessToken = this.getAccessToken();
		String url = WechatApiUtil.repleaceAccessToken(WechatApiUtil.ADD_MATERICAL, accessToken) ;
		url = url.replace("TYPE", mtype);
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
}
