package com.onlineelectronicshop.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Invoice {

	
	private User user;
	private Order order;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Invoice(User user, Order order) {
		super();
		this.user = user;
		this.order = order;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(order, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Objects.equals(order, other.order) && Objects.equals(user, other.user);
	}
	
}