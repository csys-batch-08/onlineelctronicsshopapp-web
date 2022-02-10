package com.onlineelectronicshop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineelectronicshop.model.Components;
import com.onlineelectronicshop.model.Order;
import com.onlineelectronicshop.util.ConnectionUtil;

public class ComponentDaoImpl {
	static final String COMPONENTID = "COMPONENT_ID";
	static final String COMPONENTNAME = "COMPONENT_NAME";
	static final String CATEGORYNAME = "CATEGORY_NAME";
	static final String DESCRIPTION = "DESCRIPTION";
	static final String TOTALPRICE = "TOTAL_PRICE";
	static final String PICTURE = "PICTURE";
	static final String COMPONENTSTATUS = "COMPONENT_STATUS";
	static final String QUANTITY = "quantity";

	public void insertComponent(Components component) {
		String insertQuery = " insert into component_info (component_name,category_name,description,total_price,component_status,picture)values(?,?,?,?,?,?)";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, component.getComponentName());
			pstmt.setString(2, component.getCategoryName());
			pstmt.setString(3, component.getDescription());
			pstmt.setDouble(4, component.getPrice());
			pstmt.setString(5, component.getAvailable());
			pstmt.setString(6, component.getImage());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}

	}

	public List<Components> showComponent() {
		List<Components> componentsList = new ArrayList<Components>();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String showQuery = "select component_id,component_name,category_name,description,total_price,component_status,picture "
					+ "from component_info where component_status='active'";
			pstmt = con.prepareStatement(showQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Components component = new Components(rs.getInt(COMPONENTID), rs.getString(COMPONENTNAME),
						rs.getString(CATEGORYNAME), rs.getString(DESCRIPTION), rs.getDouble(TOTALPRICE),
						rs.getString(COMPONENTSTATUS), rs.getString(PICTURE));
				componentsList.add(component);
			}
			return componentsList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(pstmt, con, rs);
		}
		return componentsList;
	}

	public List<Components> showInactive() {
		List<Components> componentsList = new ArrayList<Components>();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String showQuery = "select component_id,component_name,category_name,description,total_price,component_status,picture "
					+ "from component_info where component_status='Inactive'";
			pstmt = con.prepareStatement(showQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Components component = new Components(rs.getInt(COMPONENTID), rs.getString(COMPONENTNAME),
						rs.getString(CATEGORYNAME), rs.getString(DESCRIPTION), rs.getDouble(TOTALPRICE),
						rs.getString(COMPONENTSTATUS), rs.getString(PICTURE));
				componentsList.add(component);
			}
			return componentsList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(pstmt, con, rs);
		}
		return componentsList;
	}

	public List<Components> showComponent(String search) {
		List<Components> componentsList = new ArrayList<Components>();
		Connection con = ConnectionUtil.getDbConnection();
	PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String searchComponent="%"+search+"%";
		String searchCategory="%"+search+"%";	
		try {
			
			String showQuery = "select component_id,component_name,category_name,description,total_price,component_status,picture from "
					+ "component_info where component_name like ? or category_name like ?";

			pstmt = con.prepareStatement(showQuery);
			pstmt.setString(1, searchComponent);
			pstmt.setString(2, searchCategory);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Components component = new Components(rs.getInt(COMPONENTID), rs.getString(COMPONENTNAME),
						rs.getString(CATEGORYNAME), rs.getString(DESCRIPTION), rs.getDouble(TOTALPRICE),
						rs.getString(COMPONENTSTATUS), rs.getString(PICTURE));
				componentsList.add(component);
			}
			return componentsList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(pstmt, con, rs);
		}
		return componentsList;
	}

	public List<Order> offers() {
		String showQuery = "select c.component_id,c.component_name,c.category_name,c.description,c.total_price, sum(o.quantity) as quantity "
				+ "from component_info c join orders_table o on c.component_id=o.component_id group by (c.component_name,c.total_price,"
				+ "c.category_name,c.component_id,c.description) "
				+ "order by sum(quantity) fetch first 1 rows only ";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		List<Order> orderList = new ArrayList<Order>();
		try {
			preparedstatement = con.prepareStatement(showQuery);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				Components component = new Components(resultset.getInt(COMPONENTID), resultset.getString(COMPONENTNAME),
						resultset.getString(CATEGORYNAME), resultset.getString(DESCRIPTION),
						resultset.getDouble(TOTALPRICE));
				Order order = new Order();
				order.setComponents(component);
				order.setQuantity(resultset.getInt(QUANTITY));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedstatement, con, resultset);
		}
		return orderList;
	}

	public int findComponentId(String ComponentName) {
		String query = "select component_id from component_info where component_name=?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		int componentId = 0;
		try {
			preparedstatement = con.prepareStatement(query);
			rs = preparedstatement.executeQuery(query);
			if (rs.next()) {
				componentId = rs.getInt(1);
				ComponentName=rs.getString(2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedstatement, con, rs);
		}
		return componentId;
	}

	public String findComponent(int componentId) {
		String query = "select component_name from component_info where component_id=?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, componentId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				name = (rs.getString(COMPONENTNAME));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closePreparedStatement(pstmt, con, rs);
		}
		return name;

	}

	public void updateComponent(Double price, String componentName){
		String updateQuery = "update component_info set total_price=?  where component_name=?";
		PreparedStatement pstmt=null;
		Connection con = ConnectionUtil.getDbConnection();
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setDouble(1, price);
			pstmt.setString(2, componentName);

			int i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
		
	}

	public void updateStatus(int ComponentId) {
		String updateQuery = "update component_info set component_status='Inactive' where component_id=?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setInt(1, ComponentId);
			pstmt.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmt, con);
		}
	}

	public Double findPrice(int comId) {
		String query = "select component_id,component_name,category_name,description,total_price,component_status,picture from component_info where component_id=?";
		Connection con = ConnectionUtil.getDbConnection();
		double price = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery(query);
			if (rs.next()) {
				price = rs.getDouble(TOTALPRICE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(pstmt, con, rs);
		}
		return price;
	}

}
