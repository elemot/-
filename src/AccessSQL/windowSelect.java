package AccessSQL;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class windowSelect {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowUpdate window = new windowUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public windowSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("查询订单");
		frame.setBounds(100, 100,700, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("要查找的订单号：");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		label.setBounds(32, 32, 131, 15);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(158, 31, 124, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 206, 686, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		JButton btnNewButton = new JButton("查找");
		btnNewButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		btnNewButton.setBounds(315, 30, 97, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int flag = -1;
				String s = "";
				for (int i = 0; i < textField.getText().length(); i++) {
					if (!Character.isDigit(textField.getText().charAt(i)))
						flag = 1;
				}
				if (flag == -1) {
					String[] Title = { "ID", "车辆信息", "人员信息", "出发地", "到达地", "出发日期", "到达日期" };
					try {
						Properties prop = new Properties();
						prop.put("charSet", "utf-8");
						Class.forName("com.hxtt.sql.access.AccessDriver");
						String url = "jdbc:Access:///Database11.mdb";
						Connection con = DriverManager.getConnection(url, prop);
						Statement sta = con.createStatement();
						ResultSet rs = sta.executeQuery("select * from 订单表 where ID ='" + textField.getText() + "'");
						DefaultTableModel dtm = new DefaultTableModel();
						dtm.addColumn("ID");
						dtm.addColumn("车辆信息");
						dtm.addColumn("人员信息");
						dtm.addColumn("出发地");
						dtm.addColumn("到达地");
						dtm.addColumn("出发日期");
						dtm.addColumn("到达日期");
						dtm.addRow(Title);
						String[] base = new String[7];
						if (!rs.next())
							JOptionPane.showMessageDialog(frame, "您输入的订单不存在！", "警告", JOptionPane.WARNING_MESSAGE);
						else {
						      base[0] = rs.getString("ID");
						      base[1] = rs.getString("车辆信息");
						      base[2] = rs.getString("人员信息");
						      base[3] = rs.getString("出发地");
						      base[4] = rs.getString("到达地");
						      base[5] = rs.getString("出发日期");
						      base[6] = rs.getString("到达日期");
						      for(int i=0;i<7;i++)
						      {
						    	  s = s+base[i]+"\t";
						      }
						      textField_1.setText(s);
						      textField_1.setVisible(true);
						}con.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else 
					JOptionPane.showMessageDialog(frame,"输入错误！","警告",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		frame.setVisible(true);
	}
}
