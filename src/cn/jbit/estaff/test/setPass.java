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

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class setPass extends JFrame implements ActionListener{

	private JTextField textField;
	private JButton button;
	private JLabel lblNewLabel;

	public setPass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		setTitle("信息管理：密码设置");
		this.setSize(295, 296);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray); 
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		getContentPane().setLayout(null);
		JLabel label = new JLabel("新密码：");
		label.setBounds(47, 69, 96, 20);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(153, 69, 96, 20);
		getContentPane().add(textField);
		
		button = new JButton("重置");
		button.setBounds(87, 165, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\员工管理图片\\13.jfif"));
		lblNewLabel.setBounds(2, 2, 277, 254);
		getContentPane().add(lblNewLabel);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			String pass=textField.getText();
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			sDaoImpl.Pass(pass);
		}
	}

}
