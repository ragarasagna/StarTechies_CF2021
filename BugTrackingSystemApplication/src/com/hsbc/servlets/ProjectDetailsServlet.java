package com.hsbc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.beans.Users;
import com.hsbc.business.ProjectDetailsService;
import com.hsbc.business.ProjectDetailsServiceIntf;

@WebServlet("/ProjectDetailsServlet/*")
public class ProjectDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//ProjectDetailsServiceIntf service= new ProjectDetailsService();
		ProjectDetailsService Sr= new ProjectDetailsService();
		String projectName=null;
		if (request.getPathInfo() != null) {
			projectName = request.getPathInfo().substring(1);
		}
		
		List<Users> teamDetails= Sr.fetchTeamDetails(projectName);
		
		String projectManagerName=null;
		for(Users u: teamDetails)
		{
			if(u.getUserRole().equals("ProjectManager"))
			{
				projectManagerName= u.getUserName();
			}
		}
		String startDate= Sr.fetchStartDate(projectName);
		
		request.setAttribute("projectname", projectName);
		request.setAttribute("managername", projectManagerName);
		request.setAttribute("date", startDate);
		request.setAttribute("team", teamDetails);
		request.getRequestDispatcher("../jsp/pmdisplaydetails.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
