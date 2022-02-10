package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineelectronicshop.daoImpl.ComponentDaoImpl;
import com.onlineelectronicshop.daoImpl.UserDaoImpl;
import com.onlineelectronicshop.model.Components;

/**
 * Servlet implementation class ShowInactiveComponentServlet
 */
@WebServlet("/ShowInactiveComponentServlet")
public class ShowInactiveComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowInactiveComponentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			ComponentDaoImpl comDao = new ComponentDaoImpl();
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			List<Components> componentList = comDao.showInactive();
			request.setAttribute("InactivecomponentList", componentList);
			RequestDispatcher requestDispatch = request.getRequestDispatcher("showInactiveComponent.jsp");
			requestDispatch.forward(request, response);

			doGet(request, response);
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
