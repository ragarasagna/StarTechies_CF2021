package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hsbc.util.JDBCUtility;

public class CloseBugDao implements CloseBugDaoIntf{

	Connection con=null;
	public CloseBugDao()
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
	@Override
	public ArrayList<String> fetchDevelopers(String projectName) {
		// TODO Auto-generated method stub
		System.out.println("");
		ArrayList<String> developers= new ArrayList<String>();
		String query="select user_name from Users where user_id in (select user_id from team where project_id in (select project_id from project where project_name = ?)) and role = ?;";
		try {
		PreparedStatement stmt= con.prepareStatement(query);
		stmt.setString(1, projectName);
		stmt.setString(2, "Developer");
		ResultSet res=stmt.executeQuery();
		while(res.next())
		{
			String username= res.getString("user_name");
			developers.add(username);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return developers;
	}
	@Override
	public void closeBug(String bugId, String manageremailId) {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;
		String managerName=null;
		String managerEmail="select user_name from Users where email_id=?";
		try {
			stmt=con.prepareStatement(managerEmail);
			stmt.setString(1, manageremailId);
			ResultSet res= stmt.executeQuery();
			if(res.next())
			{
				managerName= res.getString("user_name");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		String query="select marked_for_closing from bugs where bug_id=?";
		 try {
			stmt=con.prepareStatement(query);
			stmt.setString(1, bugId);
			ResultSet res=stmt.executeQuery();
           
			if(res.next())
			{
				//String managerName=getMangerName(projectName);
				if(res.getBoolean("marked_for_closing"))
				{
			String updateBug="update bugs set closed_by=? , bug_status=? where bug_id=?";
					stmt=con.prepareStatement(updateBug);
					stmt.setString(1, managerName);
					stmt.setString(2, "Closed");
					stmt.setString(3, bugId);
					int rows=stmt.executeUpdate();
					if(rows!=1)
					{
						System.out.println("update unsuccessful");
					}
					else
					{
						System.out.println("update successful");
						
					}
						
				}
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	/*String getManagerName(String projectName)
	{
		String query="select user_name from Users where user_id like (select user_id from team where project_id like(select project_id from project where projectName) where role='ProjectManger')";
	}*/

}
