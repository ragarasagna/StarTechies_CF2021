package com.hsbc.business;

import java.util.Date;

import com.hsbc.dao.LoginDaoIntf;
import com.hsbc.dao.Logindao;

public class LoginService implements LoginServiceIntf {

	LoginDaoIntf dao= null;
	public LoginService() {
		dao= new Logindao() ;
	}
	@Override
	public String authenticateUser(String emailId, String password) {
		
		return dao.authenticateUser(emailId, password);
	}
	@Override
	public boolean checkPassword(String plainPassword, String hashedPassword) {
		
		return dao.checkPassword(plainPassword, hashedPassword);
	}
	@Override
	public void updateLoginTime(String emailId) {
		
		dao.updateLoginTime(emailId);
	}
	@Override
	public Date getLastLoginTime(String emailId) {
		
		return dao.getLastLoginTime(emailId);
	}
	@Override
	public int fetchProjectCounter(String emailId) {
		
		return dao.fetchProjectCounter(emailId);
	}
			
			
}
