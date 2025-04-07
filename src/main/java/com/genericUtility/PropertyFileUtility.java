package com.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	
	/**
	 * This method reads data from the property file using the given key.
	 * @author Saba
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstant.PropertyFilePath);
		Properties property= new Properties();
		property.load(fis);
		String value=property.getProperty(key);
		return value;
		
	}
}
