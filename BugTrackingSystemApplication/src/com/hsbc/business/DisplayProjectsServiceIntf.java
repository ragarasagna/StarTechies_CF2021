package com.hsbc.business;

import java.util.List;

import com.hsbc.beans.Project;

public interface DisplayProjectsServiceIntf {
	public List<Project> fetchProjectNames(String pmId);
}
