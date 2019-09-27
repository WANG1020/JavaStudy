package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cn.jbit.estaff.daoimpl.LogDaoimpl;
import cn.jbit.estaff.daoimpl.ManagerDaoMysqlImpl;
import cn.jbit.estaff.entity.Log;
import cn.jbit.estaff.entity.User;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class PManager extends JFrame implements ActionListener {
	
	private User user;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;
	private JMenu menu;
	private JMenu mnNewMenu_1;
	private JMenu menu_1;
	private JMenuItem menuItem_2;
	private JMenuItem menuItem_3;
	private JMenu menu_2;
	private JMenu menu_3;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem menuItem_4;
	private JMenuItem menuItem_5;
	private JMenuItem menuItem_6;
	private JLabel label;
	private JLabel lblNewLabel;
	
	public PManager(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Java上课图片\\图标.jfif"));
		this.user=user;
		setTitle("企业员工管理系统：管理员");
		this.setSize(465, 319);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(null);
		
		label = new JLabel("欢迎进入！");
		label.setBounds(338, 234, 67, 15);
		getContentPane().add(label);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\员工管理图片\\主界面.jpg"));
		lblNewLabel.setBounds(0, 1, 447, 257);
		getContentPane().add(lblNewLabel);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("员工管理");
		menuBar.add(mnNewMenu);
		
		menuItem = new JMenuItem("工资管理");
		mnNewMenu.add(menuItem);
		menuItem.addActionListener(this);
		
		menuItem_1 = new JMenuItem("员工查询");
		mnNewMenu.add(menuItem_1);
		menuItem_1.addActionListener(this);
		
		
		menu = new JMenu("部门考勤");
		menuBar.add(menu);
		mntmNewMenuItem = new JMenuItem("考勤");
		menu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(this);
		
		mnNewMenu_1 = new JMenu("部门员工职位");
		menuBar.add(mnNewMenu_1);
		
		menuItem_4 = new JMenuItem("查询");
		mnNewMenu_1.add(menuItem_4);
		menuItem_4.addActionListener(this);
		
		menu_1 = new JMenu("信息管理");
		menuBar.add(menu_1);
		
		menuItem_2 = new JMenuItem("个人信息管理");
		menu_1.add(menuItem_2);
		menuItem_2.addActionListener(this);
		
		menuItem_3 = new JMenuItem("本部门信息统计");
		menu_1.add(menuItem_3);
		menuItem_3.addActionListener(this);
		
		menu_2 = new JMenu("部门功能");//根据部门不同，而改变,例：财务工资管理（全体）人事员工管理
		menuBar.add(menu_2);
	
		menuItem_6 = new JMenuItem("管理");
		menu_2.add(menuItem_6);
		menuItem_6.addActionListener(this);
		
		menu_3 = new JMenu("锁屏功能");
		menuBar.add(menu_3);		
		menuItem_5 = new JMenuItem("锁屏");
		menu_3.add(menuItem_5);
		menuItem_5.addActionListener(this);
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
		
		ManagerDaoMysqlImpl mysqlImpl=new ManagerDaoMysqlImpl();
		if(e.getSource()==menuItem) {
			log.setOperation("工资管理");
			lDao.insertLog(log);
			new wageOfMan(user);
		}
		if(e.getSource()==menuItem_1) {
			log.setOperation("员工查询");
			lDao.insertLog(log);
			new QuerySta(user);
		}
		if(e.getSource()==mntmNewMenuItem) {
			log.setOperation("部门考勤");
			lDao.insertLog(log);
			new attenOfDep();
		}
		if(e.getSource()==menuItem_4) {
			log.setOperation("部门员工职位查询");
			lDao.insertLog(log);
			new QueryStaPos(user);
		}
		if(e.getSource()==menuItem_2) {
			log.setOperation("个人信息管理");
			lDao.insertLog(log);
			new ManPeoInfo(user);
		}
		if(e.getSource()==menuItem_3) {
			log.setOperation("本部门信息统计");
			lDao.insertLog(log);
			new totaldep(user);
		}
		if(e.getSource()==menuItem_6) {
			if(mysqlImpl.findCW(user)) {
				log.setOperation("工资管理");
				lDao.insertLog(log);
				new ManSal();
			}
			if(mysqlImpl.findRS(user)) {
				log.setOperation("员工管理");
				lDao.insertLog(log);
				new ManSta();
			}
		}
		if(e.getSource()==menuItem_5) {
			log.setOperation("锁屏");
			lDao.insertLog(log);
			new lock();
		}
	}
}
