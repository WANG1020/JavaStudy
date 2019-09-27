package cn.jbit.estaff.test;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.jbit.estaff.dao.SuperManagerDao;
import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Sector;

public class delSector extends JFrame implements ActionListener{
	private JLabel jLabel;
	private JTextField jTextField;
	private JButton jButton;
	private JButton jButton1;
	private JLabel label;
	public  delSector() {
		// TODO Auto-generated constructor stub
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Java上课图片\\图标.jfif"));
		setTitle("部门管理：删除部门");
		this.setSize(300,320);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		init();
	}
	public void init() {
		this.setLayout(null);
		
		jLabel=new JLabel();
		jLabel.setText("部门名称");
		jLabel.setBounds(10, 80, 80, 25);
		this.add(jLabel);
		
		jTextField=new JTextField();
		jTextField.setBounds(100, 80, 80, 25);
		this.add(jTextField);
		
		jButton=new JButton("删除");
		jButton.addActionListener(this);
		jButton.setBounds(40,230,65,25);
		this.add(jButton);
		
		jButton1=new JButton("返回");
		jButton1.addActionListener(this);
		jButton1.setBounds(120,230,65,25);
		this.add(jButton1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("G:\\Java上课图片\\13.jfif"));
		label.setBounds(1, 1, 445, 281);
		getContentPane().add(label);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jButton) {
			String name=jTextField.getText();
			Sector sector=new Sector(name);
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			if(sDaoImpl.findexistSec(sector)) {
				sDaoImpl.delete(sector);
			}
			else {
				JOptionPane.showMessageDialog(jTextField, "没有此部门（请检查你输入的部门）","删除失败",JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource()==jButton1) {
			this.dispose();
		}
	}
	
}
