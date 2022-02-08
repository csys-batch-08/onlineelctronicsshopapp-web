package com.onlineelectronicshop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;



import com.onlineelectronicshop.model.User;
import com.onlineelectronicshop.util.ConnectionUtil;


public class UserDaoImpl {
	static final String USERID="USER_ID";
	static final String USERNAME="USER_NAME";
	static final String EMAILID="EMAIL_ID";
	static final String PASSWORD="PASSWORD";
	static final String CONTACTNUMBER="CONTACT_NUMBER";
	static final String ADDRESS="ADDRESS";
	static final String ROLE="ROLE";
	static final String WALLET="WALLET";

	
	public void insertUser(User user) {
		String insertQuery = "insert into user_details(user_name,email_id,password,contact_number,address) values(?,?,?,?,?)";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getEmailId());
			pstmt.setString(3, user.getPassword());
			pstmt.setLong(4, user.getContactNumber());
			pstmt.setString(5, user.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			
				conUtil.closePreparedStatement(pstmt, con);
			
		}

	}

	public  User validateUser(String emailId, String password) {
		String validateQuery ="select user_id,user_name,email_id,password,contact_number,address,role,wallet from user_details where email_id='"+emailId+"' and password='"+password+"'";
				
		Connection con = ConnectionUtil.getDbConnection();
		User user = null; 
		ResultSet rs=null;
		Statement st=null;
		
		try {
		  st = con.createStatement();
			rs = st.executeQuery(validateQuery);
			if (rs.next()) {
				 
				user = new User(rs.getInt(USERID),rs.getString(USERNAME),emailId, password, rs.getLong(CONTACTNUMBER),rs.getString(ADDRESS),rs.getString(ROLE),rs.getDouble(WALLET));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closeStatement(st, con, rs);
		}
		return user;

	}
	

	public void update(String update) {
		String updatequery = "update user_details set password=? where email_id=?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(updatequery);
			pstmt.setString(1, update.split(",")[0]);
			pstmt.setString(2, update.split(",")[1]);
			int i = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		

	}

	public void deleteUser(String delete) {
		String deleteQuery = "delete from user_details where email_id=?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);
			pstmt.setString(1, delete);
			int i = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int findUserId(String emailId) {
		String findUserId = "select user_id from user_details where email_id='" +emailId + "'";
		Connection con = ConnectionUtil.getDbConnection();
		Statement stmt=null;
		ResultSet rs=null;
		 int userId=0 ;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(findUserId);
			if (rs.next()) {

				userId = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closeStatement(stmt, con, rs);
		}
		return userId;

	}

	public  List<User> showAllUser() {
		List<User> UsersList = new ArrayList<User>();

		String showQuery = "select user_id,user_name,email_id,password,contact_number,address,role,wallet from user_details where role='user'";
		Connection con = ConnectionUtil.getDbConnection();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(showQuery);
			while (rs.next()) {

				UsersList.add(
						new User(rs.getString(USERNAME), rs.getString(EMAILID), rs.getString(PASSWORD), rs.getLong(CONTACTNUMBER), rs.getString(ADDRESS),rs.getString(ROLE),rs.getDouble(WALLET)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closeStatement(stmt, con, rs);
		}
		
		return UsersList;

		
	}
	

	
	public User findUser(int userId) {
		String findUser = "select user_id,user_name,email_id,password,contact_number,address,role,wallet from user_details where USER_ID=?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt=null;
		User user = null;
		ResultSet rs=null;
		try {
			pstmt = con.prepareStatement(findUser);
			pstmt.setInt(1, userId);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				
				user = new User( rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),rs.getString(6));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closePreparedStatement(pstmt, con, rs);
		}
		return user;

	}
	public List<User> myProfile(int userId){
		List<User> UsersList = new ArrayList<User>();
		String profile="select user_name,email_id,password,contact_number,address,wallet from user_details where user_id=?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			pstm = con.prepareStatement(profile);
			pstm.setInt(1, userId);
			rs = pstm.executeQuery();
			while(rs.next()) {
				User user=new User(rs.getString(USERNAME),rs.getString(EMAILID),rs.getString(PASSWORD),rs.getLong(CONTACTNUMBER),rs.getString(ADDRESS),rs.getString(ROLE),rs.getInt(USERID));
				UsersList.add(user);
			}
	}catch(Exception e) {
		e.printStackTrace();
	}
		finally {
			ConnectionUtil.closePreparedStatement(pstm, con, rs);
		}
	
return UsersList;
}
	
}