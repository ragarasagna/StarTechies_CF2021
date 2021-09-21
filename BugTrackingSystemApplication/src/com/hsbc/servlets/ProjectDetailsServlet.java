package com.hsbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.hsbc.beans.Project;
import com.hsbc.dao.ProjectDetailsDao;
import com.hsbc.dao.ProjectDetailsIntf;

@WebServlet("/getProjectDetails")
public class ProjectDetailsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String projectName = req.getParameter("projectName");
		
		System.out.println(projectName);
		
		ProjectDetailsIntf dao = new ProjectDetailsDao();
		
		JSONObject proj = dao.getProjectDetails(projectName);
		
		out.println(proj.toString());
		
		
	}

}
