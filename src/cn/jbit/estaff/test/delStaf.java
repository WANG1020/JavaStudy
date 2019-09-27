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
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class delStaf extends JFrame implements ActionListener {

	
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	private JLabel lblNewLabel_1;

	public delStaf() {
		setTitle("员工管理：解雇员工");
		this.setSize(308, 320);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("工号：");
		lblNewLabel.setBounds(30, 49, 54, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(95, 46, 86, 21);
		getContentPane().add(textField);
		
		JLabel label = new JLabel("姓名：");
		label.setBounds(30, 104, 54, 15);
		getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 101, 86, 21);
		getContentPane().add(textField_1);
		
		button = new JButton("解雇");
		button.setBounds(86, 202, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("G:\\员工管理图片\\13.jfif"));
		lblNewLabel_1.setBounds(0, 0, 288, 282);
		getContentPane().add(lblNewLabel_1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			String name=textField_1.getText();
			String jnum=textField.getText();
			Staff staff=new Staff();
			staff.setJobOfNumber(jnum);
			staff.setName(name);
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			sDaoImpl.delSta(staff);
		}
	}

}
