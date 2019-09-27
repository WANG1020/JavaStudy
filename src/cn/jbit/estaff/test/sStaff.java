package cn.jbit.estaff.test;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.table.DefaultTableModel;

import cn.jbit.estaff.dao.SalaryDao;
import cn.jbit.estaff.daoimpl.LogDaoimpl;
import cn.jbit.estaff.daoimpl.StaffDaoMysqlImpl;
import cn.jbit.estaff.entity.Log;
import cn.jbit.estaff.entity.Salary;
import cn.jbit.estaff.entity.User;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class sStaff extends JFrame implements ActionListener{
	private User user;
	private JMenuBar menuBar;
	private JButton mnNewMenu;
	private JButton menu;
	private JLabel label;
	private JLabel lblNewLabel;
	public sStaff(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Java上课图片\\图标.jfif"));
		this.user=user;
		setTitle("企业员工管理系统：普通员工");
		this.setSize(465, 319);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(null);
		
		label = new JLabel("欢迎进入！");
		label.setBounds(347, 231, 76, 14);
		getContentPane().add(label);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\员工管理图片\\主界面.jpg"));
		lblNewLabel.setBounds(0, 0, 449, 255);
		getContentPane().add(lblNewLabel);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init(){
	
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JButton("个人信息查询");
		mnNewMenu.addActionListener(this);
		menuBar.add(mnNewMenu);
		
		menu = new JButton("工资查询");
		menu.addActionListener(this);
		menuBar.add(menu);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Log log=new Log();
		log.setJobOfNumber(user.getJobOfNumber());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.setOperationTime(df.format(new Date()));
		LogDaoimpl lDao=new LogDaoimpl();
		lDao.insertLog(log);
		if(e.getSource()==mnNewMenu){ 
			log.setOperation("查询其他员工信息");
			lDao.insertLog(log);
			new InforOfsStaff();
		}
		if(e.getSource()==menu){
			log.setOperation("查询工资");
			lDao.insertLog(log);
			new SalaryOfsStaff(user);
		}
	}
}
