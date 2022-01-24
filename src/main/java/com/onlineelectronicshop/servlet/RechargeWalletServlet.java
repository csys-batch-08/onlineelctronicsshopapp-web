package com.onlineelectronicshop.servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.onlineelectronicshop.daoImpl.WalletDaoImpl;
import com.onlineelectronicshop.model.User;
@WebServlet("/RechargeWalletServlet")

/**
 * Servlet implementation class RechargeWalletServlet
 */
public class RechargeWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeWalletServlet() {
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
		// TODO Auto-generated method stub
		//String emailId=request.getParameter("emailId");
		double amount=Integer.parseInt(request.getParameter("wallbal"));
		//System.out.println(amount);
//		Double cardNumber=Double.parseDouble(request.getParameter("AccountNumber"));
//		System.out.println(cardNumber);
//		int cvv=Integer.parseInt(request.getParameter("cvv"));
//		System.out.println(cvv);

		
		WalletDaoImpl walletDao=new WalletDaoImpl();
		HttpSession session=request.getSession();
	User user=(User) session.getAttribute("CurentUser");
		//System.out.println(user.getUserid()+"userID");
		
		int userId=user.getUserid();
		try {
			walletDao.updateWalletbalance(amount, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 try {
////			double wallet=walletDao.walletBalance(userId);
//		
////		int addwallet=wallet+amount;
////		User updatewallet=new User(null,null,null,null,null,null,addwallet);
//
//		 }catch(SQLException e) {
//			 e.printStackTrace();
//		 }
		doGet(request, response);
	}

}
