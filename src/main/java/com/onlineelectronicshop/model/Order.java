package com.onlineelectronicshop.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Order implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderid;
	private int componentId;
	private int userId;
	private int quantity;
	private double totalPrice;
	private String address;
	private LocalDate orderDate;
	private String orderStatus;
	private String componentName;
	
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getComponentId() {
		return componentId;
	}
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Order(int componentId, int userId, int quantity, double totalPrice, String address, LocalDate orderDate) {
		super();
		this.componentId = componentId;
		this.userId = userId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.address = address;
		this.orderDate = orderDate;
	}
	public Order(int componentId, int userId, int quantity, double totalPrice, String address) {
		super();
		this.componentId = componentId;
		this.userId = userId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.address = address;
	}
	
	public Order(int orderid, int componentId, int userId, int quantity, double totalPrice, String address,
			LocalDate orderDate) {
		super();
		this.orderid = orderid;
		this.componentId = componentId;
		this.userId = userId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.address = address;
		this.orderDate = orderDate;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderid, int componentId, int userId, int quantity, double totalPrice, String address, LocalDate orderDate,
			String orderStatus) {
		
		this.orderid = orderid;
		this.componentId = componentId;
		this.userId = userId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.address = address;
		this.orderDate = orderDate;
		this.orderStatus=orderStatus;
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Order(int orderid, int componentId, int userId, int quantity, double totalPrice, String address,
			LocalDate orderDate, String orderStatus, String componentName) {
		super();
		this.orderid = orderid;
		this.componentId = componentId;
		this.userId = userId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.address = address;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.componentName = componentName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, componentId, quantity, totalPrice, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(address, other.address) && componentId == other.componentId && quantity == other.quantity
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& userId == other.userId;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", componentId=" + componentId + ", userId=" + userId + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + ", address=" + address + ", orderDate=" + orderDate + "]";
	}
	
	public void setComponents(Components component) {
		
	}
	
	
	
}