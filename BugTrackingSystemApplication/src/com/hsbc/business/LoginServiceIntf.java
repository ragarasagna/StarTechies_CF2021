package com.hsbc.business;

import java.util.Date;

public interface LoginServiceIntf {
	public String authenticateUser(String emailId, String password);
	public boolean checkPassword(String plainPassword,String hashedPassword);
	public void updateLoginTime(String emailId);
	public Date getLastLoginTime(String emailId);
	public int fetchProjectCounter(String emailId);
	
}
