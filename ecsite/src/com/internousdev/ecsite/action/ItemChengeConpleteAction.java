package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemChengeConpleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemChengeConpleteAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private String msg;
	public ItemChengeConpleteDAO itemChengeConpleteDAO = new ItemChengeConpleteDAO();

	public String execute() throws SQLException {
		int flg = 0;
		flg = itemChengeConpleteDAO.update(session.get("item_name").toString(), session.get("item_stock").toString());
		if (flg > 0) {
			setMsg("商品数の変更が完了致しました。");

		} else {
			setMsg("該当する商品名がありません。");
		}
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
