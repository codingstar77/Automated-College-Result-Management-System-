package com.mm.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnectionDAO {
	
	private static Connection con;
	private static java.sql.Statement stmt;
	
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ConnectionDAO.con = con;
	}

	public static java.sql.Statement getStmt() {
		return stmt;
	}

	public static void setStmt(java.sql.Statement stmt) {
		ConnectionDAO.stmt = stmt;
	}

	public static boolean EstablishConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","kd99");  
			
			 stmt=con.createStatement();  
			return true;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
		
	
	}
	public static boolean closeConnection()
	{
		try {
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public static boolean validate(String username,String password)
	{
		try
		{
			
		return stmt.executeQuery("select * from admin where username='"+username+"' and password='"+password+"';").next();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
	}
	public static void main(String[] args) {
		EstablishConnection();
		if(validate("it","IT1"))
			System.out.println("In");
		else System.out.println("out");
	}
}
