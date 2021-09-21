package com.login.dao;

import java.sql.Timestamp;
import java.util.Date;

public interface LoginDaoIntf {
    
	public String authenticateUser(String emailId, String password);
	public boolean checkPassword(String plainPassword,String hashedPassword);
	public void updateLoginTime(String emailId);
	public Date getLastLoginTime(String emailId);
}
