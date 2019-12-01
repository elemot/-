package AccessSQL;

import java.awt.EventQueue;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.Font;
import java.awt.event.*;


public class AccessSQL {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessSQL window = new AccessSQL();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccessSQL() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("登录");
		frame.setBounds(100, 100, 350, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("账号：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(60, 38, 58, 26);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("密码：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(60, 86, 58, 26);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(121, 42, 127, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.enableInputMethods(false);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 90, 127, 21);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(textField.getText().equals("")|| new String(passwordField.getPassword()).equals(""))
				{
					JOptionPane.showMessageDialog(frame,"您输入有误！","警告",JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						Class.forName("com.hxtt.sql.access.AccessDriver");
						String url = "jdbc:Access:///Database11.mdb";
						Connection con = DriverManager.getConnection(url);
						Statement sta = con.createStatement();
						ResultSet rstpass = sta.executeQuery("select 密码 from 用户表 where 账号="+"'"+textField.getText()+"'");
						//System.out.print(rstpass.isLast());
						if(!rstpass.next())
							JOptionPane.showMessageDialog(frame,"您输入账号不存在！","警告",JOptionPane.WARNING_MESSAGE);
						else {
							if(rstpass.getString(1).equals(new String(passwordField.getPassword())))
							{
								ResultSet rstrole = sta.executeQuery("select 属性 from 用户表 where 账号="+"'"+textField.getText()+"'");
								rstrole.next();
								if(rstrole.getString(1).equals("1"))
								{
									frame.setVisible(false);
									con.close();
									windowAdmin window1 = new windowAdmin();
								}
								else if(rstrole.getString(1).equals("0"))
								{
									frame.setVisible(false);
									con.close();
									windowGuest window2 = new windowGuest();
								}
							}
							else
							{
								JOptionPane.showMessageDialog(frame,"您输入的密码有误！","警告",JOptionPane.WARNING_MESSAGE);
								con.close();
							}
						}
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(123, 196, 97, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setLocationRelativeTo(null);
	}
}