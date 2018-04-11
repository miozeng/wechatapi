package com.mio.wechat.gzh.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mio.wechat.gzh.bean.menu.MenuType;
import com.mio.wechat.gzh.bean.menu.WechatButton;
import com.mio.wechat.gzh.bean.menu.WechatMenu;
import com.mio.wechat.gzh.bean.token.WechatRetMsg;
import com.mio.wechat.gzh.service.WebchatMenuService;



@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private WebchatMenuService webchatMenuService;
	

	  @GetMapping("/create")
	  @ResponseBody
	  public WechatRetMsg createBySelf()   {
		  
		  List<WechatButton> btns = new ArrayList<WechatButton>();
		  WechatButton clickButton = new WechatButton();
	      clickButton.setKey("clickBtn1");
	      clickButton.setName("点击按钮1");
	      clickButton.setType(MenuType.click.toString());
	      btns.add(clickButton);

	    
	      
	      List<WechatButton> btns2 = new ArrayList<WechatButton>();
	      WechatButton clickButton3 = new WechatButton();
	      clickButton3.setUrl("https://www.baidu.com");
	      clickButton3.setName("view按钮");
	      clickButton3.setType(MenuType.view.toString());
	      btns2.add(clickButton3);
	      
	      WechatButton localBtn = new WechatButton();
	      localBtn.setKey("localBtn");
	      localBtn.setName("位置按钮");
	      localBtn.setType(MenuType.location_select.toString());
	      btns2.add(localBtn);
//	   
	      WechatButton complexButton = new WechatButton();
	      complexButton.setSub_button(btns2);
	      complexButton.setName("mio's menu");
	      btns.add(complexButton);
      
	      WechatMenu menu = new WechatMenu();
	      menu.setButton(btns);

//	      String jsonMenu = JSONObject.toJSONString(menu);
//	      System.out.println(jsonMenu.toString());
//	      
//	      WechatRetMsg ret = webchatMenuService.createMenu(jsonMenu);
	     
//	      System.out.println(ret.getErrcode());
	      return null;
	  }
}
