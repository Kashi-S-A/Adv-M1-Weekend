package com.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pagea")
public class PageA extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This is PageA");
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>This is PageA</h1>");
		
		String name = "Rahul";
		
		req.setAttribute("person_name", name);
		req.setAttribute("phone", 23456);
		
		RequestDispatcher rd = req.getRequestDispatcher("pageb");//dispatching req to PageB servlet
		rd.forward(req, resp);
		
//		RequestDispatcher rd = req.getRequestDispatcher("test.html");//dispatching req to test.html
//		rd.include(req, resp);
	}
}
