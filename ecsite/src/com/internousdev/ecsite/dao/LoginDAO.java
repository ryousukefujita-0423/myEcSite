package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.utill.DBConnector;

public class LoginDAO {

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) throws SQLException {
		LoginDTO loginDTO = new LoginDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from login_user_transaction where login_id = ? and login_pass= ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				loginDTO.setLoginUserId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));

				if (!(rs.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return loginDTO;
	}

}
