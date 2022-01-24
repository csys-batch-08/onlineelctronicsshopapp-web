package com.onlineelectronicshop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlineelectronicshop.model.User;
import com.onlineelectronicshop.util.ConnectionUtil;

public class WalletDaoImpl {

	//wallet
	public int walletBalance(int id) throws SQLException {
		Connection con=ConnectionUtil.getDbConnection();
		String query="select wallet from user_details where user_id=?";
		System.out.println("walletballance");
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setInt(1,id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			
			return rs.getInt(1);

		}
		return -1;
	}
	
    //update wallet
	public int updateWallet(Double amount,int userId) throws SQLException {
		Connection con=ConnectionUtil.getDbConnection();
		String query="update user_details set wallet=? where user_id=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setDouble(1, amount);
		pstmt.setInt(2, userId);
		int result=pstmt.executeUpdate();
		System.out.println(result);
		pstmt.executeUpdate("commit");
		return result;
			
	}
	
	public void updateWalletbalance(Double amount,int userId) throws SQLException {
		Connection con=ConnectionUtil.getDbConnection();
		String query="update user_details set wallet=wallet+? where user_id=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setDouble(1, amount);
		pstmt.setInt(2, userId);
		int result=pstmt.executeUpdate();
		System.out.println(result);
		pstmt.executeUpdate("commit");
					
	}
	
	public boolean refundWallet(Double amount,User user) {
		Connection con = ConnectionUtil.getDbConnection();
		UserDaoImpl userDao=new UserDaoImpl();
		
		String updateQuery1 = "update user_details set wallet=" + (user.getWallet() + amount) + "where user_id="
				+ user.getUserid();
		boolean flag = false;
		try {
			Statement stmt = con.createStatement();
			flag = stmt.executeUpdate(updateQuery1) > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;

	}
	
	
	

}
