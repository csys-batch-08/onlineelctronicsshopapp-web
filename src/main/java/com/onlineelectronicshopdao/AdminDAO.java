package com.onlineelectronicshopdao;

import com.onlineelectronicshop.model.User;

public interface AdminDAO {

	public User validateAdmin(String email,String password);
}
