package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.utill.DBConnector;

public class BuyItemDAO {

	public ArrayList<BuyItemDTO> getBuyItemInfo() throws SQLException {
		ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select id, item_name, item_price,item_stock, item_type from item_info_transaction";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BuyItemDTO buyItemDTO = new BuyItemDTO();
				buyItemDTO.setId(rs.getString("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getInt("item_price"));
				buyItemDTO.setItemStock(rs.getInt("item_stock"));
				buyItemDTO.setItem_type(rs.getInt("item_type"));
				buyItemDTOList.add(buyItemDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return buyItemDTOList;
	}

}
