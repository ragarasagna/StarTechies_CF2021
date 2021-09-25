package com.hsbc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.beans.Bugs;
import com.hsbc.business.ReportNewBugService;
import com.hsbc.business.ReportNewBugServiceIntf;

@WebServlet("/ReportNewBugServlet")
public class ReportNewBugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Bugs bugs= new Bugs();
		bugs.setProjectName(request.getParameter("projectName"));
		bugs.setBugTitle(request.getParameter("title"));
		bugs.setBugDesc(request.getParameter("desc"));
		bugs.setSeverityLevel(request.getParameter("severity"));
		
		ReportNewBugServiceIntf service= new ReportNewBugService();
		service.identifyNewBug(bugs);
		
		
		//ArrayList<String> projects= service.
			
	}

}
