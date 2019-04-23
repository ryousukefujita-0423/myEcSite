package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.utill.DBConnector;
import com.internousdev.ecsite.utill.DateUtil;

public class BuyItemConpleteDAO {
	private DateUtil dateUtil = new DateUtil();

	public BuyItemDTO select(String item_id) throws SQLException {
		BuyItemDTO buyItemDTO = new BuyItemDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from item_cart_transaction where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				buyItemDTO.setId(rs.getString("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getInt("item_price"));
				buyItemDTO.setItemStock(rs.getInt("item_stock"));
				buyItemDTO.setTotalCount(rs.getInt("total_count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return buyItemDTO;
	}

	public void buyItemInfo(String Item_transaction_id, String user_master_id, String item_name, int total_price,
			int total_count, String pay) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into user_buy_item_transaction(item_transaction_id, item_name, total_price, total_count, user_master_id, pay, insert_date) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, Item_transaction_id);
			ps.setString(2, item_name);
			ps.setInt(3, total_price);
			ps.setInt(4, total_count);
			ps.setString(5, user_master_id);
			ps.setString(6, pay);
			ps.setString(7, dateUtil.getDate());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	public BuyItemDTO select2(String item_id) throws SQLException {
		BuyItemDTO buyItemDTO = new BuyItemDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from item_info_transaction where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				buyItemDTO.setItemStock(rs.getInt("item_stock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return buyItemDTO;
	}

	public void update(int total_count, String item_id) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update item_info_transaction set item_stock = ?, update_date = ? where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, total_count);
			ps.setString(2, dateUtil.getDate());
			ps.setString(3, item_id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	public void delete(String item_id) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "delete from item_cart_transaction where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
