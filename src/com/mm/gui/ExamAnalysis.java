package com.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mm.dao.ConnectionDAO;
import com.mm.dao.ExamDAO;
import com.mm.parser.WriteExamAnalysis;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ExamAnalysis extends JFrame {

	private JPanel contentPane;

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
					ExamAnalysis frame = new ExamAnalysis();
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
	public ExamAnalysis() throws SQLException {
		ConnectionDAO.EstablishConnection();
		setTitle("Exam Analysis");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 333);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseSelectExam = new JLabel("Please Select Exam");
		lblPleaseSelectExam.setForeground(new Color(30, 144, 255));
		lblPleaseSelectExam.setFont(new Font("Sitka Heading", Font.BOLD, 25));
		lblPleaseSelectExam.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectExam.setBounds(92, 27, 373, 31);
		contentPane.add(lblPleaseSelectExam);
		
		JComboBox comboBox = new JComboBox(ExamDAO.getExamNames());
		comboBox.setBackground(new Color(100, 149, 237));
		comboBox.setForeground(Color.WHITE);
		comboBox.setBounds(65, 91, 455, 31);
		contentPane.add(comboBox);
		
		JButton btnGetReport = new JButton("Get Report");
		btnGetReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					WriteExamAnalysis.start((String)comboBox.getSelectedItem());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGetReport.setBackground(new Color(135, 206, 250));
		btnGetReport.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGetReport.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGetReport.setBounds(192, 175, 161, 36);
		contentPane.add(btnGetReport);
		
	}
}
