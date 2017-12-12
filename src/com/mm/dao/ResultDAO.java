package com.mm.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mm.pojo.Result_t;
import com.mm.pojo.Teacher;
import com.mysql.jdbc.Connection;

public class ResultDAO {
	
	public static void  addBatchResult(Connection con,ArrayList<Result_t> ar) throws SQLException
	{
		java.sql.PreparedStatement st=con.prepareStatement("insert into result_t(sub_code,exam_id,"
				+ "stu_id,insem,endsem,total,practical,term_work,oral,grade) values(?,?,?,?,?,?,?,?,?,?);");
		for(Result_t obj:ar)
		{
			st.setInt(1,obj.getSub_id());
			st.setInt(2, obj.getExam_id());
			st.setString(3, obj.getStu_id());
			st.setInt(4, obj.getInsem());
			st.setInt(5, obj.getEndsem());
			st.setInt(6,obj.getTotal());
			st.setInt(7, obj.getPractical());
			st.setInt(8, obj.getTerm_work());
			st.setInt(9, obj.getOral());
			st.setString(10, obj.getGrade());
			
			st.executeUpdate();
		}
		System.out.println("Addition successful");
	}
	
	
}
