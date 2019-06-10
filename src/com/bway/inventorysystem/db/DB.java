package com.bway.inventorysystem.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
	public static Connection getDBCon()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorysystem", "root", "");
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
