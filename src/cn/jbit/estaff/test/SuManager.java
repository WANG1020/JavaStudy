package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cn.jbit.estaff.daoimpl.LogDaoimpl;
import cn.jbit.estaff.entity.Log;
import cn.jbit.estaff.entity.User;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SuManager extends JFrame implements ActionListener{
	
	private User user;
	private JMenuBar menuBar;

	private JMenu mnNewMenu;
	private JMenuItem menuItem_3;
	private JMenuItem menuItem_2;
	private JMenuItem menuItem_1;
	private JMenuItem menuItem;
	
	private JMenu mnNewMenu_1;
	private JMenuItem menuItem_4;
	private JMenuItem menuItem_5;
	private JMenuItem menuItem_6;

	private JMenu menu;
	private JMenuItem menuItem_7;
	private JMenuItem menuItem_8;
	private JMenuItem menuItem_9;
	private JMenuItem menuItem_10;
	private JMenuItem menuItem_11;
	private JMenuItem menuItem_12;
	
	private JMenu menu_1;
	private JMenuItem menuItem_13;
	private JMenuItem menuItem_14;
	
	private JMenu menu_2;
	private JMenuItem menuItem_15;
	private JMenuItem menuItem_16;
	
	private JTextField textField;
	private JButton button;
	private JLabel label;
	private JLabel lblNewLabel;
	
	public SuManager(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Java上课图片\\图标.jfif"));
		this.user=user;
		setTitle("企业员工管理系统：超级管理员");
		this.setSize(465, 319);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(null);
		
		label = new JLabel("欢迎进入！");
		label.setBounds(349, 234, 90, 15);
		getContentPane().add(label);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\员工管理图片\\主界面.jpg"));
		lblNewLabel.setBounds(2, 1, 447, 259);
		getContentPane().add(lblNewLabel);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
	    
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("部门管理");
		menuBar.add(mnNewMenu);	
		menuItem_3 = new JMenuItem("查询部门");
		menuItem_3.addActionListener(this);
		mnNewMenu.add(menuItem_3);
		
		menuItem_2 = new JMenuItem("修改部门消息");
		mnNewMenu.add(menuItem_2);	
		menuItem_2.addActionListener(this);
		
		menuItem_1 = new JMenuItem("删除部门");
		mnNewMenu.add(menuItem_1);
		menuItem_1.addActionListener(this);	
		
		menuItem = new JMenuItem("增加部门");
		mnNewMenu.add(menuItem);
		menuItem.addActionListener(this);
		
		
		mnNewMenu_1 = new JMenu("管理员管理");
		menuBar.add(mnNewMenu_1);
		menuItem_4 = new JMenuItem("删除管理员");
		mnNewMenu_1.add(menuItem_4);
		menuItem_4.addActionListener(this);
		
		menuItem_5 = new JMenuItem("增加管理员");
		mnNewMenu_1.add(menuItem_5);
		menuItem_5.addActionListener(this);
		
		menuItem_6 = new JMenuItem("重置管理员密码");
		mnNewMenu_1.add(menuItem_6);
		menuItem_6.addActionListener(this);
		
		
		menu = new JMenu("员工管理");
		menuBar.add(menu);
		menuItem_7 = new JMenuItem("招聘员工");
		menu.add(menuItem_7);
		menuItem_7.addActionListener(this);
		
		menuItem_8 = new JMenuItem("解雇员工");
		menu.add(menuItem_8);
		menuItem_8.addActionListener(this);
		
		menuItem_16 = new JMenuItem("考勤");
		menu.add(menuItem_16);
		menuItem_16.addActionListener(this);
		
		menuItem_9 = new JMenuItem("查询考勤");
		menu.add(menuItem_9);
		menuItem_9.addActionListener(this);
		
		menuItem_10 = new JMenuItem("工资");
		menu.add(menuItem_10);
		menuItem_10.addActionListener(this);
		
		menuItem_11 = new JMenuItem("信息");
		menu.add(menuItem_11);
		menuItem_11.addActionListener(this);
		
		menuItem_12 = new JMenuItem("重置密码");
		menu.add(menuItem_12);
		menuItem_12.addActionListener(this);
		
		menu_1 = new JMenu("信息管理");
		menuBar.add(menu_1);
		menuItem_13 = new JMenuItem("密码设置");
		menu_1.add(menuItem_13);
		menuItem_13.addActionListener(this);
		
		menuItem_14 = new JMenuItem("数据统计分析");
		menu_1.add(menuItem_14);
		menuItem_14.addActionListener(this);
		
		menu_2 = new JMenu("锁屏管理");
		menuBar.add(menu_2);
		
		menuItem_15 = new JMenuItem("锁屏");
		menu_2.add(menuItem_15);
		menuItem_15.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Log log=new Log();
		log.setJobOfNumber(user.getJobOfNumber());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.setOperationTime(df.format(new Date()));
		LogDaoimpl lDao=new LogDaoimpl();
		
		if(e.getSource()==menuItem_3) {
			log.setOperation("查询部门");
			lDao.insertLog(log);
			new findSector();
		}
		if(e.getSource()==menuItem_2) {
			log.setOperation("更新部门信息");
			lDao.insertLog(log);
			new updateSector();
		}
		if(e.getSource()==menuItem_1) {
			log.setOperation("删除部门");
			lDao.insertLog(log);
			new delSector();
		}
		if(e.getSource()==menuItem) {
			log.setOperation("增加部门");
			lDao.insertLog(log);
			new addSector();
		}
		if(e.getSource()==menuItem_4) {
			log.setOperation("删除管理员");
			lDao.insertLog(log);
			new delMan();
		}
		if(e.getSource()==menuItem_5) {
			log.setOperation("增加管理员");
			lDao.insertLog(log);
			new updateMan();
		}
		if(e.getSource()==menuItem_6) {
			log.setOperation("重置管理员密码");
			lDao.insertLog(log);
			new resetManPass();
		}
		if(e.getSource()==menuItem_7) {
			log.setOperation("招聘员工");
			lDao.insertLog(log);
			new recruitStaf();
		}
		if(e.getSource()==menuItem_8) {
			log.setOperation("解雇员工");
			lDao.insertLog(log);
			new delStaf();
		}
		if(e.getSource()==menuItem_9) {
			log.setOperation("查询考勤");
			lDao.insertLog(log);
			new attendance();
		}
		if(e.getSource()==menuItem_16) {
			log.setOperation("考勤");
			lDao.insertLog(log);
			new addAtten();
		}
		if(e.getSource()==menuItem_10) {
			log.setOperation("设置基本工资");
			lDao.insertLog(log);
			new wages();
		}
		if(e.getSource()==menuItem_11) {
			log.setOperation("查找员工信息");
			lDao.insertLog(log);
			new findSta();
		}
		if(e.getSource()==menuItem_12) {
			log.setOperation("重置员工密码");
			lDao.insertLog(log);
			new resetStaPass();
		}
		if(e.getSource()==menuItem_13) {
			log.setOperation("重置所有密码");
			lDao.insertLog(log);
			new setPass();
		}
		if(e.getSource()==menuItem_14) {
			log.setOperation("数据统计");
			lDao.insertLog(log);
			 new total();
		}
		if(e.getSource()==menuItem_15) {
			log.setOperation("锁屏");
			lDao.insertLog(log);
			new lock();
		}
	}
}
