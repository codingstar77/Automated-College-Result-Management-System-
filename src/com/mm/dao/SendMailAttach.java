package com.mm.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.mm.gui.GetResultGUI;
import com.mm.gui.SendEmailGUI;
import com.mm.parser.WriteResultPDF;

public class SendMailAttach {

	public static void main(String[] args) {
		ArrayList<String> ar=new ArrayList<>();
		ar.add("kaustubhdevkar.comp@mmcoe.edu.in");
		ArrayList<String> ak=new ArrayList<>();
		ak.add("S150454224");
		start(ar,ak,"April May 2017");
		
	}
public static void start(ArrayList<String> email,ArrayList<String> seat,String examname)
{
	ConnectionDAO.EstablishConnection();
	for(int i=0;i<email.size();i++)
	{
		if(   email.get(i).equals("kaustubhdevkar.comp@mmcoe.edu.in")  )
		{
		
		}
		else continue;
			
	try {
	 //com.mm.gui.SendEmailGUI.lblStatus.setText("Sending to "+email.get(i));
		GetResultGUI.printResult(examname, seat.get(i));
		
		WriteResultPDF.start(GetResultGUI.info, GetResultGUI.str, GetResultGUI.sgpa,seat.get(i)+"_"+examname+"_"+"result");
		 String to=email.get(i);//change accordingly  
		  final String user="studentexamreport@gmail.com";//change accordingly  
		  final String password="exammmcoe123";//change accordingly  
		   
		  //1) get the session object     
		 System.out.println("----------------");
		  Properties props = new Properties();
		  props.put("mail.smtp.host", "smtp.gmail.com");
		  props.put("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.socketFactory.class",
		        	"javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.debug", "false");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", "465");
		  
		  Session session = Session.getDefaultInstance(props,  
		   new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication(user,password);  
		   }  
		  });  
		     
		  //2) compose message     
		  
		    MimeMessage message = new MimeMessage(session);  
		    message.setFrom(new InternetAddress(user));  
		    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		    message.setSubject("Hello There, Your "+examname+" Result is here..");  
		      
		    //3) create MimeBodyPart object and set your message text     
		    BodyPart messageBodyPart1 = new MimeBodyPart();  
		    messageBodyPart1.setText("Please find the attachment..");  
		      
		    //4) create new MimeBodyPart object and set DataHandler object to this object      
		    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		  
		    String filename = seat.get(i)+"_"+examname+"_"+"result.pdf";//change accordingly  
		    DataSource source = new FileDataSource(filename);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);  
		     
		     
		    //5) create Multipart object and add MimeBodyPart objects to this object      
		    Multipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyPart1);  
		    multipart.addBodyPart(messageBodyPart2);  
		  
		    //6) set the multiplart object to the message object  
		    message.setContent(multipart );  
		     
		    //7) send message  
		    Transport.send(message);  
		   
		  
		
		System.out.println("sent........");
		
		
		new File(seat.get(i)+"_"+examname+"_"+"result.pdf").delete();
		  com.mm.gui.SendEmailGUI.succ++;
			//com.mm.gui.SendEmailGUI.lblStatus.setText("Sent to "+email.get(i));
		
	 
	}
		  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		com.mm.gui.SendEmailGUI.fail++;
		//com.mm.gui.SendEmailGUI.lblStatus.setText("Failed to "+email.get(i));
	}

 }
	SendEmailGUI.btnNewButton.setText("Start Sending>>");

}
	

}