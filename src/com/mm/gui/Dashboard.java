package com.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mm.dao.ConnectionDAO;
import com.mm.dao.StudentDAO;
import com.mm.parser.StudentCSV;
import com.mysql.jdbc.Connection;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;

import com.mm.parser.*;
import com.mm.dao.*;
import java.awt.Toolkit;
public class Dashboard  {

	public static void main(String[] args) {
		startDashboard();
	}
	public static void startDashboard() {
		ConnectionDAO.EstablishConnection();
		JFrame f=new JFrame();
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kaustubh Devkar\\Documents\\dash.jpg"));
		f.getContentPane().setBackground(new Color(255, 218, 185));
		f.setTitle("Admin Dashboard");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 940, 563);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuBar.setBackground(Color.WHITE);
		f.setJMenuBar(menuBar);
		
		JMenu mnStudent = new JMenu("Student");
		mnStudent.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuBar.add(mnStudent);
		
		JMenu mnAddNew = new JMenu("Add New");
		mnAddNew.setBackground(Color.WHITE);
		mnAddNew.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnStudent.add(mnAddNew);
		
		JMenuItem mntmFromFile = new JMenuItem("From File");
		mntmFromFile.setBackground(Color.WHITE);
		mntmFromFile.addMouseListener(new MouseAdapter() {
			
	
			@Override
			public void mousePressed(MouseEvent e) {
				ConnectionDAO.EstablishConnection();
				JFileChooser fc=new JFileChooser();
				int i=fc.showOpenDialog(f);    
				try{
			    if(i==JFileChooser.APPROVE_OPTION){    
			        File f1=fc.getSelectedFile();    
			        String filepath=f1.getPath(); 
			        StudentDAO.BatchAddStudent(ConnectionDAO.getCon(), StudentCSV.readFile(filepath));
			        JOptionPane.showMessageDialog(f, "Upload Successful..");
			    }
				}
			    catch(Exception e1)
			    {
			    	e1.printStackTrace();
			    	JOptionPane.showMessageDialog(f, "Upload Failed..");
			    }
			        
			    }
			
		});
		mntmFromFile.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnAddNew.add(mntmFromFile);
		
		JMenuItem mntmManually = new JMenuItem("Manually");
		mntmManually.setBackground(Color.WHITE);
		mntmManually.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StudentGUI.Start();
			}
		});
		mntmManually.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnAddNew.add(mntmManually);
		
		JMenuItem mntmEditview = new JMenuItem("Edit\\View ");
		mntmEditview.setBackground(Color.WHITE);
		mntmEditview.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StudentSearch.Start();
			}
		});
		mntmEditview.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnStudent.add(mntmEditview);
		
		JMenuItem mntmViewAll = new JMenuItem("View all");
		mntmViewAll.setBackground(Color.WHITE);
		mntmViewAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StudentCSV.writeFile();
			}
		});
		mntmViewAll.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnStudent.add(mntmViewAll);
		
		JMenu mnTeacher = new JMenu("Teacher");
		mnTeacher.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuBar.add(mnTeacher);
		
		JMenu mnAddNew_1 = new JMenu("Add New");
		mnAddNew_1.setBackground(Color.WHITE);
		mnAddNew_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnTeacher.add(mnAddNew_1);
		
		JMenuItem mntmFromFile_1 = new JMenuItem("From File");
		mntmFromFile_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser fc=new JFileChooser();
				int i=fc.showOpenDialog(f);    
				try{
			    if(i==JFileChooser.APPROVE_OPTION){    
			        File f1=fc.getSelectedFile();    
			        String filepath=f1.getPath(); 
			        TeacherDAO.BatchAddTeacher(ConnectionDAO.getCon(), TeacherCSV.readFile(filepath));
			        JOptionPane.showMessageDialog(f, "Upload Successful..");
			    }
				}
			    catch(Exception e1)
			    {
			    	e1.printStackTrace();
			    	JOptionPane.showMessageDialog(f, "Upload Failed..");
			    }
			        
			    }
			}
		);
		mntmFromFile_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnAddNew_1.add(mntmFromFile_1);
		
		JMenuItem mntmManually_1 = new JMenuItem("Manually");
		mntmManually_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TeacherGUI.Start();
			}
		});
		mntmManually_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnAddNew_1.add(mntmManually_1);
		
		JMenuItem mntmViewedit = new JMenuItem("View/Edit ");
		mntmViewedit.setBackground(Color.WHITE);
		mntmViewedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TeacherSearch.Start();
			}
		});
		mntmViewedit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnTeacher.add(mntmViewedit);
		
		JMenuItem mntmViewAll_1 = new JMenuItem("View all");
		mntmViewAll_1.setBackground(Color.WHITE);
		mntmViewAll_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TeacherCSV.writeFile();
			}
		});
		mntmViewAll_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnTeacher.add(mntmViewAll_1);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnTeacher.add(menuBar_1);
		
		JMenu mnSubjects = new JMenu("Subjects");
		mnSubjects.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuBar.add(mnSubjects);
		
		JMenu mnAddNew_2 = new JMenu("Add new");
		mnAddNew_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnSubjects.add(mnAddNew_2);
		
		JMenuItem mntmFromFile_2 = new JMenuItem("From File");
		mntmFromFile_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				JFileChooser fc=new JFileChooser();
				int i=fc.showOpenDialog(f);    
				try{
			    if(i==JFileChooser.APPROVE_OPTION){    
			        File f1=fc.getSelectedFile();    
			        String filepath=f1.getPath(); 
			        SubjectDAO.BatchAddSubject(ConnectionDAO.getCon(), SubjectCSV.readFile(filepath));
			        JOptionPane.showMessageDialog(f, "Upload Successful..");
			    }
				}
			    catch(Exception e1)
			    {
			    	e1.printStackTrace();
			    	JOptionPane.showMessageDialog(f, "Upload Failed..");
			    }
			        
			    }
			}
	);
		mntmFromFile_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnAddNew_2.add(mntmFromFile_2);
		
		JMenuItem mntmManually_2 = new JMenuItem("Manually");
		mntmManually_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SubjectGUI.Start();
			}
		});
		mntmManually_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnAddNew_2.add(mntmManually_2);
		
		JMenuItem mntmEditview_1 = new JMenuItem("Edit/View");
		mntmEditview_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SubjectSearch.Start();
			}
		});
		mntmEditview_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnSubjects.add(mntmEditview_1);
		
		JMenuItem mntmViewAll_2 = new JMenuItem("View All");
		mntmViewAll_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SubjectCSV.writeFile();
			}
		});
		mntmViewAll_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnSubjects.add(mntmViewAll_2);
		
		JMenu mnExam = new JMenu("Exam");
		mnExam.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuBar.add(mnExam);
		
		JMenuItem mntmAddNew = new JMenuItem("Add New");
		mntmAddNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ExamGUI.start();
			}
		});
		mntmAddNew.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnExam.add(mntmAddNew);
		
		JMenuItem mntmViewedit_1 = new JMenuItem("View/Edit");
		mntmViewedit_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ExamSearch.start();
			}
		});
		mntmViewedit_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnExam.add(mntmViewedit_1);
		
		JMenuItem mntmGetReport = new JMenuItem("Get Report");
		mntmGetReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ExamAnalysis.start();
			}
		});
		mntmGetReport.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnExam.add(mntmGetReport);
		
		JMenu mnResult = new JMenu("Result");
		mnResult.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuBar.add(mnResult);
		
		JMenuItem mntmUpload = new JMenuItem("Upload");
		mntmUpload.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
					
				
					  try {
						ChooseExam.start(f);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(f,"An Error Occurred..");
						e1.printStackTrace();
					}
				
					
						
					
				
					
					
				}
				    
				
		}	   
				
			
		
		);
		mntmUpload.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnResult.add(mntmUpload);
		
		JMenuItem mntmGetResult = new JMenuItem("Get Result");
		mntmGetResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GetResultGUI.start();
			}
		});
		mntmGetResult.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnResult.add(mntmGetResult);
		
		JMenuItem mntmEmailResult = new JMenuItem("Email Result");
		mntmEmailResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SendEmailGUI.start();
			}
		});
		mntmEmailResult.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnResult.add(mntmEmailResult);
		
		JMenu mnMore = new JMenu("More");
		mnMore.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuBar.add(mnMore);
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				f.dispose();
				Start.contentPane.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				f.dispose();
				Start.startProject();
			}
		});
		mntmLogOut.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnMore.add(mntmLogOut);
		f.setVisible(true);
	}

	
	
}
