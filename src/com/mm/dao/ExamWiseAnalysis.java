package com.mm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.sf.ehcache.search.Results;

public class ExamWiseAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String getExamStats(String examname) throws SQLException
	{
		ResultSet rs=ConnectionDAO.getStmt().executeQuery("select id from exam  where exam_name='"+examname+"';");
		rs.next();
		int id=rs.getInt(1);
		
		rs=ConnectionDAO.getStmt().executeQuery("select count(stu_id) from  sgpa_t where exam_id="+id+";");
		rs.next();
		
		int total_student=rs.getInt(1);
		
		rs=ConnectionDAO.getStmt().executeQuery("select count(stu_id) from  sgpa_t where exam_id="+id+"  and sgpa>0;");
		rs.next();
		int pass_student=rs.getInt(1);
		
		float passf=(pass_student*100)/(float)total_student;
		String result="Total No of Students appeared :"+total_student+"\n";
		result+="Total No of Students Passed :"+pass_student+"\n";
		result+="Result of Exam :"+passf+"\n";
		return result;	
	}
	public static String getSubjectStats(String examname) throws SQLException
	{
		ResultSet rs=ConnectionDAO.getStmt().executeQuery("select id from exam  where exam_name='"+examname+"';");
		rs.next();
		int id=rs.getInt(1);
		rs=ConnectionDAO.getStmt().executeQuery("select count(stu_id) from  sgpa_t where exam_id="+id+";");
		rs.next();
		
		int total_student=rs.getInt(1);
		 rs=ConnectionDAO.getStmt().executeQuery("select sub_code,count(stu_id) from result_t where grade = 'F' and exam_id="+id+"  group by  sub_code;");
			String temp="";
		 while(rs.next())
			temp+=rs.getInt(1)+"\t"+(total_student-rs.getInt(2))+"\n";
		 String strarr[]=temp.split("\\n+");
		 String result="SubName\tSubCode\t%Result\n";
		 for(String st:strarr)
		 {
			 String sk[]=st.split("\\t+");
			 rs=ConnectionDAO.getStmt().executeQuery("Select sub_name from subject where sub_code= "+Integer.parseInt(sk[0])+";");
			 rs.next();
			 int pass=Integer.parseInt(sk[1]);
			 float passf=(pass*100)/(float)total_student;
			 result+=rs.getString(1)+"\t"+sk[0]+"\t"+passf+"\n";
			 
		 }
		 
			return result;		
	}
	public static String getTopTen(String examname) throws SQLException
	{
		ResultSet rs=ConnectionDAO.getStmt().executeQuery("select id from exam  where exam_name='"+examname+"';");
		rs.next();
		int id=rs.getInt(1);
		int rank=1;
		rs=ConnectionDAO.getStmt().executeQuery("select s.stu_id,r.stud_name,s.sgpa from sgpa_t s,student r where exam_id="+id+" and s.stu_id=r.uni_roll order by s.sgpa desc;");
		String result="Rank\tSeatNo\tName\tSGPA\n";
		float sgpatemp=0;
		while(rs.next())
		{
			
			
			float mk=rs.getFloat(3);
		
		if(sgpatemp>mk)
			rank++;
		result+=rank+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+mk+"\n";
			sgpatemp=rs.getFloat(3);
			if(rank>=10)
				break;
		}
		return result;
		
		
	}
	public static String getSubTop(String examname) throws SQLException
	{
		ResultSet rs=ConnectionDAO.getStmt().executeQuery("select id from exam  where exam_name='"+examname+"';");
		rs.next();
		int id=rs.getInt(1);
		rs=ConnectionDAO.getStmt().executeQuery("select sub_code,max(total) from result_t where total>0 and exam_id="+id+" group by sub_code;");
		ArrayList<Integer> code=new ArrayList<>();
		ArrayList<Integer> mk=new ArrayList<>();
		while(rs.next())
		{
			code.add(rs.getInt(1));
			mk.add(rs.getInt(2));
			
		}
		String result="SubCode\tSeatNo\tName\tMarks\n";
		for(int i=0;i<code.size();i++)
		{
			rs=ConnectionDAO.getStmt().executeQuery("select r.stu_id,s.stud_name from result_t r,student s where r.total="+mk.get(i)+" and r.sub_code"
					+ " = "+code.get(i)+" and r.stu_id=s.uni_roll and exam_id="+id+";");
			while(rs.next())
			result+=code.get(i)+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+mk.get(i)+"\n";
		}
		return result;
	}
}
