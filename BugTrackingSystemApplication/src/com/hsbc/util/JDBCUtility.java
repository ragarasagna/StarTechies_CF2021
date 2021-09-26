package com.hsbc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtility {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Connection con=null;
		if(con!=null)
			return con;
		else
		{
			try {
				Properties prop= new Properties();
				InputStream inp=new FileInputStream("C:\\config.properties");
				prop.load(inp);
				String driver= prop.getProperty("driver");
				String url= prop.getProperty("url");
				String user=prop.getProperty("user");
				String password= prop.getProperty("password");
				Class.forName(driver);
				con= DriverManager.getConnection(url, user, password);
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return con;
		}
}
}
