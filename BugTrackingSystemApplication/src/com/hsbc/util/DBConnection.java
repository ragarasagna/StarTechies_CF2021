package com.login.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static Connection conn;

	public static Connection getConnection(String userName,String password,String url){
        
		//Get the connection
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection(url, userName, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
    }
	
	public static String[] readProperties() {
		Properties properties = new Properties();
		String[] details = new String[3];
		try {
		  properties.load(new FileInputStream("D:\\BugTrackerLogin\\BugTracker\\Password.txt"));
		  details[0] = properties.getProperty("userName");
		  details[1] = properties.getProperty("password");
		  details[2] = properties.getProperty("url");
		  return details;
		  
		} catch (IOException e) {
		  System.out.println(e.getMessage());
		}
		return null;
	}
}
