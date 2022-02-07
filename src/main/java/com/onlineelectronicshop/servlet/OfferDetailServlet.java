package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.model.Components;

/**
 * Servlet implementation class OfferDetailServlet
 */
@WebServlet("/OfferDetailServlet")
public class OfferDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OfferDetailServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String componentName=request.getParameter("componentName");
		String categoryName=request.getParameter("categoryName");
		Double offerPrice=Double.parseDouble(request.getParameter("price"));
		Components component=new Components();
		component.setComponentName(componentName);
		component.setCategoryName(categoryName);
		component.setPrice(offerPrice);
		List<Components> componentList=new ArrayList<Components>();
		componentList.add(component);
		session.setAttribute("Offers",componentList);
		session.setAttribute("componentDetail", component);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("offerDetail.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
