package AccessSQL;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.TextField;

public class windowAdd {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}
	/**
	 * Create the application.
	 */
	public windowAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		frame.setTitle("添加新订单");
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("车辆信息:");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 40, 63, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("运输人员信息:");
		label_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		label_1.setBounds(39, 70, 103, 25);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("出发地：");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(39, 100, 63, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("到达地：");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(39, 130, 58, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("出发时间：");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(39, 160, 72, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("到达时间：");
		lblNewLabel_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(39, 190, 72, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(113, 43, 86, 22);
		frame.getContentPane().add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(148, 73, 97, 22);
		frame.getContentPane().add(textField_2);
		
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(103, 101, 86, 22);
		frame.getContentPane().add(textField_3);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(103, 131, 86, 22);
		frame.getContentPane().add(textField_4);
		
		TextField textField_5 = new TextField();
		textField_5.setBounds(113, 161, 86, 22);
		frame.getContentPane().add(textField_5);
		
		TextField textField_6 = new TextField();
		textField_6.setBounds(113, 193, 86, 22);
		frame.getContentPane().add(textField_6);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Properties prop = new Properties();
					prop.put("charSet", "utf-8");
					Class.forName("com.hxtt.sql.access.AccessDriver");
					String url = "jdbc:Access:///Database11.mdb";
					Connection con = DriverManager.getConnection(url,prop);
					Statement sta = con.createStatement();
					String sqlIn = "insert into 订单表(车辆信息,人员信息,出发地,到达地,出发日期,到达日期) values ('"+textField_1.getText()+"' , '"+textField_2.getText()+"' , '"+textField_3.getText()+"' , '"+textField_4.getText()+"' , '"+textField_5.getText()+"' , '"+textField_6.getText()+"')";
					//System.out.println("insert into 运输表 values ('rgr','treg','jhgv','yjf','32few','1351')");
					int count = sta.executeUpdate(sqlIn);
					con.close();
					if(count == 1)
						JOptionPane.showMessageDialog(frame,"添加成功！","提示",JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(frame,"添加失败！","警告",JOptionPane.ERROR_MESSAGE);

				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					}
				}
		});
		btnNewButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		btnNewButton.setBounds(293, 282, 97, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}
}
