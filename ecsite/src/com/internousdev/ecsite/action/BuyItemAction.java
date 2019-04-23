package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCartDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {
	public int i = 0;
	private Collection<String> checkList;
	public Map<String, Object> session;
	private String pay;
	private String errormsg;
	public int total_Count;
	BuyItemDTO buyItemDTO = new BuyItemDTO();
	public ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
	BuyItemCartDAO buyItemCartDAO = new BuyItemCartDAO();

	public String execute() throws SQLException {
		if (checkList == null) {
			setErrormsg("商品にチェックが入っていません。");
			return ERROR;
		} else {
			for (String chek : checkList) {
				buyItemDTO = buyItemCartDAO.select2(chek);
				total_Count += buyItemDTO.getItemPrice() * buyItemDTO.getTotalCount();
			}

			for (String chek : checkList) {
				buyItemDTOList = buyItemCartDAO.select3(chek);
			}

			String payment;
			if (pay.equals("1")) {
				payment = "現金払い";
				session.put("pay", payment);
			} else {
				payment = "クレジットカード";
				session.put("pay", payment);
			}
			return SUCCESS;
		}

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

	public int getTotalCount() {
		return total_Count;
	}

	public void setTotalCount(int total_Count) {
		this.total_Count = total_Count;
	}

	public ArrayList<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(ArrayList<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

}
