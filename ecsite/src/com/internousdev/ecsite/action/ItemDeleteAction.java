package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDeleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteAction extends ActionSupport implements SessionAware {
	private Collection<String> checkList;
	public Map<String, Object> session;
	private String errormsg;
	ItemDeleteDAO itemDeleteDAO = new ItemDeleteDAO();

	public String execute() throws SQLException {
		if (checkList == null) {
			setErrormsg("商品にチェックが入っていません。");
			return ERROR;
		} else {
			for (String check : checkList) {
				itemDeleteDAO.delete(check, session.get("login_user_id").toString());
			}
			return SUCCESS;
		}
	}

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

}
