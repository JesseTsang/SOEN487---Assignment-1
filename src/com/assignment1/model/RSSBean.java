/**
 * 
 */
package com.assignment1.model;

import java.util.List;

/**
 * @author Jesse Tsang
 * 
 * 	This is a serializable Java Bean class that uses Getters & Setters for the RSS url properties.
 *
 */
public class RSSBean 
{
	private String url;
	
	public List<FeedMessage> parseURL()
	{
		RSSFeedParser feedParser = new RSSFeedParser(url);
		
		Feed resultFeed = feedParser.readFeed();
		List<FeedMessage> result = resultFeed.getMessages();
		
		return result;
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
