package com.hsbc.business;

import java.util.ArrayList;

import com.hsbc.beans.Bugs;
import com.hsbc.dao.ReportNewBugDao;
import com.hsbc.dao.ReportNewBugDaoIntf;
import com.hsbc.exceptions.BugNotReportedException;

public class ReportNewBugService implements ReportNewBugServiceIntf{

	ReportNewBugDaoIntf dao;
	public ReportNewBugService()
	{
		dao= new ReportNewBugDao();
	}
	@Override
	public void identifyNewBug(Bugs bug) {
		// TODO Auto-generated method stub
		
		try {
			dao.findNewBug(bug);
		} catch (BugNotReportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Override
	public ArrayList<String> getProjects() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
