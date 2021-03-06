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
import com.onlineelectronicshop.model.*;

@WebServlet("/ShowComponentServlet")
public class ShowComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowComponentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			ComponentDaoImpl comDao = new ComponentDaoImpl();
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			List<Components> componentList = comDao.showComponent();
			for (int i = 0; i < componentList.size(); i++) {
				Components comDao1 = componentList.get(i);
				session.setAttribute("componentName", comDao1.getComponentName());
				session.setAttribute("price", comDao1.getPrice());
				session.setAttribute("Category", comDao1.getCategoryName());

			}
			request.setAttribute("showComponent", componentList);
			RequestDispatcher requestDispatch = request.getRequestDispatcher("showComponents.jsp");
			requestDispatch.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
