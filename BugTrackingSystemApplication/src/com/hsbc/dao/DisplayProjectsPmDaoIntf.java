package com.hsbc.dao;

import java.util.List;

import com.hsbc.beans.Project;

public interface DisplayProjectsPmDaoIntf {
	public List<Project> projectNames(String userId);
}
