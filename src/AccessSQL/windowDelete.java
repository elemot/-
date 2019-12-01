package AccessSQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class windowDelete {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 */
	public windowDelete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("删除订单");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("要删除的订单号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 60, 115, 36);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(150, 68, 103, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("删除");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Properties prop = new Properties();
					prop.put("charSet", "utf-8");
					Class.forName("com.hxtt.sql.access.AccessDriver");
					String url = "jdbc:Access:///Database11.mdb";
					Connection con = DriverManager.getConnection(url,prop);
					Statement sta = con.createStatement();
					String sql = "DELETE from 订单表 where ID ='"+textField.getText()+"'";
					int count = sta.executeUpdate(sql);
					con.close();
					if(count == 1)
						JOptionPane.showMessageDialog(frame,"删除成功！","提示",JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(frame,"删除失败！","警告",JOptionPane.ERROR_MESSAGE);
					}
				catch (Exception e1)
				{
					e1.printStackTrace();
					}
				}
		});
		btnNewButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		btnNewButton.setBounds(235, 174, 97, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}
}
