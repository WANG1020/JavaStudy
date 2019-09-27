package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.jbit.estaff.dao.UserDao;
import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.daoimpl.UserDaoImpl;
import cn.jbit.estaff.entity.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateMan extends JFrame implements ActionListener{

	private JTextField textField;
	private JButton button;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	public updateMan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Java上课图片\\图标.jfif"));
		setTitle("管理员管理：增加管理员");
		this.setSize(364,320);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		init();
	}
	public void init() {
		this.setLayout(null);
		JLabel label = new JLabel("管理员姓名：");
		label.setBounds(10, 80, 101, 18);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(121, 77, 93, 21);
		getContentPane().add(textField);
		
		button = new JButton("增加");
		button.setBounds(56, 197, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("管理员工号：");
		lblNewLabel.setBounds(10, 53, 101, 17);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 50, 93, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\员工管理图片\\13.jpg"));
		lblNewLabel.setBounds(-120, 0, 477, 286);
		getContentPane().add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			String name=textField.getText();
			String jnum=textField_1.getText();
			User user=new User(jnum,name);
			UserDao userDao=new UserDaoImpl();
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			if(userDao.findStaUser(user)) {
				sDaoImpl.updateMan(user);
			}
			else {
				JOptionPane.showMessageDialog(textField, "查询系统，无此用户","提示",JOptionPane.YES_OPTION);
			}
		}
	}

}
