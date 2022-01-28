package com.onlineelectronicshopdao;

import com.onlineelectronicshop.model.User;

public interface WalletDAO {

	public int walletBalance(int id);
	public int updateWallet(Double amount,int userId);
	
	public void updateWalletbalance(Double amount,int userId);
	public boolean refundWallet(Double amount,User user);
	
	
}
