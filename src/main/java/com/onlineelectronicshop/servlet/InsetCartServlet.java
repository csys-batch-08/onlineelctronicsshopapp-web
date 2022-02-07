package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.CartDaoImpl;
import com.onlineelectronicshop.daoImpl.ComponentDaoImpl;
import com.onlineelectronicshop.daoImpl.UserDaoImpl;
import com.onlineelectronicshop.model.Cart;
import com.onlineelectronicshop.model.Components;
import com.onlineelectronicshop.model.Order;
@WebServlet("/insertCartServlet")
/**
 * Servlet implementation class InsetCartServlet
 */
public class InsetCartServlet extends HttpServlet {
	
	
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public InsetCartServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int comId=Integer.parseInt(request.getParameter("compantId"));
		//int comId=(int)session.getAttribute("componentId");
		//System.out.println("com"+comId);
		session.setAttribute("compID", comId);
		String cname=request.getParameter("Cname");
		session.setAttribute("componentName" ,cname);
		int userId1=(int)session.getAttribute("userId");

		CartDaoImpl cartDao=new CartDaoImpl();
       Cart cart=new Cart(userId1,comId);
       cartDao.insertCart(cart);
       session.setAttribute("componentnewId", cart);
       
       
	
       int userId=(int) session.getAttribute("userId");
       
       int compid=(int) session.getAttribute("compID");
       List<Components> componentsList=cartDao.fetchCart(userId);
       
       
       session.setAttribute("viewCart", componentsList);
   	RequestDispatcher requestDispatch=request.getRequestDispatcher("viewCart.jsp");
   	requestDispatch.forward(request, response);
       
   	
   	
   	
	}

}
