package edu.cuny.csi.csc330.bankmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Registration extends JFrame {

	Connection conn = null;
	PreparedStatement pst;
	
	private JPanel contentPane;
	private JTextField dateField;
	private JTextField firstName;
	private JTextField username;
	private JTextField dateOfBirth;
	private JTextField nationality;
	private JTextField address;
	private JTextField pin;
	private JTextField secA;
	private JTextField password;
	private JTextField lastName;
	private JComboBox cmbAccType;
	private JComboBox cmbGender;
	private JComboBox cmbSecQ;
	private JTextField mob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		
		//SQL Connection//
		conn = sqlLiteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(16, 114, 68, 16);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(370, 114, 68, 16);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(16, 155, 68, 16);
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(370, 155, 61, 16);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblNewLabel_4 = new JLabel("Date of Birth");
		lblNewLabel_4.setBounds(16, 196, 79, 16);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setBounds(370, 196, 44, 16);
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblNewLabel_6 = new JLabel("Nationality");
		lblNewLabel_6.setBounds(16, 237, 79, 16);
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setBounds(370, 237, 51, 16);
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setBounds(16, 278, 86, 16);
		lblAccountType.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblPin = new JLabel("PIN");
		lblPin.setBounds(370, 278, 27, 16);
		lblPin.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setBounds(16, 319, 111, 16);
		lblSecurityQuestion.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblAnswer = new JLabel("Security Answer");
		lblAnswer.setBounds(370, 319, 100, 16);
		lblAnswer.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		firstName = new JTextField();
		firstName.setBounds(139, 111, 176, 26);
		firstName.setColumns(10);
		
		username = new JTextField();
		username.setBounds(139, 152, 176, 26);
		username.setColumns(10);
		
		dateOfBirth = new JTextField();
		dateOfBirth.setBounds(139, 193, 176, 26);
		dateOfBirth.setColumns(10);
		
		nationality = new JTextField();
		nationality.setBounds(139, 234, 176, 26);
		nationality.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblAccountType);
		contentPane.add(lblPin);
		contentPane.add(lblSecurityQuestion);
		contentPane.add(lblAnswer);
		contentPane.add(firstName);
		contentPane.add(username);
		contentPane.add(dateOfBirth);
		contentPane.add(nationality);
		
		address = new JTextField();
		address.setBounds(482, 234, 176, 26);
		contentPane.add(address);
		address.setColumns(10);
		
		pin = new JTextField();
		pin.setBounds(482, 275, 176, 26);
		contentPane.add(pin);
		pin.setColumns(10);
		
		secA = new JTextField();
		secA.setBounds(482, 316, 176, 26);
		contentPane.add(secA);
		secA.setColumns(10);
		
		password = new JTextField();
		password.setBounds(482, 152, 176, 26);
		contentPane.add(password);
		password.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(482, 111, 176, 26);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		JComboBox cmbSecQ = new JComboBox();
		cmbSecQ.setFont(new Font("Dialog", Font.PLAIN, 13));
		cmbSecQ.setModel(new DefaultComboBoxModel(new String[] {"What is the name of your pet?", "What is the name of your car?", 
				"What is your favorite movie?", "What is your favorite food?", "What was your childhood nickname?", 
				"What is your mother's middle name?", "In what city were you born?"}));
		cmbSecQ.setBounds(139, 316, 176, 27);
		contentPane.add(cmbSecQ);
		
		JComboBox cmbGender = new JComboBox();
		cmbGender.setFont(new Font("Dialog", Font.PLAIN, 13));
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		cmbGender.setBounds(482, 193, 176, 27);
		contentPane.add(cmbGender);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblMobileNumber.setBounds(16, 360, 100, 16);
		contentPane.add(lblMobileNumber);
		
		mob = new JTextField();
		mob.setBounds(139, 357, 176, 26);
		contentPane.add(mob);
		mob.setColumns(10);
		
		JComboBox cmbAccType = new JComboBox();
		cmbAccType.setModel(new DefaultComboBoxModel(new String[] {"Checking", "Savings"}));
		cmbAccType.setBounds(139, 275, 176, 27);
		contentPane.add(cmbAccType);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(364, 357, 117, 29);
		contentPane.add(registerButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Registration.class.getResource("/edu/cuny/csi/csc330/icons/Registration x350.png")));
		label.setBounds(155, 6, 356, 96);
		contentPane.add(label);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					String usernameField = username.getText(); //Username (1)
					String passwordField = password.getText(); //Password (2)
					int accNumField = new Random().nextInt(900000) + 100000; //Account Number (3)
					String nameField = firstName.getText() + " " + lastName.getText(); //Name (4)
					String dobField = dateOfBirth.getText(); //Date of Birth (5)
					String pinField = pin.getText(); //Pin (6)
					String accTypeField = cmbAccType.getSelectedItem().toString(); //Account Type (7)
					String nationalityField = nationality.getText(); //Nationality (8)
					int micrField = 110211000 + (new Random().nextInt(900) + 100); //MICR Number (9)
					String genderField = cmbGender.getSelectedItem().toString(); //Gender (10)
					String mobField = mob.getText(); //Mobile Number (11)
					String addressField = address.getText(); //Address (12)
					String secQField = cmbSecQ.getSelectedItem().toString(); //Security Question (13)
					String secAField = secA.getText(); //Security Answer (14)
					int balanceField = 0; //Balance (15)
					String dateField = new SimpleDateFormat("M/d/yyyy").format(Calendar.getInstance().getTime()); //Registration Date (16)
					String userTypeField = "User"; //User Type (17)
						
					String query = "insert into bankAcc (Username, Password, Acc, Name, DOB, Pin, Acc_Type, Nationality, MICR_no, Gender, Mob, Address, SecQ, SecA, Balance, Register_Date, userType)"
							+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					pst = conn.prepareStatement(query);
					
					pst.setString(1, usernameField);
					pst.setString(2, passwordField);
					pst.setString(3, Integer.toString(accNumField));
					pst.setString(4, nameField);
					pst.setString(5, dobField);
					pst.setString(6, pinField);
					pst.setString(7, accTypeField);
					pst.setString(8, nationalityField);
					pst.setString(9, Integer.toString(micrField));
					pst.setString(10, genderField);
					pst.setString(11, mobField);
					pst.setString(12, addressField);
					pst.setString(13, secQField);
					pst.setString(14, secAField);
					pst.setString(15, Integer.toString(balanceField));
					pst.setString(16, dateField);	
					pst.setString(17, userTypeField);
					pst.execute();

					JOptionPane.showMessageDialog(null, "Registration Successful");
					setVisible(false); 
					dispose(); //Destroy the JFrame object
				} 
				catch (Exception k) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
	}
}