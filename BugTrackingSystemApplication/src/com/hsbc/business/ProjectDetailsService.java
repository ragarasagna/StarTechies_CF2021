package com.hsbc.business;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.beans.Bugs;
import com.hsbc.beans.Users;
import com.hsbc.dao.ProjectDetailsDao;
import com.hsbc.dao.ProjectDetailsDaoIntf;

public class ProjectDetailsService implements ProjectDetailsServiceIntf{
	ProjectDetailsDaoIntf dao;
public ProjectDetailsService()
{
	dao= new ProjectDetailsDao();
}
	@Override
	public List<Users> fetchTeamDetails(String projectName) {
		// TODO Auto-generated method stub
		List<Users> teamDetails= dao.getTeamMembers(projectName);
		return teamDetails;
	}
	@Override
	public String fetchStartDate(String projectName) {
		// TODO Auto-generated method stub
		String str= dao.getStartDate(projectName);
		return str;
	}
	@Override
	public ArrayList<Bugs> fetchBugsList(String projectName) {
		// TODO Auto-generated method stub
		ArrayList<Bugs> bugsList= dao.getProjectBugsList(projectName);
		return bugsList;
	}

}
