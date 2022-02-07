package com.onlineelectronicshop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineelectronicshop.daoImpl.OrderDaoImpl;
import com.onlineelectronicshop.daoImpl.WalletDaoImpl;
import com.onlineelectronicshop.model.Order;
@WebServlet("/OrderServlet")
/**
 * Servlet implementation class OrderServlelt
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		int userId=(int) session.getAttribute("userId");
		//System.out.println(userId); 
				
		int compid=(int) session.getAttribute("compID");
		//System.out.println(compid);
		
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		session.setAttribute("quantity", quantity);
		//System.out.println(quantity);
		
		String address=request.getParameter("address");
		//System.out.println(address);
		
		
		//System.out.println(request.getParameter("price"));
		
		double price1=Double.parseDouble(request.getParameter("price"));	
		//System.out.println(price1);
		double totalPrice=(price1 * quantity);
		
		
		
		
		WalletDaoImpl walletDao=new WalletDaoImpl();
		int userWallet=0;
				System.out.println("userWallet"+userWallet);
		 double wallbalance=userWallet-totalPrice;
		 
//		 System.out.println("price"+price1);
//		 System.out.println("totalprice"+totalPrice);
//		 
//		 System.out.println("walletbalance"+wallbalance);
		 try {
		 userWallet = walletDao.walletBalance(userId);
		 //System.out.println(userWallet);
		 if(userWallet > totalPrice) {
		 double Blanceamount=userWallet - totalPrice;
		 //System.out.println(Blanceamount);
		 
		 session.setAttribute("wallbal",Blanceamount);
		 session.setAttribute("totalprice", totalPrice);
		walletDao.updateWallet(Blanceamount, userId);
		OrderDaoImpl orderDao=new OrderDaoImpl();			
		Order order=new Order(compid,userId,quantity,totalPrice,address);
		orderDao.insertOrder(order);		 
	response.sendRedirect("orderSuccess.jsp");
	 }
	 else {
		 response.getWriter().println("low balance");
	 }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		doGet(request, response);
	}

}
