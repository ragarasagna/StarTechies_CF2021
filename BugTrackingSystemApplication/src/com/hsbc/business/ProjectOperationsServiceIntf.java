package com.hsbc.business;

import java.util.List;
import com.hsbc.beans.Project;
import com.hsbc.beans.Users;

public interface ProjectOperationsServiceIntf {

	public String projectName(String emailId);

	public List<Project> projectNames(String emailId);

	public Project addProject(Project p, String emailId);

	void assignTeamMembers(String[] list, String projectId);

	public List<Users> getTeamMembers(String projectName);

	public String getManagerName(String projectName);

	public String getStartDate(String projectName);

	public List<String> fetchTesters(String projectManagerEmailId);

	public List<Users> fetchDevelopers();

}
