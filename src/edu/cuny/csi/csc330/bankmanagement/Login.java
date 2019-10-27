package edu.cuny.csi.csc330.bankmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Login extends JFrame {

	Connection connection = null;
	ResultSet rs;
	PreparedStatement pst;
	
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private static String username;
	private static String password;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    public static void getCredentials(String x, String y)
    {
           username = x;
    	   password = y;
    }
    public static String retUser()
    {
    	return username;
    }
    public static String retPass()
    {
    	return password;
    }

	/**
	 * Create the frame.
	 */
	
	public Login() {
			
	    //invokes sqliteConnection class function db connector//
		connection = sqlLiteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 426);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelUser = new JLabel("User ID");
		LabelUser.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		LabelUser.setBounds(25, 195, 58, 16);
		contentPane.add(LabelUser);
		
		user = new JTextField();
		user.setBounds(22, 223, 352, 39);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel LabelPass = new JLabel("Password");
		LabelPass.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		LabelPass.setBounds(25, 274, 76, 16);
		contentPane.add(LabelPass);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"User", "Admin"}));
		comboBox.setBounds(262, 194, 112, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Login");
		contentPane.getRootPane().setDefaultButton(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				getCredentials(user.getText(),pass.getText());
				try {
					String query = "select * from bankAcc where Username=? and Password=? and userType=?";
					pst = connection.prepareStatement(query);
					pst.setString(1, user.getText());
					pst.setString(2, pass.getText());
					pst.setString(3, String.valueOf(comboBox.getSelectedItem()));
					
					rs = pst.executeQuery();
					if(rs.next()) 
					{
						JOptionPane.showMessageDialog(null, "Login Successful");
						
						if(comboBox.getSelectedIndex() == 1) 
						{				
							BankerHomePage.main(null);
							setVisible(false); 
							dispose(); //Destroy the JFrame object
						}			
						else if(comboBox.getSelectedIndex() == 0) 
						{		        
							CustomerHomePage newCustomer = new CustomerHomePage();
							newCustomer.setVisible(true); 
							dispose(); //Destroy the JFrame object
						}  
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect Username and/or Password");
					}
				} 
				catch(Exception k) {	
					JOptionPane.showMessageDialog(null, k);
				}
				finally {
					try {
						rs.close();
						pst.close();	
					}
					catch(Exception k) {
					}
				}
			}		
		});
		btnNewButton.setBounds(22, 353, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user.setText(null);
				pass.setText(null);
			}
		});
		btnNewButton_2.setBounds(119, 353, 97, 25);
		contentPane.add(btnNewButton_2);
		
		pass = new JPasswordField();
		pass.setBounds(22, 302, 352, 39);
		contentPane.add(pass);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/edu/cuny/csi/csc330/icons/Bank Logo x325.png")));
		label_1.setBounds(35, 6, 326, 164);
		contentPane.add(label_1);	
		
		JButton btnNewButton_1 = new JButton("New User");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Registration.main(null);
				}
				catch(Exception f){
					JOptionPane.showMessageDialog(null, f);
				}
			}
		});
		btnNewButton_1.setBounds(277, 353, 97, 25);
		contentPane.add(btnNewButton_1);
	}
}