package com.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cybozu.labs.langdetect.util.Messages;
import com.mm.dao.ConnectionDAO;
import com.mm.dao.ExamDAO;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class SendEmailGUI extends JFrame implements Runnable {

	private JPanel contentPane;
	public static JLabel lblSucc ;
	public static JLabel lblFail ;
	public static JLabel lblStatus ;
	public static int succ;
	public static int fail;
	public static JComboBox comboBox;
	public static JLabel lblNewLabel;
	public static JButton btnNewButton;
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
					SendEmailGUI frame = new SendEmailGUI();
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
	public SendEmailGUI() throws SQLException {
		ConnectionDAO.EstablishConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kaustubh Devkar\\Documents\\images.png"));
		setTitle("SendEmail");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 388);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectExam = new JLabel("Select Exam");
		lblSelectExam.setForeground(Color.BLUE);
		lblSelectExam.setFont(new Font("Sitka Heading", Font.PLAIN, 19));
		lblSelectExam.setBounds(29, 22, 126, 31);
		contentPane.add(lblSelectExam);
		
		 comboBox = new JComboBox(ExamDAO.getExamNames());
		 comboBox.setBackground(Color.WHITE);
		 comboBox.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		comboBox.setBounds(184, 23, 331, 31);
		contentPane.add(comboBox);
		
		 btnNewButton = new JButton("Start Sending>>");
		 btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		btnNewButton.setBounds(162, 96, 175, 23);
		contentPane.add(btnNewButton);
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 btnNewButton.setText("Sending..");
				 try {
						succ=0;
						fail=0;
						sendmail(comboBox.getSelectedItem().toString());
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "An Errror Occured..");
						
						}
				}
				
		
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setText("Sending..");
			}	
		});
		lblSucc = new JLabel("Succ");
		lblSucc.setFont(new Font("Arial Unicode MS", Font.PLAIN, 17));
		lblSucc.setBounds(10, 216, 505, 23);
		contentPane.add(lblSucc);
		lblSucc.setVisible(false);
		 lblFail = new JLabel("fail");
		lblFail.setFont(new Font("Arial Unicode MS", Font.PLAIN, 17));
		lblFail.setBounds(10, 250, 505, 23);
		contentPane.add(lblFail);
		lblFail.setVisible(false);
		 lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Arial Unicode MS", Font.PLAIN, 17));
		lblStatus.setBounds(10, 294, 524, 23);
		contentPane.add(lblStatus);
		lblStatus.setVisible(false);
	}
public void sendmail(String examname) throws Exception
{
	ArrayList<String> messages=new ArrayList<>();
	ArrayList<String> seat=new ArrayList<>();
	ArrayList<String> emails=new ArrayList<>();
	ResultSet rs=null;
	
	
	rs=ConnectionDAO.getStmt().executeQuery("select id,batch from exam where exam_name='"+examname+"';");
	rs.next();
	int id=rs.getInt(1);
	String batch=rs.getString(2);
	
	ResultSet rs1=null,rs2=null,rs3=null;
	rs=ConnectionDAO.getStmt().executeQuery("select s.uni_roll,s.email from student s where s.uni_roll in(select r.stu_id from result_t r where r.exam_id="+id+" group by r.stu_id) ;");
	while(rs.next())
	{
		seat.add(rs.getString(1));
		emails.add(rs.getString(2));
	}
	String ex=(String)comboBox.getSelectedItem();
	/*ArrayList<String> studList=new ArrayList<>();
	int ik=0;
	while(rs.next())
	{
		studList.add(rs.getString(3)+","+rs.getString(2)+","+rs.getString(4));
		System.out.println(studList.get(ik++));
	}

	for(String stud:studList)
	{
		System.out.println("---");
		String str[]=stud.split(",");
		String seatno=str[0];
		String info="Seat No:"+seatno+"\nName:"+str[1]+"\n\n";
		
		emails.add(str[2]);
		names.add(str[1]);
		 rs1=ConnectionDAO.getStmt().executeQuery("select * from result_t where stu_id='"+seatno+"' and exam_id="+id+";");
		 boolean found=false;
		 String str1="Sub Code\tInsem\tEndsem\ttotal\tPractical\tTerm Work\tOral\tGrade\n";
		
		while(rs1.next())
		{
			str1+=rs1.getInt(2)+"\t    "+rs1.getInt(5)+"\t    "+rs1.getInt(6)+"\t    "+rs1.getInt(7)+
					"\t    "+rs1.getInt(8)+"\t    "+rs1.getInt(9)+"\t    "+rs1.getInt(10)+"\t    "+rs1.getString(11)+"\n";			
			
			found=true;
		}
	
		rs2=ConnectionDAO.getStmt().executeQuery("select sgpa from sgpa_t where stu_id='"+seatno+"' and exam_id="+id+";");
		rs2.next();
		String sgpa="SGPA :"+String.valueOf(rs2.getFloat(1));
	
		String message=info+str1+sgpa;
		messages.add(message);
		
	
		
	
	}*/
	 Thread t=new Thread(this);
	 t.start();
	lblFail.setVisible(true);
	//lblStatus.setVisible(true);
	lblSucc.setVisible(true);

	try{
		System.out.println("00000");
	com.mm.dao.SendMailAttach.start(emails, seat,ex);
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(contentPane, "Please check Your Connection..");
	}
	
}

@Override
public void run() {
	// TODO Auto-generated method stub
	while(true)
	{
		lblFail.setText("Failed to Sent Emails :"+fail);
		lblSucc.setText("Successfully Sent Emails :"+succ);
		
	}
}
}
