package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.utill.DBConnector;

public class ItemChengeConpleteDAO {
	public int update(String item_name, String item_stock) throws SQLException {
		int flg = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update item_info_transaction set item_stock = ? where item_name = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_stock);
			ps.setString(2, item_name);
			int count = ps.executeUpdate();

			if (count > 0) {
				flg = 1;
			} else {
				flg = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return flg;
	}

}
