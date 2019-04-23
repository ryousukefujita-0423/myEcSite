package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.utill.DBConnector;

public class MenuDAO {

	public ArrayList<BuyItemDTO> select(int item_type) throws SQLException {
		ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select id, item_name, item_price,item_stock from item_info_transaction where item_type = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item_type);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BuyItemDTO buyItemDTO = new BuyItemDTO();
				buyItemDTO.setId(rs.getString("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getInt("item_price"));
				buyItemDTO.setItemStock(rs.getInt("item_stock"));
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
