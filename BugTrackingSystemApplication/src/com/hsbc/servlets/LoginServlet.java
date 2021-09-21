package com.hsbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.LoginDaoIntf;
import com.hsbc.dao.Logindao;

@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		
		String emailId = req.getParameter("email");
	    String password = req.getParameter("psw");
	  
	    LoginDaoIntf loginDao = new Logindao();
	 
	    try
	    {
	        String userValidate = loginDao.authenticateUser(emailId,password);
	 
	        if(userValidate.equals("Project_Manager"))
	        {
	        	Date lastlogin = loginDao.getLastLoginTime(emailId);
	        	DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        	String dateStr = formatter.format(lastlogin);
	        	System.out.println(dateStr);
	  
	        	//out.println("Last login: " + dateStr);
	        	
	        	loginDao.updateLoginTime(emailId);
	            //out.println("Project Manager's Page");
	 
	            HttpSession session = req.getSession(); //Creating a session
	            String seshId = session.getId();
	            session.setAttribute("session_id",seshId);
	            req.setAttribute("emailId", emailId);
	            req.setAttribute("last_login", dateStr);
	            req.setAttribute("role", "ProjectManager");
	            req.getRequestDispatcher("pmpage.html").forward(req, resp);
	        }
	        else if(userValidate.equals("Developer"))
	        {   
	        	Date lastlogin = loginDao.getLastLoginTime(emailId);
	        	DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        	String dateStr = formatter.format(lastlogin);
	        	//out.println("Last login: " + dateStr);
	        	
	        	loginDao.updateLoginTime(emailId);
	        	
	        	//out.println("Developer Page");
	            System.out.println("Developer's Home");
	 
	            HttpSession session = req.getSession();
	            String seshId = session.getId();
	            session.setAttribute("session_id",seshId);
	            req.setAttribute("emailId", emailId);
	            req.setAttribute("last_login", dateStr);
	            req.setAttribute("role", "Developer");

	 
	            req.getRequestDispatcher("developerpage.html").forward(req, resp);
	        }
	        else if(userValidate.equals("Tester"))
	        {
	        	Date lastlogin = loginDao.getLastLoginTime(emailId);
	        	DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        	String dateStr = formatter.format(lastlogin);
	        	//out.println("Last login: " + dateStr);
	        	
	        	loginDao.updateLoginTime(emailId);
	        	//out.println("Tester's Page");
	            System.out.println("Tester's Home");
	 
	            HttpSession session = req.getSession();
	            String seshId = session.getId();
	            session.setAttribute("session_id",seshId);
	            req.setAttribute("emailId", emailId);
	            req.setAttribute("last_login", dateStr);
	            req.setAttribute("role", "Tester");
	             
	            req.getRequestDispatcher("testerpage.html").forward(req, resp);
	        }
	        else
	        {
	            System.out.println("Error message = "+userValidate);
	            req.setAttribute("errMessage", userValidate);
	 
	            req.getRequestDispatcher("login.html").forward(req, resp);
	        }
	    }
	    catch (Exception e2)
	    {
	        e2.printStackTrace();
	    }
	}

}
