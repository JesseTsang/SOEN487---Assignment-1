/**
 * 
 */
package com.assignment1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment1.model.LoginBean;

/**
 * @author Jesse Tsang
 *	
 *	This is a controller class in MVC pattern that intercept the login request 
 *	and pass the validation to LoginBean.java and return a proper page.
 */
public class ControllerServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//1. Extract values from the JSP form - index.jsp
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//2. Setup Java Bean class
		LoginBean bean = new LoginBean();
		
		bean.setName(name);
		bean.setPassword(password);
		
		request.setAttribute("bean", bean);
		
		//3. Valdate data & Forward to output page.
		boolean status = bean.validate();
		
		if(status == true)
		{
			RequestDispatcher rd = request.getRequestDispatcher("login-success.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
		}		
	}//end doPost()
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
}
