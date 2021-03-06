package com.hsbc.business;

import java.util.List;

import com.hsbc.beans.Project;
import com.hsbc.beans.Users;
import com.hsbc.dao.ProjectModelDao;
import com.hsbc.exceptions.projectNotAddedException;

public class ProjectOperationsService implements ProjectOperationsServiceIntf {

	ProjectModelDao projectModel;

	public ProjectOperationsService() {
		projectModel = new ProjectModelDao();
	}

	@Override
	public String projectName(String emailId) {

		String projectName = projectModel.projectName(emailId);
		return projectName;
	}

	@Override
	public List<Project> projectNames(String emailId) {

		List<Project> projectNames = projectModel.projectNames(emailId);
		return projectNames;
	}

	@Override
	public Project addProject(Project p, String emailId) {

		String message = null;
		Project project = null;
		try {
			project = projectModel.addProject(p, emailId);
		} catch (projectNotAddedException e) {
			e.printStackTrace();
		}
		return project;
	}

	@Override
	public void assignTeamMembers(String[] list, String projectId) {

		projectModel.assignTeamMembers(list, projectId);
	}

	@Override
	public List<Users> getTeamMembers(String projectName) {

		List<Users> teamList = projectModel.getTeamMembers(projectName);
		return teamList;
	}

	@Override
	public String getManagerName(String projectName) {

		String managerName = projectModel.getManagerName(projectName);
		return managerName;
	}

	@Override
	public String getStartDate(String projectName) {

		String startDate = projectModel.getStartDate(projectName);
		return startDate;
	}

	@Override
	public List<String> fetchTesters(String projectManagerEmailId) {
		List<String> testers = projectModel.fetchTesters(projectManagerEmailId);
		return testers;
	}

	@Override
	public List<Users> fetchDevelopers() {
		List<Users> developers = projectModel.fetchDevelopers();
		return developers;
	}

}
