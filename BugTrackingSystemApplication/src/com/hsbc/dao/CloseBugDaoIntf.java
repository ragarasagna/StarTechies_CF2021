package com.hsbc.dao;

import java.util.ArrayList;

public interface CloseBugDaoIntf {

	void closeBug(String bugId, String managerName);
	ArrayList<String> fetchDevelopers(String projectName);
}
