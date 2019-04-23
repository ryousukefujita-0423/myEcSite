package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.utill.DBConnector;

public class ItemListDAO {
	ArrayList<ItemListDTO> itemListDTO = new ArrayList<ItemListDTO>();

	public ArrayList<ItemListDTO> select() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from item_info_transaction";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ItemListDTO dto = new ItemListDTO();
				dto.setId(rs.getString("id"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getString("item_price"));
				dto.setItem_stock(rs.getString("item_stock"));
				itemListDTO.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return itemListDTO;
	}

	public ArrayList<ItemListDTO> select2(String check) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from item_info_transaction where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, check);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ItemListDTO dto = new ItemListDTO();
				dto.setId(rs.getString("id"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getString("item_price"));
				dto.setItem_stock(rs.getString("item_stock"));
				itemListDTO.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return itemListDTO;
	}
}
