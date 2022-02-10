package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.ComponentDaoImpl;
import com.onlineelectronicshop.model.Components;

/**
 * Servlet implementation class SearchComponentServlet
 */
@WebServlet("/SearchComponentServlet")
public class SearchComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchComponentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String component=request.getParameter("search");
			ComponentDaoImpl compontDao=new ComponentDaoImpl();
			List<Components>ShowComponent=compontDao.showComponent(component);
			for(int i=0;i<ShowComponent.size();i++) {
				Components user=ShowComponent.get(i);
				if(user.getComponentName().equalsIgnoreCase(component))
				{
					ShowComponent.add(user);	
				}
				else if(user.getCategoryName().equalsIgnoreCase(component))
				{
					ShowComponent.add(user);
				}
			}
			
			HttpSession session=request.getSession();
			request.setAttribute("list",ShowComponent);
			RequestDispatcher requestDispatch=request.getRequestDispatcher("searchComponents.jsp");
			requestDispatch.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
