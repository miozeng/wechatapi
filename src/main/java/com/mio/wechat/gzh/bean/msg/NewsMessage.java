package com.mio.wechat.gzh.bean.msg;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/** 回复图文消息
 * <xml><ToUserName>< ![CDATA[toUser] ]></ToUserName><FromUserName>< ![CDATA[fromUser] ]></FromUserName><CreateTime>12345678</CreateTime>
 * <MsgType>< ![CDATA[news] ]></MsgType>
 * <ArticleCount>2</ArticleCount>
 * <Articles>
 * <item>
 * <Title>< ![CDATA[title1] ]></Title> 
 * <Description>< ![CDATA[description1] ]></Description>
 * <PicUrl>< ![CDATA[picurl] ]></PicUrl>
 * <Url>< ![CDATA[url] ]></Url>
 * </item>
 * <item>
 * <Title>< ![CDATA[title] ]></Title>
 * <Description>< ![CDATA[description] ]></Description>
 * <PicUrl>< ![CDATA[picurl] ]></PicUrl>
 * <Url>< ![CDATA[url] ]></Url>
 * </item></Articles></xml>
 * @author admin */
public class NewsMessage extends BaseWechatMessage {

	@XStreamAlias("ArticleCount")
	private Integer ArticleCount;

	@XStreamAsAttribute//以属性的形式出现
	@XStreamAlias("Articles")
	private List<Articles> articles;

	public Integer getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(Integer articleCount) {
		ArticleCount = articleCount;
	}

	public List<Articles> getArticles() {
		return articles;
	}

	public void setArticles(List<Articles> articles) {
		this.articles = articles;
	}

	

}
