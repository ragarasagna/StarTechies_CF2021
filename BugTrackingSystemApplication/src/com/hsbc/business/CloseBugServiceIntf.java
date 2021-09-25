package com.hsbc.business;

import java.util.ArrayList;

public interface CloseBugServiceIntf {

	ArrayList<String> getDevelopers(String projectName);
	 void closeBug(String bugId, String manageremailId);
}
