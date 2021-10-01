package com.hsbc.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.beans.Bugs;
import com.hsbc.exceptions.BugNotReportedException;

public interface BugOperationsServiceIntf {

	public int reportNewBug(Bugs bug);

	public List<Bugs> testerProjectDetails(String emailId);

	public ArrayList<Bugs> fetchAssignedBug(String emailId);

	public void markForClose(String bugId);

	public ArrayList<Bugs> DisplayBugs(String projectName);

	public void closeBug(String bugId, String managerEmailId);

	public void assignBugToDeveloper(String developerName, String bugId);

}
