package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineelectronicshop.daoImpl.UserDaoImpl;
import com.onlineelectronicshop.model.User;


@WebServlet("/ShowUserServlet")
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UserDaoImpl userDao=new UserDaoImpl();			
		List<User> UsersList=userDao.showAllUser();
		request.setAttribute("listOfUser", UsersList);
		RequestDispatcher requestDispatch = request.getRequestDispatcher("showUser.jsp");
		requestDispatch.forward(request, response);
		
		
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
