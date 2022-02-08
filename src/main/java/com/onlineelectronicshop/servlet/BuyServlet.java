package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.OrderDaoImpl;
import com.onlineelectronicshop.daoImpl.WalletDaoImpl;
import com.onlineelectronicshop.model.Order;

@WebServlet("/BuyServlet")
/**
 * Servlet implementation class OrderServlelt
 */
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		int compid = (int) session.getAttribute("componentId");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String address = request.getParameter("address");
		Double price1 = (Double) session.getAttribute("price");
		double totalPrice = (price1 * quantity);
		WalletDaoImpl walletDao = new WalletDaoImpl();
		int userWallet = 0;
		double wallbalance = userWallet - totalPrice;
		try {
			userWallet = walletDao.walletBalance(userId);
			if (userWallet > totalPrice) {
				double Blanceamount = userWallet - totalPrice;
				session.setAttribute("wallbal", Blanceamount);
				session.setAttribute("totalprice", totalPrice);
				walletDao.updateWallet(Blanceamount, userId);
				OrderDaoImpl orderDao = new OrderDaoImpl();
				Order order = new Order(compid, userId, quantity, totalPrice, address);
				orderDao.insertOrder(order);
				response.sendRedirect("orderSuccess.jsp");
			} else {
				response.getWriter().println("low balance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
