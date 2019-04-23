package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteConfirmAction extends ActionSupport {
	private Collection<String> checkList;
	public ArrayList<ItemListDTO> List = new ArrayList<ItemListDTO>();
	public ItemListDAO itemListDAO = new ItemListDAO();

	public String execute() throws SQLException {
		for (String chek : checkList) {
			List = itemListDAO.select2(chek);
		}
		return SUCCESS;
	}

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

}
