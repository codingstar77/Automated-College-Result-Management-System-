package com.mm.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.mm.dao.ConnectionDAO;
import com.mm.dao.StudentDAO;
import com.mm.dao.SubjectDAO;
import com.mm.pojo.Student;
import com.mm.pojo.Subject;

public class SubjectGUI extends JFrame{
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
	private static SubjectGUI frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Start();
	}
	public static void Start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SubjectGUI();
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
	public SubjectGUI() {
		setTitle("Subject Dashboard");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 586);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrnNo = new JLabel("Sub Code");
		lblPrnNo.setForeground(Color.BLUE);
		lblPrnNo.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblPrnNo.setBounds(10, 34, 96, 21);
		contentPane.add(lblPrnNo);
		
		JLabel lblRollNo = new JLabel("Name");
		lblRollNo.setForeground(Color.BLUE);
		lblRollNo.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblRollNo.setBounds(10, 90, 96, 21);
		contentPane.add(lblRollNo);
		
		JLabel lblUniRollNo = new JLabel("Year");
		lblUniRollNo.setForeground(Color.BLUE);
		lblUniRollNo.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblUniRollNo.setBounds(10, 146, 117, 21);
		contentPane.add(lblUniRollNo);
		
		JLabel lblName = new JLabel("Branch");
		lblName.setForeground(Color.BLUE);
		lblName.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblName.setBounds(10, 204, 96, 21);
		contentPane.add(lblName);
		
		JLabel lblDivision = new JLabel("Batch");
		lblDivision.setForeground(Color.BLUE);
		lblDivision.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblDivision.setBounds(10, 258, 96, 21);
		contentPane.add(lblDivision);
		
		JLabel lblYear = new JLabel("Sem");
		lblYear.setForeground(Color.BLUE);
		lblYear.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblYear.setBounds(10, 312, 96, 21);
		contentPane.add(lblYear);
		
		/*JLabel lblBranch = new JLabel("Branch");
		lblBranch.setForeground(Color.BLUE);
		lblBranch.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblBranch.setBounds(10, 362, 96, 21);
		contentPane.add(lblBranch);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setForeground(Color.BLUE);
		lblBatch.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblBatch.setBounds(10, 415, 96, 21);
		contentPane.add(lblBatch);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblEmail.setBounds(10, 462, 96, 21);
		contentPane.add(lblEmail);*/
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField.setBounds(135, 25, 375, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_1.setBounds(135, 81, 375, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_2.setBounds(135, 137, 375, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_3.setBounds(135, 195, 375, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_4.setBounds(135, 249, 375, 30);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_5.setBounds(135, 303, 375, 30);
		contentPane.add(textField_5);
		
		/*textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_6.setBounds(135, 353, 375, 30);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_7.setColumns(10);
		textField_7.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_7.setBounds(135, 406, 375, 30);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_8.setColumns(10);
		textField_8.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_8.setBounds(135, 453, 375, 30);
		contentPane.add(textField_8);*/
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Subject obj=new Subject(Integer.parseInt(textField.getText()),textField_1.getText(),textField_2.getText(),
						textField_3.getText(),textField_4.getText(),Integer.parseInt(textField_5.getText()));
				try {
					SubjectDAO.addOneSubject(ConnectionDAO.getCon(), obj,1);
					JOptionPane.showMessageDialog(contentPane, "Addition Successful..");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, "Error in Inserting..");
					e1.printStackTrace();
				}
			}
			
		});
		btnSave.setBounds(332, 513, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(78, 513, 89, 23);
		contentPane.add(btnCancel);
	}

}
