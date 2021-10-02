package com.hsbc.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hsbc.beans.ImportedUsers;
import com.hsbc.exceptions.UploadNotSuccessfulException;
import com.hsbc.util.JDBCUtility;

public class ImportUsersDao implements ImportUsersDaoIntf {

	@Override
	public void readFile() throws UploadNotSuccessfulException {
		try {
			Connection con = JDBCUtility.getConnection();

			FileReader reader;

			reader = new FileReader("C:\\importusers\\users.json");
			Object obj = null;

			try {
				obj = new JSONParser().parse(reader);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

			JSONArray imp_list = (JSONArray) obj;

			Iterator it = imp_list.iterator();
			PreparedStatement preparedStmt = null;

			while (it.hasNext()) {
				JSONObject jo = (JSONObject) it.next();
				ImportedUsers user = new ImportedUsers();
				String userName = (String) jo.get("userName");
				user.setUserName(userName);
				String userRole = (String) jo.get("userRole");
				user.setUserRole(userRole);
				String userEmail = (String) jo.get("userEmail");
				user.setUserEmail(userEmail);
				String[] arr = userEmail.split("@", 2);
				String userId = arr[0];

				String checkQuery = "Select user_id from imported_users where user_id=?";
				preparedStmt = con.prepareStatement(checkQuery);
				preparedStmt.setString(1, userId);
				ResultSet result = preparedStmt.executeQuery();

				if (!result.next()) {
					String insertQuery = "insert into imported_users (user_id,email_id,role,user_name)"
							+ "values(?,?,?,?)";
					preparedStmt = con.prepareStatement(insertQuery);
					preparedStmt.setString(1, userId);
					preparedStmt.setString(2, userEmail);
					preparedStmt.setString(3, userRole);
					preparedStmt.setString(4, userName);
					preparedStmt.execute();

				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
