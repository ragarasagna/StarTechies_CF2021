package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import com.login.util.DBConnection;
import org.mindrot.jbcrypt.BCrypt;

public class LoginDao implements LoginDaoIntf {
	
	private Connection con = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public boolean checkPassword(String plainPassword,String hashedPassword) {
		if(BCrypt.checkpw(plainPassword,hashedPassword)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void updateLoginTime(String emailId) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String query = "UPDATE registeredUsers SET last_login = ? WHERE email_id = ?";
		System.out.println(query);
		
		try {
			PreparedStatement prepSt = con.prepareStatement(query);

			prepSt.setTimestamp(1, timestamp);
			prepSt.setString(2, emailId);

			int rowsAffected = prepSt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Updated User object successfully");
			} else {
				System.out.println("Could not update");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public Date getLastLoginTime(String emailId) {
		String getDateQuery = "SELECT last_login FROM registeredUsers WHERE email_id =" + "'" + emailId + "'";
		System.out.println(getDateQuery);
		Statement st;
		try {
			st = con.createStatement();
			ResultSet result = st.executeQuery(getDateQuery);
			if(result.next()) {
			 return result.getTimestamp(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public String authenticateUser(String emailId, String password) {

		String emailIdDB = "";
		String passwordDB = "";
		String roleDB = "";
		System.out.println("Reading props");
		String[] props = DBConnection.readProperties();
		System.out.println(Arrays.toString(props));

		try {
			con = DBConnection.getConnection(props[0],props[1],props[2]);
			statement = con.createStatement();
			resultSet = statement.executeQuery("select email_id,password,role from registeredUsers");

			while (resultSet.next()) {
				emailIdDB = resultSet.getString("email_id");
				passwordDB = resultSet.getString("password");
				roleDB = resultSet.getString("role");

				if (emailId.equals(emailIdDB) && password.equals(passwordDB) && roleDB.equals("ProjectManager"))
					return "Project_Manager";
				else if (emailId.equals(emailIdDB) && password.equals(passwordDB) && roleDB.equals("Developer"))
					return "Developer";
				else if (emailId.equals(emailIdDB) && password.equals(passwordDB) && roleDB.equals("Tester"))
					return "Tester";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials";
	}
}
