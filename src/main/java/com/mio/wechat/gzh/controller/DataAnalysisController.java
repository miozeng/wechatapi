package com.mio.wechat.gzh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mio.wechat.gzh.bean.analysis.ArticleMethodEnum;
import com.mio.wechat.gzh.bean.analysis.InterMethodEnum;
import com.mio.wechat.gzh.bean.analysis.MsgMethodEnum;
import com.mio.wechat.gzh.bean.analysis.UserMethodEnum;
import com.mio.wechat.gzh.service.DataAnalysisService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/dc", description = "数据统计")
@RestController
@RequestMapping("/dc")
public class DataAnalysisController {

	@Autowired
	private DataAnalysisService dataAnalysisService;
	
	@ApiOperation(value = "用户分析数据接口", notes = "  method：最大时间跨度是指一次接口调用时最大可获取数据的时间范围，如最大时间跨度为7是指最多一次性获取7天的数据。\n\r"
			+ "获取用户增减数据（getusersummary） 	最大时间跨度:7 \n\r"
			+ "获取累计用户数据（getusercumulate） 	最大时间跨度:7 \n\r")
	@GetMapping("/dcUser")
	@ResponseBody
	public String dcUser(@ApiParam(value="开始时间    时间格式：yyyy-MM-dd ")@RequestParam String start, 
			@ApiParam(value="结束时间  时间格式：yyyy-MM-dd")@RequestParam String end,
			@RequestParam UserMethodEnum method) {
		
		return dataAnalysisService.dcUser(start, end, method);

	}
	
	
	@ApiOperation(value = "图文分析数据接口", notes = "method：获取图文群发每日数据（getarticlesummary）	最大时间跨度:1\n\r"
			+ "获取图文群发总数据（getarticletotal） 	最大时间跨度:2\n\r"
			+ "获取图文统计数据（getuserread）  	最大时间跨度:3\n\r"
			+ "获取图文统计分时数据（getuserreadhour）  	最大时间跨度:1\n\r"
			+ "获取图文分享转发数据（getusershare） 	最大时间跨度:7\n\r"
			+ "获取图文分享转发分时数据（getusersharehour） 	最大时间跨度:1\n\r")
	@GetMapping("/article")
	@ResponseBody
	public String dcArticle(@ApiParam(value="开始时间    时间格式：yyyy-MM-dd ")@RequestParam String start, 
			@ApiParam(value="结束时间  时间格式：yyyy-MM-dd")@RequestParam String end, @RequestParam ArticleMethodEnum method) {
		
		return dataAnalysisService.dcArticle(start, end, method);

	}
	@ApiOperation(value = "接口分析数据接口", notes = " method：获取接口分析数据（getinterfacesummary）	最大时间跨度:30\n\r"
			+ "获取接口分析分时数据（getinterfacesummaryhour） 	最大时间跨度:1\n\r")
	@GetMapping("/inter")
	@ResponseBody
	public String dcInter(@ApiParam(value="开始时间    时间格式：yyyy-MM-dd ")@RequestParam String start,
			@ApiParam(value="结束时间  时间格式：yyyy-MM-dd")@RequestParam String end, @RequestParam InterMethodEnum method) {
		
		return dataAnalysisService.dcInter(start, end, method);

	}
	

	
	@ApiOperation(value = "消息分析数据接口", notes = " method：获取消息发送概况数据（getupstreammsg）	最大时间跨度:7\n\r"
			+ "获取消息分送分时数据（getupstreammsghour） 	最大时间跨度:1\n\r"
			+ "获取消息发送周数据（getupstreammsgweek）  	最大时间跨度:30\n\r"
			+ "获取消息发送月数据（getupstreammsgmonth）  	最大时间跨度:30\n\r"
			+ "获取消息发送分布数据（getupstreammsgdist）	最大时间跨度:15\n\r"
			+ "获取消息发送分布周数据（getupstreammsgdistweek） 	最大时间跨度:30\n\r"
			+ "获取消息发送分布月数据（getupstreammsgdistmonth）	最大时间跨度:30\n\r")
	@GetMapping("/msg")
	@ResponseBody
	public String dcMsg(@ApiParam(value="开始时间    时间格式：yyyy-MM-dd ")@RequestParam String start,
			@ApiParam(value="结束时间  时间格式：yyyy-MM-dd")@RequestParam String end, @RequestParam MsgMethodEnum method) {
		
		return dataAnalysisService.dcMsg(start, end, method);

	}
}
