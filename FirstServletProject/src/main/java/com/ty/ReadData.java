package com.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/read")
public class ReadData extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Read the data");
		
		String name = req.getParameter("uname");
		String email = req.getParameter("uemail");
		String password = req.getParameter("upwd");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		
		PrintWriter pw=res.getWriter();
		pw.print("<h1>Welcome "+name+"</h1>");
	}

}
