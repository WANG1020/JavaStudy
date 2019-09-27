package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.WindowConstants;
import javax.accessibility.Accessible;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class resetStaPass extends JFrame implements ActionListener{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton button;
	private JLabel label_3;
	
	public resetStaPass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		setTitle("员工管理：密码重置");
		this.setSize(310, 337);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray); 
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		getContentPane().setLayout(null);
		JLabel label = new JLabel("工号：");
		label.setBounds(31, 62, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setBounds(31, 112, 54, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("姓名：");
		label_2.setBounds(31, 87, 54, 15);
		getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(95, 59, 93, 21);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 84, 93, 21);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 109, 93, 21);
		getContentPane().add(textField_2);
		
		button = new JButton("重置");
		button.setBounds(51, 197, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("G:\\员工管理图片\\13.jfif"));
		label_3.setBounds(2, 1, 292, 297);
		getContentPane().add(label_3);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			String jnum=textField.getText();
			String name=textField_1.getText();
			String pass=textField_2.getText();
			User user=new User();
			user.setJobOfNumber(jnum);
			user.setName(name);
			user.setPassword(pass);
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			UserDao uDao=new UserDaoImpl();
			if(uDao.findStaUser(user)) {
				sDaoImpl.resetStafPass(user);
			}
			else {
				JOptionPane.showMessageDialog(textField, "查询系统，无此员工","提示",JOptionPane.YES_OPTION);
			}
		}
	}

}
