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
import com.onlineelectronicshop.daoImpl.UserDaoImpl;
import com.onlineelectronicshop.model.Components;
import com.onlineelectronicshop.model.Order;

@WebServlet("/OffersServlet")
public class OffersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OffersServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());

			HttpSession session = request.getSession();
			ComponentDaoImpl comDao = new ComponentDaoImpl();
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			List<Order> order = comDao.offers();
			List<Components> componentList = comDao.showComponent();
			for (int i = 0; i < order.size(); i++) {

				Components comDao1 = componentList.get(i);
				session.setAttribute("componentName", comDao1.getComponentName());
				session.setAttribute("price", comDao1.getPrice());
				session.setAttribute("Category", comDao1.getCategoryName());
			}
			request.setAttribute("offer", order);
			RequestDispatcher requestDispatch = request.getRequestDispatcher("offer.jsp");
			requestDispatch.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
