package com.hsbc.beans;


import java.time.LocalDate;

public class Bugs {
    private String bugId,bugTitle,bugDesc,projectId,createdBy,
    assignedTo,closedBy,bugStatus,severityLevel;
    private LocalDate openDate;
    private boolean markedForClosing;
    public Bugs() {}
    public Bugs(String bugTitle, String bugStatus, String severityLevel)
    {
    	this.bugTitle=bugTitle;
    	this.bugStatus=bugStatus;
    	this.severityLevel=severityLevel;
    }
	public Bugs(String bugId, String bugTitle, String bugDesc, String projectId, String createdBy, String assignedTo,
			String closedBy, String bugStatus, String severityLevel, LocalDate openDate, boolean markedForClosing) {
		this.bugId = bugId;
		this.bugTitle = bugTitle;
		this.bugDesc = bugDesc;
		this.projectId = projectId;
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
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
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
	public boolean isMarkedForClosing() {
		return markedForClosing;
	}
	public void setMarkedForClosing(boolean markedForClosing) {
		this.markedForClosing = markedForClosing;
	}
	@Override
	public String toString() {
		return "Bugs [bugId=" + bugId + ", bugTitle=" + bugTitle + ", bugDesc=" + bugDesc + ", projectId=" + projectId
				+ ", createdBy=" + createdBy + ", assignedTo=" + assignedTo + ", closedBy=" + closedBy + ", bugStatus="
				+ bugStatus + ", severityLevel=" + severityLevel + ", openDate=" + openDate + ", markedForClosing="
				+ markedForClosing + "]";
	}
}