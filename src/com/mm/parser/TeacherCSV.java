package com.mm.parser;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mm.dao.ConnectionDAO;
import com.mm.pojo.Student;
import com.mm.pojo.Teacher;

public class TeacherCSV {
	public static ArrayList<Teacher> readFile(String path) throws FileNotFoundException
	{
		ArrayList ar=new ArrayList<Teacher>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        ar.add(createTeacherObj(line.split(",")));
		    }
		  return ar;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	public static Teacher createTeacherObj(String str[])
	{
		return new Teacher(str[0],Integer.parseInt(str[1]),str[2],str[3],Integer.parseInt(str[4]),str[5]);
		
	}
	public static void writeFile()
	{
		try {
			FileWriter file=new FileWriter(new File("TeacherData.csv"));
			String str="";
			file.write("ID,Name,Subject Code,Year,Branch,Sem,Division\n");
			ResultSet rs=ConnectionDAO.getStmt().executeQuery("select * from teacher;");
			while(rs.next())
				file.write(rs.getInt(1)+","+rs.getString(2)+","+rs.getInt(3)+","+rs.getString(4)
						+","+rs.getString(5)+","+rs.getInt(6)+","+rs.getString(7)+"\n");
				
				
			
			
			file.close();
			Desktop.getDesktop().open(new File("TeacherData.csv"));
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
