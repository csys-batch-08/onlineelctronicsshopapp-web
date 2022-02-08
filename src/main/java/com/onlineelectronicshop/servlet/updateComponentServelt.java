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

public class updateComponentServelt extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComponentDaoImpl comDao=new ComponentDaoImpl();
		HttpSession session=request.getSession();
		String componentName=request.getParameter("component");
		double newPrice2=Double.parseDouble(request.getParameter("newPrice"));
		try {
			comDao.updateComponent(newPrice2, componentName);
			response.sendRedirect("admin.jsp");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
	
	}
	

}
