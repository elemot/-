package AccessSQL;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class windowWatch {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public windowWatch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("全部订单");
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		String[] Title = {"ID","车辆信息","人员信息","出发地","到达地","出发日期","到达日期"};
		try {
			Properties prop = new Properties();
			prop.put("charSet", "utf-8");
			Class.forName("com.hxtt.sql.access.AccessDriver");
			String url = "jdbc:Access:///Database11.mdb";
			Connection con = DriverManager.getConnection(url,prop);
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery("select * from 订单表");
			DefaultTableModel dtm = new DefaultTableModel();
			dtm.addColumn("ID");
			dtm.addColumn("车辆信息");
			dtm.addColumn("人员信息");
			dtm.addColumn("出发地");
			dtm.addColumn("到达地");
			dtm.addColumn("出发日期");
			dtm.addColumn("到达日期");
			dtm.addRow(Title);
			Object[] base = new Object[7];
			while(rs.next()){     
			      base[0] = rs.getString("ID");
			      base[1] = rs.getString("车辆信息");
			      base[2] = rs.getString("人员信息");
			      base[3] = rs.getString("出发地");
			      base[4] = rs.getString("到达地");
			      base[5] = rs.getString("出发日期");
			      base[6] = rs.getString("到达日期");
			      dtm.addRow(base);
			      }
			table = new JTable(dtm);
			table.setBounds(0, 0, 536, 463);
			table.setEnabled(false);
			frame.getContentPane().add(table);
			con.close();
			}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		finally 
		{
			frame.setVisible(true);
		}
	}
}
