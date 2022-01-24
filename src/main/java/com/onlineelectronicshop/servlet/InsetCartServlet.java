package com.onlineelectronicshop.servlet;

import java.io.IOException;
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
import com.onlineelectronicshop.model.Order;
@WebServlet("/insertCartServlet")
/**
 * Servlet implementation class InsetCartServlet
 */
public class InsetCartServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int comId=Integer.parseInt(request.getParameter("compantId"));
		//int comId=(int)session.getAttribute("componentId");
		//System.out.println("com"+comId);
		session.setAttribute("compID", comId);
		String cname=request.getParameter("Cname");
		session.setAttribute("componentName" ,cname);
		//ComponentDaoImpl comDao=new ComponentDaoImpl(); 
		//UserDaoImpl userDaoImpl=new UserDaoImpl();
		int userId1=(int)session.getAttribute("userId");
		//System.out.println(userId1);
		CartDaoImpl cartDao=new CartDaoImpl();
       Cart cart=new Cart(userId1,comId);
       cartDao.insertCart(cart);
       session.setAttribute("componentnewId", cart);
       response.sendRedirect("viewCart.jsp");
	}

}
