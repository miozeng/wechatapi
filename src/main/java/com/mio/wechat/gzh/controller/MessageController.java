package com.mio.wechat.gzh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mio.wechat.gzh.bean.common.WechatErrorMsg;
import com.mio.wechat.gzh.bean.msg.sendall.DelAll;
import com.mio.wechat.gzh.bean.msg.sendall.MsgTypeEnum;
import com.mio.wechat.gzh.bean.msg.sendall.SendAllArticle;
import com.mio.wechat.gzh.bean.msg.sendall.SendAllFilter;
import com.mio.wechat.gzh.bean.msg.sendall.SendAllReplay;
import com.mio.wechat.gzh.service.WechatSendAllService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/msg", description = "群消息发送")
@RestController
@RequestMapping("/msg")
public class MessageController {

	
	@Autowired
	private WechatSendAllService wechatSendAllService;
	
	@ApiOperation(value = "根据标签进行群发", notes = "发送消息\n\r"
			+ " mpnews:图文消息     text: 文本\n\r"
			+ "voice: 语音/音频（注意此处media_id需通过基础支持中的上传下载多媒体文件来得到）\n\r"
			+ "image:图片     mpvideo:视频   wxcard：卡券消息 ")
	@PostMapping("/sendAll")
	@ResponseBody
	public SendAllReplay batchget(@ApiParam(value="文本内容,type为text时填写")@RequestParam(required= false) String content,
			@ApiParam(value="mediaId,type不为text时填写")@RequestParam(required= false) String mediaId,
			@ApiParam(value="图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。")@RequestParam(required= false) Integer sendIgnoreReprint,
			@ApiParam(value="消息类型")@RequestParam MsgTypeEnum type,
			@ApiParam(value="用于设定图文消息的接收者")@RequestBody SendAllFilter filter) {
		return wechatSendAllService.sendAllText(content, mediaId, sendIgnoreReprint, type,filter);
	}
	
	@ApiOperation(value = "上传图文消息内的图片获取URL", notes = "请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。")
	@PostMapping(value = "/uploadImg",consumes=" multipart/*", headers="Content-type=multipart/form-data")
	@ResponseBody
	public String uploadImg(@ApiParam(value="文件")@RequestParam("file") MultipartFile file,
			HttpServletRequest request,HttpServletResponse response) throws IOException {
		//@RequestParam("title") String title , @RequestParam("introduction") String introduction  ,
		
		return wechatSendAllService.uploadImg(file);
		
	}
	
	@ApiOperation(value = "上传图文消息素材", notes = "上传图文消息素材  \n\r"
			+ "thumb_media_id	是	图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得\n\r"
			+ "author	否	图文消息的作者\n\r"
			+ "title	是	图文消息的标题\n\r"
			+ "content_source_url	否	在图文消息页面点击“阅读原文”后的页面，受安全限制，如需跳转Appstore，可以使用itun.es或appsto.re的短链服务，并在短链后增加 #wechat_redirect 后缀。\n\r"
			+ "content	是	图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用，如需插入小程序卡片，可参考下文。\n\r"
			+ "digest	否	图文消息的描述，如本字段为空，则默认抓取正文前64个字\n\r"
			+ "show_cover_pic	否	是否显示封面，1为显示，0为不显示")
	@PostMapping("/uploadNews")
	@ResponseBody
	public String uploadNews(@RequestBody List<SendAllArticle> articles) {
		return wechatSendAllService.uploadNews(articles);
	}
	
	@ApiOperation(value = "删除群发", notes = "群发之后，随时可以通过该接口删除群发。【订阅号与服务号认证后均可用】  \n\r"
			+ "msgId	是	发送出去的消息ID\n\r"
			+ "articleIdx	否	要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章")
	@PostMapping("/deleteAll")
	@ResponseBody
	public WechatErrorMsg  deleteAll(@RequestBody DelAll delAll){
		return wechatSendAllService.deleteAll(delAll);
	}
	
	@ApiOperation(value = "预览接口", notes = "开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版。为了满足第三方平台开发者的需求，在保留对openID预览能力的同时，增加了对指定微信号发送预览的能力，但该能力每日调用次数有限制（100次），请勿滥用。\n\r"
			+ " mpnews:图文消息     text: 文本\n\r"
			+ "voice: 语音/音频（注意此处media_id需通过基础支持中的上传下载多媒体文件来得到）\n\r"
			+ "image:图片     mpvideo:视频   wxcard：卡券消息 ")
	@PostMapping("/preview")
	@ResponseBody
	public String preview(@ApiParam(value="文本内容,type为text时填写")@RequestParam(required= false) String content,
			@ApiParam(value="mediaId(card_id),type不为text时填写")@RequestParam(required= false) String mediaId,
			@ApiParam(value="卡卷附件信息。")@RequestParam(required= false) String cardExt,
			@ApiParam(value="消息类型")@RequestParam MsgTypeEnum type,
			@ApiParam(value="接收消息用户对应该公众号的openid，该字段也可以改为towxname，以实现对微信号的预览")@RequestBody String touser) {
		return wechatSendAllService.preview(content, mediaId, cardExt, type,touser);
	}
}
