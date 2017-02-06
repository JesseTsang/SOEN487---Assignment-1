/**
 * 
 */
package com.assignment1.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

import com.assignment1.model.Feed;
import com.assignment1.model.FeedMessage;

/**
 * @author Jesse
 *
 *	This class reads a XML file from a provided RSS url.
 */
public class RSSFeedParser 
{
	static final String TITLE = "title";
	static final String DESCRIPTION = "description";
	static final String CHANNEL = "channel";
	static final String LANGUAGE = "language";
	static final String COPYRIGHT = "copyright";
	static final String LINK = "link";
	static final String AUTHOR = "author";
	static final String ITEM = "item";
	static final String PUB_DATE = "pubDate";
	static final String GUID = "guid";
	
	final URL url;
	
	/*
	 * Constructor
	 */
	public RSSFeedParser(String feedUrl)
	{
		try
		{
			this.url = new URL(feedUrl);			
		}
		catch (MalformedURLException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public Feed readFeed()
	{
		Feed feed = null;
		
		try
		{
			boolean isFeedHeader = true;
			
			//Initialize header values to empty strings.
			String description = "";
			String title = "";
			String link = "";
			String language = "";
			String copyright = "";
			String author = "";
			String pubDate = "";
			String guid = "";
			
			//1. First we create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			
			//2. Setup a new eventReader
			InputStream in = read();
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			
			//3. Read the XML document
			while (eventReader.hasNext())
			{
				XMLEvent event = eventReader.nextEvent();
				
				if(event.isStartElement())
				{
					String localPart = event.asStartElement().getName().getLocalPart();
					
					switch(localPart)
					{
						case ITEM:
							if (isFeedHeader)
							{
								isFeedHeader = false;
								feed = new Feed(title, link, description, language, copyright, pubDate);
							}
							event = eventReader.nextEvent();
							break;
						
						case TITLE:
							title = getCharacterData(event, eventReader);
							break;
						
						case DESCRIPTION:
							description = getCharacterData(event, eventReader);
							break;
						
						case LINK:
							link = getCharacterData(event, eventReader);
							break;
						
						case GUID:
							guid = getCharacterData(event, eventReader);
							break;
						
						case LANGUAGE:
							language = getCharacterData(event, eventReader);
							break;
						
						case AUTHOR:
							author = getCharacterData(event, eventReader);
							break;
							
						case PUB_DATE:
							pubDate = getCharacterData(event, eventReader);
							break;
							
						case COPYRIGHT:
							copyright = getCharacterData(event, eventReader);
							break;	
					} //End switch
				}
				else if (event.isEndElement())
				{
					if (event.asEndElement().getName().getLocalPart() == (ITEM))
					{
						FeedMessage message = new FeedMessage();
						
						message.setAuthor(author);
						message.setDescription(description);
						message.setGuid(guid);
						message.setLink(link);
						message.setTitle(title);
						
						feed.getMessages().add(message);
						
						event = eventReader.nextEvent();
						continue;
					}
				} //End else if
			} // End while
		}
		catch (XMLStreamException e)
		{
			throw new RuntimeException(e);
		}
		
		return feed;	
	}

	private String getCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException
	{
		String result = "";
		event = eventReader.nextEvent();
		
		if (event instanceof Characters)
		{
			result = event.asCharacters().getData();
		}

		return result;
	}

	private InputStream read() 
	{
		try
		{
			return url.openStream();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

}
