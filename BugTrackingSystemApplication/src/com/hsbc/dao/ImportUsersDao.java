package com.hsbc.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public void readFile() throws  UploadNotSuccessfulException{
	//	System.out.println(s);
		// TODO Auto-generated method stub
		try {
			Connection con=JDBCUtility.getConnection();
			
			FileReader reader;
			
				reader = new FileReader("C:\\jsonfile\\users.json");
			//System.out.println(s);
			Object obj=null;
			
				try {
					obj = new JSONParser().parse(reader);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			JSONArray imp_list = (JSONArray) obj;

			Iterator it = imp_list.iterator();

			while (it.hasNext()) {
				JSONObject jo = (JSONObject) it.next();
				ImportedUsers user = new ImportedUsers();
				String userName = (String) jo.get("userName");
				user.setUserName(userName);
				String userRole = (String) jo.get("userRole");
				user.setUserRole(userRole);
				String userEmail = (String) jo.get("userEmail");
				user.setUserEmail(userEmail);
				String userId = UUID.randomUUID().toString();
				String query = "insert into imported_users (user_id,email_id,role,user_name)" + "values(?,?,?,?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setString(1, userId);
				preparedStmt.setString(2, userEmail);
				preparedStmt.setString(3, userRole);
				preparedStmt.setString(4, userName);
				preparedStmt.execute();
				System.out.println("in the loop!");
				
			
		}
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}		
		
	}

	
