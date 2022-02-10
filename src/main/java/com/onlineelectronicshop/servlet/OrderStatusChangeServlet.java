package com.onlineelectronicshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineelectronicshop.daoImpl.OrderDaoImpl;


@WebServlet("/ChangeOrderStatusServelt")

public class OrderStatusChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderStatusChangeServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			int orderid=Integer.parseInt(request.getParameter("orderid"));
			OrderDaoImpl orderDao=new OrderDaoImpl();
			boolean b=orderDao.updateOrderStatus(orderid);
			if(b) {
				
				response.sendRedirect("OrderListServlet");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
