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

import com.onlineelectronicshop.daoImpl.CartDaoImpl;
import com.onlineelectronicshop.model.Components;

/**
 * Servlet implementation class ProceedBuyServlet
 */
@WebServlet("/ProceedBuyServlet")
public class ProceedBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProceedBuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String componentName=request.getParameter("compantName");
		Double price=Double.parseDouble(request.getParameter("price"));
		int componentId=Integer.parseInt(request.getParameter("componentId"));
		
		
		int userId=(int) session.getAttribute("userId");
		CartDaoImpl cartDao=new CartDaoImpl();
		List<Components> componentsList=cartDao.fetchCart(userId);
		for(Components component:componentsList){
		
			
			session.setAttribute("componentName", componentName);
			session.setAttribute("componentId",componentId);
			session.setAttribute("price", price);
		}
		
		RequestDispatcher requestDispatch=request.getRequestDispatcher("BuyComponent.jsp");
		requestDispatch.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
