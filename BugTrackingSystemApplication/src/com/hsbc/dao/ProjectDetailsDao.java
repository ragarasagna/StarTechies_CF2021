package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.simple.JSONObject;

import com.hsbc.beans.Project;
import com.hsbc.util.JDBCUtility;

public class ProjectDetailsDao implements ProjectDetailsIntf {
     
	Connection conn = JDBCUtility.getConnection();
	
	@Override
	public JSONObject getProjectDetails(String projectName) {
		String query = "WITH temp AS\r\n" + 
				"(SELECT u.user_name,u.role,p.project_name,p.start_date\r\n" + 
				"FROM users u\r\n" + 
				"INNER JOIN team t\r\n" + 
				"ON t.user_id = u.user_id\r\n" + 
				"INNER JOIN project p\r\n" + 
				"ON p.project_id = t.project_id)\r\n" + 
				"SELECT user_name,role FROM temp WHERE project_name = ?";
		JSONObject jo = new JSONObject();
		LinkedHashMap<String,String> m = new LinkedHashMap<>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		try {
			PreparedStatement prepSt = conn.prepareStatement(query);
			prepSt.setString(1,projectName);
			ResultSet res = prepSt.executeQuery();
			while(res.next()) {
				String userName = res.getString(1);
				String role = res.getString(2);
				m.put(userName, role);
			}
			jo.put("team", m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String getDateQuery = "SELECT start_date FROM project WHERE project_name=?";
		try {
			PreparedStatement prepSt = conn.prepareStatement(getDateQuery);
			prepSt.setString(1,projectName);
			ResultSet rs = prepSt.executeQuery();
			while(rs.next()) {
				Date startDate = rs.getDate(1);
				String dateStr = formatter.format(startDate);
;				jo.put("start_date", dateStr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(jo.toString());
		return jo;
	}
}
