package com.tapfood.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private DBUtil() {

	}
	public static DBUtil connection=new DBUtil();
	public static DBUtil getDBUtils() 
	{
		return connection;
	}
	public static Connection myConnect() {
		String url="jdbc:mysql://localhost:3306/user";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}