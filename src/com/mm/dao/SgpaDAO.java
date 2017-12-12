package com.mm.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mm.pojo.Sgpa_t;
import com.mm.pojo.Teacher;
import com.mysql.jdbc.Connection;

public class SgpaDAO {
	
	public static void BatchAddSgpa(Connection con,ArrayList<Sgpa_t> ar) throws SQLException
	{
		
		java.sql.PreparedStatement st=con.prepareStatement("insert into sgpa_t(stu_id,exam_id,"
				+ "batch,sgpa) values(?,?,?,?);");
		for(Sgpa_t obj:ar)
		{
			st.setString(1,obj.getStu_id());
			st.setInt(2, obj.getExam_id());
			st.setString(3, obj.getBatch());
			st.setFloat(4, obj.getSgpa());
			
			st.executeUpdate();
		}
		System.out.println("Addition successful");
		
		
		
		
	}
	
}
