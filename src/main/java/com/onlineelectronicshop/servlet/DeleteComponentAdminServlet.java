package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineelectronicshop.daoImpl.ComponentDaoImpl;

/**
 * Servlet implementation class DeleteComponentAdminServlet
 */
@WebServlet("/DeleteComponentAdminServlet")
public class DeleteComponentAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteComponentAdminServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int componentID=Integer.parseInt(request.getParameter("componentId"));
		ComponentDaoImpl componentDaoImpl=new ComponentDaoImpl(); 
		componentDaoImpl.updateStatus(componentID);
		response.sendRedirect("admin.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
