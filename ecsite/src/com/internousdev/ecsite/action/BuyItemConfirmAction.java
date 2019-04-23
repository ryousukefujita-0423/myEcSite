package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemConpleteDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private Collection<String> checkList;
	private BuyItemConpleteDAO buyItemCompleteDAO = new BuyItemConpleteDAO();
	public BuyItemDTO buyItemDTO = new BuyItemDTO();

	public String execute() throws SQLException {

		for (String count : checkList) {
			int total_zaiko = 0;
			int buy_item_count = 0;

			buyItemDTO = buyItemCompleteDAO.select(count);
			buy_item_count = buyItemDTO.getTotalCount();

			buyItemCompleteDAO.buyItemInfo(buyItemDTO.getId(), session.get("login_user_id").toString(),
					buyItemDTO.getItemName(), buyItemDTO.getItemPrice(), buyItemDTO.getTotalCount(),
					session.get("pay").toString());
			buyItemDTO = buyItemCompleteDAO.select2(count);
			total_zaiko = buyItemDTO.getItemStock() - buy_item_count;

			buyItemCompleteDAO.update(total_zaiko, count);
			buyItemCompleteDAO.delete(count);
		}
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

	public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}

	public void setBuyItemDTO(BuyItemDTO buyItemDTO) {
		this.buyItemDTO = buyItemDTO;
	}

}
