package com.onlineelectronicshopdao;


import java.util.List;



public interface UserDAO {
	public void insertUser(UserDAO userDAO);
	public UserDAO validateUser(String emailId,String password);
	public void update(String update);
	public void deleteUser(String delete);
	public int findUserId(String userName);
	public List<UserDAO> showAllUser();
	public int walletBalance(int id);
	public int updateWallet(int amount,int userId);

}
