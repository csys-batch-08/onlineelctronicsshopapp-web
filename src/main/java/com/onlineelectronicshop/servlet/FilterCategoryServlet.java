package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.ComponentDaoImpl;
import com.onlineelectronicshop.model.Components;

/**
 * Servlet implementation class FilterCategoryServlet
 */
public class FilterCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search=request.getParameter("search");
		ComponentDaoImpl comDao=new ComponentDaoImpl();	
		List<Components> componentList=comDao.findCategory();
		 List<Components> List=new ArrayList<Components>();
         for(int i=0;i<componentList.size();i++) {
        	 Components component=componentList.get(i);
        	 if(component.getComponentName().equalsIgnoreCase(search)) {
        		 List.add(component);
        	 }
        	 else if(component.getCategoryName().equalsIgnoreCase(search)) {
        		 List.add(component);
        	 }
        	 for(int j=0;j<List.size();j++) {
        		 Components component1=List.get(j);
        		 
        	 }
        	 
        	 
         }
		HttpSession session=request.getSession();
		session.setAttribute("list", List);
		response.sendRedirect("search.jsp");
		
		
	}

}
