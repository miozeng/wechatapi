package com.mio.wechat.gzh.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mio.wechat.gzh.service.MaterialService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "/material", description = " 素材管理 API")
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	
//	@GetMapping("/list")
//	@ResponseBody
//	public Material batchget() {
//		
//		return null;
//
//	}

	/**
	 * 
	 * @param file
	 * @param type图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ApiOperation(value = "新增其他类型永久素材", notes = " 新增其他类型永久素材 ")
	@PostMapping(value = "/addMaterial",consumes=" multipart/*", headers="Content-type=multipart/form-data")
	@ResponseBody
	public String addMaterial(@ApiParam(value="文件")@RequestParam("file") MultipartFile file,
			@ApiParam(value="type图片（image）、语音（voice）、视频（video）和缩略图（thumb）")@RequestParam("type") String type  , 
			HttpServletRequest request,HttpServletResponse response) throws IOException {
		//@RequestParam("title") String title , @RequestParam("introduction") String introduction  ,
		
		return materialService.addMaterial(file, type);
		
	}

}
