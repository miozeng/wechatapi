package com.mio.wechat.gzh.bean.menu;

import java.util.List;

public class WechatSearchMenu {

	private List<WechatButton> button;

	private List<WechatButton> conditionalmenu;

	public List<WechatButton> getButton() {
		return button;
	}

	public void setButton(List<WechatButton> button) {
		this.button = button;
	}

	public List<WechatButton> getConditionalmenu() {
		return conditionalmenu;
	}

	public void setConditionalmenu(List<WechatButton> conditionalmenu) {
		this.conditionalmenu = conditionalmenu;
	}
	
	
}
