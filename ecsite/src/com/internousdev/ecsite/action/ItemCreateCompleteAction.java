package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;

	public String execute() throws SQLException {
		ItemCreateCompleteDAO itemCreateCompleteDAO = new ItemCreateCompleteDAO();
		itemCreateCompleteDAO.insert(session.get("new_item_name").toString(), session.get("new_item_price").toString(),
				session.get("new_item_stock").toString(), session.get("new_item_type").toString());
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
