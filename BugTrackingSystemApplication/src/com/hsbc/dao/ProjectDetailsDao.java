package com.hsbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.beans.Bugs;
import com.hsbc.beans.Users;
import com.hsbc.util.JDBCUtility;
import java.sql.*;

public class ProjectDetailsDao implements ProjectDetailsDaoIntf{

	private Connection con=null;
	public ProjectDetailsDao()
	{
		try {
			con=JDBCUtility.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Users> getTeamMembers(String projectName) {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			String query = "WITH temp AS\r\n" + 
					"(SELECT u.user_name,u.role,p.project_name,p.start_date\r\n" + 
					"FROM users u\r\n" + 
					"INNER JOIN team t\r\n" + 
					"ON t.user_id = u.user_id\r\n" + 
					"INNER JOIN project p\r\n" + 
					"ON p.project_id = t.project_id)\r\n" + 
					"SELECT user_name,role FROM temp WHERE project_name = ?";
			
			Users userObj = null;
			ArrayList<Users> userList = new ArrayList<>();
			
	
			
			try {
			
				PreparedStatement prepSt = con.prepareStatement(query);
				prepSt.setString(1,projectName);
				ResultSet res = prepSt.executeQuery();
				while(res.next()) {
					String userName = res.getString(1);
					String role = res.getString(2);
					userObj = new Users(userName,role);
					userList.add(userObj);
				}
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		
			
			return userList;
			
	}
	public String getStartDate(String projectName)
	{
		String getDateQuery = "SELECT start_date FROM project WHERE project_name=?";
		String dateStr=null;
			try {
				
				PreparedStatement prepSt = con.prepareStatement(getDateQuery);
				prepSt.setString(1,projectName);
				ResultSet rs = prepSt.executeQuery();
				while(rs.next()) {
					Date startDate = rs.getDate(1);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
					 dateStr = formatter.format(startDate);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(dateStr);
			System.out.println("start date from dao: "+dateStr);
			return dateStr;
		}
	@Override
	public ArrayList<Bugs> getProjectBugsList(String projectName) {
		// TODO Auto-generated method stub
		ArrayList<Bugs> bugsList= new ArrayList<Bugs>();
		String getBugsQuery = " select * from bugs where project_name=?";
		try {
		 PreparedStatement pst = con.prepareStatement(getBugsQuery);
		 pst.setString(1,projectName);
		 ResultSet rs = pst.executeQuery();
		 while(rs.next()) {
             String bugid= rs.getString(1);
			 String bugTitle = rs.getString(2);
			 String bugDesc = rs.getString(3);
			 String bugStatus = rs.getString(10);
			 String severityLevel = rs.getString(11);
			 boolean markedForClosing= rs.getBoolean(8);
			 System.out.println("the markeforclosing is: "+markedForClosing);
			 String message;
			 if(markedForClosing)
			 {
				 
				 message="yes";
			 }
			 else
			 {
				

				 message="no";
			 }
			 Bugs bugObj = new Bugs(bugTitle,bugStatus,severityLevel,bugDesc,bugid,message);
			 
			 bugsList.add(bugObj);
		 }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return bugsList;
		
	}
	}

	


