package com.hsbc.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.beans.Project;
import com.hsbc.beans.Users;
import com.hsbc.business.NewProjectService;
import com.hsbc.business.NewProjectServiceIntf;


@WebServlet("/jsp/CreateNewProjectServlet")
public class CreateNewProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		NewProjectServiceIntf service= new NewProjectService();
		
		//sending testers and developers to the frontend
		List<Users> developers= service.getDevelopersList();
		//String userid= (String)session.getAttribute("userid");
		//System.out.println(userid);
		List<String> testers= service.getTestersList("user7");
		session.setAttribute("developers", developers);
		session.setAttribute("testers",testers );
		request.getRequestDispatcher("../jsp/newproject.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*HttpSession session = request.getSession();

		NewProjectDaoIntf dao= new NewProjectDao();
		
		//sending testers and developers to the frontend
		List<Users> developers= dao.fetchDevelopers();
		//String userid= (String)session.getAttribute("userid");
		//System.out.println(userid);
		List<String> testers= dao.fetchTesters("user7");
		session.setAttribute("developers", developers);
		session.setAttribute("testers",testers );
		request.getRequestDispatcher("newproject.jsp").forward(request, response);
		
		for(Users s: developers)
		{
			System.out.println(s.getUserName());
		}
		for(String s: testers)
		{
			System.out.println(s);
		}*/
		
		
		
		/*String id= session.getId();
		String sessionid=(String)session.getAttribute("sessionid");
		
		//System.out.println("new project page sessionid: "+id);
		//System.out.println("user sessionid is: "+sessionid);*/
		NewProjectServiceIntf service= new NewProjectService();

		
		//checking if user is loggedin
	/*	if(id==sessionid)
		{
		*/	Project project= new Project();
			project.setProjectId(UUID.randomUUID().toString());
			project.setProjectName(request.getParameter("pname"));
			project.setProjectStatus("InProgress");
			project.setProjectDesc(request.getParameter("desc"));
			project.setStartDate(LocalDate.parse(request.getParameter("sdate")));
			
			String[] teamMembers = request.getParameterValues("teamMembers");
			for(String s: teamMembers)
			{
				System.out.println("selected team members are:"+s);
			}
			String message= service.createNewProject(project, "user7");
			String projectid= project.getProjectId();
			service.createTeam(teamMembers, projectid);
			/*if(message=="Project added successfully!")
			{
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			else
				if(message=="Project not added")
				{
					request.setAttribute("message", message);
					request.getRequestDispatcher("Login.jsp").forward(request, response);
                    
				}*/
			
		}
		/*else {
			request.getRequestDispatcher("Logout.jsp").forward(request, response);

		}*/
		
	}


