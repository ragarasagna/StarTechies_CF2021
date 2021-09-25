package com.hsbc.business;

import java.util.List;

import com.hsbc.beans.Project;
import com.hsbc.beans.Users;
import com.hsbc.dao.NewProjectDao;
import com.hsbc.dao.NewProjectDaoIntf;

public class NewProjectService implements NewProjectServiceIntf{
	NewProjectDaoIntf dao;
	public NewProjectService()
	{
		dao=new  NewProjectDao();
	}
	@Override
	public String createNewProject(Project project, String userid) {
		// TODO Auto-generated method stub
		String message=dao.addProject(project, userid);
		return message;
	}

	@Override
	public List<Users> getDevelopersList() {
		// TODO Auto-generated method stub
		List<Users> developers= dao.fetchDevelopers();
		return developers;
	}

	@Override
	public List<String> getTestersList(String managerId) {
		// TODO Auto-generated method stub
		List<String> testers=dao.fetchTesters(managerId);
		return testers;
	}

	@Override
	public void createTeam(String[] teamMembers, String projectId) {
		// TODO Auto-generated method stub
		dao.assignTeamMembers(teamMembers, projectId);;
		
	}
}
