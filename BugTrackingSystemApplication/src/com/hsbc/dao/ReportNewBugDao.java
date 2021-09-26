package com.hsbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import com.hsbc.beans.Bugs;
import com.hsbc.exceptions.BugNotReportedException;
import com.hsbc.util.JDBCUtility;

public class ReportNewBugDao implements ReportNewBugDaoIntf{

	Connection con=null;
	public ReportNewBugDao()
	{
		try {
			 con= JDBCUtility.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	public String fetchTesterName(String projectName)
	{
		String testerName=null;
		 String testerQuery="select user_name from Users where user_id in (select user_id from team where project_id in (select project_id from project where project_name = ?)) and role = ?;";
	     try {
	     PreparedStatement stmt= con.prepareStatement(testerQuery);
	     stmt.setString(1, projectName);
	     stmt.setString(2, "Tester");
	     ResultSet res= stmt.executeQuery();
	     while(res.next())
	     {
	    	 testerName=res.getString("user_name");
	     }
	     }
	     catch(SQLException e)
	     {
	    	 e.printStackTrace();
	     }
	     return testerName;
	}



	@Override
	public int findNewBug(Bugs bug) throws BugNotReportedException {
		// TODO Auto-generated method stub
		int result=0;
		String projectName=bug.getProjectName();
     String testerName=fetchTesterName(projectName);
     bug.setBugId(UUID.randomUUID().toString());
     bug.setCreatedBy(testerName);
     bug.setOpenDate(LocalDate.now());
     bug.setBugStatus("InProgress");
     String query= "insert into bugs(bug_id, bug_title, bug_desc, project_name, created_by, open_date,bug_status,severity_level) values (?,?,?,?,?,?,?,?); " ;
     try {
     PreparedStatement stmt= con.prepareStatement(query);
     stmt.setString(1, bug.getBugId());
     stmt.setString(2, bug.getBugTitle());
     stmt.setString(3, bug.getBugDesc());
     stmt.setString(4, bug.getProjectName());
     stmt.setString(5, bug.getCreatedBy());
     stmt.setDate(6,Date.valueOf(bug.getOpenDate()));
     stmt.setString(7, bug.getBugStatus());
     stmt.setString(8, bug.getSeverityLevel());
     result=stmt.executeUpdate();
     
     }
     catch(SQLException e)
     {
    	 e.printStackTrace();
     }
    if(result!=1)
    {
    	throw new BugNotReportedException("BugNotReportedException. The Bug Was Not Reported!");
    }
    else {
    	return result;
    }	
	}



	@Override
	public ArrayList<String> fetchProjects() {
		// TODO Auto-generated method stub
		//get projects for tester
		
		return null;
	}
}
