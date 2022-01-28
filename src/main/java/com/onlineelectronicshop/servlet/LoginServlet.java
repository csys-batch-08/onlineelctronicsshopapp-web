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

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter pw=response.getWriter();
		
		Connection con=ConnectionUtil.getDbConnection();
		
		String emailid=request.getParameter("loginemail");
		session.setAttribute("emailId",emailid);
		
		String password=request.getParameter("loginpassword");
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		int userId=userDaoImpl.findUserId(emailid);
		session.setAttribute("userId", userId);
		
		
		
		//System.out.println(userId);
//		
		//System.out.println("hello"+emailid+password);
		User Currentuser=userDaoImpl.validateUser(emailid,password);
		//System.out.println(Currentuser.getUserid()+"userid");
		
		String userName=Currentuser.getUserName();
		session.setAttribute("userName", userName);
	
		session.setAttribute("CurentUser", Currentuser);
		//System.out.println(Currentuser.getWallet()+"Second Amount");
	
		//System.out.println(Currentuser.getRole()+"Second role");
	//	try {
		if(Currentuser.getRole().equals("user")) {

		   
			session.setAttribute("CurrentUser",Currentuser);
			session.setAttribute("userId", Currentuser.getUserid());
			//doGet(request, response);
		//	pw.write(Currentuser.getUserName());
     	//	pw.write("welcome");
     		response.sendRedirect("viewHomePage.jsp");
		}

		else if(Currentuser.getRole().equals("admin")){
				response.sendRedirect("admin.jsp");
				pw.write("welcome admin");
				}	
//		else
//		{
//		 throw new  FoundException();
//		}
//		}catch(FoundException e)
//		{
//			session.setAttribute("invalid", e.getMessage());
//			response.sendRedirect("login.jsp");
//		}
	}

}
