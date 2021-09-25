package com.hsbc.dao;

import com.hsbc.beans.Bugs;
import java.lang.Exception;
import java.util.ArrayList;

import com.hsbc.exceptions.BugNotReportedException;

public interface ReportNewBugDaoIntf {

	int findNewBug(Bugs bug) throws BugNotReportedException;
	ArrayList<String> fetchProjects();
}
