package com.onlineelectronicshop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.onlineelectronicshop.model.Order;
import com.onlineelectronicshop.model.Components;
import com.onlineelectronicshop.model.User;
import com.onlineelectronicshop.util.ConnectionUtil;

public class OrderDaoImpl {
	//insert cart
public void  insertOrder(Order order) throws SQLException {
	ComponentDaoImpl comDao=new ComponentDaoImpl(); 
	UserDaoImpl userDaoImpl=new UserDaoImpl();
	String insertQuery = "insert into orders_table (user_id,component_id,quantity,total_price,address) values(?,?,?,?,?)";
Connection con=ConnectionUtil.getDbConnection();
PreparedStatement pstmt=null;
try {
pstmt=con.prepareStatement(insertQuery);

pstmt.setInt(1, order.getUserId());
pstmt.setInt(2, order.getComponentId());
pstmt.setInt(3, order.getQuantity());
pstmt.setDouble(4,order.getTotalPrice());
pstmt.setString(5, order.getAddress());
 pstmt.executeUpdate();
System.out.println("value inserted successfully");
}catch(SQLException e) {
	e.printStackTrace();
}


}

public ResultSet showOrder(int userId){
	Connection con=ConnectionUtil.getDbConnection(); 
	List<Order> orderList=new ArrayList<Order>();
	
	String query="select* from orders_table where order_status='Not delivered' and user_id='"+userId+"'order by order_date desc";
	try {
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
	
//		while(rs.next()) {
//		String date=rs.getString(7);
//		LocalDate localdate=LocalDate.parse(date);
//		Order order=new Order(rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5),rs.getString(6),localdate);
//		orderList.add(order);
//	}
		
       return rs;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return null;
	
}


public LocalDate findOrderDate(int userId) {
	 String query="select order_Date from orders_table where user_id='"+userId+"'";
	 Connection con=ConnectionUtil.getDbConnection();
		LocalDate orderDate=null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				orderDate=rs.getDate(1).toLocalDate();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	 return orderDate;
	 
}

public boolean updateStatus(int orderid){
	Connection con=ConnectionUtil.getDbConnection(); 
	
	String query="update orders_table set order_status='cancel' where order_id=?";
	
       
	boolean flag=false;
    try {
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, orderid);
		flag=pstmt.executeUpdate()>0;
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
	
}

public ResultSet orderList(){
	Connection con=ConnectionUtil.getDbConnection(); 
	List<Order> orderList=new ArrayList<Order>();
	
	String query="select* from orders_table";
	try {
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
	
//		while(rs.next()) {
//		String date=rs.getString(7);
//		LocalDate localdate=LocalDate.parse(date);
//		Order order=new Order(rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5),rs.getString(6),localdate);
//		orderList.add(order);
//	}
		
       return rs;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return null;
	
}

public boolean updateOrderStatus(int orderid){
	Connection con=ConnectionUtil.getDbConnection(); 
	
	String query="update orders_table set order_status='delivered' where order_id=?";
	
       
	boolean flag=false;
    try {
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, orderid);
		flag=pstmt.executeUpdate()>0;
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
	
}

public ResultSet CalculateAmount(Date fromDate,Date toDate) {
	Connection con=ConnectionUtil.getDbConnection(); 
	ResultSet rs=null;
String query="select component_id,sum(total_price) from orders_table where order_status='delivered' and order_date between ? and ? group by component_id";
try {
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setDate(1, new java.sql.Date(fromDate.getTime()));
	pstmt.setDate(2, new java.sql.Date(toDate.getTime()));
	rs = pstmt.executeQuery();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	return rs;
}


}
