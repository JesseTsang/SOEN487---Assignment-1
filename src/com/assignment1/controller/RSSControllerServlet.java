/**
 * 
 */
package com.assignment1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jesse Tsang
 * 
 * 	This is a controller class in MVC pattern that intercept the form request in login-success.jsp 
 *	and pass the url value to RSSBean.java and return a proper page.
 */
public class RSSControllerServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/heml");
		PrintWriter out = response.getWriter();
		
		
		
		
	}

}
