package com.hsbc.business;

import java.util.ArrayList;

import com.hsbc.beans.Bugs;

public interface ReportNewBugServiceIntf {
void identifyNewBug(Bugs bug);
ArrayList<String> getProjects();
}
