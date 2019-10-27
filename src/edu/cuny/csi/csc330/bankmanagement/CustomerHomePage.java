package edu.cuny.csi.csc330.bankmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;

public class CustomerHomePage extends JFrame {
	
	protected static final String String = null;
	Connection conn = null;
	ResultSet rs;
	PreparedStatement pst;

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textName;
	private JTable table;
	private JTextField dateField;
	private String username;
	private String password;
	private JTextField textFieldname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerHomePage frame = new CustomerHomePage();
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
	public void Table1()
	{
		try {
			String sql = "Select Name, transType, Amount, Balance, Date, Time from transaction_hist where Name=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, textName.getText());
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
	
	public void Calendar()
	{
		Calendar date = new GregorianCalendar();
		int day = date.get(Calendar.DAY_OF_MONTH);
		int month = date.get(Calendar.MONTH);
		int year = date.get(Calendar.YEAR);
		dateField.setText((month+1) + "/" + (day) + "/" + year );
	}
	
	public void setName()
	{
		try {
			String sql = "select * from bankAcc where Username=? and Password=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next())
			{
				 String add1 = rs.getString("Name");
				 textName.setText(add1);
			     String add2 = rs.getString("Balance");
				 textField_1.setText(add2);
				 textField_9.setText(add2);
			     String add3 = rs.getString("Acc_Type");
				 textField_8.setText(add3);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
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
	
	public CustomerHomePage() 
	{
		//SQL Connection//
		conn = sqlLiteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(29, 133, 672, 272);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("General", null, panel, null);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(159, 20, 138, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Account Balance");
		lblNewLabel_1.setBounds(51, 23, 108, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Withdraw");
		lblNewLabel_2.setBounds(51, 64, 63, 16);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(159, 61, 70, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(227, 61, 70, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		username = Login.retUser();
		password = Login.retPass();
	
		JButton btnNewButton = new JButton("Total");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				if(textField_2.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Amount");
				}
				else if(textField_2.getText().isEmpty()){
					
					JOptionPane.showMessageDialog(null, "Update Balance");
				}
				else
				{				
					try 
					{
				  	  	String amount1 = textField_1.getText();
				  	  	String amount2 = textField_2.getText();
				  	  	int difference = Integer.parseInt(amount1) - Integer.parseInt(amount2);
				  	  	if(difference < 0)
				  	  		JOptionPane.showMessageDialog(null, "Error Negative Balance");
				  	  	else {
				  	  		String difference1 = String.valueOf(difference);
				  	  		textField_3.setText(difference1);
				  	  	}
					}
					catch(Exception k) {
						JOptionPane.showMessageDialog(null, k);
					} 
				}
			}
		});
		btnNewButton.setBounds(330, 61, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Withdraw");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_3.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Find Total");
				else
				{
					try {	
						String string1 = textName.getText();
						String string2 = textField_3.getText();
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
						String time = new SimpleDateFormat("hh:mm a").format(Calendar.getInstance().getTime());
					
						//updates following into TransHistory database//
						String value1 = textName.getText(); //Name
						String value2 = '-' + textField_2.getText(); //amount
						String value3 = textField_3.getText(); //balance
						String value4 = "Withdraw"; //TransType
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

					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
				}
			}
		});
		btnNewButton_1.setBounds(439, 61, 97, 25);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Deposit");
		lblNewLabel_4.setBounds(51, 105, 54, 16);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(159, 102, 70, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(227, 102, 70, 22);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Total");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(textField_4.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Amount");
				}
                else if(textField_4.getText().isEmpty()) 
                {				
					JOptionPane.showMessageDialog(null, "Update Balance");
				}
				else
				{
					try {					
						String amount1 = textField_1.getText();
						String amount2 = textField_4.getText();
						int sum = Integer.parseInt(amount1) + Integer.parseInt(amount2);
						String sum1 = String.valueOf(sum);					
						textField_5.setText(sum1);					
					}
					catch(Exception k) {
						JOptionPane.showMessageDialog(null, k);
					}
				}
			}		
		});
		btnNewButton_2.setBounds(330, 102, 97, 25);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Deposit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_5.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Find Total");
				}
				else
				{
				  try {
					  String val1 = textName.getText();
					  String val2 = textField_5.getText();
					  String sql = "Update bankAcc set Balance = '" + val2 + "' where Name ='" + val1 + "'";			  
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
				  	  String time = new SimpleDateFormat("hh:mm a").format(Calendar.getInstance().getTime());

				  	  //updates following into TransHistory database//
				  	  String value1 = textName.getText(); //Name
				  	  String value2 = textField_4.getText() + '+'; //amount
				  	  String value3 = textField_5.getText(); //balance
					  String value4 = "Deposit"; //TransType
					  String query = " insert into transaction_hist (Name, transType, Amount, Balance, Date,Time)"
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
			      //////////////////////////////////////////////////////////////////////////////////////////////////

				  textField_1.setText("");
				  textField_4.setText("");
				  textField_5.setText("");				
				}
			}
		});
		btnNewButton_3.setBounds(439, 102, 97, 25);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from bankAcc where Name=?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textName.getText());
					rs = pst.executeQuery();
					if(rs.next())
					{
						String add1 = rs.getString("Balance");
						textField_1.setText(add1);
						textField_9.setText(add1);
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
		btnNewButton_4.setBounds(330, 20, 97, 25);
		panel.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Transfer", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Account Type");
		lblNewLabel_8.setBounds(51, 23, 91, 16);
		panel_1.add(lblNewLabel_8);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(159, 20, 138, 22);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Account Balance");
		lblNewLabel_9.setBounds(51, 64, 107, 16);
		panel_1.add(lblNewLabel_9);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBounds(159, 61, 138, 22);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Transfer");
		lblNewLabel_10.setBounds(51, 105, 57, 16);
		panel_1.add(lblNewLabel_10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(159, 102, 70, 22);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setBounds(227, 102, 70, 22);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Credit Account");
		lblNewLabel_11.setBounds(51, 146, 99, 16);
		panel_1.add(lblNewLabel_11);
		
		textField_12 = new JTextField();
		textField_12.setBounds(159, 143, 138, 22);
		panel_1.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Total");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_10.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter Amount");
				}
				else
				{
				  try {
				  	  String amount1 = textField_9.getText();
				  	  String amount2 = textField_10.getText();
				  	  
				 	  int sum = Integer.parseInt(amount1) - Integer.parseInt(amount2);
				 	  if(sum < 0)
				 	  {
				 		  JOptionPane.showMessageDialog(null,"Error Negative Balance");
				 	  }
				 	  else {
				 		  String sum1 = String.valueOf(sum);
				 		  textField_11.setText(sum1);
				 	  }
				  }
				  catch(Exception e) {
					  JOptionPane.showMessageDialog(null, e);
				  }
				}
			}
		});
		btnNewButton_5.setBounds(330, 102, 97, 25);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Transfer");
		btnNewButton_6.addActionListener(new ActionListener() {		
			public void TransferC() {		
				try {
					String val1 = textField_12.getText();
					String val2 = textField_15.getText();
					String sql = "update bankAcc set Balance = '" + val2 + "' where Acc ='" + val1 + "'";			
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
					String time = new SimpleDateFormat("hh:mm a").format(Calendar.getInstance().getTime());

					//updates following into TransHistory database//
					String value1 = textFieldname.getText(); //Name
					String value2 = textField_10.getText()+'+'; //amount
					String value3 = textField_15.getText(); //balance
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
			public void TransferD() {
				try {
					String val1 = textName.getText();	//get Name
					String val2 = textField_11.getText();
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
					String time = new SimpleDateFormat("hh:mm a").format(Calendar.getInstance().getTime());

					//updates following into TransHistory database//
					String value1 = textName.getText(); //Name
					String value2 = '-'+textField_10.getText(); //amount
					String value3 = textField_11.getText(); //balance
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
			public void actionPerformed(ActionEvent arg0) {
				if(textField_10.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Find Transfer Total");
				}
				else if(textField_12.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Reenter Credit Number");
				}
				else
				{
					TransferD();
					TransferC();
					textField_8.setText("");
					textField_9.setText("");
					textField_10.setText("");
					textField_11.setText("");
					textField_12.setText("");
					textField_14.setText("");
					textField_15.setText("");
					textFieldname.setText("");
				}
			}
		});
		btnNewButton_6.setBounds(45, 184, 97, 25);
		panel_1.add(btnNewButton_6);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setBounds(-159, -184, -56, -22);
		panel_1.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setBounds(-227, -184, -56, -22);
		panel_1.add(textField_15);
		textField_15.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("Enter");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_10.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Transfer Amount");
				}
				else if(textField_12.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Account Number");
				}
				else {
					 String sql = "select * from bankAcc where Acc=?";
					 try {
						 pst = conn.prepareStatement(sql);
						 pst.setString(1, textField_12.getText());
						 rs = pst.executeQuery();
						 if(rs.next())
						 {
							 String add1 = rs.getString("Balance");//
							 textField_14.setText(add1);
							 String add2 = rs.getString("Name");
							 textFieldname.setText(add2);
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
						 String amount1 = textField_10.getText();
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
		btnNewButton_7.setBounds(330, 143, 97, 25);
		panel_1.add(btnNewButton_7);
		
		textFieldname = new JTextField();
		textFieldname.setBounds(-295, -184, -40, -22);
		panel_1.add(textFieldname);
		textFieldname.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("Update");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "select* from bankAcc where Name =?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textName.getText());
					rs = pst.executeQuery();
					if(rs.next())
					{
						String add1 = rs.getString("Balance");
						textField_9.setText(add1);
						textField_1.setText(add1);
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
		btnNewButton_8.setBounds(330, 61, 97, 25);
		panel_1.add(btnNewButton_8);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Transaction List", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 38, 651, 188);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_9 = new JButton("Find");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table1();
			}
		});
		btnNewButton_9.setBounds(537, 7, 97, 25);
		panel_2.add(btnNewButton_9);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CustomerHomePage.class.getResource("/edu/cuny/csi/csc330/icons/Bank Logo 2 x325.png")));
		label.setBounds(29, 23, 326, 81);
		contentPane.add(label);
		
		textName = new JTextField();
		textName.setBounds(528, 40, 100, 22);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel date = new JLabel("Date");
		date.setBounds(495, 72, 34, 16);
		contentPane.add(date);
		
		dateField = new JTextField();
		dateField.setColumns(10);
		dateField.setBounds(528, 69, 100, 22);
		contentPane.add(dateField);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(495, 43, 34, 16);
		contentPane.add(lblNewLabel);
		
		Calendar();
		setName();
	}
}