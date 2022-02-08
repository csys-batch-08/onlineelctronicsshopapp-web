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

/**
 * Servlet implementation class UpdateShowComponentServlet
 */
@WebServlet("/UpdateShowComponentServlet")
public class UpdateShowComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateShowComponentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		ComponentDaoImpl comDao = new ComponentDaoImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List<Components> componentList = comDao.showComponent();
		request.setAttribute("showComponent", componentList);
		RequestDispatcher requestDispatch = request.getRequestDispatcher("showProductAdmin.jsp");
		requestDispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
