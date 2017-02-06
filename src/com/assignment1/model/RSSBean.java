/**
 * 
 */
package com.assignment1.model;

/**
 * @author Jesse Tsang
 * 
 * 	This is a serializable Java Bean class that uses Getters & Setters for the RSS url properties.
 *
 */
public class RSSBean 
{
	private String url;
	
	public Feed parseURL(String url)
	{
		RSSFeedParser feedParser = new RSSFeedParser(url);
		
		return feedParser.readFeed();
	}

	//Getters & Setters -- Below
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	//Getters & Setters -- Above
	
	

}
