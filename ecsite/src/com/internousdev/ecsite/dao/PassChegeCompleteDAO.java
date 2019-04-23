package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.PassChegeCompleteDTO;
import com.internousdev.ecsite.utill.DBConnector;
import com.internousdev.ecsite.utill.DateUtil;

public class PassChegeCompleteDAO {
	private static DateUtil dateUtil = new DateUtil();

	public PassChegeCompleteDTO select(String login_id) throws SQLException {
		PassChegeCompleteDTO passChegeCompleteDTO = new PassChegeCompleteDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from login_user_transaction where login_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login_id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				passChegeCompleteDTO.setOldpass(rs.getString("login_pass"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return passChegeCompleteDTO;
	}

	public static void update(String login_id, String newpassword) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update login_user_transaction set login_pass = ?, update_date = ? where login_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newpassword);
			ps.setString(2, dateUtil.getDate());
			ps.setString(3, login_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
