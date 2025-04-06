package com.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginPage extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("useremail");
		String pwd = req.getParameter("userpwd");
		
		System.out.println(email);
		System.out.println(pwd);
		
		PrintWriter pw = resp.getWriter();
		pw.print("<h1>User with email : "+email+" is logged in </h1>");
	}
}
