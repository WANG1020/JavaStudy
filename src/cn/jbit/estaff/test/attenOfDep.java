package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Attendance;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class attenOfDep extends JFrame implements ActionListener{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	
	public attenOfDep() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		setTitle("部门考勤");
		this.setSize(304, 320);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		getContentPane().setLayout(null);
		JLabel label = new JLabel("编号：");
		label.setBounds(43, 40, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("工号：");
		label_1.setBounds(43, 78, 54, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("姓名：");
		label_2.setBounds(43, 116, 54, 15);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("工作日：");
		label_3.setBounds(43, 160, 54, 15);
		getContentPane().add(label_3);
		
		textField = new JTextField();
		textField.setBounds(122, 37, 109, 21);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 75, 109, 18);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(122, 113, 109, 18);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(122, 157, 109, 21);
		getContentPane().add(textField_3);
		
		btnNewButton = new JButton("添加考勤");
		btnNewButton.setBounds(92, 235, 93, 23);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\员工管理图片\\13.2.jpg"));
		lblNewLabel.setBounds(1, 1, 287, 282);
		getContentPane().add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnNewButton) {
			Attendance attendance=new Attendance();
			attendance.setId(textField.getText());
			attendance.setJobOfNumber(textField_1.getText());
			attendance.setName(textField_2.getText());
			attendance.setWorkday(textField_3.getText());
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			sDaoImpl.insertWorkAtten(attendance);
		}
	}

}
