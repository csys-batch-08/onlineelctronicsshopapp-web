package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.ComponentDaoImpl;

@WebServlet("/updateComponentServelt")
/**
 * Servlet implementation class updateComponentServelt
 */
public class updateComponentServelt extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComponentDaoImpl comDao=new ComponentDaoImpl();
		//System.out.println("hello");
		HttpSession session=request.getSession();
		double price=Double.parseDouble(request.getParameter("price"));
		//System.out.println(price);
		String comName=request.getParameter("componentName");
		//System.out.println(comId1);
		//System.out.println("asdfg"+comId1);
		try {
			comDao.updateComponent(price, comName);
			response.sendRedirect("admin.jsp");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
