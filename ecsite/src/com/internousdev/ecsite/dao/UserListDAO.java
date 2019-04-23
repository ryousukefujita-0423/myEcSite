package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.utill.DBConnector;

public class UserListDAO {
	ArrayList<UserListDTO> userListDTO = new ArrayList<UserListDTO>();

	public ArrayList<UserListDTO> select(String login_id) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from login_user_transaction where login_id != ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserListDTO dto = new UserListDTO();
				dto.setLogin_id(rs.getString("login_id"));
				dto.setLogin_pass(rs.getString("login_pass"));
				dto.setUser_name(rs.getString("user_name"));
				userListDTO.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return userListDTO;
	}

}
