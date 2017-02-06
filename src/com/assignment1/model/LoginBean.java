/**
 * 
 */
package com.assignment1.model;

/**
 * @author Jesse Tsang
 *
 *	This is a serializable Java Bean class that uses Getters & Setters for login properties.
 */
public class LoginBean 
{
	private String name;
	private String password;
	
	public boolean validate()
	{
		if(password.equals("admin"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		
	//Getters & Setters -- Below
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Getters & Setters -- Above

}
