package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCartDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCartAction extends ActionSupport implements SessionAware {
	private int count;
	private int total_count;
	private int buy_count;
	private String errormsg;
	public Map<String, Object> session;
	BuyItemDTO buyItemDTO = new BuyItemDTO();
	BuyItemCartDAO buyItemCartDAO = new BuyItemCartDAO();

	public String execute() throws SQLException {
		buyItemDTO = buyItemCartDAO.select2(session.get("id").toString());
		buy_count = buyItemDTO.getTotalCount() + count;
		if (session.get("id").toString().equals(buyItemDTO.getId())
				&& session.get("login_user_id").toString().equals(buyItemDTO.getUser_Id())) {

			buyItemDTO = buyItemCartDAO.select(session.get("id").toString());
			if (buyItemDTO.getItemStock() < buy_count) {
				setErrormsg("購入希望数が在庫数を超えているため購入できません。");
				return ERROR;
			} else {
				buyItemDTO = buyItemCartDAO.select2(session.get("id").toString());
				total_count = buyItemDTO.getTotalCount() + count;
				buyItemCartDAO.update(session.get("id").toString(), session.get("login_user_id").toString(),
						total_count);
				return SUCCESS;
			}
		}
		buyItemDTO = buyItemCartDAO.select(session.get("id").toString());
		if (buyItemDTO.getItemStock() == 0) {
			setErrormsg("商品に在庫が無いため購入できません。");
			return ERROR;
		} else if (buyItemDTO.getItemStock() < count) {
			setErrormsg("購入希望数が在庫数を超えているため購入できません。");
			return ERROR;
		} else {
			buyItemCartDAO.insert(session.get("id").toString(), session.get("item_name").toString(),
					session.get("item_price").toString(), session.get("item_stock").toString(), count,
					session.get("login_user_id").toString());
			return SUCCESS;
		}
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}

	public void setBuyItemDTO(BuyItemDTO buyItemDTO) {
		this.buyItemDTO = buyItemDTO;
	}

}
