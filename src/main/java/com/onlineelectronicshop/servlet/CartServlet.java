package com.onlineelectronicshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CartServlet() {
        super();
        }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			HttpSession session=request.getSession();
			String componentName=request.getParameter("compantName");
			Double price=Double.parseDouble(request.getParameter("price"));
			int compantId=Integer.parseInt(request.getParameter("componentId"));
			session.setAttribute("componentName", componentName);
			session.setAttribute("componentId",compantId);
			session.setAttribute("price", price);

			RequestDispatcher requestDispatch=request.getRequestDispatcher("insertCart.jsp");
			requestDispatch.forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
