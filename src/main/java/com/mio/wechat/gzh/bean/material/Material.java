package com.mio.wechat.gzh.bean.material;

import java.util.List;

public class Material {
	
	private String total_count;
	
	private String item_count;
	
	private List<MaterialItem> items;

	public String getTotal_count() {
		return total_count;
	}

	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}

	public String getItem_count() {
		return item_count;
	}

	public void setItem_count(String item_count) {
		this.item_count = item_count;
	}

	public List<MaterialItem> getItems() {
		return items;
	}

	public void setItems(List<MaterialItem> items) {
		this.items = items;
	}
	
	

}
