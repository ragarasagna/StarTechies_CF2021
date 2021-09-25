package com.hsbc.beans;


import java.time.LocalDate;

public class Bugs {
    private String bugId,bugTitle,bugDesc,projectName,createdBy,
    assignedTo,closedBy,bugStatus,severityLevel;
    private LocalDate openDate;
    private String markedForClosing;
    public Bugs() {}

    
    public Bugs(String bugid,String title, String status, String markedforclosing )
    {
    	this.bugId=bugid;
    	this.bugTitle=title;
    	this.bugStatus=status;
    	this.markedForClosing=markedforclosing;
    }
    public Bugs(String bugTitle, String bugDesc, String severityLevel) {
	
	this.bugTitle = bugTitle;
	this.bugDesc = bugDesc;
	this.severityLevel = severityLevel;
}
	public Bugs( String bugTitle, String bugStatus, String severityLevel, String description, String bugId, String markedforClosing)
    {
    	this.bugTitle=bugTitle;
    	this.bugStatus=bugStatus;
    	this.severityLevel=severityLevel;
    	this.bugDesc= description;
    	this.bugId=bugId;
    	this.markedForClosing= markedforClosing;
    }
	public Bugs(String bugId, String bugTitle, String bugDesc, String projectName, String createdBy, String assignedTo,
			String closedBy, String bugStatus, String severityLevel, LocalDate openDate, String markedForClosing) {
		this.bugId = bugId;
		this.bugTitle = bugTitle;
		this.bugDesc = bugDesc;
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.assignedTo = assignedTo;
		this.closedBy = closedBy;
		this.bugStatus = bugStatus;
		this.severityLevel = severityLevel;
		this.openDate = openDate;
		this.markedForClosing = markedForClosing;
	}
	public String getBugId() {
		return bugId;
	}
	public void setBugId(String bugId) {
		this.bugId = bugId;
	}
	public String getBugTitle() {
		return bugTitle;
	}
	public void setBugTitle(String bugTitle) {
		this.bugTitle = bugTitle;
	}
	public String getBugDesc() {
		return bugDesc;
	}
	public void setBugDesc(String bugDesc) {
		this.bugDesc = bugDesc;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getClosedBy() {
		return closedBy;
	}
	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}
	public String getBugStatus() {
		return bugStatus;
	}
	public void setBugStatus(String bugStatus) {
		this.bugStatus = bugStatus;
	}
	public String getSeverityLevel() {
		return severityLevel;
	}
	public void setSeverityLevel(String severityLevel) {
		this.severityLevel = severityLevel;
	}
	public LocalDate getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}
	
	public String getMarkedForClosing() {
		return markedForClosing;
	}
	public void setMarkedForClosing(String markedForClosing) {
		this.markedForClosing = markedForClosing;
	}
	@Override
	public String toString() {
		return "Bugs [bugId=" + bugId + ", bugTitle=" + bugTitle + ", bugDesc=" + bugDesc + ", projectId=" + projectName
				+ ", createdBy=" + createdBy + ", assignedTo=" + assignedTo + ", closedBy=" + closedBy + ", bugStatus="
				+ bugStatus + ", severityLevel=" + severityLevel + ", openDate=" + openDate + ", markedForClosing="
				+ markedForClosing + "]";
	}
}