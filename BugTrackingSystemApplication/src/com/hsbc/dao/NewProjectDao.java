package com.hsbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.beans.Project;
import com.hsbc.beans.Users;
import com.hsbc.util.JDBCUtility;

public class NewProjectDao implements NewProjectDaoIntf {
	@Override
	public String addProject(Project p, String userid) {
		// TODO Auto-generated method stub
		int projectresult, teamresult;
		String message = null;
		Connection con;
		try {
			con = JDBCUtility.getConnection();

			String projectquery = "insert into project (project_id,project_name,project_desc,start_date,project_state) values(?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(projectquery);

			pstmt.setString(1, p.getProjectId());
			pstmt.setString(2, p.getProjectName());
			pstmt.setString(3, p.getProjectDesc());
			pstmt.setDate(4, Date.valueOf(p.getStartDate()));
			pstmt.setString(5, p.getProjectStatus());
			projectresult = pstmt.executeUpdate();
			if (projectresult != 1) {
				message = "Project not added";

			}

			else {
				message = "Project added successfully!";
				teamresult = save(userid, p.getProjectId(), con);
				updateProjectCounter(userid, con);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	int save(String userid, String projectId, Connection con) {
		int teamresult = 0;
		try {
			String rolequery = "select role from Users where user_id=?;";
			PreparedStatement rstmt = con.prepareStatement(rolequery);
			rstmt.setString(1, userid);
			ResultSet res = rstmt.executeQuery();
			String role = null;
			while (res.next()) {
				role = res.getString("role");
			}
			String teamquery = "insert into team(user_id,project_id,role) values (?,?,?);";
			PreparedStatement tstmt;

			tstmt = con.prepareStatement(teamquery);
			tstmt.setString(1, userid);
			tstmt.setString(2, projectId);
			tstmt.setString(3, role);
			teamresult = tstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teamresult;

	}

	int updateProjectCounter(String userid, Connection con) {
		String userquery = "update Users set project_counter= project_counter+1 where user_id=?;";
		int res = 0;
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(userquery);
			stmt.setString(1, userid);
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Users> fetchDevelopers() {
		// TODO Auto-generated method stub
		List<Users> devlist = new ArrayList<Users>();
		String query = "select * from users where role='Developer' and project_counter<1";

		Connection con = null;
		try {
			con = JDBCUtility.getConnection();
			PreparedStatement stmt;
			stmt = con.prepareStatement(query);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				Users user = new Users();
				user.setUserId(res.getString("user_id"));
				user.setProjectCounter(res.getInt("project_counter"));
				user.setUserName(res.getString("user_name"));
				devlist.add(user);

			}
			stmt.close();
			res.close();
			con.close();
		}

		catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return devlist;
	}

	@Override
	public List<String> fetchTesters(String pmId) {

		Connection con = null;
		List<String> projectIds = new ArrayList<String>();
		List<String> testers = new ArrayList<String>();
		List<String> finalTesters = new ArrayList<String>();

		try {
			con = JDBCUtility.getConnection();
			String projectsQuery = "select project_id from team where user_id=?";
			PreparedStatement stmt1;
			stmt1 = con.prepareStatement(projectsQuery);
			stmt1.setString(1, pmId);
			ResultSet res1 = stmt1.executeQuery();
			while (res1.next()) {
				String projectid = res1.getString("project_id");
				projectIds.add(projectid);
			}

		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		for (String s : projectIds) {
			try {
				String testersInSameProjectquery = "select user_id from team where role='Tester' and project_id=?;";
				PreparedStatement stmt2 = con.prepareStatement(testersInSameProjectquery);
				stmt2.setString(1, s);
				ResultSet res2 = stmt2.executeQuery();
				while (res2.next()) {
					String testerid = res2.getString("user_id");
					testers.add(testerid);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

			// add to testers list.
		}

		String testersAvailablequery = "select user_id from Users where role='Tester' and project_counter<2;";
		try {
			PreparedStatement stmt3 = con.prepareStatement(testersAvailablequery);
			ResultSet res3 = stmt3.executeQuery();
			while (res3.next()) {
				String testerid = res3.getString("user_id");
				finalTesters.add(testerid);
			}
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		testers.retainAll(finalTesters);

		return testers;
	}

	@Override
	public void assignTeamMembers(String[] list, String projectId) {

		Connection con = null;
		try {
			con = JDBCUtility.getConnection();
			PreparedStatement stmt;

			for (String s : list) {
				String query = "select user_id, role from Users where user_name= ?;";
				stmt = con.prepareStatement(query);
				stmt.setString(1, s);
				ResultSet res = stmt.executeQuery();
				String role = null, userid = null;
				while (res.next()) {
					role = res.getString("role");
					userid = res.getString("user_id");
				}
				System.out.println("role and userid:" + role + " " + userid);
				String insertquery = "insert into team(user_id, project_id, role) values(?,?,?);";
				stmt = con.prepareStatement(insertquery);
				stmt.setString(1, userid);
				stmt.setString(2, projectId);
				stmt.setString(3, role);

				int res2 = stmt.executeUpdate();

				String updatequery = "update Users set project_counter= project_counter+1 where user_id=?;";
				stmt = con.prepareStatement(updatequery);
				stmt.setString(1, userid);
				int res3 = stmt.executeUpdate();

			}
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}
}
