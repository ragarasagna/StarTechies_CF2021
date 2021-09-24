package com.hsbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.hsbc.business.ImportUsersService;
import com.hsbc.business.ImportUsersServiceIntf;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/jsp/ImportUsersServlet")
public class ImportUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FileItem item;
		//String fieldName = .getFieldName();
		response.setContentType("text/text");
		//PrintWriter out = response.getWriter();
		String fileName= request.getParameter("up");
	
		System.out.println(fileName);
		MultipartRequest mr = new MultipartRequest(request,"C:\\importusers");
		String file="C:\\importusers\\"+fileName;
		ImportUsersServiceIntf imp= new ImportUsersService();
		imp.readFile(file);
		//out.println("Successfully Uploaded.");
	}

}
