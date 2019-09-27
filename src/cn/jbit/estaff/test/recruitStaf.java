package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Staff;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class recruitStaf extends JFrame implements ActionListener{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JButton button;
	private JTextArea textArea;
	private JLabel lblNewLabel_1;
	public recruitStaf() {
		setTitle("员工管理：招聘员工");
		this.setSize(466, 333);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray); 
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		getContentPane().setLayout(null);
		JLabel label = new JLabel("编号：");
		label.setBounds(10, 10, 54, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(95, 7, 66, 21);
		getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("工号：");
		label_1.setBounds(10, 38, 54, 15);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 35, 66, 21);
		getContentPane().add(textField_1);
		
		JLabel label_2 = new JLabel("姓名：");
		label_2.setBounds(10, 69, 54, 15);
		getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 66, 66, 21);
		getContentPane().add(textField_2);
		
		JLabel label_3 = new JLabel("性别：");
		label_3.setBounds(10, 100, 54, 15);
		getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(95, 104, 66, 21);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel = new JLabel("年龄：");
		lblNewLabel.setBounds(10, 138, 54, 15);
		getContentPane().add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(95, 135, 66, 21);
		getContentPane().add(textField_4);
		
		JLabel label_4 = new JLabel("所属部门：");
		label_4.setBounds(10, 173, 75, 15);
		getContentPane().add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(95, 170, 66, 21);
		getContentPane().add(textField_5);
		
		JLabel label_5 = new JLabel("职位：");
		label_5.setBounds(10, 208, 54, 15);
		getContentPane().add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(95, 205, 66, 21);
		getContentPane().add(textField_6);
		
		JLabel label_6 = new JLabel("入职日期：");
		label_6.setBounds(10, 233, 66, 15);
		getContentPane().add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(95, 230, 66, 21);
		getContentPane().add(textField_7);
		
		JLabel label_7 = new JLabel("离职日期：");
		label_7.setBounds(211, 10, 66, 15);
		getContentPane().add(label_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(312, 7, 66, 21);
		getContentPane().add(textField_8);
		
		JLabel label_8 = new JLabel("工龄：");
		label_8.setBounds(211, 38, 54, 15);
		getContentPane().add(label_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(312, 35, 66, 21);
		getContentPane().add(textField_9);
		
		JLabel label_9 = new JLabel("证件号码：");
		label_9.setBounds(211, 69, 66, 15);
		getContentPane().add(label_9);
		
		textField_10 = new JTextField();
		textField_10.setBounds(312, 66, 66, 21);
		getContentPane().add(textField_10);
		
		JLabel label_10 = new JLabel("学历：");
		label_10.setBounds(211, 100, 54, 15);
		getContentPane().add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(312, 97, 66, 18);
		getContentPane().add(textField_11);
		
		JLabel label_11 = new JLabel("家庭住址：");
		label_11.setBounds(211, 138, 75, 15);
		getContentPane().add(label_11);
		
		textField_12 = new JTextField();
		textField_12.setBounds(312, 138, 122, 25);
		getContentPane().add(textField_12);
		
		JLabel label_12 = new JLabel("电话号码：");
		label_12.setBounds(211, 173, 66, 15);
		getContentPane().add(label_12);
		
		textField_13 = new JTextField();
		textField_13.setBounds(312, 173, 66, 21);
		getContentPane().add(textField_13);
		
		JLabel label_13 = new JLabel("邮箱：");
		label_13.setBounds(211, 208, 54, 15);
		getContentPane().add(label_13);
		
		textField_14 = new JTextField();
		textField_14.setBounds(312, 205, 66, 21);
		getContentPane().add(textField_14);
		
		JLabel label_14 = new JLabel("个人照片：");
		label_14.setBounds(211, 233, 66, 15);
		getContentPane().add(label_14);
		
		textArea = new JTextArea();
		textArea.setBounds(311, 233, 107, 43);
		getContentPane().add(textArea);
		
		button = new JButton("添加");
		button.setBounds(150, 271, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("G:\\员工管理图片\\12.jpg"));
		lblNewLabel_1.setBounds(-9, 1, 467, 379);
		getContentPane().add(lblNewLabel_1);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			Staff staff=new Staff();
			staff.setId(textField.getText());
			staff.setJobOfNumber(textField_1.getText());
			staff.setName(textField_2.getText());
			staff.setSex(textField_3.getText());
			Integer age=Integer.parseInt(textField_4.getText());
			staff.setAge(age);
			staff.setDepartment(textField_5.getText());
			staff.setPosition(textField_6.getText());
			staff.setDateOnBoard(textField_7.getText());
			staff.setDepartureDate(textField_8.getText());
			Integer workingYears=Integer.parseInt(textField_9.getText());
			staff.setWorkingYears(workingYears);
			staff.setIdNumber(textField_10.getText());
			staff.setEducationBackground(textField_11.getText());
			staff.setFamilyAddress(textField_12.getText());
			staff.setPhoneNumber(textField_13.getText());
			staff.setMailBox(textField_14.getText());
			staff.setPicture(textArea.getText()); 
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			sDaoImpl.insertSta(staff);
		}
	}
}
