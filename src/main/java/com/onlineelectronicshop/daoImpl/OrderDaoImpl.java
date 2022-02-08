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
	static final String ORDERID = "ORDER_ID";
	static final String COMPONENTID = "COMPONENT_ID";
	static final String COMPONENTNAME = "COMPONENT_NAME";
	static final String ADDRESS = "ADDRESS";
	static final String ORDERSTATUS = "ORDER_STATUS";
	static final String TOTALPRICE = "TOTAL_PRICE";
	static final String COMPONENTSTATUS = "COMPONENT_STATUS";
	static final String USERID = "USER_ID";
	static final String QUANTITY = "QUANTITY";
	static final String ORDERDATE = "ORDER_DATE";

	public void insertOrder(Order order) throws SQLException {
		String insertQuery = "insert into orders_table (user_id,component_id,quantity,total_price,address) values(?,?,?,?,?)";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insertQuery);

			pstmt.setInt(1, order.getUserId());
			pstmt.setInt(2, order.getComponentId());
			pstmt.setInt(3, order.getQuantity());
			pstmt.setDouble(4, order.getTotalPrice());
			pstmt.setString(5, order.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}

	}

	public List<Order> showOrder(int userId) {
		Connection con = ConnectionUtil.getDbConnection();
		List<Order> orderList = new ArrayList<Order>();
		ComponentDaoImpl comDao = new ComponentDaoImpl();

		Statement stmt = null;
		ResultSet rs = null;
		String query = "select order_id,user_id,component_id,quantity,total_price,address,order_date,order_status from orders_table where order_status='Not delivered' and user_id='"
				+ userId + "'order by order_date desc";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String componentName = comDao.findComponent(rs.getInt(COMPONENTID));
				Order order = new Order(rs.getInt(ORDERID), rs.getInt(COMPONENTID), rs.getInt(USERID),
						rs.getInt(QUANTITY), rs.getDouble(TOTALPRICE), rs.getString(ADDRESS),
						rs.getDate(ORDERDATE).toLocalDate(), rs.getString(ORDERSTATUS), componentName);

				orderList.add(order);

			}
			return orderList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(stmt, con, rs);
		}
		return orderList;

	}

	public LocalDate findOrderDate(int userId) {
		String query = "select order_Date from orders_table where user_id='" + userId + "'";
		Connection con = ConnectionUtil.getDbConnection();
		LocalDate orderDate = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				orderDate = rs.getDate(ORDERDATE).toLocalDate();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(stmt, con, rs);
		}
		return orderDate;

	}

	public boolean updateStatus(int orderid) {
		Connection con = ConnectionUtil.getDbConnection();

		String query = "update orders_table set order_status='cancel' where order_id=?";
		PreparedStatement pstmt = null;

		boolean flag = false;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderid);
			flag = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return flag;

	}

	public List<Order> orderList() {
		Connection con = ConnectionUtil.getDbConnection();
		List<Order> orderList = new ArrayList<Order>();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select order_id,user_id,component_id,quantity,total_price,address,order_date,order_status from orders_table";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Order order = new Order(rs.getInt(ORDERID), rs.getInt(COMPONENTID), rs.getInt(USERID),
						rs.getInt(QUANTITY), rs.getDouble(TOTALPRICE), rs.getString(ADDRESS),
						rs.getDate(ORDERDATE).toLocalDate(), rs.getString(ORDERSTATUS));

				orderList.add(order);

			}
			return orderList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(stmt, con, rs);
		}
		return orderList;
	}

	public boolean updateOrderStatus(int orderid) {
		Connection con = ConnectionUtil.getDbConnection();

		String query = "update orders_table set order_status='delivered' where order_id=?";
		PreparedStatement pstmt = null;

		boolean flag = false;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderid);
			flag = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		return flag;

	}

	public List<Order> CalculateAmount(Date fromDate, Date toDate) {
		Connection con = ConnectionUtil.getDbConnection();
		List<Order> orderList = new ArrayList<Order>();
		ResultSet rs = null;
		Order order = null;
		PreparedStatement pstmt = null;
		String query = "select component_id,sum(total_price) from orders_table where order_status='delivered' and order_date between ? and ? group by component_id";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, new java.sql.Date(fromDate.getTime()));
			pstmt.setDate(2, new java.sql.Date(toDate.getTime()));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				order = new Order();
				order.setComponentId(rs.getInt(COMPONENTID));
				order.setTotalPrice(rs.getDouble(TOTALPRICE));
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con, rs);
		}
		return orderList;

	}

}
