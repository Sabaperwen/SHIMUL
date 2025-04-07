package com.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Random;

public class JavaUtility {

	/**
	 * This method is used to generate a random number between 0 and 499.
	 * @author Saba
	 * @return
	 */
	public int getRandumNo()
	{
		Random ran=new Random();
		int random = ran.nextInt(500);
		return random;
	}
	
	
	
	/**
	 * This method returns the current system date and time as a String.
	 * @author Saba
	 * @return
	 */
	public String getSystemDate()
	{
		java.util.Date dt = new java.util.Date();
		String date=dt.toString();
		return date;
	}
	
	/**
	 * This method returns the current system date and time
	 * in a specific format: "dd-MM-yyyy HH-mm-ss". 
	 * @author csuser
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		
		java.util.Date dt = new java.util.Date();
		String date=dateformat.format(dt);
		return date;
	}
}
