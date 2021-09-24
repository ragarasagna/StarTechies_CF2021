package com.hsbc.dao;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.beans.Bugs;
import com.hsbc.beans.Users;

public interface ProjectDetailsDaoIntf {
	public List<Users> getTeamMembers(String projectName);
	public String getStartDate(String projectName);
	ArrayList<Bugs> getProjectBugsList(String projectName);

}
