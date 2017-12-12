package com.mm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mm.pojo.Student;
import com.mm.pojo.Teacher;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TeacherDAO {
	public static Teacher getOneTeacher(java.sql.Statement st,int id) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from teacher where t_id="+id+";");
		Teacher obj=null;
		while(rs.next())
		{
			 obj=new Teacher(rs.getInt(1),rs.getString(2),rs.getInt(3),
					rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
			//System.out.println(obj);
		}
		return obj;
	}
	public static ArrayList<Teacher> getAllTeachers(Statement st) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from teacher;");
		ArrayList<Teacher> ar=new ArrayList<>();
		while(rs.next())
		{
			 ar.add(new Teacher(rs.getInt(1),rs.getString(2),rs.getInt(3),
						rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7)));
			
		}
		return ar;
	}
	public static void addOneTeacher(Connection con,Teacher obj,int type) throws SQLException
	{
		String q=null;
		if(type==1)
			q="insert into teacher(t_name,sub_id,"
				+ "year,branch,sem,division) values(?,?,?,?,?);";
		else q="update teacher set t_name=?,sub_id=?,"
				+ "year=?,branch=?,sem=?,division=? where t_id="+obj.getT_id()+";";
		
		java.sql.PreparedStatement st=con.prepareStatement(q);
		st.setString(1,obj.getT_name());
		st.setInt(2, obj.getSub_id());
		st.setString(3, obj.getYear());
		st.setString(4, obj.getBranch());
		st.setInt(5, obj.getSem());
		st.setString(6,obj.getDivision());
		
		
		st.executeUpdate();
		System.out.println("Addition successful");
		
		
		
		
	}
	public static void BatchAddTeacher(Connection con,ArrayList<Teacher> ar) throws SQLException
	{
		
		java.sql.PreparedStatement st=con.prepareStatement("insert into teacher(t_name,sub_id,"
				+ "year,branch,sem,division) values(?,?,?,?,?,?);");
		for(Teacher obj:ar)
		{
			st.setString(1,obj.getT_name());
			st.setInt(2, obj.getSub_id());
			st.setString(3, obj.getYear());
			st.setString(4, obj.getBranch());
			st.setInt(5, obj.getSem());
			st.setString(6,obj.getDivision());
			st.executeUpdate();
		}
		System.out.println("Addition successful");
		
		
		
		
	}
	public static int  deleteTeacher(Statement st,Teacher obj) throws SQLException
	{
		return st.executeUpdate("delete from teacher where t_id="+obj.getT_id()+";");
		
	}
}
