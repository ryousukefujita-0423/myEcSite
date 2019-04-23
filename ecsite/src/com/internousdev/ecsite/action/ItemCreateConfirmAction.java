package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware {
	private String item_name;
	private String item_price;
	private String item_stock;
	private String item_type;
	private String errormsg;
	public Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		if (item_name.equals("") || item_price.equals("") || item_stock.equals("")) {
			setErrormsg("未入力の項目があります。");
			result = ERROR;
		} else {
			session.put("new_item_name", item_name);
			session.put("new_item_price", item_price);
			session.put("new_item_stock", item_stock);
			session.put("new_item_type", item_type);
			result = SUCCESS;
		}
		return result;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_price() {
		return item_price;
	}

	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}

	public String getItem_stock() {
		return item_stock;
	}

	public void setItem_stock(String item_stock) {
		this.item_stock = item_stock;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getItem_type() {
		return item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

}
