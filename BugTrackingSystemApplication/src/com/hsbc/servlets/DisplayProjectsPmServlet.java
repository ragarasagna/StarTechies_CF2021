package com.hsbc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.beans.Project;
import com.hsbc.business.DisplayProjectsService;
import com.hsbc.business.DisplayProjectsServiceIntf;

@WebServlet("/jsp/DisplayProjectsPmServlet")
public class DisplayProjectsPmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		String emailId=(String) session.getAttribute("emailId");
		DisplayProjectsServiceIntf service= new DisplayProjectsService() ;
		
			List<Project> projects= service.fetchProjectNames(emailId);
			request.setAttribute("projects", projects);
			request.getRequestDispatcher("../jsp/pmdisplayproject.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
