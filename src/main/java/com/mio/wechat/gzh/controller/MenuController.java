package com.mio.wechat.gzh.controller;


import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mio.wechat.gzh.bean.common.WechatErrorMsg;
import com.mio.wechat.gzh.service.WebchatMenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(value = "/menu", description = " 自定义菜单")
@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private WebchatMenuService webchatMenuService;
	

//	  @PostMapping("/create")
//	  @ResponseBody
//	  public WechatErrorMsg createBySelf(@RequestBody WechatMenu menu)   {
//	      return webchatMenuService.createMenu(menu);
//	  }
	  
	  @ApiOperation(value = "自定义菜单创建", notes = "创建菜单，请修改config/menu.json的内容为菜单内容  ，文件必须为utf-8")
	  @GetMapping("/init")
	  @ResponseBody
	  public WechatErrorMsg initMenu(HttpServletRequest request)   {
	      String proClassPath = request.getSession().getServletContext().getRealPath("") ;
	      proClassPath = proClassPath.replace("webapp", "resources"+File.separator+"config"+File.separator+"menu.json");
	      System.out.println("path: "+proClassPath);
	      return webchatMenuService.initMenu(proClassPath);
	  }
	  @ApiOperation(value = "自定义菜单查询", notes = "自定义菜单查询")
	  @GetMapping("/search")
	  @ResponseBody
	  public String searchMenu(  )   {
	      return webchatMenuService.searchMenu();
	  }
	  
	  @ApiOperation(value = "自定义菜单删除", notes = "自定义菜单删除 ")
	  @GetMapping("/delete")
	  @ResponseBody
	  public WechatErrorMsg delMenu( )   {
	      return webchatMenuService.delMenu();
	  }
	  
	  @ApiOperation(value = "个性菜单创建", notes = "创建个性菜单，请修改config/conditional_menu.json的内容为菜单内容  ")
	  @GetMapping("/initConditional")
	  @ResponseBody
	  public String initConditional(HttpServletRequest request)   {
	      String proClassPath = request.getSession().getServletContext().getRealPath("") ;
	      proClassPath = proClassPath.replace("webapp", "resources"+File.separator+"config"+File.separator+"conditional_menu.json");
	      System.out.println("path: "+proClassPath);
	      return webchatMenuService.initConditional(proClassPath);
	  }
	  
	  @ApiOperation(value = "个性化菜单匹配结果", notes = "个性化菜单匹配结果  ")
	  @GetMapping("/matchConditional")
	  @ResponseBody
	  public String matchConditional(@ApiParam(value="可以是粉丝的OpenID，也可以是粉丝的微信号")@RequestParam String userId)   {
	      return webchatMenuService.matchConditional(userId);
	  }
	  
	  @ApiOperation(value = "删除个性化菜单", notes = "删除个性化菜单。  ")
	  @GetMapping("/deleteConditional")
	  @ResponseBody
	  public WechatErrorMsg delConditional(@ApiParam(value="为菜单id，可以通过自定义菜单查询接口获取")@RequestParam String menuid )   {
	      return webchatMenuService.delConditional(menuid);
	  }
	  
	  @ApiOperation(value = "获取自定义菜单配置接口", notes = "获取自定义菜单配置接口")
	  @GetMapping("/menuInfo")
	  @ResponseBody
	  public String searchMenuInfo(  )   {
	      return webchatMenuService.searchMenuInfo();
	  }
}
