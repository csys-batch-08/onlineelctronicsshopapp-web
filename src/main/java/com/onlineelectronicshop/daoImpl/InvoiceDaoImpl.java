package com.onlineelectronicshop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineelectronicshop.model.Invoice;
import com.onlineelectronicshop.model.User;
import com.onlineelectronicshop.util.ConnectionUtil;

public class InvoiceDaoImpl {
	static final String COMPONENTNAME="COMPONENT_NAME";
	static final String DESCRIPTION="DESCRIPTION";
	static final String TOTALPRICE="TOTAL_PRICE";
	static final String USERNAME="USER_NAME";	
	static final String ORDERDATE="ORDER_DATE";
	static final String QUANTITY="quantity";
	
	
	public List<List<Object>> showBill(int userId) {
		Connection con = ConnectionUtil.getDbConnection();
		
		String showQuery = "select u.user_name,c.component_name,o.quantity,o.total_price,o.order_date from user_details"
				+ "         u join orders_table o on u.user_id=o.user_id"
				+ "         join component_info c on c.component_id=o.component_id where o.user_id=? order by o.order_id desc fetch first 1 row only";
		
		
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		
		List<Object> list = null;
		List<List<Object>> listObject=null;
        
		try {
			pstmt = con.prepareStatement(showQuery);
			pstmt.setInt(1,userId);
			rs = pstmt.executeQuery();

				 
			 listObject = new ArrayList<List<Object>>();
				while (rs.next()) {
					list = new ArrayList<Object>();
					list.add(rs.getString(USERNAME));
					list.add(rs.getString(COMPONENTNAME));
					list.add(rs.getInt(QUANTITY));
					list.add(rs.getDouble(TOTALPRICE));
					list.add(rs.getDate(ORDERDATE));
					listObject.add(list);
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closePreparedStatement(pstmt, con, rs);
		}
				return listObject;
}
}
