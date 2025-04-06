package com.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pageb")
public class PageB extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This is PageB");

		String pname = (String) req.getAttribute("person_name");
		int phone = (Integer) req.getAttribute("phone");

		PrintWriter pw = resp.getWriter();
		pw.print("<h1>This is PageB</h1>");
		pw.print("<h1>name : " + pname + "</h1>");
		pw.print("<h1>phone : " + phone + "</h1>");
	}
}
