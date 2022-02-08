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
import com.onlineelectronicshop.daoImpl.OrderDaoImpl;
import com.onlineelectronicshop.daoImpl.UserDaoImpl;
import com.onlineelectronicshop.model.Order;
import com.onlineelectronicshop.model.User;

@WebServlet("/ShowOrderServlet")
public class ShowOrderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		OrderDaoImpl orderDao = new OrderDaoImpl();
		int userId = (int) session.getAttribute("userId");
		UserDaoImpl userDao = new UserDaoImpl();
		ComponentDaoImpl comDao = new ComponentDaoImpl();
		int componentId = 0;
		List<Order> orderList = orderDao.showOrder(userId);
		for (int i = 0; i < orderList.size(); i++) {
			Order order = orderList.get(i);

			componentId = order.getComponentId();
		}
		String componentName = comDao.findComponent(componentId);
		User user = userDao.findUser(userId);
		request.setAttribute("listOfOrder", orderList);
		request.setAttribute("UserName", user);
		RequestDispatcher requestDispatch = request.getRequestDispatcher("myOrder.jsp");
		requestDispatch.forward(request, response);
	}

}
