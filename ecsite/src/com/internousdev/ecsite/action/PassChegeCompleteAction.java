package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.PassChegeCompleteDAO;
import com.internousdev.ecsite.dto.PassChegeCompleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PassChegeCompleteAction extends ActionSupport implements SessionAware {
	private String oldpass;
	private String newpass;
	private String newkakuninpass;
	private String errormsg;
	public Map<String, Object> session;

	public String execute() throws SQLException {
		String result = ERROR;
		PassChegeCompleteDAO passChegeCompleteDAO = new PassChegeCompleteDAO();
		PassChegeCompleteDTO passChegeCompleteDTO = new PassChegeCompleteDTO();

		passChegeCompleteDTO = passChegeCompleteDAO.select(session.get("login_user_id").toString());

		if (oldpass.equals("") || newpass.equals("") || newkakuninpass.equals("")) {
			setErrormsg("未入力の項目があります。");
			return ERROR;
		} else if (!oldpass.equals(passChegeCompleteDTO.getOldpass())) {
			setErrormsg("現パスワードが間違っています。");
			return ERROR;
		} else if (!newpass.equals(newkakuninpass)) {
			setErrormsg("新パスワードが一致しません。");
			return ERROR;
		} else {
			PassChegeCompleteDAO.update(session.get("login_user_id").toString(), newpass);
			session.clear();
			result = SUCCESS;
		}
		return result;
	}

	public String getOldpass() {
		return oldpass;
	}

	public void setOldpass(String oldpass) {
		this.oldpass = oldpass;
	}

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	public String getNewkakuninpass() {
		return newkakuninpass;
	}

	public void setNewkakuninpass(String newkakuninpass) {
		this.newkakuninpass = newkakuninpass;
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

}
