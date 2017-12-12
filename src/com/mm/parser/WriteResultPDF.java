package com.mm.parser;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.text.FontFactory;  


public class WriteResultPDF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			start("hjbh","hjh","sjdhs","test13");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void  openResult(String name) throws IOException
	{
		  Desktop.getDesktop().open(new File(name+".pdf"));
	}
public static void start(String info,String result,String sgpa,String name) throws IOException
{
	       
     PdfWriter writer = new PdfWriter(name+".pdf");           
     
     // Creating a PdfDocument       
     PdfDocument pdf = new PdfDocument(writer);              
     
     // Creating a Document        
     Document document = new Document(pdf);              
       
           document.setFontSize(15.7f);
     
     // Creating Paragraphs       
     Paragraph paragraph1 = new Paragraph(info);             
     Paragraph paragraph2 = new Paragraph(sgpa);              
     
     // Adding paragraphs to document       
     document.add(paragraph1); 
     
     
     float [] pointColumnWidths = {50F, 50F, 50F,50F,50F,50F,50F,50F};   
     Table table = new Table(pointColumnWidths);    
     
     String resultarr[]=result.split("\\n+");
     for(String line:resultarr)
     {
    	 String st[]=line.split("\\t+");
    	 for(String element:st)
    		 table.addCell(new Cell().add(element));   
     }
     // Adding cells to the table       
        
       
     // Adding Table to document        
     document.add(table);      
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     document.add(paragraph2);           
     
     // Closing the document       
     document.close();             
   
     System.out.println("Paragraph added");   
}
}
