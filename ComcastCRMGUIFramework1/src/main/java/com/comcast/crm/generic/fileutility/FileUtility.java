package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromProp(String key) throws Throwable {
		
		FileInputStream fin = new FileInputStream("./configureAppData/commondata.properties");
		Properties prop = new Properties();
		prop.load(fin);
		return prop.getProperty(key);
	}
}
