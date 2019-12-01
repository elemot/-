package AccessSQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class windowAdmin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 */
	public windowAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("欢迎使用");
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.setBackground(Color.LIGHT_GRAY);
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("按订单号查找");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				windowSelect winse = new windowSelect();
			}
		});
		menu.setBackground(Color.LIGHT_GRAY);
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("添加");
		menu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				windowAdd winadd = new windowAdd();
			}
		});
		menu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("修改");
		menu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(menu_2);
		menu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				windowUpdate winupdate = new windowUpdate();
			}
		});
		
		JMenu menu_3 = new JMenu("删除");
		menu_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(menu_3);
		menu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				windowDelete windel = new windowDelete();
			}
		});
		
		JMenu menu_4 = new JMenu("查看全部");
		menu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				windowWatch winWatch = new windowWatch();
			}
		});
		menu_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(menu_4);
		
		JMenu menu_5 = new JMenu("帮助");
		menu_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(menu_5);
		
		JMenuItem menuItem = new JMenuItem("关于");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"本窗口为精简版物流管理系统管理员端！","提示",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,"本窗口为精简版物流管理系统管理员端！","提示",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menu_5.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("版本");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"本程序使用Java 12版！使用IDE为Eclipse！","提示",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		menuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,"本程序使用Java 12版！使用IDE为Eclipse！","提示",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menu_5.add(menuItem_1);
		
		frame.setVisible(true);
	}

}
