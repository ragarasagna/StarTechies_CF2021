package com.hsbc.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		InputStream is = request.getInputStream();

		File file = new File("C:\\importusers\\users.json");
		FileOutputStream os = new FileOutputStream(file);
		int read;
		int fileSize = is.available();
		byte[] bytes = new byte[8192];

		read = is.read(bytes, 0, bytes.length);
		String s = new String(bytes);
		char[] chars = s.toCharArray();
		int start, last;
		start = 0;
		last = bytes.length;
		// int count =1;
		for (int i = 0; i < bytes.length; i++) {
			if (chars[i] == '[')
				start = i;
			if (chars[i] == ']') {
				last = i;
				break;
			}
		}
		os.write(bytes, start, last - start + 1);
		ImportUsersServiceIntf imp = new ImportUsersService();
		imp.readFile();
		request.getRequestDispatcher("../jsp/register.jsp").forward(request,response);
		// out.println("Successfully Uploaded.");
	}

}
