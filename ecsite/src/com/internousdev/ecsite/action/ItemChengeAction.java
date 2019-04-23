package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemChengeAction extends ActionSupport {
	ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
	BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute() throws SQLException {
		buyItemDTOList = buyItemDAO.getBuyItemInfo();
		return SUCCESS;
	}

	public ArrayList<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(ArrayList<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}

}
