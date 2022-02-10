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
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CancelOrderServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			HttpSession session=request.getSession();
			int orderid=Integer.parseInt(request.getParameter("orderId"));
			double price=Double.parseDouble(request.getParameter("refundprice"));
			User user=(User)session.getAttribute("CurentUser");
			OrderDaoImpl orderDao=new OrderDaoImpl();	
			boolean b=orderDao.updateStatus(orderid);
			if(b) {
				WalletDaoImpl wallet=new WalletDaoImpl();
				
				boolean b1=wallet.refundWallet(price,user);
				if(b1) {
					session.setAttribute("cancel","Order cancelled and amount refunded successfully!!");
					response.sendRedirect("CancelOrderRefundServlet");
					
				}
				
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
