package com.mm.analysis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mm.dao.ConnectionDAO;
import com.mm.pojo.Result_t;


public class StudentResult {
	
	public static ArrayList<Result_t> getResult(int examid,String uni) throws SQLException
	{
		ArrayList<Result_t> ar=new ArrayList<>();
		String sql="select * from result_t where exam_id="+examid+" and stu_id='"+uni+"';";
		Statement st=ConnectionDAO.getStmt();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
			ar.add(new Result_t(rs.getInt(2),rs.getInt(3), rs.getString(4),rs.getInt(5), rs.getInt(6),
					rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11)));
		return ar;
			
	}
	public static float getSgpa(int examid,String uni) throws SQLException
	{
		String sql="select sgpa from sgpa_t where exaam_id="+examid+" and stu_is='"+uni+"';";
		Statement st=ConnectionDAO.getStmt();
		ResultSet rs=st.executeQuery(sql);
		rs.next();
		return rs.getFloat(1);
	}
}
