package com.hsbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.business.LoginService;
import com.hsbc.business.LoginServiceIntf;
import com.hsbc.dao.LoginDaoIntf;
import com.hsbc.dao.Logindao;



@WebServlet("/jsp/Loginservlet")
public class Loginservlet extends HttpServlet {

	LoginServiceIntf service=null;
	public Loginservlet()
	{
		service= new LoginService();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		
		String emailId = req.getParameter("email");
	    String password = req.getParameter("psw");
	  
	 
	    try
	    {
	        String userValidate = service.authenticateUser(emailId,password);
	 
	        if(userValidate.equals("ProjectManager"))
	        {
	        	Date lastlogin = service.getLastLoginTime(emailId);
	        	String dateStr;
	        	int projectCounter=service.fetchProjectCounter(emailId);
	        	//If last login is not available,get the current timeStamp and display it.
	        	//If it is available, display that.
	        	
	        	
	        	if(lastlogin != null) {
	        		DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	dateStr = formatter.format(lastlogin);
	        	}else {
	        		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        		DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	dateStr = formatter.format(timestamp);
	        	}
	      
	  
	        	
	        	service.updateLoginTime(emailId);
	 
	            HttpSession session = req.getSession(); //Creating a session
	            String seshId = session.getId();
	            session.setAttribute("session_id",seshId);
	            session.setAttribute("projectCounter", projectCounter);
	            session.setAttribute("emailId", emailId);
	            session.setAttribute("last_login", dateStr);
	            session.setAttribute("role", "ProjectManager");
	            req.getRequestDispatcher("../jsp/pmpage.jsp").forward(req, resp);
	        }
	        else if(userValidate.equals("Developer"))
	        {   
	        	Date lastlogin = service.getLastLoginTime(emailId);
	        	String dateStr = "";
	        	if(lastlogin != null) {
	        		DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	dateStr = formatter.format(lastlogin);
	        	}else {
	        		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        		DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	dateStr = formatter.format(timestamp);
	        	}
	        	out.println("Last login: " + dateStr);
	        	
	        	service.updateLoginTime(emailId);
	        	
	 
	            HttpSession session = req.getSession();
	            String seshId = session.getId();
	            session.setAttribute("session_id",seshId);
	            session.setAttribute("emailId", emailId);
	            req.setAttribute("emailId", emailId);
	            req.setAttribute("last_login", dateStr);
	        
	            req.setAttribute("role", "Developer");

	 
	            req.getRequestDispatcher("../jsp/developerpage.jsp").forward(req, resp);
	        }
	        else if(userValidate.equals("Tester"))
	        {
	        	Date lastlogin = service.getLastLoginTime(emailId);
	        	String dateStr = "";
	        	if(lastlogin != null) {
	        		DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	dateStr = formatter.format(lastlogin);
	        	}else {
	        		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        		DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        	dateStr = formatter.format(timestamp);
	        	}
	        	
	        	service.updateLoginTime(emailId);
	 
	            HttpSession session = req.getSession();
	            String seshId = session.getId();
	            session.setAttribute("session_id",seshId);
	            session.setAttribute("emailId", emailId);
	            req.setAttribute("emailId", emailId);
	            req.setAttribute("last_login", dateStr);
	            req.setAttribute("role", "Tester");
	            session.setAttribute("role", "Tester");

	             
	            req.getRequestDispatcher("../jsp/testerpage.jsp").forward(req, resp);
	        }
	        else
	        {
	            req.setAttribute("errMessage", userValidate);
	 
	            req.getRequestDispatcher("../jsp/login.jsp").forward(req, resp);
	        }
	    }
	    catch (Exception e2)
	    {
	        e2.printStackTrace();
	    }
	} 
   
}
