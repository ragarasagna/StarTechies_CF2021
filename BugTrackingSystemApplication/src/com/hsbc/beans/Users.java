package com.hsbc.beans;

import java.sql.Timestamp;

public class Users extends ImportedUsers{
	private String password;
	private Timestamp lastLogin;
	int projectCounter;
	public Users() {super();}
	public Users(String userName,String role)
	{
		super(userName,role);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getProjectCounter() {
		return projectCounter;
	}

	public void setProjectCounter(int projectCounter) {
		this.projectCounter = projectCounter;
	}

}
