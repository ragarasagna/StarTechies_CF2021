package com.hsbc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.business.CloseBugService;
import com.hsbc.business.CloseBugServiceIntf;


@WebServlet("/jsp/CloseBugServlet/*")
public class CloseBugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		String bugId=null;
		if (request.getPathInfo() != null) {
			bugId= request.getPathInfo().substring(1);
		}
		String emailid=(String)session.getAttribute("emailId");
		System.out.println("emaild is:"+emailid);
		CloseBugServiceIntf service= new CloseBugService();
		service.closeBug(bugId, emailid);
		String projectName=(String) session.getAttribute("projectname");
		System.out.println(projectName);
		String close= request.getParameter("close");
		if(close==null)
		{
			request.getRequestDispatcher("../jsp/pmdisplaydetails.jsp").forward(request, response);
		}
		else
		if(close.equals("close"))
		{
			response.sendRedirect("../jsp/pmdisplaydetails.jsp");
		}

		//request.getRequestDispatcher("/ProjectDetailsServlet/"+projectName);
		//service.close(bugId);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
