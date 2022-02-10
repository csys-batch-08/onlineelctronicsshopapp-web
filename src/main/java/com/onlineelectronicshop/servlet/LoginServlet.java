package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.UserDaoImpl;
import com.onlineelectronicshop.exception.FoundException;
import com.onlineelectronicshop.model.User;
import com.onlineelectronicshop.util.ConnectionUtil;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
			try {
				HttpSession session = request.getSession();
				PrintWriter pw = response.getWriter();
				Connection con = ConnectionUtil.getDbConnection();
				String emailid = request.getParameter("loginemail");
				session.setAttribute("emailId", emailid);
				String password = request.getParameter("loginpassword");
				UserDaoImpl userDaoImpl = new UserDaoImpl();
				int userId = userDaoImpl.findUserId(emailid);
				session.setAttribute("userId", userId);
				User Currentuser = userDaoImpl.validateUser(emailid, password);
				String userName = Currentuser.getUserName();
				session.setAttribute("userName", userName);
				session.setAttribute("CurentUser", Currentuser);
				if (Currentuser.getRole().equals("user")) {
					session.setAttribute("CurrentUser", Currentuser);
					session.setAttribute("userId", Currentuser.getUserid());
					response.sendRedirect("viewHomePage.jsp");
				}

				else if (Currentuser.getRole().equals("admin")) {
					response.sendRedirect("admin.jsp");
					pw.write("welcome admin");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}


