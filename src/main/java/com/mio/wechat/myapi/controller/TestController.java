package com.mio.wechat.myapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mio.wechat.myapi.entity.UserInfo;


@RestController
public class TestController {

	
	@PostMapping(value = "/test/saveuser")
	@ResponseBody
	public UserInfo getMeetInfo(@RequestBody UserInfo dto) {
		UserInfo u= new UserInfo();
		u.setName("hhhhh");
		u.setAge("25");
		return u;
	}
	
	@GetMapping(value = "/test")
	@ResponseBody
	public UserInfo logger( ) {
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("hh", "kdaedw");
//		map.put("hh2", "kdaedw");
//		map.put("hh3", "kdaedw");
		UserInfo u= new UserInfo();
		u.setName("hhhhh");
		u.setAge("25");
		return u;
	}
}
