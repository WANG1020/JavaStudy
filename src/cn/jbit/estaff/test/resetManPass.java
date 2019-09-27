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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class resetManPass extends JFrame implements ActionListener {

	private JTextField textField;
	private JButton button;
	private JLabel lblNewLabel;

	public resetManPass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		setTitle("管理员管理：重置密码");
		this.setSize(343, 288);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		getContentPane().setLayout(null);
		JLabel label = new JLabel("输入要重置密码的工号：");
		label.setBounds(35, 64, 159, 16);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(192, 63, 105, 17);
		getContentPane().add(textField);
		
		
		button = new JButton("重置");
		button.setBounds(111, 158, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\员工管理图片\\13.jpg"));
		lblNewLabel.setBounds(-151, 2, 509, 247);
		getContentPane().add(lblNewLabel);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			String jnum=textField.getText();
			User user=new User(jnum);
			UserDao userDao=new UserDaoImpl();
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			if(userDao.findManUser(user)) {
				sDaoImpl.resetAdmPass(user);
			}
			else {
				JOptionPane.showMessageDialog(textField, "查询系统，无此管理员","提示",JOptionPane.YES_OPTION);
			}
		}
	}
}
