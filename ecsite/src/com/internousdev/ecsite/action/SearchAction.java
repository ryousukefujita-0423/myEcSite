package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.SearchDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {
	private String search;
	public String errorMsg;
	ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
	public SearchDAO searchDAO = new SearchDAO();

	public String execute() throws SQLException {
		buyItemDTOList = searchDAO.select(search);
		if (buyItemDTOList.size() <= 0) {
			setErrorMsg("'" + search + "'" + "を含む該当する商品はありませんでした。");
		}
		return SUCCESS;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public ArrayList<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(ArrayList<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
