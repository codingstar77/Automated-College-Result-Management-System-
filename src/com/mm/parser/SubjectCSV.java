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
import com.mm.pojo.Subject;

public class SubjectCSV {
	public static ArrayList<Subject> readFile(String path) throws FileNotFoundException
	{
		ArrayList ar=new ArrayList<Subject>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        ar.add(createSubjectObj(line.split(",")));
		    }
		  return ar;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	public static Subject createSubjectObj(String str[])
	{
		System.out.println(str[0]);
		return new Subject(Integer.parseInt(str[0]),str[1],str[2],str[3],str[4],Integer.parseInt(str[5]));
		
	}
	public static void writeFile()
	{
		try {
			FileWriter file=new FileWriter(new File("SubjectData.csv"));
			String str="";
			file.write("ID,Sub Code,Name,Year,Branch,Batch,Sem\n");
			ResultSet rs=ConnectionDAO.getStmt().executeQuery("select * from subject;");
			while(rs.next())
				file.write(rs.getInt(1)+","+rs.getInt(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)
						+","+rs.getString(6)+","+rs.getString(7)+"\n");
				
				
			
			
			file.close();
			Desktop.getDesktop().open(new File("SubjectData.csv"));
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
