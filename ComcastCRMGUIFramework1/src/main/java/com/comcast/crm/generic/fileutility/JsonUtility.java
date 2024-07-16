package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String readDataFromJson(String key) throws Throwable{
		JSONParser jparse = new JSONParser();
		Object obj = jparse.parse( new FileReader("./configure/jsondata.json"));
		
		JSONObject jobj = (JSONObject)obj;
		return (String)jobj.get(key);
	}

}
