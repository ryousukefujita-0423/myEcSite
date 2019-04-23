package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.utill.DBConnector;

public class SearchDAO {
	ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	public ArrayList<BuyItemDTO> select(String search) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from item_info_transaction where item_name like ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + search + "%");
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
