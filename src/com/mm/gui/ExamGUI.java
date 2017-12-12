package com.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.mm.dao.ConnectionDAO;
import com.mm.dao.ExamDAO;
import com.mm.dao.TeacherDAO;
import com.mm.pojo.Exam;
import com.mm.pojo.Teacher;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ExamGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private static ExamGUI frame;
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
					 frame = new ExamGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExamGUI() {
		setTitle("Exam Dashboard");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 666);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(30, 144, 255));
		lblName.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblName.setBounds(21, 31, 87, 14);
		contentPane.add(lblName);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setForeground(new Color(30, 144, 255));
		lblBranch.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblBranch.setBounds(21, 78, 87, 19);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(new Color(30, 144, 255));
		lblYear.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblYear.setBounds(21, 132, 87, 19);
		contentPane.add(lblYear);
		
		JLabel lblSem = new JLabel("Sem");
		lblSem.setForeground(new Color(30, 144, 255));
		lblSem.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblSem.setBounds(21, 189, 87, 19);
		contentPane.add(lblSem);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setForeground(new Color(30, 144, 255));
		lblBatch.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblBatch.setBounds(21, 238, 87, 19);
		contentPane.add(lblBatch);
		
		JLabel lblMaxMarks = new JLabel("Max Marks");
		lblMaxMarks.setForeground(new Color(30, 144, 255));
		lblMaxMarks.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblMaxMarks.setBounds(21, 284, 116, 19);
		contentPane.add(lblMaxMarks);
		
		JLabel lblInsem = new JLabel("Insem");
		lblInsem.setForeground(new Color(30, 144, 255));
		lblInsem.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblInsem.setBounds(21, 329, 87, 19);
		contentPane.add(lblInsem);
		
		JLabel lblEndsem = new JLabel("EndSem");
		lblEndsem.setForeground(new Color(30, 144, 255));
		lblEndsem.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblEndsem.setBounds(21, 380, 87, 19);
		contentPane.add(lblEndsem);
		
		JLabel lblPractical = new JLabel("Practical");
		lblPractical.setForeground(new Color(30, 144, 255));
		lblPractical.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblPractical.setBounds(21, 425, 87, 19);
		contentPane.add(lblPractical);
		
		JLabel lblTermWork = new JLabel("Term Work");
		lblTermWork.setForeground(new Color(30, 144, 255));
		lblTermWork.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblTermWork.setBounds(21, 485, 96, 19);
		contentPane.add(lblTermWork);
		
		JLabel lblOral = new JLabel("Oral");
		lblOral.setForeground(new Color(30, 144, 255));
		lblOral.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblOral.setBounds(21, 534, 87, 19);
		contentPane.add(lblOral);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField.setBounds(152, 22, 334, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_1.setBounds(152, 70, 334, 27);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_2.setBounds(152, 120, 334, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_3.setBounds(152, 181, 334, 27);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_4.setBounds(152, 230, 334, 27);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_5.setBounds(152, 321, 334, 27);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_6.setColumns(10);
		textField_6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_6.setBounds(152, 369, 334, 27);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_7.setColumns(10);
		textField_7.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_7.setBounds(152, 417, 334, 27);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_8.setColumns(10);
		textField_8.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_8.setBounds(152, 474, 334, 27);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_9.setColumns(10);
		textField_9.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_9.setBounds(152, 523, 334, 27);
		contentPane.add(textField_9);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConnectionDAO.EstablishConnection();
				Exam obj=new Exam(textField.getText(),textField_1.getText(),textField_2.getText(),
						Integer.parseInt(textField_3.getText()),textField_4.getText(),Integer.parseInt(textField_5.getText()),
						Integer.parseInt(textField_6.getText()),Integer.parseInt(textField_7.getText()),Integer.parseInt(textField_8.getText()),
						Integer.parseInt(textField_9.getText()));
				try {
					ExamDAO.addOneExam(ConnectionDAO.getCon(), obj,1);
					JOptionPane.showMessageDialog(contentPane, "Addition Successful..");
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, "Error in Inserting..");
					e1.printStackTrace();
				}
			}
			
		});
		btnSave.setBounds(306, 593, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(59, 593, 89, 23);
		contentPane.add(btnCancel);
	}
}
