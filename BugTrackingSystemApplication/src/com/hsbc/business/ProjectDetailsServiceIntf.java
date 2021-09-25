package com.hsbc.business;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.beans.Bugs;
import com.hsbc.beans.Users;

public interface ProjectDetailsServiceIntf {

	List<Users> fetchTeamDetails(String projectName);
	public String fetchStartDate(String projectName);
	ArrayList<Bugs> fetchBugsList(String projectName);
}
