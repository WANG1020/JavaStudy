package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.SignIn;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class addAtten extends JFrame implements ActionListener{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel label_4;
	private JButton button;
	
	public addAtten() {
		setTitle("员工管理：添加考勤");
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		this.setSize(450, 300);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		getContentPane().setLayout(null);
		JLabel label = new JLabel("编号：");
		label.setBounds(58, 44, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("工号：");
		label_1.setBounds(58, 84, 54, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("姓名：");
		label_2.setBounds(58, 126, 54, 15);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("签到次数：");
		label_3.setBounds(58, 169, 66, 15);
		getContentPane().add(label_3);
		
		JLabel lblNewLabel = new JLabel("签到时间：");
		lblNewLabel.setBounds(58, 209, 66, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(124, 42, 83, 18);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 81, 83, 21);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 124, 83, 18);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(124, 167, 83, 18);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(124, 206, 83, 21);
		getContentPane().add(textField_4);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("G:\\员工管理图片\\15.jpg"));
		label_4.setBounds(229, 0, 205, 261);
		getContentPane().add(label_4);
		
		button = new JButton("添加");
		button.setBounds(68, 238, 93, 23);
		getContentPane().add(button);
		button.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			SignIn signIn=new SignIn();
			signIn.setId(textField.getText());
			signIn.setJobOfNumber(textField_1.getText());
			signIn.setName(textField_2.getText());
			signIn.setSignedNumber(textField_3.getText());
			signIn.setSignenTime(textField_4.getText());
			sDaoImpl.insertOfSignIn(signIn);
		}
	}
}
