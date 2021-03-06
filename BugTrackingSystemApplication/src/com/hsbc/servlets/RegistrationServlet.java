package com.hsbc.servlets;
import com.hsbc.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.beans.Users;
import com.hsbc.business.RegistrationService;
import com.hsbc.business.RegistrationServiceIntf;
import com.hsbc.dao.RegistrationDao;

@WebServlet("/jsp/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	RegistrationServiceIntf service=null;
	public RegistrationServlet()
	{
	 service=new RegistrationService(); 
						
	}
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
	    String role=request.getParameter("role");
	    String password=request.getParameter("psw");
	    
		Users user= new Users();
		user.setUserEmail(email);
		user.setUserRole(role);
		user.setPassword(password);
		String message= service.registerUser(user);
		request.setAttribute("message", message);

		if(message.equals("User Registered Successfully!"))
		{
			
			request.getRequestDispatcher("../jsp/login.jsp").forward(request,response);
		}
		else 
		{
			request.getRequestDispatcher("../jsp/register.jsp").forward(request,response);

		}	
	}

}
