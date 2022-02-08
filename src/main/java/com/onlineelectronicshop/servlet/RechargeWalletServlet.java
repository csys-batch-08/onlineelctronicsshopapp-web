package com.onlineelectronicshop.servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.WalletDaoImpl;
import com.onlineelectronicshop.model.User;

@WebServlet("/RechargeWalletServlet")

public class RechargeWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RechargeWalletServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		double amount = Integer.parseInt(request.getParameter("wallbal"));
		WalletDaoImpl walletDao = new WalletDaoImpl();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("CurentUser");
		int userId = user.getUserid();
		try {
			walletDao.updateWalletbalance(amount, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
