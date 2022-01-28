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
	public void insertCart(Cart cart) {
		String insertQuery="insert into cart(user_id,component_id)values(?,?)";
		Connection con=ConnectionUtil.getDbConnection();
		PreparedStatement pstmt=null;
		try {
		pstmt=con.prepareStatement(insertQuery);
		
		pstmt.setInt(1, cart.getUserId());
		pstmt.setInt(2, cart.getComponentId());
		pstmt.executeUpdate();
		
		System.out.println("value inserted successfully");
	}catch(SQLException e) {
		e.printStackTrace();
	}


}
	
	public void updateCart(String updateCart) throws ClassNotFoundException, SQLException {
		String updateQuery = "update cart set quantity =? where item_id=?";

		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement(updateQuery);
		pstmt.setInt(1, Integer.parseInt(updateCart.split(",")[0]));
		pstmt.setInt(2, Integer.parseInt(updateCart.split(",")[1]));
		int i = pstmt.executeUpdate();
		System.out.println(i + "row updated");
		pstmt.close();
		con.close();
	}

	// delete cart

	public void deleteCart(String deleteCart)  {
		String deleteQuery = "delete from cart where user_id=?";

		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, Integer.parseInt(deleteCart));
			int i = pstmt.executeUpdate();
			System.out.println(i + "row deleted");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

		public  Order findCart(int cartId) {
			String query = "select * from order_items where item_id=?";

			Connection con = ConnectionUtil.getDbConnection();
			Order order = null;
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, cartId);

				ResultSet rs = pstmt.executeQuery(query);

				if (rs.next()) {
				 //cart=new Cart(rs.getInt(0),rs.getInt(1),rs.getInt(2),rs.getDouble(3));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return order;

		
	}
		
		public List<Components> fetchCart(int userId){
			List<Components> componentsList=new ArrayList<Components>();
			String query="select component_name,category_name,description,total_price,status from component_info where component_id in (select component_id from cart where user_id in ?)";
		    Connection con=ConnectionUtil.getDbConnection();
		    try {
		    	PreparedStatement pstmt=con.prepareStatement(query);
		    	pstmt.setInt(1, userId);
		    	ResultSet rs=pstmt.executeQuery();
		    	
		    	while(rs.next()) {
		    		componentsList.add(new Components(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5)));
		    	}}
		    	catch(SQLException e) {
		    		e.printStackTrace();
		    		
		    	}
		    	return componentsList;
		    }

		public List<Cart> allCart(){
			List<Cart> cartList=new ArrayList<Cart>();
			String cart="select cart_id,user_id,component_id from cart;";
			Connection con=ConnectionUtil.getDbConnection();
			
			try {
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(cart);
				while(rs.next()) {
					Cart cart1=new Cart(rs.getInt(2),rs.getInt(3));
					cartList.add(cart1);
				}}
				 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return cartList;
		
}
		
		
		}
