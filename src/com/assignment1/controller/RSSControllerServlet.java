/**
 * 
 */
package com.assignment1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment1.model.Feed;
import com.assignment1.model.FeedMessage;
import com.assignment1.model.RSSBean;

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
		//1. Extract values from the JSP form - login-success.jsp
		response.setContentType("text/heml");
		PrintWriter out = response.getWriter();
		
		String url = request.getParameter("url");
				
		//2. Setup Java Bean class
		RSSBean rssBean = new RSSBean();
		rssBean.setUrl(url);
		
		request.setAttribute("rssBean", rssBean);
		
		//3. Request operation & Forward to output page.
		List<FeedMessage> feed = rssBean.parseURL();
		
		request.setAttribute("feed", feed);
		
		RequestDispatcher rd = request.getRequestDispatcher("RSSResult.jsp");
		rd.forward(request, response);	
	}//end doPost()
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);		
	}

}
