package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.utill.DBConnector;

public class UserListDeleteCompleteDAO {
	public void delete(String login_id) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "delete from login_user_transaction where login_id != ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login_id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}
