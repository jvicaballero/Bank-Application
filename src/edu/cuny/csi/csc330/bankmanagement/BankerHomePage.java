package edu.cuny.csi.csc330.bankmanagement;

import java.awt.BorderLayout;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Beans;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;

import com.mysql.jdbc.Statement;
import net.proteanit.sql.DbUtils;

import javax.swing.event.PopupMenuEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.ImageIcon;

public class BankerHomePage extends JFrame {
	
    Connection conn = null;
	ResultSet rs;
	PreparedStatement pst;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField dateField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField userFieldDeposit;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_1;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTable table;
	private JTable table_1;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankerHomePage frame = new BankerHomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Sets the date using the Gregorian Calendar implementation
	public void Calendar()
	{
		Calendar date = new GregorianCalendar();
		int day = date.get(Calendar.DAY_OF_MONTH);
		int month = date.get(Calendar.MONTH);
		int year = date.get(Calendar.YEAR);
		dateField.setText((month+1) + "/" + (day) + "/" + year );
	}
	
	public void Table1()
	{
		try {
			String sql = "Select Name, Acc, Acc_Type, Register_Date from bankAcc";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));		
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		finally {
			try {
				rs.close();
				pst.close();	
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		}
	}

	/**
	 * Create the frame.
	 */
	public BankerHomePage() {
		
		Beans.isDesignTime(); //Allows to open design page
		
		//SQL Connection//
		conn = sqlLiteConnection.dbConnector();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel user = new JLabel("User");
		user.setBounds(495, 43, 34, 16);
		contentPane.add(user);
		
		textField = new JTextField();
		textField.setBounds(528, 40, 100, 22);
		contentPane.add(textField);
		textField.setColumns(10);
	
		JLabel date = new JLabel("Date");
		date.setBounds(495, 72, 34, 16);
		contentPane.add(date);
		
		dateField = new JTextField();
		dateField.setEditable(false);
		dateField.setBounds(528, 71, 100, 22);
		contentPane.add(dateField);
		dateField.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBounds(29, 133, 672, 272);
		contentPane.add(tabbedPane);
		
		JPanel profilePanel = new JPanel();
		profilePanel.setBackground(Color.WHITE);
		profilePanel.setBorder(new LineBorder(Color.BLACK));
		tabbedPane.addTab("Profile", null, profilePanel, null);
		profilePanel.setLayout(null);
		
		JLabel lblDob = new JLabel("Date Of Birth");
		lblDob.setBounds(51, 64, 82, 16);
		profilePanel.add(lblDob);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(51, 23, 45, 16);
		lblName.setVerticalAlignment(SwingConstants.BOTTOM);
		profilePanel.add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(159, 20, 138, 22);
		profilePanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(159, 61, 138, 22);
		profilePanel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(51, 105, 73, 16);
		profilePanel.add(lblNationality);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(159, 102, 138, 22);
		profilePanel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(51, 146, 56, 16);
		profilePanel.add(lblGender);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(159, 143, 138, 22);
		profilePanel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setBounds(51, 187, 56, 16);
		profilePanel.add(lblNewLabel);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(159, 184, 138, 22);
		profilePanel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblAccountNo = new JLabel("Account No.");
		lblAccountNo.setBounds(336, 23, 95, 16);
		profilePanel.add(lblAccountNo);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setBounds(336, 64, 95, 16);
		profilePanel.add(lblAccountType);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setBounds(336, 105, 82, 16);
		profilePanel.add(lblPhoneNo);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(464, 20, 138, 22);
		profilePanel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(464, 61, 138, 22);
		profilePanel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBounds(464, 102, 138, 22);
		profilePanel.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setBounds(336, 146, 116, 16);
		profilePanel.add(lblSecurityQuestion);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setBounds(464, 143, 138, 22);
		profilePanel.add(textField_10);
		textField_10.setColumns(10);

		/////////////////////////////PROFILE////////////////////////////////////
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			//When edit button is pressed, allow the user to edit the information 
			public void actionPerformed(ActionEvent arg0) {
				textField_2.setEditable(false);
				textField_3.setEditable(false);
				textField_4.setEditable(true);
				textField_5.setEditable(true);
				textField_6.setEditable(true);
				textField_7.setEditable(false);
				textField_8.setEditable(false);
				textField_9.setEditable(true);
				textField_10.setEditable(true);
			}
		});
		///////////////////////////////////////////////////////////////////////////

		btnEdit.setBounds(330, 184, 101, 25);
		profilePanel.add(btnEdit);

		///////////////////////////////////////////PROFILE//////////////////////////////////////////////////////////////////
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				try {									  //updates following
					String val1 = textField_4.getText();  //nationality
					String val2 = textField_5.getText();  //gender
					String val3 = textField_6.getText();  //address
					String val4 = textField_9.getText();  //phone number
					String val5 = textField_10.getText(); //security question
					String val6 = textField_2.getText();  //name
					
					String sql = "update bankAcc set Nationality='" + val1 + "',Gender='" + val2 + "',Address='" +val3+"'"
							      + ",SecQ='" + val5 + "',Mob='" + val4 + "'where Name='" + val6 + "'";
							 
					pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Updated");
				}
				catch(Exception k) {
					JOptionPane.showMessageDialog(null, k);
				}
			}
		});
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		btnSaveChanges.setBounds(486, 184, 116, 25);
		profilePanel.add(btnSaveChanges);
		
		JPanel depositPanel = new JPanel();
		depositPanel.setBackground(Color.WHITE);
		depositPanel.setBorder(new LineBorder(Color.BLACK));
		depositPanel.setForeground(Color.BLACK);
		tabbedPane.addTab("Deposit", null, depositPanel, null);
		depositPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setBounds(51, 23, 36, 16);
		depositPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Account Type");
		lblNewLabel_2.setBounds(51, 64, 91, 16);
		depositPanel.add(lblNewLabel_2);
			
		JLabel lblNewLabel_3 = new JLabel("Account No.");
		lblNewLabel_3.setBounds(336, 64, 83, 16);
		depositPanel.add(lblNewLabel_3);
			
		JLabel lblNewLabel_4 = new JLabel("Account Balance");
		lblNewLabel_4.setBounds(51, 105, 108, 16);
		depositPanel.add(lblNewLabel_4);
			
		JLabel lblNewLabel_5 = new JLabel("Deposit");
		lblNewLabel_5.setBounds(51, 146, 54, 16);
		depositPanel.add(lblNewLabel_5);
			
		userFieldDeposit = new JTextField();
		userFieldDeposit.setBounds(159, 20, 138, 22);
		depositPanel.add(userFieldDeposit);
		userFieldDeposit.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setBounds(159, 61, 138, 22);
		depositPanel.add(textField_11);
		textField_11.setColumns(10);
			
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setBounds(443, 61, 138, 22);
		depositPanel.add(textField_12);
		textField_12.setColumns(10);
			
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setBounds(159, 102, 138, 22);
		depositPanel.add(textField_13);
		textField_13.setColumns(10);

		/////////////////////////////DEPOSIT//////////////////////////////////////////
		JButton btnNewButton = new JButton("Find");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "select * from bankAcc where Name=?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, userFieldDeposit.getText());
					rs = pst.executeQuery();
					if(rs.next())
					{
						String add1 = rs.getString("Acc_Type");
						textField_11.setText(add1);
						String add2 = rs.getString("Acc");
						textField_12.setText(add2);
						String add3 = rs.getString("Balance");
						textField_13.setText(add3);
						rs.close();
						pst.close();
					}
					else
						JOptionPane.showMessageDialog(null, "Enter Correct Name");
				}	
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				finally {
					try {
						rs.close();
						pst.close();
					}
					catch(Exception e) {
					}
				}
			}
		});	   
		//////////////////////////////////////////////////////////////////////////////////////
			
		textField_14 = new JTextField();
		textField_14.setBounds(159, 143, 70, 22);
		depositPanel.add(textField_14);
		textField_14.setColumns(10);
		btnNewButton.setBounds(330, 20, 97, 25);
		depositPanel.add(btnNewButton);
			
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setBounds(227, 143, 70, 22);
		depositPanel.add(textField_15);
		textField_15.setColumns(10);
		
		/////////////////////////////DEPOSIT///////////////////////////////////////
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_14.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Amount");
				}
				else
				{
					try {
						String amount1 = textField_13.getText();
						String amount2 = textField_14.getText();
						int sum = Integer.parseInt(amount1) + Integer.parseInt(amount2);
						String sum1 = String.valueOf(sum);
						textField_15.setText(sum1);				
					}
					catch(Exception k) {
						JOptionPane.showMessageDialog(null, k);
					}
				}
			}
		});
		////////////////////////////////////////////////////////////////////////////
		
		btnTotal.setBounds(330, 143, 97, 25);
		depositPanel.add(btnTotal);
		
		////////////////////////////////////////////DEPOSIT///////////////////////////////////////////////////
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_15.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Find Total");
				}
				else
				{
					try {
						String val1 = userFieldDeposit.getText();
						String val2 = textField_15.getText();
						String sql = " Update bankAcc set Balance = '" + val2 + "' where Name ='" + val1 +"'";
					  
						pst = conn.prepareStatement(sql);
						pst.execute();
				
						JOptionPane.showMessageDialog(null, "Successfully Deposited");			  
					}
					catch(Exception k) {
					 	JOptionPane.showMessageDialog(null, k);
					}
                    
					///////////////////////////TRANSACTION HISTORY//////////////////////////////////////////////////
					try {	
						//  Calendar calendar = Calendar.getInstance();
						String date = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
						String time= new SimpleDateFormat("hh:mm a").format(Calendar.getInstance().getTime());

						//updates following into TransHistory database//
						String value1 = userFieldDeposit.getText(); //Name
						String value2 = textField_14.getText()+'+'; //amount
						String value3 = textField_15.getText(); //balance
						String value4 = "Deposit"; //TransType
						String query = " insert into transaction_hist (Name, transType, Amount, Balance, Date, Time)"
							        + " values (?, ?, ?, ?, ?, ?)";
						
						pst = conn.prepareStatement(query);
					    pst.setString (1, value1);
						pst.setString (2, value4);
					    pst.setString (3, value2);
					    pst.setString (4, value3);
					    pst.setString(5,date);
						pst.setString(6,time);
						pst.execute();
					}
					catch(Exception k) {
							JOptionPane.showMessageDialog(null, k);
					}
				    //////////////////////////////////////////////////////////////////////////////////////////////////
					
					userFieldDeposit.setText("");
					textField_11.setText("");
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					textField_15.setText("");	  
				}
			}
		});
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
		btnDeposit.setBounds(45, 184, 97, 25);
		depositPanel.add(btnDeposit);
			 
		//////////////////DEPOSIT////////////////////////
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_14.setText(null);
				textField_15.setText(null);					
			}
		});
		/////////////////////////////////////////////////
		
		btnClear.setBounds(439, 143, 97, 25);
		depositPanel.add(btnClear);
		
		JPanel withdrawPanel = new JPanel();
		withdrawPanel.setBackground(Color.WHITE);
		withdrawPanel.setBorder(new LineBorder(Color.BLACK));
		tabbedPane.addTab("Withdraw", null, withdrawPanel, null);
		withdrawPanel.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("User");
		lblNewLabel_12.setBounds(51, 23, 36, 16);
		withdrawPanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Account Type");
		lblNewLabel_13.setBounds(51, 64, 91, 16);
		withdrawPanel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Account No.");
		lblNewLabel_14.setBounds(336, 64, 86, 16);
		withdrawPanel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Account Balance");
		lblNewLabel_15.setBounds(51, 105, 103, 16);
		withdrawPanel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Withdraw");
		lblNewLabel_16.setBounds(51, 146, 63, 16);
		withdrawPanel.add(lblNewLabel_16);
		
		textField_28 = new JTextField();
		textField_28.setBounds(159, 20, 138, 22);
		withdrawPanel.add(textField_28);
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setEditable(false);
		textField_29.setBounds(159, 61, 138, 22);
		withdrawPanel.add(textField_29);
		textField_29.setColumns(10);
		
		textField_30 = new JTextField();
		textField_30.setEditable(false);
		textField_30.setBounds(443, 61, 138, 22);
		withdrawPanel.add(textField_30);
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setEditable(false);
		textField_31.setBounds(159, 102, 138, 22);
		withdrawPanel.add(textField_31);
		textField_31.setColumns(10);
		
		textField_32 = new JTextField();
		textField_32.setBounds(159, 143, 70, 22);
		withdrawPanel.add(textField_32);
		textField_32.setColumns(10);
		
		textField_33 = new JTextField();
		textField_33.setEditable(false);
		textField_33.setBounds(227, 143, 70, 22);
		withdrawPanel.add(textField_33);
		textField_33.setColumns(10);

		//////////////////////////////////////WITHDRAW////////////////////////////////
		JButton btnFind_1 = new JButton("Find");
		btnFind_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String sql = "select * from bankAcc where Name=?";
				 try {
					 pst = conn.prepareStatement(sql);
					 pst.setString(1, textField_28.getText());
					 rs = pst.executeQuery();
					 if(rs.next())
					 {
						 String add1 = rs.getString("Acc_Type");
						 textField_29.setText(add1);
						 String add2 = rs.getString("Acc");
						 textField_30.setText(add2);
						 String add3 = rs.getString("Balance");
						 textField_31.setText(add3);
						 rs.close();
						 pst.close();
					 }
					 else
						 JOptionPane.showMessageDialog(null, "Enter Correct Name");	
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
		////////////////////////////////////////////////////////////////////////////////
		
		btnFind_1.setBounds(330, 20, 97, 25);
		withdrawPanel.add(btnFind_1);
		
		//////////////////////////////////////WITHDRAW//////////////////////////////////////
		JButton btnShow_1 = new JButton("Total");
		btnShow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_32.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter Amount");
				}
				else
				{
				  try {
				  	  String amount1 = textField_31.getText();
				  	  String amount2 = textField_32.getText();
				 	  int difference = Integer.parseInt(amount1) - Integer.parseInt(amount2);
				 	  if(difference < 0)
				 		 JOptionPane.showMessageDialog(null,"Error Negative Balance");
				 	  else {
				 		  String difference1 = String.valueOf(difference);
				 		  textField_33.setText(difference1);
				 	  }
				 }
				  catch(Exception k) {
				 	JOptionPane.showMessageDialog(null, k);
				 } 
				}
			}
		});
        ///////////////////////////////////////////////////////////////////////////////////////

		btnShow_1.setBounds(330, 143, 97, 25);
		withdrawPanel.add(btnShow_1);
 
		//////////////////////////////////////WITHDRAW////////////////////////////////////////////////////////////
		JButton btnTakeOut = new JButton("Withdraw");
		btnTakeOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_33.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"Find Total");
				else
				{
					try {	
						String string1 = textField_28.getText();
						String string2 = textField_33.getText();
						String sql = "Update bankAcc set Balance='" + string2 + "' where Name='" + string1 + "'";
						pst = conn.prepareStatement(sql);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Successfully Withdrawn"); 
					}
					catch(Exception k) {
						JOptionPane.showMessageDialog(null, k);
					}

					///////////////////////////TRANSACTION HISTORY///////////////////////////////////////////////////
					try {	
						//  Calendar calendar = Calendar.getInstance();
						String date = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
						String time= new SimpleDateFormat("hh:mm a").format(Calendar.getInstance().getTime());

						//updates following into TransHistory database//
						String value1 = textField_28.getText(); //Name
						String value2 = '-'+textField_32.getText(); //amount
						String value3 = textField_33.getText(); //balance
						String value4 = "Withdraw"; //TransType
						String query = " insert into transaction_hist (Name, transType, Amount, Balance, Date, Time)"
								+ " values (?, ?, ?, ?, ?,?)";

						pst = conn.prepareStatement(query);
						pst.setString (1, value1);
						pst.setString (2, value4);
						pst.setString (3, value2);
						pst.setString (4, value3);
						pst.setString(5,date);
						pst.setString(6,time);
						pst.execute();
					}
					catch(Exception k) {
						JOptionPane.showMessageDialog(null, k);
					}
					///////////////////////////////////////////////////////////////////////////////////////////////////
				
					textField_28.setText("");
					textField_29.setText("");
					textField_30.setText("");
					textField_31.setText("");
					textField_32.setText("");
					textField_33.setText("");
				}
			}
		});
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		btnTakeOut.setBounds(45, 184, 97, 25);
		withdrawPanel.add(btnTakeOut);
 
		///////////////////////WITHDRAW//////////////////////
		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_32.setText(null);
				textField_33.setText(null);			
			}
		});
        /////////////////////////////////////////////////////

		btnClear_1.setBounds(439, 143, 97, 25);
		withdrawPanel.add(btnClear_1);
		
		JPanel transferPanel = new JPanel();
		transferPanel.setBackground(Color.WHITE);
		transferPanel.setBorder(new LineBorder(Color.BLACK));
		tabbedPane.addTab("Transfer", null, transferPanel, null);
		transferPanel.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(51, 23, 36, 16);
		transferPanel.add(lblUser);
		
		JLabel lblName_1 = new JLabel("Account Type");
		lblName_1.setBounds(51, 64, 91, 16);
		transferPanel.add(lblName_1);
		
		JLabel lblNewLabel_6 = new JLabel("Account No.");
		lblNewLabel_6.setBounds(336, 64, 86, 16);
		transferPanel.add(lblNewLabel_6);
		
		JLabel lblAvailableBalance = new JLabel("Account Balance");
		lblAvailableBalance.setBounds(51, 105, 107, 16);
		transferPanel.add(lblAvailableBalance);
		
		JLabel lblTransferAmount = new JLabel("Transfer");
		lblTransferAmount.setBounds(51, 146, 57, 16);
		transferPanel.add(lblTransferAmount);
		
		JLabel lblCreditAccount = new JLabel("Credit Account");
		lblCreditAccount.setBounds(159, 187, 99, 16);
		transferPanel.add(lblCreditAccount);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 20, 138, 22);
		transferPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setBounds(159, 61, 138, 22);
		transferPanel.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setBounds(443, 61, 138, 22);
		transferPanel.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setEditable(false);
		textField_18.setBounds(159, 102, 138, 22);
		transferPanel.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(159, 143, 70, 22);
		transferPanel.add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setEditable(false);
		textField_20.setBounds(387, 184, 70, 22);
		transferPanel.add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setEditable(false);
		textField_21.setBounds(227, 143, 70, 22);
		transferPanel.add(textField_21);
		textField_21.setColumns(10);

		////////////////////////////////////////TRANSFER///////////////////////////////////////
		JButton btnNewButton_1 = new JButton("Find");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from bankAcc where Name=?";
				try {
				    pst = conn.prepareStatement(sql);
					pst.setString(1, textField_1.getText());
					rs = pst.executeQuery();
					if(rs.next())
					{
						String add1 = rs.getString("Acc_Type");
						textField_16.setText(add1);
						String add2 = rs.getString("Acc");
						textField_17.setText(add2);
						String add3 = rs.getString("Balance");
						textField_18.setText(add3);
						rs.close();
						pst.close();
					}
					else
						JOptionPane.showMessageDialog(null, "Enter Correct Name");
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
		//////////////////////////////////////////////////////////////////////////////////////

		btnNewButton_1.setBounds(330, 20, 97, 25);
		transferPanel.add(btnNewButton_1);

		////////////////////////////////////////TRANSFER///////////////////////////////////////
		JButton btnNewButton_2 = new JButton("Total");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_19.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter Amount");
				}
				else if(textField_18.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter User");
				}
				else
				{
				  try {
				  	  String amount1 = textField_18.getText();
				  	  String amount2 = textField_19.getText();
				  	  
				 	  int sum = Integer.parseInt(amount1) - Integer.parseInt(amount2);
				 	  if(sum < 0)
				 	  {
				 		  JOptionPane.showMessageDialog(null,"Error Negative Balance");
				 	  }
				 	  else {
				 		  String sum1 = String.valueOf(sum);
				 		  textField_21.setText(sum1);
				 	  }
				 }
				 catch(Exception e) {
				 	JOptionPane.showMessageDialog(null, e);
				 }
				}
			}
		});
        /////////////////////////////////////////////////////////////////////////////////////////

		btnNewButton_2.setBounds(330, 143, 97, 25);
		transferPanel.add(btnNewButton_2);
		
		textField_22 = new JTextField();
		textField_22.setEditable(false);
		textField_22.setBounds(455, 184, 70, 22);
		transferPanel.add(textField_22);
		textField_22.setColumns(10);
 
		////////////////////////////////////////TRANSFER///////////////////////////////////////
		JButton btnShow = new JButton("Enter");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_19.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Transfer Amount");
				}
				else if(textField_34.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Account Number");
				}
				else if(textField_18.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter User");
				}
				else
				{
					String sql = "select * from bankAcc where Acc=?";
					try {
						pst = conn.prepareStatement(sql);
						pst.setString(1, textField_34.getText());
						rs = pst.executeQuery();
						if(rs.next())
						{
							String add1 = rs.getString("Balance");
							textField_20.setText(add1);
							String add2 = rs.getString("Name");
							textField_36.setText(add2);
							rs.close();
							pst.close();
						}
						else
							JOptionPane.showMessageDialog(null, "Incorrect Account Number");
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
					try {
				  	  	String amount1 = textField_19.getText();
				  	  	String amount2 = textField_20.getText();			  	  
				  	  	int sum = Integer.parseInt(amount1) + Integer.parseInt(amount2);			
				  	  	String sum1 = String.valueOf(sum);			
				  	  	textField_22.setText(sum1);		 
					}
					catch(Exception k) {
						JOptionPane.showMessageDialog(null, k);
					}  
				}
		    }	
		});
	    ////////////////////////////////////////////////////////////////////////////////////////////

		btnShow.setBounds(551, 167, 71, 25);
		transferPanel.add(btnShow);
  
		/////////////////////////////////////////////////TRANSFER///////////////////////////////////////////////////////////////
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {		
			public void TransferC() {	
				try {
					String val1 = textField_34.getText();
					String val2 = textField_22.getText();
					String sql = "update bankAcc set Balance = '" + val2 + "' where Acc ='" + val1 +"'";
					
					pst = conn.prepareStatement(sql);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Successfully Transferred");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null , e);
				}

				/////////////////////////TRANSACTION HISTORY/////////////////////////////////////////////////////
				try {	
					//  Calendar calendar = Calendar.getInstance();
					String date = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
					String time= new SimpleDateFormat("hh:mm a").format(Calendar.getInstance().getTime());

					//updates following into TransHistory database//
					String value1 = textField_36.getText(); //Name
					String value2 = textField_19.getText()+'+'; //amount
					String value3 = textField_22.getText(); //balance
					String value4 = "Transfer"; //TransType
					String query = " insert into transaction_hist (Name, transType, Amount, Balance, Date, Time)"
					        + " values (?, ?, ?, ?, ?, ?)";

					pst = conn.prepareStatement(query);
				    pst.setString (1, value1);
					pst.setString (2, value4);
				    pst.setString (3, value2);
				    pst.setString (4, value3);
				    pst.setString(5, date);
					pst.setString(6, time);
					pst.execute();
				}
				catch(Exception k) {
					JOptionPane.showMessageDialog(null, k);
				}
				///////////////////////////////////////////////////////////////////////////////////////////////////
			}
			public void TransferD() {
				try {
					String val1 = textField_1.getText();	//get Name
					String val2 = textField_21.getText();
					String sql = "update bankAcc set Balance = '" + val2 + "' where Name ='" + val1 +"'";
					
					pst = conn.prepareStatement(sql);
					pst.execute();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null , e);
				}

				/////////////////////////TRANSACTION HISTORY/////////////////////////////////////////////////////
				try {	
					//  Calendar calendar = Calendar.getInstance();
					String date = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
					String time= new SimpleDateFormat("hh:mm a").format(Calendar.getInstance().getTime());

					//updates following into TransHistory database//
					String value1 = textField_1.getText(); //Name
					String value2 = '-'+textField_19.getText(); //amount
					String value3 = textField_21.getText(); //balance
					String value4 = "Transfer"; //TransType
					String query = " insert into transaction_hist (Name, transType, Amount, Balance, Date, Time)"
					        + " values (?, ?, ?, ?, ?,?)";

					pst = conn.prepareStatement(query);
				    pst.setString (1, value1);
					pst.setString (2, value4);
				    pst.setString (3, value2);
				    pst.setString (4, value3);
				    pst.setString(5,date);
					pst.setString(6,time);
					pst.execute();	
				}
				catch(Exception k) {
					JOptionPane.showMessageDialog(null, k);
				}	
				///////////////////////////////////////////////////////////////////////////////////////////////////

			}		
			public void actionPerformed(ActionEvent e) {
				if(textField_22.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Find Transfer Total");
				}
				else if(textField_19.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Reenter Credit Number");
				}
				else
				{
					TransferD();
					TransferC();
					textField_1.setText("");
					textField_16.setText("");
					textField_17.setText("");
					textField_18.setText("");
					textField_19.setText("");
					textField_20.setText("");
					textField_21.setText("");
					textField_22.setText("");
					textField_34.setText("");
					textField_36.setText("");
				}			
			}
		});
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

		btnTransfer.setBounds(529, 195, 116, 25);
		transferPanel.add(btnTransfer);

		////////////////////TRANSFER///////////////////////////
		JButton btnClear_2 = new JButton("Clear");
		btnClear_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_19.setText(null);
				textField_21.setText(null);
				textField_36.setText(null);
				textField_34.setText(null);
				textField_20.setText(null);
				textField_22.setText(null);
			}
		});
		///////////////////////////////////////////////////////////

		btnClear_2.setBounds(439, 143, 97, 25);
		transferPanel.add(btnClear_2);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(259, 184, 116, 22);
		transferPanel.add(textField_34);
		
		textField_36 = new JTextField();
		textField_36.setEditable(false);
		textField_36.setBounds(49, 184, 107, 22);
		transferPanel.add(textField_36);
		textField_36.setColumns(10);
		
		JPanel customerListPanel = new JPanel();
		customerListPanel.setBackground(Color.WHITE);
		customerListPanel.setBorder(new LineBorder(Color.BLACK));
		tabbedPane.addTab("Customer List", null, customerListPanel, null);
		customerListPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 651, 226);
		customerListPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel transactionPanel = new JPanel();
		transactionPanel.setBorder(null);
		transactionPanel.setForeground(Color.BLACK);
		tabbedPane.addTab("Transaction History", null, transactionPanel, null);
		transactionPanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 38, 651, 188);
		transactionPanel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		/////////////////////////////////////////////////TRANACTION HISTORY////////////////////////////////////////////
		JButton btnNewButton_4 = new JButton("Find");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "Select Name, transType, Amount, Balance, Date, Time from transaction_hist where Name=?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField_35.getText());
					rs = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));			
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				finally {
					try {
						rs.close();
						pst.close();					
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}				
				}
			}
		});
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		btnNewButton_4.setBounds(537, 7, 97, 25);
		transactionPanel.add(btnNewButton_4);
		
		textField_35 = new JTextField();
		textField_35.setBounds(387, 7, 138, 22);
		transactionPanel.add(textField_35);
		textField_35.setColumns(10);
		
		JLabel lblUser_1 = new JLabel("User");
		lblUser_1.setBounds(345, 10, 35, 16);
		transactionPanel.add(lblUser_1);
		
		JPanel balancePanel = new JPanel();
		balancePanel.setBackground(Color.WHITE);
		balancePanel.setBorder(new LineBorder(Color.BLACK));
		tabbedPane.addTab("View Balance", null, balancePanel, null);
		balancePanel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("User");
		lblNewLabel_7.setBounds(51, 23, 36, 16);
		balancePanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Account Type");
		lblNewLabel_8.setBounds(51, 64, 96, 16);
		balancePanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Account No.");
		lblNewLabel_9.setBounds(336, 64, 83, 16);
		balancePanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("MICR No.");
		lblNewLabel_10.setBounds(51, 105, 66, 16);
		balancePanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Account Balance");
		lblNewLabel_11.setBounds(51, 146, 108, 16);
		balancePanel.add(lblNewLabel_11);
		
		textField_23 = new JTextField();
		textField_23.setBounds(159, 20, 138, 22);
		balancePanel.add(textField_23);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setEditable(false);
		textField_24.setBounds(159, 61, 138, 22);
		balancePanel.add(textField_24);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setEditable(false);
		textField_25.setBounds(443, 61, 138, 22);
		balancePanel.add(textField_25);
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setEditable(false);
		textField_26.setBounds(159, 102, 138, 22);
		balancePanel.add(textField_26);
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setEditable(false);
		textField_27.setBounds(159, 143, 138, 22);
		balancePanel.add(textField_27);
		textField_27.setColumns(10);
 
		///////////////////////////////VIEW BALANCE/////////////////////////////////////////
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from bankAcc where Name=?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField_23.getText());
					rs = pst.executeQuery();
					if(rs.next())
					{
						String add1 = rs.getString("Acc_Type");
						textField_24.setText(add1);
						String add2 = rs.getString("Acc");
						textField_25.setText(add2);
						String add3 = rs.getString("MICR_No");
						textField_26.setText(add3);
						String add4 = rs.getString("Balance");
						textField_27.setText(add4);
						rs.close();
						pst.close();
					}
					else
						JOptionPane.showMessageDialog(null, "Enter Correct Name");
				}
				catch(Exception k) {
					JOptionPane.showMessageDialog(null, k);
				}
			}
		});
		//////////////////////////////////////////////////////////////////////////////////////

		btnFind.setBounds(330, 20, 97, 25);
		balancePanel.add(btnFind);

		////////////////VIEW BALANCE//////////////////////
		JButton btnClear_3 = new JButton("Clear");
		btnClear_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_23.setText(null);
				textField_24.setText(null);
				textField_25.setText(null);
				textField_26.setText(null);
				textField_27.setText(null);
			}
		});
		//////////////////////////////////////////////////

		btnClear_3.setBounds(330, 143, 97, 25);
		balancePanel.add(btnClear_3);

		////////////////////////////////PROFILE/////////////////////////////////////////
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "Select * from bankAcc where Name=?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					rs = pst.executeQuery();
					if(rs.next()) {
						String add1 = rs.getString("Name");
						textField_2.setText(add1);
						String add2 = rs.getString("Acc"); //Account No. set
						textField_7.setText(add2);
						String add3 = rs.getString("DOB");
						textField_3.setText(add3);
						String add4 = rs.getString("Acc_Type");
						textField_8.setText(add4);
						String add5 = rs.getString("Nationality");
						textField_4.setText(add5);
						String add6 = rs.getString("Mob");
						textField_9.setText(add6);
						String add7 = rs.getString("Gender");
						textField_5.setText(add7);
						String add8 = rs.getString("SecQ");
						textField_10.setText(add8);
						String add9 = rs.getString("Address");
						textField_6.setText(add9);
						rs.close();
						pst.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Enter Correct Name");
					}	
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				finally{
					try {
						rs.close();
						pst.close();
					} 
					catch(Exception e){						
					}
				}
			}
		});
        ////////////////////////////////////////////////////////////////////////////////////////// 

		btnSearch.setBounds(629, 39, 83, 25);
		contentPane.add(btnSearch);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BankerHomePage.class.getResource("/edu/cuny/csi/csc330/icons/Bank Logo 2 x325.png")));
		label.setBounds(29, 23, 326, 81);
		contentPane.add(label);
		
		//After the table and its components are created, fill in information
		//Call to fill in info for date tab		
		Calendar();		
		Table1();
	}
}