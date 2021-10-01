package com.hsbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.hsbc.beans.Bugs;
import com.hsbc.exceptions.BugNotReportedException;
import com.hsbc.util.JDBCUtility;

public class BugModelDao implements BugModelDaoIntf {
	Connection con = null;

	public BugModelDao() {
		try {
			con = JDBCUtility.getConnection();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/*
	 * 1)closeBug(String bugId, String managerName)
	 * 
	 * 2)ArrayList<String> fetchDevelopers(String projectName);//assigningbugs
	 * 
	 * 3)int findNewBug(Bugs bug) throws BugNotReportedException;
	 * 
	 * 4)ArrayList<String> fetchProjects();
	 * 
	 * 5)ArrayList<Bugs>Displaybugs(projectName);
	 * 
	 * 6)assignbugs(devname, bugid);
	 */

	public List<Bugs> testerProjectDetails(String emailId) {
		ArrayList<Bugs> bugslist = new ArrayList<>();
		String sql = "select bug_title, bug_desc, severity_level,project_name from bugs where created_by in(select user_id from Users where email_id =?)order by project_name;";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emailId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String bugTitle = rs.getString("bug_title");
				String bugDesc = rs.getString("bug_desc");
				String severityLevel = rs.getString("severity_level");
				String projectName = rs.getString("project_name");
				Bugs bug = new Bugs();
				bug.setBugTitle(bugTitle);
				bug.setBugDesc(bugDesc);
				bug.setSeverityLevel(severityLevel);
				bug.setProjectName(projectName);
				bugslist.add(bug);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return bugslist;

	}

	public ArrayList<Bugs> fetchAssignedBug(String emailId) {

		ArrayList<Bugs> bugslist = new ArrayList<>();
		String query = "select * from bugs where assigned_to like(select user_name from Users where email_id=?);";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, emailId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String bugid = rs.getString(1);
				String bugTitle = rs.getString(2);
				String bugStatus = rs.getString("bug_status");

				boolean markedForClosing = rs.getBoolean("marked_for_closing");
				String message;
				if (markedForClosing) {

					message = "yes";
				} else {
					message = "no";
				}
				Bugs bugObj = new Bugs(bugid, bugTitle, bugStatus, message);
				bugslist.add(bugObj);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bugslist;

	}

	public void markForClose(String bugId) {
		String sql = "update bugs set marked_for_closing=? where bug_id like ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("inside mark " + bugId);
			pst.setBoolean(1, true);
			pst.setString(2, bugId);
			int i = pst.executeUpdate();
			if (i != 0) {
				System.out.println("Update success");
			} else
				System.out.println("Update failed");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public ArrayList<Bugs> DisplayBugs(String projectName) {
		System.out.println("project name in bugdao:" + projectName);
		ArrayList<Bugs> bugsList = new ArrayList<Bugs>();
		String getBugsQuery = " select * from bugs where project_name=?";
		try {
			PreparedStatement pst = con.prepareStatement(getBugsQuery);
			pst.setString(1, projectName);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String bugid = rs.getString(1);
				String bugTitle = rs.getString(2);
				String bugDesc = rs.getString(3);
				String bugStatus = rs.getString(10);
				String severityLevel = rs.getString(11);
				boolean markedForClosing = rs.getBoolean(8);
				String message;
				if (markedForClosing) {

					message = "yes";
				} else {
					message = "no";
				}
				Bugs bugObj = new Bugs(bugTitle, bugStatus, severityLevel, bugDesc, bugid, message);

				bugsList.add(bugObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bugsList;

	}

	public void closeBug(String bugId, String managerEmailId) {
		PreparedStatement stmt = null;
		String managerName = null;
		String managerEmail = "select user_name from Users where email_id=?";
		try {
			stmt = con.prepareStatement(managerEmail);
			stmt.setString(1, managerEmailId);
			ResultSet res = stmt.executeQuery();
			if (res.next()) {
				managerName = res.getString("user_name");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String query = "select marked_for_closing from bugs where bug_id=?";
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, bugId);
			ResultSet res = stmt.executeQuery();

			if (res.next()) {
				if (res.getBoolean("marked_for_closing")) {
					String updateBug = "update bugs set closed_by=? , bug_status=? where bug_id=?";
					stmt = con.prepareStatement(updateBug);
					stmt.setString(1, managerName);
					stmt.setString(2, "Closed");
					stmt.setString(3, bugId);
					int rows = stmt.executeUpdate();
					if (rows != 1) {
						System.out.println("update unsuccessful");
					} else {
						System.out.println("update successful");

					}

				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public String fetchTesterName(String projectName) {
		String testerName = null;
		String testerQuery = "select user_name from Users where user_id in (select user_id from team where project_id in (select project_id from project where project_name = ?)) and role = ?;";
		try {
			PreparedStatement stmt = con.prepareStatement(testerQuery);
			stmt.setString(1, projectName);
			stmt.setString(2, "Tester");
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				testerName = res.getString("user_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return testerName;
	}

	@Override
	public int reportNewBug(Bugs bug) throws BugNotReportedException {

		int result = 0;
		String projectName = bug.getProjectName();
		String testerName = fetchTesterName(projectName);
		System.out.println("testers name from report bug: " + testerName);
		bug.setBugId(UUID.randomUUID().toString());
		bug.setCreatedBy(testerName);
		bug.setOpenDate(LocalDate.now());
		bug.setBugStatus("Open");
		String query = "insert into bugs(bug_id, bug_title, bug_desc, project_name, created_by, open_date,bug_status,severity_level) values (?,?,?,?,?,?,?,?); ";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, bug.getBugId());
			stmt.setString(2, bug.getBugTitle());
			stmt.setString(3, bug.getBugDesc());
			stmt.setString(4, bug.getProjectName());
			stmt.setString(5, bug.getCreatedBy());
			stmt.setDate(6, Date.valueOf(bug.getOpenDate()));
			stmt.setString(7, bug.getBugStatus());
			stmt.setString(8, bug.getSeverityLevel());
			result = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result != 1) {
			throw new BugNotReportedException("BugNotReportedException. The Bug Was Not Reported!");
		} else {
			return result;
		}
	}

	@Override
	public void assignBugToDeveloper(String developerName, String bugId) {
		String query = "update bugs set assigned_to=? , bug_status=? where bug_id=? ";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, developerName);
			stmt.setString(2, "InProgress");
			stmt.setString(3, bugId);
			int rows = stmt.executeUpdate();
			if (rows > 1) {
				System.out.println("bug table updaredsuccessfully!");
			} else {
				System.out.println("bug table not  updaredsuccessfully!");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
