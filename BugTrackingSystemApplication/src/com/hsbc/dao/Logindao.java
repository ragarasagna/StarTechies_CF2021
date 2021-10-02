package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;

import com.hsbc.util.JDBCUtility;

public class Logindao implements LoginDaoIntf {

	private Connection con = null;
	private ResultSet resultSet = null;
	private PreparedStatement prepSt = null;
	private Statement statement = null;
	private ResultSet result = null;

	public Logindao() {
		try {
			con = JDBCUtility.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String authenticateUser(String emailId, String password) {
		String emailIdDB = "";
		String passwordDB = "";
		String roleDB = "";

		try {

			statement = con.createStatement();
			resultSet = statement.executeQuery("select email_id,password,role from Users");

			while (resultSet.next()) {
				emailIdDB = resultSet.getString("email_id");

				passwordDB = resultSet.getString("password");
				roleDB = resultSet.getString("role");

				if (emailId.equals(emailIdDB) && checkPassword(password, passwordDB) && roleDB.equals("ProjectManager"))
					return "ProjectManager";
				else if (emailId.equals(emailIdDB) && checkPassword(password, passwordDB) && roleDB.equals("Developer"))
					return "Developer";
				else if (emailId.equals(emailIdDB) && checkPassword(password, passwordDB) && roleDB.equals("Tester"))
					return "Tester";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials";
	}

	public int fetchProjectCounter(String emailId) {
		String query = "select project_counter from users where email_id=?";
		try {
			prepSt = con.prepareStatement(query);
			prepSt.setString(1, emailId);
			result = prepSt.executeQuery();

			if (result.next()) {
				return (result.getInt("project_counter"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public boolean checkPassword(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateLoginTime(String emailId) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String query = "UPDATE Users SET last_login = ? WHERE email_id = ?";

		try {
			prepSt = con.prepareStatement(query);

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

	@Override
	public Date getLastLoginTime(String emailId) {
		String getDateQuery = "SELECT last_login FROM Users WHERE email_id =?";

		try {
			prepSt = con.prepareStatement(getDateQuery);
			prepSt.setString(1, emailId);
			result = prepSt.executeQuery();
			if (result.next()) {
				return result.getTimestamp(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
