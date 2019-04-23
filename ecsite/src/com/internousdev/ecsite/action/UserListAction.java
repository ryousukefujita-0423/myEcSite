package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware {
	public int msg = 0;
	public ArrayList<UserListDTO> userList = new ArrayList<UserListDTO>();
	private Map<String, Object> session;

	public String execute() throws SQLException {
		UserListDAO userListDAO = new UserListDAO();
		userList = userListDAO.select(session.get("login_user_id").toString());
		if (userList.size() == 0) {
			setMsg(1);
		}
		return SUCCESS;
	}

	public ArrayList<UserListDTO> getUserListDTO() {
		return userList;
	}

	public void setUserListDTO(ArrayList<UserListDTO> userListDTO) {
		this.userList = userListDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getMsg() {
		return msg;
	}

	public void setMsg(int msg) {
		this.msg = msg;
	}

}
