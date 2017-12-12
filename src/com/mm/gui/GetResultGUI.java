package com.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mm.dao.ConnectionDAO;
import com.mm.dao.ExamDAO;
import com.mm.parser.WritePDF;
import com.mm.parser.WriteResultPDF;
import com.mm.pojo.Result_t;
import com.mm.pojo.Sgpa_t;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GetResultGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtSelectExam;
	private JTextField textField;
	private JTextField txtSeatNo;
	private static JTextArea textArea;
	private static JButton btnDownload;
public static String info,str,sgpa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		start();
	}
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetResultGUI frame = new GetResultGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public GetResultGUI() throws SQLException {
		setTitle("Get Result");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 694);
		ConnectionDAO.EstablishConnection();
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(ExamDAO.getExamNames());
		comboBox.setBounds(25, 56, 301, 35);
		contentPane.add(comboBox);
		
		txtSelectExam = new JTextField();
		txtSelectExam.setForeground(Color.BLUE);
		txtSelectExam.setBorder(null);
		txtSelectExam.setFont(new Font("Sitka Heading", Font.PLAIN, 23));
		txtSelectExam.setText("Select Exam");
		txtSelectExam.setBounds(25, 9, 128, 28);
		contentPane.add(txtSelectExam);
		txtSelectExam.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(358, 56, 255, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtSeatNo = new JTextField();
		txtSeatNo.setText("Seat No");
		txtSeatNo.setForeground(Color.BLUE);
		txtSeatNo.setFont(new Font("Sitka Heading", Font.PLAIN, 23));
		txtSeatNo.setColumns(10);
		txtSeatNo.setBorder(null);
		txtSeatNo.setBounds(359, 10, 106, 35);
		contentPane.add(txtSeatNo);
		textArea = new JTextArea();
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String name=(String)comboBox.getSelectedItem();
					printResult(name,textField.getText());
					textArea.setText(info+str+sgpa);
					
					
					btnDownload.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "No Such Result Found..");
					btnDownload.setVisible(false);
					textArea.setText("Try Again..");
					
				}
			}
		});
		btnNewButton.setBounds(638, 56, 106, 35);
		contentPane.add(btnNewButton);
		
		
		textArea.setFont(new Font("Meiryo UI", Font.PLAIN, 13));
		textArea.setBounds(10, 134, 780, 510);
		contentPane.add(textArea);
		
		btnDownload = new JButton("Download");
		btnDownload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String ex=(String)comboBox.getSelectedItem();
					WriteResultPDF.start(info,str,sgpa, textField.getText()+"_"+ex+"_"+"result");
					WriteResultPDF.openResult( textField.getText()+"_"+ex+"_"+"result");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDownload.setBounds(765, 56, 90, 35);
		contentPane.add(btnDownload);
		btnDownload.setVisible(false);
	}
	public static  void printResult(String examname,String seat) throws Exception
	{
		ResultSet rs=null;
		rs=ConnectionDAO.getStmt().executeQuery("select id,batch from exam where exam_name='"+examname+"';");
		rs.next();
		int id=rs.getInt(1);
		String batch=rs.getString(2);
		 info="Result is as follows\nExam Name:"+examname+"\n  ";
		rs=ConnectionDAO.getStmt().executeQuery("select prn,stud_name from student where uni_roll='"+seat+"' and batch='"+batch+"';");
		rs.next();
		info+=" Seat No:"+seat+"\n   Name:"+rs.getString(2);
		info+="\n   Prn No:"+rs.getString(1)+"\n\n";
		 rs=ConnectionDAO.getStmt().executeQuery("select * from result_t where stu_id='"+seat+"' and exam_id="+id+";");
		 boolean found=false;
		  str="   SubCode\tInsem\tEndsem\ttotal\tPractical\tTermWork\tOral\tGrade\n";
		while(rs.next())
		{
			str+="   "+rs.getInt(2)+"\t  "+rs.getInt(5)+"\t  "+rs.getInt(6)+"\t  "+rs.getInt(7)+
					"\t  "+rs.getInt(8)+"\t  "+rs.getInt(9)+"\t   "+rs.getInt(10)+"\t   "+rs.getString(11)+"\n";			
			
			found=true;
		}
		if(!found)
			throw new Exception();
		rs=ConnectionDAO.getStmt().executeQuery("select sgpa from sgpa_t where stu_id='"+seat+"' and exam_id="+id+";");
		rs.next();
		 sgpa="   SGPA :"+String.valueOf(rs.getFloat(1));
		System.out.println(str);
		
		
	}
}
