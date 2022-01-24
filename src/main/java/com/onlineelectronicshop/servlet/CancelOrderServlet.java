package com.onlineelectronicshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.OrderDaoImpl;
import com.onlineelectronicshop.daoImpl.WalletDaoImpl;
import com.onlineelectronicshop.model.User;


@WebServlet("/CancelOrderServlet")

/**
 * Servlet implementation class CancelOrderServlet
 */
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderServlet() {
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

		int orderid=Integer.parseInt(request.getParameter("orderid"));
		double price=Double.parseDouble(request.getParameter("refundprice"));
		User user=(User)session.getAttribute("CurentUser");
		OrderDaoImpl orderDao=new OrderDaoImpl();	
		boolean b=orderDao.updateStatus(orderid);
		if(b) {
			WalletDaoImpl wallet=new WalletDaoImpl();
			
			boolean b1=wallet.refundWallet(price,user);
			if(b1) {
				session.setAttribute("cancel", true);
				
				response.sendRedirect("cancelOrder.jsp");
				
			}
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
