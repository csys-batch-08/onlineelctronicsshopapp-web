package com.onlineelectronicshop.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlineelectronicshop.model.User;
import com.onlineelectronicshop.util.ConnectionUtil;

public class InvoiceDaoImpl {
	public ResultSet showBill(int user_id) {
		
		String showQuery = "select u.user_name,c.component_name,o.quantity,o.total_price,o.order_date from user_details"
				+ "         u join orders_table o on u.user_id=o.user_id"
				+ "         join component_info c on c.component_id=o.component_id where o.user_id="+user_id+" order by o.order_id desc";
		
		Connection con = ConnectionUtil.getDbConnection();
		ResultSet rs=null;
		try {
			Statement stmt = con.createStatement();
			 rs = stmt.executeQuery(showQuery);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	

}
}
