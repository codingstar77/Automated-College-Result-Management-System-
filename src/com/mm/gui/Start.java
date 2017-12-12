package com.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import com.mm.dao.ConnectionDAO;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;

public class Start{

	static JFrame contentPane;
public static void main(String[] args) {
	contentPane = new JFrame();
	if(!ConnectionDAO.EstablishConnection())
	{
		JOptionPane.showMessageDialog(contentPane, "Unable to establish Connection With Database..");
	}
	startProject();
}
	

	
	public static void startProject() {
		
		
		contentPane.setTitle("Result Management System");
		contentPane.getContentPane().setBackground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
	
	
		contentPane.getContentPane().setLayout(null);
		contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBounds(100, 100, 894, 458);
		JTextField textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField.setBounds(499, 166, 324, 38);
		contentPane.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(499, 253, 324, 35);
		passwordField.setText("");
		contentPane.getContentPane().add(passwordField);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(255, 160, 122));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblLogin.setBounds(559, 34, 309, 53);
		contentPane.getContentPane().add(lblLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnLogin.setForeground(Color.BLUE);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

					
					String user=textField.getText();
				String pass=passwordField.getText();
				if(ConnectionDAO.validate(user, pass))
				{
					contentPane.setVisible(false);
					textField.setText("");
					passwordField.setText("");
					Dashboard.startDashboard();
					JOptionPane.showMessageDialog(contentPane, "Welcome "+user);
					
					//Dashboard.start();
				}
				else
					{
					
					
					JOptionPane.showMessageDialog(contentPane, "Invalid Username or Password");
					}
			}
		});
		btnLogin.setBackground(new Color(233, 150, 122));
		btnLogin.setFont(new Font("Calisto MT", Font.BOLD, 24));
		btnLogin.setBounds(511, 357, 315, 38);
		contentPane.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Kaustubh Devkar\\Documents\\images.png"));
		lblNewLabel.setBounds(439, 11, 157, 109);
		contentPane.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Kaustubh Devkar\\Documents\\project\\main.gif"));
		lblNewLabel_1.setBounds(66, 52, 337, 325);
		contentPane.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Kaustubh Devkar\\Documents\\project\\male.png"));
		label.setBounds(462, 176, 32, 27);
		contentPane.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Kaustubh Devkar\\Documents\\project\\lock.png"));
		label_1.setBounds(462, 253, 32, 35);
		contentPane.getContentPane().add(label_1);
		contentPane.setVisible(true);
	}
}