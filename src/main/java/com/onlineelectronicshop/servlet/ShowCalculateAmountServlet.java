package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.OrderDaoImpl;
import com.onlineelectronicshop.model.Order;

@WebServlet("/ShowCalculateAmountServlet")
public class ShowCalculateAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowCalculateAmountServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		Date fromDate = (Date) session.getAttribute("FromDate");
		Date toDate = (Date) session.getAttribute("ToDate");
		OrderDaoImpl orderDao = new OrderDaoImpl();
		List<Order> orderList = orderDao.CalculateAmount(fromDate, toDate);
		request.setAttribute("list2", orderList);
		RequestDispatcher requestDispatch = request.getRequestDispatcher("sales.jsp");
		requestDispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
