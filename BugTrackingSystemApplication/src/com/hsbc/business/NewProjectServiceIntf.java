package com.hsbc.business;

import java.util.List;

import com.hsbc.beans.Project;
import com.hsbc.beans.Users;

public interface NewProjectServiceIntf {
	String createNewProject(Project project, String userid);
	List<Users> getDevelopersList();
	List<String> getTestersList(String managerId);
	void createTeam(String[] teamMembers, String projectId);
}
