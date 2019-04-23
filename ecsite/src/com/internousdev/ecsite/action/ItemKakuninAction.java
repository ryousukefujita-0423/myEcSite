package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCartDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemKakuninAction extends ActionSupport implements SessionAware {
	private String id;
	public Map<String, Object> session;
	BuyItemCartDAO buyItemCartDAO = new BuyItemCartDAO();
	BuyItemDTO buyItemDTO = new BuyItemDTO();

	public String execute() throws SQLException {
		buyItemDTO = buyItemCartDAO.select(id);
		session.put("id", buyItemDTO.getId());
		session.put("item_name", buyItemDTO.getItemName());
		session.put("item_price", buyItemDTO.getItemPrice());
		session.put("item_stock", buyItemDTO.getItemStock());
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}

	public void setBuyItemDTO(BuyItemDTO buyItemDTO) {
		this.buyItemDTO = buyItemDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
