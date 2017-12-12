package com.mm.parser;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mm.dao.ConnectionDAO;
import com.mm.pojo.Student;

public class StudentCSV {

	public static ArrayList<Student> readFile(String path) throws FileNotFoundException
	{
		ArrayList ar=new ArrayList<Student>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        ar.add(createStudentObj(line.split(",")));
		    }
		  return ar;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	public static Student createStudentObj(String str[])
	{
		return new Student(str[0],Integer.parseInt(str[1]),str[2],str[3],str[4],str[5],str[6],str[7],str[8]);
		
	}
	public static void writeFile()
	{
		try {
			FileWriter file=new FileWriter(new File("StudentData.csv"));
			String str="";
			file.write("ID,Prn,Roll No,University Seat No,Name,Division,Year,Branch,Batch,Email\n");
			ResultSet rs=ConnectionDAO.getStmt().executeQuery("select * from student;");
			while(rs.next())
				file.write(rs.getInt(1)+","+rs.getString(2)+","+rs.getInt(3)+","+rs.getString(4)+","+rs.getString(5)
						+","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8)+","+rs.getString(9)+","+rs.getString(10)+"\n");
				
				
			
			
			file.close();
			Desktop.getDesktop().open(new File("StudentData.csv"));
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
