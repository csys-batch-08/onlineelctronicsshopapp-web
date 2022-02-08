package com.onlineelectronicshop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineelectronicshop.model.Cart;
import com.onlineelectronicshop.model.Components;
import com.onlineelectronicshop.model.Order;
import com.onlineelectronicshop.util.ConnectionUtil;
import com.onlineelectronicshopdao.CartDAO;

public class CartDaoImpl {
	static final String USERID="USER_ID";
	static final String COMPONENTID="COMPONENT_ID";
	static final String CARTID="CART_ID";
	static final String COMPONENTNAME="COMPONENT_NAME";
	static final String CATEGORYNAME="CATEGORY_NAME";
	static final String DESCRIPTION="DESCRIPTION";
	static final String TOTALPRICE="TOTAL_PRICE";
	static final String PICTURE="PICTURE";
	static final String COMPONENTSTATUS="COMPONENT_STATUS";

	
	public void insertCart(Cart cart) {
		String insertQuery = "insert into cart(user_id,component_id)values(?,?)";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, cart.getUserId());
			pstmt.setInt(2, cart.getComponentId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}

	}

	public void updateCart(String updateCart) throws ClassNotFoundException, SQLException {
		String updateQuery = "update cart set quantity =? where item_id=?";

		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement(updateQuery);
		pstmt.setInt(1, Integer.parseInt(updateCart.split(",")[0]));
		pstmt.setInt(2, Integer.parseInt(updateCart.split(",")[1]));
		int i = pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}

	public int deleteCart(int itemId, int userId) throws SQLException {
		String query = "delete from cart where component_id = ? and user_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, itemId);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return 0;
	}

	public List<Components> fetchCart(int userId) {
		List<Components> componentsList = new ArrayList<Components>();
		String query = "select component_name,category_name,description,total_price,component_status from component_info where component_id in (select component_id from cart where user_id in ?)";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				componentsList.add(new Components(rs.getString(COMPONENTNAME), rs.getString(CATEGORYNAME), rs.getString(DESCRIPTION), rs.getDouble(TOTALPRICE),
						rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con, rs);
		}
		return componentsList;
	}

	public List<Cart> allCart() {
		List<Cart> cartList = new ArrayList<Cart>();
		String cart = "select cart_id,user_id,component_id from cart";
		Connection con = ConnectionUtil.getDbConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(cart);
			while (rs.next()) {
				Cart cart1 = new Cart(rs.getInt(USERID), rs.getInt(COMPONENTID));
				cartList.add(cart1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(stmt, con, rs);
		}
		return cartList;

	}

}
