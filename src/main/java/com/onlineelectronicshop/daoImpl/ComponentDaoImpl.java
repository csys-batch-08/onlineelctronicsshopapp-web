package com.onlineelectronicshop.daoImpl;


	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

import com.onlineelectronicshop.model.Components;
import com.onlineelectronicshop.util.ConnectionUtil;

	public class ComponentDaoImpl {
		
public void insertCmponent(Components component) {
	String insertQuery=" insert into component_info (component_name,category_name,description,total_price,picture)values(?,?,?,?,?)";
	Connection con=ConnectionUtil.getDbConnection();
	PreparedStatement pstmt = null;
	try {
		pstmt=con.prepareStatement(insertQuery);
		
		pstmt.setString(1, component.getComponentName());
		pstmt.setString(2, component.getCategoryName());
		pstmt.setString(3, component.getDescription());
		pstmt.setDouble(4, component.getPrice());
		pstmt.setString(5, component.getImage());
		pstmt.executeUpdate();
		System.out.println("value inserted scucccessfully");
	}catch
		(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted in the table");
		}
	
}
		public List<Components> showComponent(){
			List<Components> componentsList=new ArrayList<Components>();
			
				try {
				String showQuery="select component_id,component_name,category_name,description,total_price,status,picture from component_info";
				Connection con=ConnectionUtil.getDbConnection();
			    Statement stmt=con.createStatement();
			    ResultSet rs=stmt.executeQuery(showQuery);
			    while(rs.next()) {
			    	Components component=new Components(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7));
			    	componentsList.add(component);                         
			    }
			    return componentsList;			                          
			    }catch(SQLException e) {	
			    			e.printStackTrace();
			    }
				return componentsList;
				}
				
		
		public List<Components> showComponent(String search){
			List<Components> componentsList=new ArrayList<Components>();
			
				try {
				String showQuery="select component_id,component_name,category_name,description,total_price,status,picture from component_info where component_name like '%"+search+"%' or category_name like '%"+search+"%'";
				Connection con=ConnectionUtil.getDbConnection();
			    Statement stmt=con.createStatement();
			    ResultSet rs=stmt.executeQuery(showQuery);
			    while(rs.next()) {
			    	Components component=new Components(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7));
			    	componentsList.add(component);                         
			    }
			    return componentsList;			                          
			    }catch(SQLException e) {	
			    			e.printStackTrace();
			    }
				return componentsList;
				}
				
		
		public  int findComponentId(String ComponentName)
		{
			String query="select component_id from component_info where component_name='"+ComponentName+"'";
			Connection con=ConnectionUtil.getDbConnection();
			Statement stmt;
			int componentId=0;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(query);				
				if(rs.next())
				{
				componentId=rs.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return componentId;
			
		}
		public String findComponent(int componentId) {
			String query="select component_name from component_info where component_id=?";
		Connection con=ConnectionUtil.getDbConnection();
		String name=null;
		System.out.println(componentId);
		
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, componentId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				name=(rs.getString(1));
				System.out.println(name);
			}}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return name;
			
		}
		

		public void updateComponent(Double price,String componentName) throws ClassNotFoundException, SQLException {
			String updateQuery = "update component_info set total_price=?  where component_name=?";

			Connection con = ConnectionUtil.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement(updateQuery);
			pstmt.setDouble(1, price);
			pstmt.setString(2, componentName);
			
			
			int i = pstmt.executeUpdate();
			System.out.println(i + "row updated");
			pstmt.close();
			con.close();
		}	
		public void deleteComponent(int ComponentId) throws SQLException {
			String deleteQuery = "delete from component_info where component_id=?";

			Connection con = ConnectionUtil.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, (ComponentId));
			int i = pstmt.executeUpdate();
			System.out.println(i + "row deleted");
			pstmt.close();
			con.close();
		}
		public void updateAvailable(String ComponetName) {
			String updateQuery="update component_info set status='not available' where component_name=?";
		Connection con=ConnectionUtil.getDbConnection();
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(updateQuery);
				pstmt.setString(1, ComponetName);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public Double findPrice(int comId) {
			String query="select *from component_info where component_id='"+comId+"'";
			Connection con=ConnectionUtil.getDbConnection();
			//ComponentDao comDao=new ComponentDao();
			double price=0;
			Statement stmt=null;
			try {
				 stmt=con.createStatement();
				 ResultSet rs=stmt.executeQuery(query);
				 if(rs.next())
					{
						price=rs.getDouble(5);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return price;
	}
		
		public ResultSet findCompoent(int comId) {
			String query="select *from component_info where component_id='"+comId+"'";
			Connection con=ConnectionUtil.getDbConnection();
			//ComponentDao comDao=new ComponentDao();
			double price=0;
			Statement stmt=null;
			try {
				 stmt=con.createStatement();
				 ResultSet rs=stmt.executeQuery(query);
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
//		
		
		
		public List<Components> findCategory() {
			 List<Components> componentsList=new ArrayList<Components>();
			 String query="select * from component_info";
			 Connection con=ConnectionUtil.getDbConnection();
			 Components component=null;
		 	        Statement stmt;
					try {
						stmt = con.createStatement();
						ResultSet rs;
						rs = stmt.executeQuery(query);
					   while(rs.next()) {
 	
                   try {
                 component = new Components(rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(7));
                     } catch (SQLException e) {

}
 	componentsList.add(component);                         
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			return componentsList ;
		 }		

//		public  Components findComponent(String ComponentName)
//		{
//			String query="select * from component_info where component_name='"+ComponentName+"'";
//			Connection con=ConnectionUtil.getDbConnection();
//			Statement stmt;
//			Components component=null;
//			try {
//				stmt = con.createStatement();
//				ResultSet rs=stmt.executeQuery(query);				
//				if(rs.next())
//				{
//					component=rs.getInt(1),rs.get;
//				}
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return component;
//			
//		}

	}
		
		

