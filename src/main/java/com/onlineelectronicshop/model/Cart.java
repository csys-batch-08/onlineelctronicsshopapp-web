package com.onlineelectronicshop.model;

import java.io.Serializable;
import java.util.Objects;

public class Cart implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cartId;
    private int userId;
	private int componentId;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getComponentId() {
		return componentId;
	}
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}
	public Cart(int userId, int componentId) {
		super();
		this.userId = userId;
		this.componentId = componentId;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", componentId=" + componentId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(componentId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return componentId == other.componentId && userId == other.userId;
	}
	
	
	
	
	
	
}
