package com.hsbc.business;


import com.hsbc.beans.Users;
import com.hsbc.dao.RegistrationDao;
import com.hsbc.dao.RegsitrationDaoIntf;

public class RegistrationService implements RegistrationServiceIntf{

	RegsitrationDaoIntf dao=null;
	public RegistrationService()
	{
		dao= new RegistrationDao();
	}
	@Override
	public String registerUser(Users user) {
		return dao.registerUser(user);
	}

}
