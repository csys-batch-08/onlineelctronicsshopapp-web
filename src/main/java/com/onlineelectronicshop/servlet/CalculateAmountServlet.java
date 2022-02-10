package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.OrderDaoImpl;

@WebServlet("/CalculateAmount")
public class CalculateAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CalculateAmountServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				Date fromDate = sdf.parse(request.getParameter("fromdate"));
				Date toDate = sdf.parse(request.getParameter("todate"));
				HttpSession session=request.getSession();
				session.setAttribute("FromDate", fromDate);
				session.setAttribute("ToDate", toDate);
				response.sendRedirect("ShowCalculateAmountServlet");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}	
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
