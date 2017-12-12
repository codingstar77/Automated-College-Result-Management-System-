package com.mm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mm.pojo.Subject;
import com.mm.pojo.Subject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SubjectDAO {
	public static Subject getOneSubjectById(Statement st,int id) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from subject where sub_id="+id+";");
		Subject obj=null;
		while(rs.next())
		{
			 obj=new Subject(rs.getInt(1),rs.getInt(2),rs.getString(3),
					rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
			//System.out.println(obj);
		}
		return obj;
	}
	public static Subject getOneSubjectByCode(java.sql.Statement st,int id) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from subject where sub_code="+id+";");
		Subject obj=null;
		while(rs.next())
		{
			 obj=new Subject(rs.getInt(1),rs.getInt(2),rs.getString(3),
					rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
			//System.out.println(obj);
		}
		return obj;
	}
	public static ArrayList<Subject> getAllSubjects(Statement st) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from subject;");
		ArrayList<Subject> ar=new ArrayList<>();
		while(rs.next())
		{
			 ar.add(new Subject(rs.getInt(1),rs.getInt(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			
		}
		return ar;
	}
	public static void addOneSubject(Connection con,Subject obj,int type) throws SQLException
	{
		String q=null;
		if(type==1)
			q="insert into subject(sub_code,sub_name"
				+ "year,branch,batch,sem) values(?,?,?,?,?,?);";
		else q="update subject set sub_code=?,sub_name=?,"
				+ "year=?,branch=?,batch=?,sem=? where sub_code="+obj.getSub_code()+";";
		
		java.sql.PreparedStatement st=con.prepareStatement(q);
		st.setInt(1,obj.getSub_code());
		st.setString(2, obj.getSub_name());
		st.setString(3, obj.getYear());
		st.setString(4, obj.getBranch());
		st.setString(5, obj.getBatch());
		st.setInt(6,obj.getSem());
		
		
		st.executeUpdate();
		System.out.println("Addition successful");
		
		
		
		
	}
	public static void BatchAddSubject(Connection con,ArrayList<Subject> ar) throws SQLException
	{
		
		java.sql.PreparedStatement st=con.prepareStatement("insert into subject(sub_code,sub_name"
				+ ",year,branch,batch,sem) values(?,?,?,?,?,?);");
		for(Subject obj:ar)
		{
			st.setInt(1,obj.getSub_code());
			st.setString(2, obj.getSub_name());
			st.setString(3, obj.getYear());
			st.setString(4, obj.getBranch());
			st.setString(5, obj.getBatch());
			st.setInt(6,obj.getSem());
			
			st.executeUpdate();
		}
		System.out.println("Addition successful");
		
		
		
		
	}
	public static int  deleteSubject(Statement st,Subject obj) throws SQLException
	{
		return st.executeUpdate("delete from subject where sub_id='"+obj.getSub_id()+"';");
		
	}
}
