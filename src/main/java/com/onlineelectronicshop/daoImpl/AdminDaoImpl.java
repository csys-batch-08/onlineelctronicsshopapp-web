package com.onlineelectronicshop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineelectronicshop.model.Components;
import com.onlineelectronicshop.model.User;
import com.onlineelectronicshop.util.ConnectionUtil;

public class AdminDaoImpl {
public static User validateAdmin(String email,String password) {
	String validateQuery="select * from user_details where role='admin' and email_id='"+email+"'and password='"+password+"'";
	Connection con=ConnectionUtil.getDbConnection();
	User user=null;
	Statement st=null;
	ResultSet rs=null;
	try {
		st=con.createStatement();
		 rs=st.executeQuery(validateQuery);
		if(rs.next())
		{
			user=new User(rs.getString(2),email,password,Long.parseLong(rs.getString(5)),rs.getString(6));
		}
		
} catch (SQLException e) {
	e.printStackTrace();
}
	finally {
		ConnectionUtil.closeStatement(st, con, rs);
	}
return user;	
}
	    }
