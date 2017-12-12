package com.mm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.mm.pojo.Exam;
import com.mm.pojo.Teacher;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import net.sf.ehcache.search.Results;

public class ExamDAO {

	public static Exam getOneExam(java.sql.Statement st,int id) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from exam where id="+id+";");
		Exam obj=null;
		while(rs.next())
		{
			 obj=new Exam(rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)
					,rs.getInt(10),rs.getInt(11));
			//System.out.println(obj);
		}
		return obj;
	}
	public static Vector<String> getExamNames() throws SQLException
	{
		ResultSet rs=ConnectionDAO.getStmt().executeQuery("Select exam_name from exam;");
		Vector< String > ar=new Vector<>();
		while(rs.next())
			ar.add(rs.getString(1));
		return ar;
	}
	
	public static ArrayList<Exam> getAllExam(Statement st) throws SQLException
	{
		ResultSet rs=st.executeQuery("select * from exam;");
		ArrayList<Exam> ar=new ArrayList<>();
		while(rs.next())
		{
			 ar.add(new Exam(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)
						,rs.getInt(10),rs.getInt(11)));
			
		}
		return ar;
	}
	public static void addOneExam(Connection con,Exam obj,int type) throws SQLException
	{
		String q=null;
		if(type==1)
			q="insert into exam(exam_name,"
				+ "branch,year,sem,batch,insem_max,endsem_max,prac_max,tw_max,oral_max) "
				+ "values(?,?,?,?,?,?,?,?,?,?);";
		else q="update exam set exam_name=?,"
				+ "branch=?,year=?,sem=?,batch=?,insem_max=?,endsem_max=?,prac_max=?,tw_max=?,oral_max=? where id='"+obj.getId()+"';";
		
		java.sql.PreparedStatement st=con.prepareStatement(q);
		st.setString(1,obj.getExam_name());
		st.setString(2, obj.getBranch());
		st.setString(3, obj.getYear());
		st.setInt(4, obj.getSem());
		st.setString(5, obj.getBatch());
		st.setInt(6,obj.getInsem_max());
		st.setInt(7, obj.getEndsem_max());
		st.setInt(8, obj.getPrac_max());
		st.setInt(9,obj.getTw_max());
		st.setInt(10,obj.getOral_max());
		
		
		st.executeUpdate();
		System.out.println("Addition successful");
		
		
		
		
	}
	public static void BatchAddExam(Connection con,ArrayList<Exam> ar) throws SQLException
	{
		
		java.sql.PreparedStatement st=con.prepareStatement("insert into exam(exam_name,"
				+ "branch,year,sem,batch,insem_max,endsem_max,prac_max,tw_max) "
				+ "values(?,?,?,?,?,?,?,?,?);");
		for(Exam obj:ar)
		{
			st.setString(1,obj.getExam_name());
			st.setString(2, obj.getBranch());
			st.setString(3, obj.getYear());
			st.setInt(4, obj.getSem());
			st.setString(5, obj.getBatch());
			st.setInt(6,obj.getInsem_max());
			st.setInt(7, obj.getEndsem_max());
			st.setInt(8, obj.getPrac_max());
			st.setInt(9,obj.getTw_max());
			st.setInt(10,obj.getOral_max());
			st.executeUpdate();
		}
		System.out.println("Addition successful");
		
		
		
		
	}
	public static int  deleteExam(Statement st,Exam obj) throws SQLException
	{
		return st.executeUpdate("delete from exam where id='"+obj.getId()+"';");
		
	}
	
	
}
