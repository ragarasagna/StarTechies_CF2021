package com.hsbc.dao;

import java.util.List;

import com.hsbc.beans.Project;
import com.hsbc.beans.Users;

public interface NewProjectDaoIntf {
	String addProject(Project p, String userid);
	List<Users> fetchDevelopers();
	List<String> fetchTesters(String pmId);
	void assignTeamMembers(String[] list, String projectId);
}
