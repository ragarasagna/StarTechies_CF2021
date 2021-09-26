package com.hsbc.dao;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.beans.Bugs;
import com.hsbc.exceptions.BugNotReportedException;

public interface BugModelDaoIntf {
	
	public int reportNewBug(Bugs bug) throws BugNotReportedException;

	public List<Bugs> testerProjectDetails(String emailId);

	public ArrayList<Bugs> fetchAssignedBug(String emailId);

	public void markForClose(String bugId);

	public ArrayList<Bugs> DisplayBugs(String projectName);

	public void closeBug(String bugId, String managerEmailId);
	
	public void assignBugToDeveloper(String developerName, String bugId);

}
