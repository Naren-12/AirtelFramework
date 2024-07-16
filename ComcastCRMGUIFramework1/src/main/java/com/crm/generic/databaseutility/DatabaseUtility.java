package com.crm.generic.databaseutility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection cnt;
	
	public void getDbconnection( String url, String username, String password ) throws Throwable {
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			cnt = DriverManager.getConnection(url, username, password);
			
			
		} catch (Exception  e) {
		}
	}
	public void getDbconnection( ) throws Throwable {
		/*This method is a customized for testing the regular Database
		 */
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			cnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			
			
		} catch (Exception  e) {
		}
	}
	
	public void closeDbConnection() throws Throwable {
		try {
			cnt.close();
		} catch (Exception e) {	}
	} 
	
	public ResultSet executeSelectQuery(String query) throws Throwable{
		ResultSet res = null;
		try {
			java.sql.Statement stmt = cnt.createStatement();
			res = stmt.executeQuery(query);
		} catch (Exception e) {
			
		}
		return res;
	}
	
	public int executeNonSelectQuery(String query) throws Throwable{
		int rset = 0 ;
		try {
			Statement stmt= cnt.createStatement();
			rset = stmt.executeUpdate(query);
		} catch (Exception e) {}
		return rset;
	}
	
	
}
