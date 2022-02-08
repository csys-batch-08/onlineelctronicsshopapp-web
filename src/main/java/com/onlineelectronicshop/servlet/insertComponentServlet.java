package com.onlineelectronicshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineelectronicshop.daoImpl.ComponentDaoImpl;
import com.onlineelectronicshop.model.Components;

/**
 * Servlet implementation class insertComponentServlet
 */
@WebServlet("/insertComponentServlet")
public class insertComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 
    public insertComponentServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String componentName=request.getParameter("componentName");
		String categoryName=request.getParameter("categoryName");
		String description=request.getParameter("description");
		Double price=Double.parseDouble(request.getParameter("price"));
		String available=request.getParameter("available" );
		String image=request.getParameter("componentImage");
	    Components component=new Components(componentName,categoryName,description,price,available,image);
		ComponentDaoImpl comDao=new ComponentDaoImpl();
		comDao.insertComponent(component);
		response.sendRedirect("viewComponent.jsp");
		doGet(request, response);
	}

}
