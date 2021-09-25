package com.hsbc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.beans.Bugs;
import com.hsbc.beans.Project;
import com.hsbc.beans.Users;
import com.hsbc.business.ProjectDetailsService;
import com.hsbc.business.ProjectDetailsServiceIntf;
import com.hsbc.dao.BugModelDao;
import com.hsbc.dao.ProjectModelDao;

@WebServlet("/jsp/ProjectsServlet/*")
public class ProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 void retrieveProject(HttpServletRequest request, HttpServletResponse response)
 {
	 	HttpSession session = request.getSession();
		ProjectModelDao Sr = new ProjectModelDao();
		BugModelDao bugmodel= new BugModelDao();
		String emailId = (String) session.getAttribute("emailId");
		String projectName= Sr.projectName(emailId);
		String projectManager= Sr.getManagerName(projectName);
		String date= Sr.getStartDate(projectName);
		List<Users> team=Sr.getTeamMembers(projectName);
        List<Bugs> bugsList= bugmodel.fetchAssignedBug(emailId);
        
        System.out.println("emaildId from servlet: "+emailId);
        System.out.println("projectName from servlet: "+projectName);
        System.out.println("projectmanager from servlet: "+projectManager);
        System.out.println("date from servlet: "+date);
        System.out.println("bugsliost from servlet: "+bugsList);



        
        request.setAttribute("projectname", projectName);
        request.setAttribute("projectmanager",projectManager);
        request.setAttribute("startdate", date);
        request.setAttribute("team", team);
        request.setAttribute("bugslist", bugsList);
        try {
			request.getRequestDispatcher("/jsp/developerproject.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
 }
	
	void projectList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside projectslist");
		HttpSession session = request.getSession();
		ProjectModelDao Sr = new ProjectModelDao();
		String emailId = (String) session.getAttribute("emailId");
		List<Project> projects = Sr.projectNames(emailId);
		System.out.println("projects: " + projects);
		request.setAttribute("projects", projects);
		try {
			request.getRequestDispatcher("/jsp/pmdisplayproject.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	void projectDetails(HttpServletRequest request, HttpServletResponse response, String projectName)
	{
		ProjectModelDao Sr = new ProjectModelDao();
		BugModelDao bugmodel= new BugModelDao();
		HttpSession session = request.getSession();
		List<Users> teamDetails= Sr.getTeamMembers(projectName);
		String emailId= (String)session.getAttribute("emailId");
		System.out.println("team details: "+teamDetails);
		String projectManagerName=Sr.getManagerName(projectName);
		String startDate= Sr.getStartDate(projectName);
		List<Bugs> bugsList= bugmodel.DisplayBugs(projectName);
		request.setAttribute("projectName", projectName);
	    request.setAttribute("managername", projectManagerName);
		request.setAttribute("date", startDate);
		request.setAttribute("team", teamDetails);
		request.setAttribute("bugslist", bugsList);
		System.out.println("Inside method"+bugsList);
		try {
			request.getRequestDispatcher("/jsp/pmdisplaydetails.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 public void markForClosing(HttpServletRequest request, HttpServletResponse response,String bugId) {
		BugModelDao dao=new BugModelDao();
		dao.markForClose(bugId);
		try {
			response.sendRedirect("/BugTrackingSystemApplication/jsp/ProjectsServlet/ProjectAssigned");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 }

	 public void fetchBugDetails(HttpServletRequest request, HttpServletResponse response)
	 {
		 
		 HttpSession session = request.getSession();
		 String emailId= (String)session.getAttribute("emailId");
		 BugModelDao dao=new BugModelDao();
		 List<Bugs> bugslist= dao.testerProjectDetails(emailId);
		 System.out.println(bugslist);
		 request.setAttribute("testerbuglist", bugslist);
		 System.out.println("tester bugs: "+bugslist);
		 try {
			request.getRequestDispatcher("/jsp/testerbugs.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession session= request.getSession();
//		//ProjectDetailsService Sr= new ProjectDetailsService();
//	    ProjectModelDao Sr= new ProjectModelDao();
//		String projectName=null;
//		/*if (request.getPathInfo() != null) {
//			projectName = request.getPathInfo().substring(1);
//		}*/
        System.out.println("close value is:"+request.getAttribute("close"));
		String projectName = null;
		String path = null;
		String[] arr = null;
		if (request.getPathInfo() != null) {
			path = request.getPathInfo().substring(1);
			arr = path.split("/", 5);
			for (String s : arr) {
				System.out.println("pathh:" + s);
			}
			if (arr[0].equals("Details")) {
				if (arr.length > 1) {
					projectName = arr[1];
					projectDetails(request,response, projectName);

				} else {
					projectList(request, response);
				}
			} else if (arr[0].equals("NewProject")) {
				// newProject();
				
			}
			else if(arr[0].equals("ProjectAssigned"))
			{
				if (arr.length > 1) {
					String bugid= arr[2];
					System.out.println("inside if  bug"+bugid);
					markForClosing(request,response,bugid);

				} else {
					retrieveProject(request, response);
				}
				
			}
			else if(arr[0].equals("TesterBugsDetails"))
			{
				fetchBugDetails(request,response);
			}
			

		}

//		System.out.println("substring 2: "+request.getPathInfo().substring(2));
//		System.out.println("projectName: "+projectName);
//		//System.out.println("project name is...:"+projectName);
//		List<Users> teamDetails= Sr.getTeamMembers(projectName);
//		String emailId= (String)session.getAttribute("emailId");
//		List<Project> projects= Sr.projectNames(emailId);
//		System.out.println("team details: "+teamDetails);
//		String projectManagerName=Sr.getManagerName(projectName);
//		
//		String startDate= Sr.getStartDate(projectName);
//		System.out.println("managername: "+projectManagerName);
//		System.out.println("startdae: "+startDate);
		/*
		 * ArrayList<Bugs> bugslist= Sr.fetchBugsList(projectName); for(Bugs bug:
		 * bugslist) { System.out.println(bug.getBugDesc()); }
		 */
		// request.setAttribute("bugslist", bugslist);
//		request.setAttribute("projectname", projectName);
//		request.setAttribute("managername", projectManagerName);
//		request.setAttribute("date", startDate);
//		request.setAttribute("team", teamDetails);
//		request.setAttribute("projects", projects);
//		request.getRequestDispatcher("../jsp/pmdisplaydetails.jsp").forward(request, response);	
	}
	// response.sendRedirect(arg0);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);

	}

}
