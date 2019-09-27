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
import cn.jbit.estaff.entity.Sector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class addSector extends JFrame implements ActionListener{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton button;
	private JTextArea textArea;
	private JLabel lblNewLabel_2;
	public addSector() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Java上课图片\\图标.jfif"));
		setTitle("部门管理：增加部门");
		this.setSize(465, 319);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("部门编号：");
		lblNewLabel.setBounds(60, 26, 69, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("部门名称：");
		lblNewLabel_1.setBounds(60, 61, 69, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("部门管理员：");
		label.setBounds(60, 93, 88, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("部门联系方式：");
		label_1.setBounds(60, 126, 88, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("部门简介：");
		label_2.setBounds(60, 164, 88, 15);
		getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(191, 28, 66, 21);
		getContentPane().add(textField);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 58, 66, 21);
		getContentPane().add(textField_1);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 90, 66, 21);
		getContentPane().add(textField_2);
	
		textField_3 = new JTextField();
		textField_3.setBounds(191, 123, 66, 21);
		getContentPane().add(textField_3);
		
		
		textArea = new JTextArea();
		textArea.setBounds(191, 160, 233, 46);
		getContentPane().add(textArea);
		
		button = new JButton("添加");
		button.setBounds(146, 228, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("G:\\Java上课图片\\13.jfif"));
		lblNewLabel_2.setBounds(2, 3, 439, 276);
		getContentPane().add(lblNewLabel_2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			Sector sec=new Sector();
			sec.setId(textField.getText());
			sec.setName(textField_1.getText());
			sec.setDepartmentManager(textField_2.getText());
			sec.setContctInformation(textField_3.getText());
			sec.setIntroduction(textArea.getText());
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			sDaoImpl.insert(sec);
		}
	}
}
