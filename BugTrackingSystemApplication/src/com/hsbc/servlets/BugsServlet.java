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
import com.hsbc.business.BugOperationsService;
import com.hsbc.business.BugOperationsServiceIntf;

import com.hsbc.business.ProjectOperationsService;
import com.hsbc.business.ProjectOperationsServiceIntf;
import com.hsbc.dao.ProjectModelDao;

@WebServlet("/jsp/BugsServlet/*")
public class BugsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BugOperationsServiceIntf bugService = null;
	ProjectOperationsServiceIntf projectService = null;

	public BugsServlet() {
		bugService = new BugOperationsService();
		projectService = new ProjectOperationsService();
	}

	public void fetchBugDetails(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String emailId = (String) session.getAttribute("emailId");
		List<Bugs> bugslist = bugService.testerProjectDetails(emailId);
		request.setAttribute("testerbuglist", bugslist);
		try {
			request.getRequestDispatcher("/jsp/testerbugs.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String projectName = null;
		String path = null;
		String[] arr = null;
		String emailId = (String) session.getAttribute("emailId");
		if (request.getPathInfo() != null) {
			path = request.getPathInfo().substring(1);
			arr = path.split("/", 5);

		}
		if (arr[0].equals("ReportNewBug")) {
			reportNewBug(request, response, session, emailId);
		} else if (arr[0].equals("BugsReported")) {
			fetchBugDetails(request, response, session);
		}
		else if (arr[0].equals("treportbug")) {
			response.sendRedirect("/BugTrackingSystemApplication/jsp/BugsServlet/BugsReported");
		} 	

		else if (arr[0].isEmpty()) {
			response.sendRedirect("/BugTrackingSystemApplication/jsp/BugsServlet/BugsReported");
		} 
	}

	void projectDetails(HttpServletRequest request, HttpServletResponse response,HttpSession session, String projectName,
			String severity) {
	
		ProjectModelDao dao = new ProjectModelDao();
		List<Users> teamDetails = projectService.getTeamMembers(projectName);
		List<Users> devList = dao.fetchDevelopersByProjectName(projectName);
		String emailId = (String) session.getAttribute("emailId");
		String projectManagerName = projectService.getManagerName(projectName);
		String startDate = projectService.getStartDate(projectName);
		List<Bugs> bugsList = bugService.DisplayBugs(projectName,severity);
		request.setAttribute("projectName", projectName);
		request.setAttribute("managername", projectManagerName);
		request.setAttribute("date", startDate);
		request.setAttribute("team", teamDetails);
		request.setAttribute("bugslist", bugsList);
		request.setAttribute("developerList", devList);
		try {
			request.getRequestDispatcher("/jsp/pmdisplaydetails.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	private void assignBug(HttpServletRequest request, HttpServletResponse response, HttpSession session, String bugId,
			String projectName) {

		String developerName = request.getParameter("devName");
		bugService.assignBugToDeveloper(developerName, bugId);
		String url = "/BugTrackingSystemApplication/jsp/ProjectsServlet/Details/" + projectName;
		try {
			response.sendRedirect(url);
		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void reportNewBug(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String emailId) {

		List<Project> testerProjects = projectService.projectNames(emailId);
		request.setAttribute("testerprojects", testerProjects);
		try {
			request.getRequestDispatcher("/jsp/treportbug.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = null;
		String[] arr = null;
		String projectName = null;
		
		
		if (request.getPathInfo() != null) {
			path = request.getPathInfo().substring(1);
			arr = path.split("/", 5);
		}
		
		if (arr[0].equals("treportbug")) {
			Bugs bug = new Bugs();
			bug.setProjectName(request.getParameter("pname"));
			bug.setBugTitle(request.getParameter("bugtitle"));
			bug.setBugDesc(request.getParameter("descbug"));
			bug.setSeverityLevel(request.getParameter("severity"));
			bugService.reportNewBug(bug);
		} else if (arr[0].equals("pmdisplaydetails")) {
			projectName = request.getParameter("projectName");
			String bugId = request.getParameter("bugId");
			
			assignBug(request, response, session, bugId, projectName);

		}else if(arr[0].equals("filter")) {
			projectName = request.getParameter("projectName1");
			String severity=request.getParameter("filter");
			projectDetails(request, response, session, projectName, severity);
			
		}

		doGet(request, response);
	}

};

