package com.onlineelectronicshop.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineelectronicshop.daoImpl.UserDaoImpl;
import com.onlineelectronicshop.model.User;
import com.onlineelectronicshop.util.ConnectionUtil;


@WebServlet("/RegisterServlet")
/**
 * Servlet implementation class Register
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String name=request.getParameter("registername");
		String emailid=request.getParameter("registeremail");
		String password=request.getParameter("registerpassword");
		Long mobilenumber=Long.parseLong(request.getParameter("registercontactnumber"));
		String address=request.getParameter("registeraddress");
		System.out.println(name+emailid+password+mobilenumber+address);
		
		User user=new User(name,emailid,password,mobilenumber,address);
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		userDaoImpl.insertUser(user);
//		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");	
//		rd.forward(request, response);
		response.sendRedirect("login.jsp");
	}
}
