package com.mm.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mm.dao.ConnectionDAO;
import com.mm.dao.ExamDAO;
import com.mm.dao.ResultDAO;
import com.mm.dao.SgpaDAO;
import com.mm.parser.ResultPDFParser;

public class ChooseExam {
	static int id;
	static String batch;
	
	public static void main(String[] args) throws SQLException {
	
	}
public static void start(JFrame f1) throws SQLException
{
	ConnectionDAO.EstablishConnection();
	JFrame f=new JFrame();
	JDialog d = new JDialog(f);  
	JComboBox box=new JComboBox(ExamDAO.getExamNames());
	JButton next=new JButton("Next>>");
	box.setBounds(50,20, 200,45);
	next.setBounds(50, 100,90,35 );
	d.add(box);
	d.add(next);
	d.setSize(300, 250);
	d.setLayout(null);
	d.setVisible(true);
	next.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
			String name=(String)box.getSelectedItem();
			try {
				ResultSet rs=ConnectionDAO.getStmt().executeQuery("select id,batch from exam where exam_name='"+name+"';");
				rs.next();
				id=rs.getInt(1);
				 batch=rs.getString(2);
				 d.dispose();
			
				addResult(id, batch,f1);
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
		}
		
	});
}
public static void addResult(int id ,String batch,JFrame f)
{
	
try{
	JFileChooser fc=new JFileChooser();
	int i=fc.showOpenDialog(f);    
	
    if(i==JFileChooser.APPROVE_OPTION){    
        File f1=fc.getSelectedFile();    
        String filepath=f1.getPath(); 
      
	ResultPDFParser.startParsing(filepath, ChooseExam.id, ChooseExam.batch);
	ResultDAO.addBatchResult(ConnectionDAO.getCon(),ResultPDFParser.getAr());
	SgpaDAO.BatchAddSgpa(ConnectionDAO.getCon(), ResultPDFParser.getAs());
    JOptionPane.showMessageDialog(f, "Upload Successful..");
    }
}
    catch(Exception e)
    {
    	e.printStackTrace();
    	  JOptionPane.showMessageDialog(f, "Upload Unsuccessful..");
    	
    }

}
}
