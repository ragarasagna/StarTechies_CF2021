package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.beans.Project;
import com.hsbc.util.JDBCUtility;

public class DisplayProjectsPmDao implements DisplayProjectsPmDaoIntf {

	Connection con=null;
	public DisplayProjectsPmDao()
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
	public List<Project> projectNames(String emailId) {
		// TODO Auto-generated method stub
		List<Project> list = new ArrayList<>();
		PreparedStatement pstat=null;
		//String sql="select * from users";
		String sql="select project_name from project where project_id in (select project_id from teams where user_id in (select user_id from users where email_id = ?));";
		//String sql="select project_name from project where project_id in (select project_id from team where user_id = ?);";
		try {
			pstat=con.prepareStatement(sql);
			pstat.setString(1, emailId);
			ResultSet rs=pstat.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				System.out.println("Hey");
				Project name=new Project();
				name.setProjectName(rs.getString("project_name"));
				list.add(name);
			System.out.println("hello");
			}
			for(Project n : list) {
				System.out.println(n.getProjectName());
			}
		}catch (SQLException e) {

			System.out.println("world");
		}
		
		return list;
	}

}
