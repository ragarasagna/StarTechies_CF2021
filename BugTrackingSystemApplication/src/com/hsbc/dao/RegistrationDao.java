package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.hsbc.beans.Roles;
import com.hsbc.beans.Users;
import com.hsbc.util.JDBCUtility;

public class RegistrationDao implements RegsitrationDaoIntf {

	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	@Override
	public String registerUser(Users user) {
		// TODO Auto-generated method stub
		String message=null;
		// TODO Auto-generated method stub
		//String userId= user.getUserId();
		//String userName= user.getUserName();
		String userEmail= user.getUserEmail();
		String userRole= user.getUserRole();
		String password= user.getPassword();
		
		//check if email exixts in imported users table and 
		//already exists in users table and 
		Connection con=null;
		try {
		
			con= JDBCUtility.getConnection();
			String query1="select * from imported_users where email_id= ?";
			String query2="select *from users where email_id= ?";
			PreparedStatement  stmt1= con.prepareStatement(query1);
			PreparedStatement stmt2= con.prepareStatement(query2);		
		    stmt1.setString(1, userEmail);
		    stmt2.setString(1, userEmail);

			ResultSet result1= stmt1.executeQuery();
			ResultSet result2= stmt2.executeQuery();
			//if eligible to register get the details and update in users table
			if(result2.next()==false)
			{
				if(result1.next())
				{
					//check in users table
					String s1=(result1.getString("role"));
					String s=Roles.Tester.toString();
					//if(s1.equals(Roles.Developer)|| s1.equals(Roles.ProjectManager) || s1.equals(Roles.Tester))
					//{
					if(s1.equals(Roles.Tester.toString()) || s1.equals(Roles.Developer.toString()) || s1.equals(Roles.ProjectManager.toString())) {
					String s2=(user.getUserRole());

					
					if(s1.equals(s2)) {
						
					Users u= new Users();
					u.setUserId(result1.getString("user_id"));
					u.setUserName(result1.getString("user_name"));
					u.setUserRole(result1.getString("role"));
					u.setUserEmail(result1.getString("email_id"));
					String encryptpwd=hashPassword(password);
					u.setPassword(encryptpwd);
					int count = save(u,con);
					if(count!=0)
					{
						message="User Registered Successfully!";
					}
					else
						message="Registration Failed!";
				}
					else
					{
						message="Your role does not match with the records!";
					}
				}
					else {message="This role is not yet given access!";}
				}
					
				
			else {
				message="Registration Failed! You are not allowed to register";
				}
			
			
	}
			else {
				message="Already Registered!";
			}
		
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return message;
	}
	
	
	public int save(Users u, Connection con)
	{
		String query="insert into users (user_id, user_name, role, email_id, password,project_counter) values(?,?,?,?,?,0)";
		int result=0;
		try {
			PreparedStatement stmt= con.prepareStatement(query);
			stmt.setString(1, u.getUserId());
			stmt.setString(2, u.getUserName());
			stmt.setString(3, u.getUserRole());
			stmt.setString(4, u.getUserEmail());
			System.out.println(u.getPassword());
			stmt.setString(5, u.getPassword());
		    result= stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}


}
