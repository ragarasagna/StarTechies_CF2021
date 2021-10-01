package com.hsbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.hsbc.beans.Bugs;
import com.hsbc.beans.Project;
import com.hsbc.beans.Users;
import com.hsbc.exceptions.BugNotReportedException;
import com.hsbc.exceptions.projectNotAddedException;
import com.hsbc.util.JDBCUtility;

public class ProjectModelDao implements ProjectModelDaoIntf {
	Connection con = null;

	public ProjectModelDao() {
		try {
			con = JDBCUtility.getConnection();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/*
	 * 1)String addProject(Project p, String userid); 4)void
	 * assignTeamMembers(String[] list, String projectId);
	 * 
	 * 5)public List<ProjectName> displayprojectNames(String userId)
	 * 
	 * - public List<Project> projectdetails()
	 * 
	 * 6)public String getStartDate(String projectName);
	 */

	public String projectName(String emailId) {
		String name = null;
		PreparedStatement pstat = null;
		String sql = "select project_name from project where project_id in(select project_id  from team where user_id = (select user_id from Users where email_id=?));";
		try {
			pstat = con.prepareStatement(sql);
			pstat.setString(1, emailId);
			ResultSet rs = pstat.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				// System.out.println("Hey");
				name = rs.getString("project_name");

				System.out.println("hello");
			}

		} catch (SQLException e) {

			System.out.println("world");
		}
		return name;
	}

	public List<Project> projectNames(String emailId) {
		// TODO Auto-generated method stub
		List<Project> list = new ArrayList<>();
		PreparedStatement pstat = null;
		// String sql="select * from users";
		String sql = "select project_id from team where user_id in(select user_id from Users where email_id=?);";
		
		// String sql="select project_name from project where project_id in (select
		// project_id from team where user_id = ?);";
		try {
			
			pstat = con.prepareStatement(sql);
			pstat.setString(1, emailId);
			ResultSet rs = pstat.executeQuery();
			System.out.println(rs);
			
			while (rs.next()) {
				String projectId=(rs.getString("project_id"));
				System.out.println("Project Id inside loop:"+projectId);
				String query="select project_name from project where project_id=?";
				pstat=con.prepareStatement(query);
				pstat.setString(1, projectId);
				ResultSet rs1= pstat.executeQuery();
				if(rs1.next())
				{
					Project project = new Project();
					project.setProjectName(rs1.getString("project_name"));
					list.add(project);
				}
				
			}
				
				
			for (Project n : list) {
				System.out.println(n.getProjectName());
			}
		} catch (SQLException e) {

			System.out.println("world");
		}

		return list;
	}

	public Project addProject(Project p, String emailId) throws projectNotAddedException {
		// TODO Auto-generated method stub
		int projectresult, teamresult;
		String message = null;
Project project=null;
		try {

			String projectquery = "insert into project (project_id,project_name,project_desc,start_date,project_state) values(?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(projectquery);
			p.setProjectId(UUID.randomUUID().toString());
			p.setProjectStatus("InProgress");
			pstmt.setString(1, p.getProjectId());
			pstmt.setString(2, p.getProjectName());
			pstmt.setString(3, p.getProjectDesc());
			pstmt.setDate(4, Date.valueOf(p.getStartDate()));
			pstmt.setString(5, p.getProjectStatus());
			project=p;
			projectresult = pstmt.executeUpdate();
			if (projectresult != 1) {
				message = "Project not added";
				throw new projectNotAddedException(message);

			}

			else {
				message = "Project added successfully!";
				System.out.println(message);
System.out.println("emailid of project manager is: "+ emailId);
System.out.println("projectId of the created project is "+p.getProjectId());
				teamresult = save(emailId, p.getProjectId());// update team table
				updateProjectCounter(emailId, con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return project;

	}

	public int save(String emailId, String projectId) {
		int teamresult = 0;
		try {
			String rolequery = "select role,user_id from Users where email_id=?;";
			PreparedStatement rstmt = con.prepareStatement(rolequery);
			rstmt.setString(1, emailId);
			ResultSet res = rstmt.executeQuery();
			String role = null, userId = null;
			while (res.next()) {
				role = res.getString("role");
				userId = res.getString("user_id");
			}
			String teamquery = "insert into team(user_id,project_id,role) values (?,?,?);";
			PreparedStatement tstmt;

			tstmt = con.prepareStatement(teamquery);
			tstmt.setString(1, userId);
			tstmt.setString(2, projectId);
			tstmt.setString(3, role);
			teamresult = tstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return teamresult;

	}

	public int updateProjectCounter(String emailId, Connection con) {
		String userquery = "update Users set project_counter= project_counter+1 where email_id=?;";
		int res = 0;
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(userquery);
			stmt.setString(1, emailId);
			res = stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return res;
	}

	public void assignTeamMembers(String[] list, String projectId) {

		PreparedStatement stmt;
		try {
			for (String s : list) {
				String query = "select user_id, role from Users where user_name= ?;";
				stmt = con.prepareStatement(query);
				stmt.setString(1, s);
				ResultSet res = stmt.executeQuery();
				String role = null, userid = null;
				if (res.next()) {
					role = res.getString("role");
					userid = res.getString("user_id");

					String insertquery = "insert into team(user_id, project_id, role) values(?,?,?);";
					stmt = con.prepareStatement(insertquery);
					stmt.setString(1, userid);
					stmt.setString(2, projectId);
					stmt.setString(3, role);

					stmt.executeUpdate();

					String updateQuery = "update Users set project_counter= project_counter+1 where user_id=?;";
					stmt = con.prepareStatement(updateQuery);
					stmt.setString(1, userid);
					stmt.executeUpdate();
				}
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}

	public List<Users> getTeamMembers(String projectName) {

		String query = "WITH temp AS\r\n" + "(SELECT u.user_name,u.role,p.project_name,p.start_date\r\n"
				+ "FROM users u\r\n" + "INNER JOIN team t\r\n" + "ON t.user_id = u.user_id\r\n"
				+ "INNER JOIN project p\r\n" + "ON p.project_id = t.project_id)\r\n"
				+ "SELECT user_name,role FROM temp WHERE project_name = ?";

		Users userObj = null;
		ArrayList<Users> userList = new ArrayList<>();
		System.out.println("teamlistdao: " + userList);

		try {

			PreparedStatement prepSt = con.prepareStatement(query);
			prepSt.setString(1, projectName);
			ResultSet res = prepSt.executeQuery();
			while (res.next()) {
				String userName = res.getString(1);
				String role = res.getString(2);
				userObj = new Users(userName, role);
				userList.add(userObj);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;

	}

	public String getStartDate(String projectName) {
		String getDateQuery = "SELECT start_date FROM project WHERE project_name=?";
		String dateStr = null;
		try {

			PreparedStatement prepSt = con.prepareStatement(getDateQuery);
			prepSt.setString(1, projectName);
			ResultSet rs = prepSt.executeQuery();
			while (rs.next()) {
				Date startDate = rs.getDate(1);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				dateStr = formatter.format(startDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("startdate from dao" + dateStr);
		return dateStr;
	}

	public String getManagerName(String projectName) {
		List<Users> team = getTeamMembers(projectName);

		String projectManagerName = null;
		for (Users u : team) {
			if (u.getUserRole().equals("ProjectManager")) {
				projectManagerName = u.getUserName();
			}
		}
		return projectManagerName;
	}

	public ArrayList<Bugs> getProjectBugsList(String projectName) {

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
				System.out.println("the markeforclosing is: " + markedForClosing);
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

	@Override
	public List<Users> fetchDevelopers() {

		List<Users> devlist = new ArrayList<Users>();
		String query = "select * from users where role='Developer' and project_counter=?";

		Connection con = null;
		try {
			con = JDBCUtility.getConnection();
			PreparedStatement stmt;
			stmt = con.prepareStatement(query);
			stmt.setInt(1, 0);
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
	public List<String> fetchTesters(String projectManagerEmailId) {

		Connection con = null;
		PreparedStatement stmt=null;
		List<String> projectIds = new ArrayList<String>();
		List<String> testers = new ArrayList<String>();
		List<String> finalTesters = new ArrayList<String>();

		try {
			con = JDBCUtility.getConnection();
			

			String pmId = "select user_id from Users where email_id=?";
			stmt = con.prepareStatement(pmId);
			stmt.setString(1, projectManagerEmailId);
			ResultSet res=stmt.executeQuery();
			String pmid=null;
			if(res.next())
			{
				pmid=res.getString("user_id");
			}
			String projectsQuery = "select project_id from team where user_id=?";

			stmt = con.prepareStatement(projectsQuery);
			stmt.setString(1, pmid);
			ResultSet res1 = stmt.executeQuery();
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
				String testersInSameProjectquery = "select distinct user_id from team where role='Tester' and project_id=?;";
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
	
List<String> team=testers.stream().distinct().collect(Collectors.toList());
System.out.println("team mebers are dao..."+team);
		return team;
	}
	
	
	public List<Users> fetchDevelopersByProjectName(String projectName)
	{
		List<Users> devList= new ArrayList<>();
		PreparedStatement pstmt = null;
		String query=" WITH temp AS(SELECT u.user_name,u.role,p.project_name FROM users u INNER JOIN team t ON t.user_id = u.user_id INNER JOIN project p ON p.project_id = t.project_id) SELECT distinct user_name FROM temp WHERE role = 'Developer' and project_name=?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, projectName);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				String name=rs.getString("user_name");
				Users u = new Users();
				u.setUserName(name);
				devList.add(u);
				
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Developer List:"+devList);
		return devList;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
