package com.hsbc.business;

import java.util.List;

import com.hsbc.beans.Project;
import com.hsbc.dao.DisplayProjectsPmDao;
import com.hsbc.dao.DisplayProjectsPmDaoIntf;

public class DisplayProjectsService implements DisplayProjectsServiceIntf{

	DisplayProjectsPmDaoIntf dao;
	public DisplayProjectsService()
	{
		dao= new DisplayProjectsPmDao() ;
	}
			
	
	
	@Override
	public List<Project> fetchProjectNames(String emailId) {
		// TODO Auto-generated method stub
		List<Project> projects= dao.projectNames(emailId);
		return projects;
	}

}
