package com.hsbc.business;

import java.util.ArrayList;

import com.hsbc.dao.CloseBugDao;
import com.hsbc.dao.CloseBugDaoIntf;

public class CloseBugService implements CloseBugServiceIntf{

	CloseBugDaoIntf dao;
	public CloseBugService()
	{
		dao=new CloseBugDao();
	}
	@Override
	public ArrayList<String> getDevelopers(String projectName) {
		// TODO Auto-generated method stub
		ArrayList<String> developers= dao.fetchDevelopers(projectName);
		return developers;
	}
	@Override
	public void closeBug(String bugId, String manageremailId) {
		// TODO Auto-generated method stub
		dao.closeBug(bugId, manageremailId);
	}

}
