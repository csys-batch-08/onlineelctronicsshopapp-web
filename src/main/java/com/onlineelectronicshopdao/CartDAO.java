package com.onlineelectronicshopdao;

import java.util.List;

import com.onlineelectronicshop.model.Cart;
import com.onlineelectronicshop.model.Components;
import com.onlineelectronicshop.model.User;

public interface CartDAO {
	
	public void  insertCart(CartDAO cartDAO);
	
	public List<CartDAO> viewCart(User currentUser);
	public void updateCart(String updateCart);
	public void deleteCart(String deleteCart);
	public CartDAO findCart(int cartId);
	public List<Cart> getCartById(int userId);
	public List<Components> fetchCart(int userId);
	public List<Cart> allCart();
	
	

}
