package com.hsbc.business;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.beans.Bugs;
import com.hsbc.dao.BugModelDao;
import com.hsbc.dao.BugModelDaoIntf;
import com.hsbc.exceptions.BugNotReportedException;

public class BugOperationsService implements BugOperationsServiceIntf {

	BugModelDaoIntf bugModel;

	public BugOperationsService() {
		bugModel = new BugModelDao();
	}

	@Override
	public List<Bugs> testerProjectDetails(String emailId) {

		List<Bugs> projects = bugModel.testerProjectDetails(emailId);
		return projects;
	}

	@Override
	public ArrayList<Bugs> fetchAssignedBug(String emailId) {
		ArrayList<Bugs> assignedBug = bugModel.fetchAssignedBug(emailId);
		return assignedBug;
	}

	@Override
	public void markForClose(String bugId) {
		bugModel.markForClose(bugId);
	}

	@Override
	public ArrayList<Bugs> DisplayBugs(String projectName) {
		ArrayList<Bugs> bugsList = bugModel.DisplayBugs(projectName);
		return bugsList;
	}

	@Override
	public void closeBug(String bugId, String managerEmailId) {
		bugModel.closeBug(bugId, managerEmailId);
	}

	@Override
	public int reportNewBug(Bugs bug) {

		try {
			bugModel.reportNewBug(bug);

		} catch (BugNotReportedException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void assignBugToDeveloper(String developerName, String bugId) {

		bugModel.assignBugToDeveloper(developerName, bugId);
	}

}
