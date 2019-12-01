package AccessSQL;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;

public class windowUpdate {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 */
	public windowUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("修改订单");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("要修改的订单号：");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(43, 28, 115, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(168, 27, 90, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("选择要修改的属性：");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 86, 130, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("车辆信息");
		rdbtnNewRadioButton.setBounds(31, 107, 73, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("人员信息");
		rdbtnNewRadioButton_1.setBounds(112, 107, 78, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("出发地");
		rdbtnNewRadioButton_2.setBounds(192, 107, 73, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("到达地");
		rdbtnNewRadioButton_3.setBounds(31, 132, 73, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("出发日期");
		rdbtnNewRadioButton_4.setBounds(112, 132, 78, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("到达日期");
		rdbtnNewRadioButton_5.setBounds(192, 132, 127, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_5);
		
		ButtonGroup jbg = new ButtonGroup();
		jbg.add(rdbtnNewRadioButton);jbg.add(rdbtnNewRadioButton_1);
		jbg.add(rdbtnNewRadioButton_2);jbg.add(rdbtnNewRadioButton_3);
		jbg.add(rdbtnNewRadioButton_4);jbg.add(rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel_2 = new JLabel("修改后的属性值：");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(43, 178, 115, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 177, 115, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String btnstr = "";
				try {
					Properties prop = new Properties();
					prop.put("charSet", "utf-8");
					Class.forName("com.hxtt.sql.access.AccessDriver");
					String url = "jdbc:Access:///Database11.mdb";
					Connection con = DriverManager.getConnection(url,prop);
					Statement sta = con.createStatement();
					Enumeration<AbstractButton> radioBtns=jbg.getElements(); 
					while (radioBtns.hasMoreElements()) {
						AbstractButton btn = radioBtns.nextElement();
						if(btn.isSelected())
							btnstr = btn.getText();
					}
					String s = "update 订单表 set "+btnstr +"='"+textField_1.getText()+"' where ID = '"+textField.getText() + "'";
					int count = sta.executeUpdate(s);
					con.close();
					if(count == 1)
						JOptionPane.showMessageDialog(frame,"修改成功！","提示",JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(frame,"修改失败！","警告",JOptionPane.ERROR_MESSAGE);
			}
				catch(Exception e1)
				{
					e1.printStackTrace();;
					}
				}
		});
		btnNewButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		btnNewButton.setBounds(298, 230, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		frame.setVisible(true);
	}

}
