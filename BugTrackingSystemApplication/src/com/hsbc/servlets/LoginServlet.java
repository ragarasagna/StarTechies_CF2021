package com.login.controller;

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

import com.login.dao.LoginDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		
		String emailId = req.getParameter("emailId");
	    String password = req.getParameter("password");
	    String role = "";
	    /*LoginBean loginBean = new LoginBean();
	    
	    loginBean.setemailId(emailId);
	    loginBean.setPassword(password);
	    */
	 
	    LoginDao loginDao = new LoginDao();
	 
	    try
	    {
	        String userValidate = loginDao.authenticateUser(emailId,password);
	 
	        if(userValidate.equals("Project_Manager"))
	        {
	        	Date lastlogin = loginDao.getLastLoginTime(emailId);
	        	DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        	String dateStr = formatter.format(lastlogin);
	        	System.out.println(dateStr);
	  
	        	out.println("Last login: " + dateStr);
	        	
	        	loginDao.updateLoginTime(emailId);
	            out.println("Project Manager's Page");
	 
	            HttpSession session = req.getSession(); //Creating a session
	            session.setAttribute("ProjectManager", role); //setting session attribute
	            req.setAttribute("emailId", emailId);
	 
	            //req.getreqDispatcher("/JSP/Admin.jsp").forward(req, resp);
	        }
	        else if(userValidate.equals("Developer"))
	        {   
	        	Date lastlogin = loginDao.getLastLoginTime(emailId);
	        	DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        	String dateStr = formatter.format(lastlogin);
	        	out.println("Last login: " + dateStr);
	        	
	        	loginDao.updateLoginTime(emailId);
	        	
	        	out.println("Developer Page");
	            System.out.println("Developer's Home");
	 
	            HttpSession session = req.getSession();
	            session.setAttribute("Developer", role);
	            req.setAttribute("emailId", emailId);
	 
	            //req.getreqDispatcher("/JSP/Editor.jsp").forward(req, resp);
	        }
	        else if(userValidate.equals("Tester"))
	        {
	        	Date lastlogin = loginDao.getLastLoginTime(emailId);
	        	DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        	String dateStr = formatter.format(lastlogin);
	        	out.println("Last login: " + dateStr);
	        	
	        	loginDao.updateLoginTime(emailId);
	        	out.println("Tester's Page");
	            System.out.println("Tester's Home");
	 
	            HttpSession session = req.getSession();
	            session.setMaxInactiveInterval(10*60);
	            session.setAttribute("Tester", role);
	            req.setAttribute("emailId", emailId);
	 
	           // req.getreqDispatcher("/JSP/User.jsp").forward(req, resp);
	        }
	        else
	        {
	            System.out.println("Error message = "+userValidate);
	            req.setAttribute("errMessage", userValidate);
	 
	           // req.getreqDispatcher("/JSP/Login.jsp").forward(req, resp);
	        }
	    }
	    catch (Exception e2)
	    {
	        e2.printStackTrace();
	    }
	} 
   
}
