package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.utill.DBConnector;
import com.internousdev.ecsite.utill.DateUtil;

public class ItemCreateCompleteDAO {
	private DateUtil dateUtil = new DateUtil();

	public void insert(String item_name, String item_price, String item_stock, String item_type) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into item_info_transaction(item_name, item_price, item_stock, insert_date, item_type) values(?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_name);
			ps.setString(2, item_price);
			ps.setString(3, item_stock);
			ps.setString(4, dateUtil.getDate());
			ps.setString(5, item_type);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}
