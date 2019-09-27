package cn.jbit.epet.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import cn.jbit.epet.dao.masterDao;
import cn.jbit.epet.daoimpl.MasterDaoMySqlMpl;
import cn.jbit.epet.entity.Master;


public class Login extends JFrame implements ActionListener {
	private Master master;
	private JTextField textFiled;
	private JPasswordField password;
	private JButton btnSinginOfLogin;
	private JButton btnSinginOfEnroll;
	public Login() {
		master=new Master();
		this.setTitle("宠物管理系统");
		this.setSize(800,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		this.setLayout(null);
		
		JLabel jLabel=new JLabel("欢迎来到宠物管理系统",JLabel.CENTER);
		jLabel.setBounds(290, 10, 150, 30);
		jLabel.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel);
		
		textFiled=new JTextField();//实例化textFiled
		JLabel jLabel1=new JLabel("用户名:");//标签，起提示作用
		jLabel1.setBounds(230, 150, 60, 30);
    	jLabel1.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel1);
    	textFiled=new JTextField();
    	textFiled.setBounds(300,150,150,30);
    	Font font1=new Font("黑体", 1,15);
    	textFiled.setFont(font1);
    	textFiled.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textFiled);
    	
    	JLabel jLabel2=new JLabel("密码：");
    	jLabel2.setBounds(230, 200, 50, 30);
    	jLabel2.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel2);
    	password=new JPasswordField();
    	password.setBounds(300,200,150,30);
    	password.setEchoChar('*');
    	password.setHorizontalAlignment(JTextField.CENTER);
    	this.add(password);
    	
    	btnSinginOfLogin=new JButton("登录");//如果master里面有就登录
    	btnSinginOfLogin.setBounds(230,350,90,30);
    	btnSinginOfLogin.addActionListener(this);
    	this.add(btnSinginOfLogin);
    	
    	btnSinginOfEnroll=new JButton("注册");//增加一条master记录
    	btnSinginOfEnroll.setBounds(400,350,90,30);
    	btnSinginOfEnroll.addActionListener(this);
    	this.add(btnSinginOfEnroll);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Login();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnSinginOfLogin) {
			String name=textFiled.getText();
			String pass=new String(password.getPassword());
			master.setName(name);
			master.setPassword(pass);
			masterDao masterDao=new MasterDaoMySqlMpl();
			if(masterDao.findMaster(master)) {
				this.dispose();
				new mainMenu(master);
			}
			else {
				JOptionPane.showMessageDialog(textFiled, "请检查您的密码和账号信息","登录失败",JOptionPane.YES_OPTION);
			}
		}
		if(e.getSource()==btnSinginOfEnroll) {//没写完
			//new一个注册界面
            JOptionPane.showMessageDialog(textFiled, "不支持此功能","内侧版本",JOptionPane.YES_OPTION);
		}
	}

}
