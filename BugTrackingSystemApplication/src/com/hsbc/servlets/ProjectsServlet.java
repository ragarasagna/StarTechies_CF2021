package com.hsbc.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import com.hsbc.dao.BugModelDao;
import com.hsbc.dao.ProjectModelDao;

@WebServlet("/jsp/ProjectsServlet/*")
public class ProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BugOperationsServiceIntf bugService;
	ProjectOperationsServiceIntf projectService;

	public ProjectsServlet() {
		bugService = new BugOperationsService();
		projectService = new ProjectOperationsService();
	}

	void newProject(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String emailId = (String) session.getAttribute("emailId");
		List<Users> developers = projectService.fetchDevelopers();
		List<String> testers = projectService.fetchTesters(emailId);
		request.setAttribute("developers", developers);
		request.setAttribute("testers", testers);
		try {

			request.getRequestDispatcher("/jsp/newproject.jsp").forward(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void retrieveProject(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String emailId = (String) session.getAttribute("emailId");
		String projectName = projectService.projectName(emailId);
		String projectManager = projectService.getManagerName(projectName);
		String date = projectService.getStartDate(projectName);
		List<Users> team = projectService.getTeamMembers(projectName);
		List<Bugs> bugsList = bugService.fetchAssignedBug(emailId);

		request.setAttribute("projectname", projectName);
		request.setAttribute("projectmanager", projectManager);
		request.setAttribute("startdate", date);
		request.setAttribute("team", team);
		request.setAttribute("bugslist", bugsList);
		try {
			request.getRequestDispatcher("/jsp/developerproject.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void projectList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String emailId = (String) session.getAttribute("emailId");
		List<Project> projects = projectService.projectNames(emailId);
		request.setAttribute("projects", projects);
		try {
			request.getRequestDispatcher("/jsp/pmdisplayproject.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void projectDetails(HttpServletRequest request, HttpServletResponse response, String projectName,
			HttpSession session) {
		ProjectModelDao dao = new ProjectModelDao();
		List<Users> teamDetails = projectService.getTeamMembers(projectName);
		List<Users> devList = dao.fetchDevelopersByProjectName(projectName);
		String emailId = (String) session.getAttribute("emailId");
		String projectManagerName = projectService.getManagerName(projectName);
		String startDate = projectService.getStartDate(projectName);
		List<Bugs> bugsList = bugService.DisplayBugs(projectName);
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

	public void markForClosing(HttpServletRequest request, HttpServletResponse response, String bugId) {
		bugService.markForClose(bugId);
		try {
			response.sendRedirect("/BugTrackingSystemApplication/jsp/ProjectsServlet/ProjectAssigned");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void closeBug(HttpServletRequest request, HttpServletResponse response, HttpSession session, String bugId,
			String projectName) {
		String emailId = (String) session.getAttribute("emailId");
		bugService.closeBug(bugId, emailId);

		String url = "/BugTrackingSystemApplication/jsp/ProjectsServlet/Details/" + projectName;
		try {
			response.sendRedirect(url);
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
		if (request.getPathInfo() != null) {
			path = request.getPathInfo().substring(1);
			arr = path.split("/", 5);
		}

		if (arr[0].equals("Details")) {
			if (arr.length > 1) {
				if (arr.length == 2) {
					projectName = arr[1];
					projectDetails(request, response, projectName, session);
				} else if (arr[2].equals("close")) {
					String bugId = arr[3];
					projectName = arr[1];
					closeBug(request, response, session, bugId, projectName);
				}

			} else {
				projectList(request, response, session);

			}
		} else if (arr[0].equals("NewProject")) {
			if (arr.length > 1) {
				String bugid = arr[2];
				markForClosing(request, response, bugid);

			} else {
				newProject(request, response, session);
			}

		} else if (arr[0].equals("ProjectAssigned")) {
			if (arr.length > 1) {
				String bugid = arr[2];
				markForClosing(request, response, bugid);

			} else {
				retrieveProject(request, response, session);
			}

		} else if (arr[0].equals("TesterBugDetails")) {

		} else if (arr[0].equals("LogOut")) {
			logOutSession(request, response, session);
		}

		else if (arr[0].isEmpty()) {
			response.sendRedirect("/BugTrackingSystemApplication/jsp/ProjectsServlet/Details");
		}

	}

	private void logOutSession(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session.invalidate();

		HttpSession session1 = request.getSession(false);
		if (session1 != null) {
		} else {
			try {
				response.sendRedirect("/BugTrackingSystemApplication/jsp/login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = null;
		try {
			startDate = formatter1.parse(request.getParameter("sdate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LocalDate date = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		HttpSession session = request.getSession();
		String emailId = (String) session.getAttribute("emailId");
		Project project = new Project();

		project.setProjectName(request.getParameter("pname"));

		project.setProjectDesc(request.getParameter("desc"));
		project.setStartDate(date);

		String[] teamMembers = request.getParameterValues("teamMembers");

		for (String s : teamMembers) {
		}
		project = projectService.addProject(project, emailId);
		String projectId = project.getProjectId();
		projectService.assignTeamMembers(teamMembers, projectId);
		doGet(request, response);

	}

}
