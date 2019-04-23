package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.utill.DBConnector;
import com.internousdev.ecsite.utill.DateUtil;

public class UserCreateCompleteDAO {
	private DateUtil dateUtil = new DateUtil();

	public void createUser(String loginUserId, String loginPassword, String userName) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into login_user_transaction(login_id, login_pass, user_name, insert_date) values(?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ps.setString(3, userName);
			ps.setString(4, dateUtil.getDate());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	public int select(String loginUserId) throws SQLException {
		int count = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from login_user_transaction where login_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString("login_id").equals(null)) {
					count = 0;
				} else {
					count = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return count;
	}
}
