package com.onlineelectronicshop.exception;

public class FoundException extends Exception {
    
	@Override
	public String getMessage()
	{
		return "invalid username and password";
	}
	
}
