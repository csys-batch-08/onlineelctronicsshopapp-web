package com.onlineelectronicshop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlineelectronicshop.model.User;
import com.onlineelectronicshop.util.ConnectionUtil;

public class WalletDaoImpl {
	static final String USERID = "USER_ID";

	public int walletBalance(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = ConnectionUtil.getDbConnection();
		String query = "select wallet from user_details where user_id=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				return rs.getInt(1);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con, rs);
		}

		return -1;
	}

	public int updateWallet(Double amount, int userId){
		Connection con = ConnectionUtil.getDbConnection();
		String query = "update user_details set wallet=? where user_id=?";
		PreparedStatement pstmt =null;
		int result=0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, userId);
			result = pstmt.executeUpdate();
			pstmt.executeUpdate("commit");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return result;

	}

	public int updateWalletbalance(Double amount, int userId){
		Connection con = ConnectionUtil.getDbConnection();
		String query = "update user_details set wallet=wallet+? where user_id=?";
		PreparedStatement pstmt=null;
		int result=0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, userId);
			result = pstmt.executeUpdate();
			pstmt.executeUpdate("commit");
		} catch (SQLException e) {
			e.printStackTrace();
		}
finally {
	ConnectionUtil.closePreparedStatement(pstmt, con);
}
		return result;

	}

	public boolean refundWallet(Double amount, User user) {
		Connection con = ConnectionUtil.getDbConnection();
		Statement stmt = null;
		String updateQuery1 = "update user_details set wallet=" + (user.getWallet() + amount) + "where user_id="
				+ user.getUserid();
		boolean flag = false;
		try {
			stmt = con.createStatement();
			flag = stmt.executeUpdate(updateQuery1) > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closeStatement(stmt, con);
		}
		return flag;

	}
}
