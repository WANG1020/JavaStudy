package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.jbit.estaff.dao.SuperManagerDao;
import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Sector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class updateSector extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton button;
	private JButton button_1;
	private JLabel label;
	public updateSector() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Java上课图片\\图标.jfif"));
		setTitle("部门管理：更改部门信息");
		this.setSize(465, 319);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
    public void init() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("输入部门名称：");
		lblNewLabel.setBackground(new Color(102, 204, 153));
		lblNewLabel.setBounds(38, 46, 174, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("输入修改后的部门管理员：");
		lblNewLabel_1.setBounds(38, 85, 174, 29);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("输入修改后的部门联系方式：");
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2.setBounds(38, 124, 174, 28);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(248, 50, 111, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(248, 95, 111, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(249, 134, 110, 18);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		button = new JButton("修改");
		button.setBounds(144, 228, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		button_1 = new JButton("返回");
		button_1.setBounds(341, 228, 93, 23);
		button_1.addActionListener(this);
		getContentPane().add(button_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("G:\\Java上课图片\\13.jfif"));
		label.setBounds(1, 1, 445, 281);
		getContentPane().add(label);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name=textField.getText();		
		Sector sector=new Sector(name);
		SuperManagerDaoImpl sManagerDao=new SuperManagerDaoImpl();
		if(e.getSource()==button) {
			if(sManagerDao.findexistSec(sector)) {
				sector.setDepartmentManager(textField_1.getText());
				sector.setContctInformation(textField_2.getText());
				sManagerDao.update(sector);
			}
			else {
				JOptionPane.showMessageDialog(textField, "没有此部门（请检查你输入的部门）","查询失败",JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource()==button_1) {
			this.dispose();
		}
	}
}
