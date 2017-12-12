package com.mm.parser;
import java.awt.Desktop;
import java.io.File; 
import java.io.IOException;
  
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage; 
import org.apache.pdfbox.pdmodel.PDPageContentStream; 
import org.apache.pdfbox.pdmodel.font.PDType1Font;
public class WritePDF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static void start(String content,String name) throws IOException
{
	//Loading an existing document
 
    PDDocument doc = new PDDocument();
     
    //Creating a PDF Document
    PDPage page = new PDPage();
    doc.addPage(page);
   
    PDPageContentStream contentStream = new PDPageContentStream(doc, page); 
     
    //Begin the Content stream 
    contentStream.beginText(); 
     
    //Setting the font to the Content stream
    contentStream.setFont( PDType1Font.COURIER, 16 );
     
    //Setting the leading
    contentStream.setLeading(14.5f);

    //Setting the position for the line
    contentStream.newLineAtOffset(25, 725);

   
String str[]=content.split("\\n+");
    //Adding text in the form of string
for(String sk:str)
{
	try{
    contentStream. showText(sk);
    contentStream.newLine();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
    //Ending the content stream
    contentStream.endText();

    System.out.println("Content added");

    //Closing the content stream
    contentStream.close();

    //Saving the document
    doc.save(name+".pdf");
          
    //Closing the document
    doc.close();
    Desktop.getDesktop().open(new File(name+".pdf"));
 }

}

