package com.mm.parser;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.mm.dao.ExamWiseAnalysis;

public class WriteExamAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static void start(String examname) throws IOException, SQLException
{
 PdfWriter writer = new PdfWriter(examname+"_analysis2.pdf");           
     
     // Creating a PdfDocument       
     PdfDocument pdf = new PdfDocument(writer);              
     
     // Creating a Document        
     Document document = new Document(pdf);              
       
           document.setFontSize(15.7f);
     
     // Creating Paragraphs      
           String stat=ExamWiseAnalysis.getExamStats(examname);
           String substat=ExamWiseAnalysis.getSubjectStats(examname);
           String topten=ExamWiseAnalysis.getTopTen(examname);
           String subtop=ExamWiseAnalysis.getSubTop(examname);
           Paragraph paragraph3 = new Paragraph("Analysis Report For exam "+examname+"\n");
           paragraph3.setHorizontalAlignment(HorizontalAlignment.CENTER);
           document.add(paragraph3);
           
     Paragraph paragraph1 = new Paragraph(stat);             
              
     
     // Adding paragraphs to document       
     document.add(paragraph1); 
     
     Paragraph paragraph2 = new Paragraph("\nSubject Wise Result:\n");
     document.add(paragraph2);
     float [] pointColumnWidths = {100F, 100F, 100F};   
     Table table = new Table(pointColumnWidths);    
     
     String substatarr[]=substat.split("\\n+");
     for(String line:substatarr)
     {
    	 String st[]=line.split("\\t+");
    	 for(String element:st)
    		 table.addCell(new Cell().add(element));   
     }
     document.add(table);   
     Paragraph paragraph5 = new Paragraph("\nTop ten Students:\n");
     document.add(paragraph5);
     
    float[] pointColumnWidths1 = {80F, 80F, 80F,80F};
 Table table1 = new Table(pointColumnWidths1);    
     
     String toptenarr[]=topten.split("\\n+");
     for(String line:toptenarr)
     {
    	 String st[]=line.split("\\t+");
    	 for(String element:st)
    		 table1.addCell(new Cell().add(element));   
     }
     document.add(table1);      
     Paragraph paragraph4= new Paragraph("\n\nSubject Wise Toppers:\n");
     document.add(paragraph4);
     float[] pointColumnWidths2 = {80F, 80F, 80F,80F};
 Table table2 = new Table(pointColumnWidths2);    
     
     String subtoparr[]=subtop.split("\\n+");
     for(String line:subtoparr)
     {
    	 String st[]=line.split("\\t+");
    	 for(String element:st)
    		 table2.addCell(new Cell().add(element));   
     }
     // Adding cells to the table       
        
       
     // Adding Table to document        
      
   
     document.add(table2);      
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
         
     
     // Closing the document       
     document.close();             
   Desktop.getDesktop().open(new File(examname+"_analysis2.pdf"));
     System.out.println("Paragraph added");   
}
}
