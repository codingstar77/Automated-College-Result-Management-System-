package com.mm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import com.mm.pojo.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class StudentDAO {

	public static Student getOneStudent(java.sql.Statement st,String id) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from student where prn='"+id+"';");
		Student obj=null;
		while(rs.next())
		{
			 obj=new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			//System.out.println(obj);
		}
		return obj;
	}
	public static ArrayList<Student> getAllStudent(Statement st) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from student;");
		ArrayList<Student> ar=new ArrayList<>();
		while(rs.next())
		{
			 ar.add(new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
			
		}
		return ar;
	}
	public static void addOneStudent(Connection con,Student obj,int type) throws SQLException
	{
		String q=null;
		if(type==1)
			q="insert into student(prn,roll_no,uni_roll,"
				+ "stud_name,division,year,branch,batch,email) values(?,?,?,?,?,?,?,?,?);";
		else q="update student set prn=?,roll_no=?,uni_roll=?,"
				+ "stud_name=?,division=?,year=?,branch=?,batch=?,email=? where prn='"+obj.getPrn()+"';";
		
		java.sql.PreparedStatement st=con.prepareStatement(q);
		st.setString(1, obj.getPrn());
		st.setInt(2,obj.getRoll_no());
		st.setString(3, obj.getUni_roll());
		st.setString(4, obj.getStud_name());
		st.setString(5, obj.getDivision());
		st.setString(6, obj.getYear());
		st.setString(7, obj.getBranch());
		st.setString(8, obj.getBatch());
		st.setString(9, obj.getEmail());
		st.executeUpdate();
		System.out.println("Addition successful");
		
		
		
		
	}
	public static void BatchAddStudent(Connection con,ArrayList<Student> ar) throws SQLException
	{
		
		java.sql.PreparedStatement st=con.prepareStatement("insert into student(prn,roll_no,uni_roll,"
				+ "stud_name,division,year,branch,batch,email) values(?,?,?,?,?,?,?,?,?);");
		for(Student obj:ar)
		{
			st.setString(1, obj.getPrn());
			st.setInt(2,obj.getRoll_no());
			st.setString(3, obj.getUni_roll());
			st.setString(4, obj.getStud_name());
			st.setString(5, obj.getDivision());
			st.setString(6, obj.getYear());
			st.setString(7, obj.getBranch());
			st.setString(8, obj.getBatch());
			st.setString(9, obj.getEmail());
			st.executeUpdate();
		}
		System.out.println("Addition successful");
		
		
		
		
	}
	public static int  deleteStudent(Statement st,Student obj) throws SQLException
	{
		return st.executeUpdate("delete from student where prn='"+obj.getPrn()+"';");
		
	}
	
	
	}

