package com.mm.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import com.mm.dao.ConnectionDAO;
import com.mm.dao.ResultDAO;
import com.mm.pojo.Result_t;
import com.mm.pojo.Sgpa_t;

public class ResultPDFParser {

	private static ArrayList<Result_t> ar;
	private static ArrayList<Sgpa_t> as;
	public  static ArrayList<Result_t> getAr() {
		return ar;
	}
	public void setAr(ArrayList<Result_t> ar) {
		this.ar = ar;
	}
	public static ArrayList<Sgpa_t> getAs() {
		return as;
	}
	public void setAs(ArrayList<Sgpa_t> as) {
		this.as = as;
	}
	public static int parseMarks(String mk)
	{
		
		try{
		if(mk.contains("$"))
		return Integer.parseInt(mk.substring(0,2));
		return Integer.parseInt(mk.substring(0,3));
		}
		catch(Exception e)
		{
			return 0;
		}
		
		
		
	}
	public static boolean startParsing(String path,int examid,String batch) throws IOException, SAXException, TikaException
	{
		int insem,endsem,prac,tw,oral,subid,total;
		float sgpa = 0;
		String grade,stuid;
		 BodyContentHandler handler = new BodyContentHandler(-1);
	      Metadata metadata = new Metadata();
	      FileInputStream inputstream = new FileInputStream(new File(path));
	      ParseContext pcontext = new ParseContext();
	      
	      //parsing the document using PDF parser
	      PDFParser pdfparser = new PDFParser(); 
	      pdfparser.parse(inputstream, handler, metadata,pcontext);
	     // FileWriter fout=new FileWriter(new File("result11.csv"));
	      //getting the content of the document
	      String s1=handler.toString();
	    //  System.out.println(s1);
	      ar=new ArrayList<>();
	      as=new ArrayList<>();
	      String str[]=s1.split("\\n+", 0);
	     
	      int i=0;
	      String sk[];
	     
	      String name,seat;
	     
	    System.out.println(str.length);
	    
	   while(i<str.length-1)
	   {
		  
		   if(str[i].equals(".............................................................................................................") && !str[i+1].contains("UNIVERSITY"))
		   {
			   
			
			 i++;
			   sk=str[i].split("\\s+");
			   //System.out.println();
			   name=sk[1]+" "+sk[2]+" "+sk[3];
			   stuid=sk[0];
			  i++;
			   
			   
			   while(true)
			   {
				   String testnum[]=str[i].split("\\s+");
				   if(testnum[1].equals("SGPA"))
					   break;
				  if(testnum[1].matches("[0-9]+"))
				  {
					 // System.out.println(testnum[1]);
					   String sub[]=str[i].split("\\s+");
					   subid=Integer.parseInt(sub[1]);
					   if(sub[2].equals("*"))
					   {
						   insem=parseMarks(sub[3]);
						  endsem=parseMarks(sub[4]);
						   total=parseMarks(sub[5]);
						   tw=parseMarks(sub[6]);
						   prac=parseMarks(sub[7]);
						   oral=parseMarks(sub[8]);
						   grade=sub[11];
						   
					   }
					   else
					   {
						   insem=parseMarks(sub[2]);
							  endsem=parseMarks(sub[3]);
							   total=parseMarks(sub[4]);
							   tw=parseMarks(sub[5]);
							   prac=parseMarks(sub[6]);
							   oral=parseMarks(sub[7]);
							   grade=sub[10];
							  
					   }
					   ar.add(new Result_t(subid,examid,stuid,insem,endsem,total,prac,tw,oral,grade));
					  
				  }
				  i++;
			   }
			   int k=0;
			   while(true)
			   {
			   sk=str[i+k].split("\\s+");
			   if(sk.length>=2 && sk[1].equals("SGPA"))
			   break;
			   k++;
			   }
			   try
			   {
				   sgpa=Float.parseFloat(sk[3].substring(0,sk[3].length()-1));
				   
			   }
			   catch(Exception e)
			   {
				   sgpa=(float)0.0;
			   }
			  as.add(new Sgpa_t(stuid,examid,batch,sgpa));
			  
		   }
		   i++;
	   }
		for(int k=0;k<50;k++)
			System.out.println(ar.get(k));
		
		return false;
		
	}
	public static void main(String[] args) throws SQLException {
		try {
			ConnectionDAO.EstablishConnection();
			startParsing("C:\\Users\\Kaustubh Devkar\\Desktop\\ex1.pdf",2,"2019");
			ResultDAO.addBatchResult(ConnectionDAO.getCon(), ar);
		} catch (IOException | SAXException | TikaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
