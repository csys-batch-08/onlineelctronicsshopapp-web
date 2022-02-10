package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.UserDaoImpl;
import com.onlineelectronicshop.model.User;


@WebServlet("/MyProfileServlet")
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyProfileServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("CurentUser");
		UserDaoImpl daoImpl=new UserDaoImpl(); 
		List<User> UsersList =daoImpl.showAllUser();
		for(User user1:UsersList){
			if(user1.getUserName().equalsIgnoreCase(user.getUserName())){
				user=user1;
			}
		}
		List<User> newUser= new ArrayList<User>();
		newUser.add(user);
		session.setAttribute("listOfUser",newUser);
		RequestDispatcher requestDispatch = request.getRequestDispatcher("myProfile.jsp");
		requestDispatch.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
