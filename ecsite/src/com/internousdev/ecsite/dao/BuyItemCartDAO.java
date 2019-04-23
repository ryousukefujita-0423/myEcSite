package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.utill.DBConnector;
import com.internousdev.ecsite.utill.DateUtil;

public class BuyItemCartDAO {
	private DateUtil dateUtil = new DateUtil();
	ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	public BuyItemDTO select(String check) throws SQLException {
		BuyItemDTO buyItemDTO = new BuyItemDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from item_info_transaction where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, check);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				buyItemDTO.setId(rs.getString("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getInt("item_price"));
				buyItemDTO.setItemStock(rs.getInt("item_stock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return buyItemDTO;
	}

	public void insert(String id, String item_name, String item_price, String item_stock, int total_count,
			String userid) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into item_cart_transaction(id, item_name, item_price, item_stock, total_count, user_id, insert_date) values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, item_name);
			ps.setString(3, item_price);
			ps.setString(4, item_stock);
			ps.setInt(5, total_count);
			ps.setString(6, userid);
			ps.setString(7, dateUtil.getDate());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	public BuyItemDTO select2(String check) throws SQLException {
		BuyItemDTO buyItemDTO = new BuyItemDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from item_cart_transaction where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, check);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				buyItemDTO.setId(rs.getString("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getInt("item_price"));
				buyItemDTO.setItemStock(rs.getInt("item_stock"));
				buyItemDTO.setTotalCount(rs.getInt("total_count"));
				buyItemDTO.setUser_Id(rs.getString("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return buyItemDTO;
	}

	public ArrayList<BuyItemDTO> select3(String check) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from item_cart_transaction where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, check);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BuyItemDTO buyItemDTO = new BuyItemDTO();
				buyItemDTO.setId(rs.getString("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getInt("item_price"));
				buyItemDTO.setItemStock(rs.getInt("item_stock"));
				buyItemDTO.setTotalCount(rs.getInt("total_count"));
				buyItemDTOList.add(buyItemDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return buyItemDTOList;
	}

	public void update(String id, String user_id, int total_count) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update item_cart_transaction set total_count = ?, update_date = ? where id = ? and user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, total_count);
			ps.setString(2, dateUtil.getDate());
			ps.setString(3, id);
			ps.setString(4, user_id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
