package com.hsbc.beans;

import java.time.LocalDate;

public class Project {
private String projectId,projectName,projectDesc,projectStatus;
private LocalDate startDate;
public Project()
{
	
}
public Project(String projectId, String projectName, String projectDesc, String projectStatus, LocalDate startDate) {
	
	this.projectId = projectId;
	this.projectName = projectName;
	this.projectDesc = projectDesc;
	this.projectStatus = projectStatus;
	this.startDate = startDate;
}
public String getProjectId() {
	return projectId;
}
public void setProjectId(String projectId) {
	this.projectId = projectId;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getProjectDesc() {
	return projectDesc;
}
public void setProjectDesc(String projectDesc) {
	this.projectDesc = projectDesc;
}
public String getProjectStatus() {
	return projectStatus;
}
public void setProjectStatus(String projectStatus) {
	this.projectStatus = projectStatus;
}
public LocalDate getStartDate() {
	return startDate;
}
public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}

}