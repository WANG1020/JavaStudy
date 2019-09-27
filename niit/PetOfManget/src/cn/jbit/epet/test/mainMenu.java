package cn.jbit.epet.test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import cn.jbit.epet.entity.Master;

public class mainMenu extends JFrame implements ActionListener{
	private Master master;
	private JMenuBar menuBar1;//一个主菜单
	
	private JMenu baseManagerMenu;//menuBar1的两个分菜单
	private JMenu searchMenu;
	
	private JMenuItem baseItem1;//分菜单baseManagerMenu的子菜单（购买，删除，更改）
	private JMenuItem baseItem2;
	private JMenuItem baseItem3;
	
	private JMenuItem searchwithName;//分菜单searchMenu的子菜单
	private JMenuItem searchwithId;
	public mainMenu( Master master){
		this.master=master;
		init();
		setTitle("宠物管理");
		setSize(800,500);
		setVisible(true);
		setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	public void init() {
		this.setLayout(null);
		
		menuBar1=new JMenuBar();
		
		baseManagerMenu=new JMenu("宠物管理");
		baseManagerMenu.setBounds(10, 10, 90, 60);
		baseManagerMenu.addActionListener(this);
		menuBar1.add(baseManagerMenu);
		
		searchMenu=new JMenu("宠物查询");
		searchMenu.setBounds(120, 10, 90, 60);
		searchMenu.addActionListener(this);
		menuBar1.add(searchMenu);
		
		baseItem1=new JMenuItem("购买宠物");
		baseItem1.addActionListener(this);
		baseItem2=new JMenuItem("删除宠物");
		baseItem2.addActionListener(this);
		baseItem3=new JMenuItem("更改宠物信息");
		baseItem3.addActionListener(this);
		baseManagerMenu.add(baseItem1);
		baseManagerMenu.add(baseItem2);
		baseManagerMenu.add(baseItem3);
		
		searchwithId=new JMenuItem("按id查询");
		searchwithId.addActionListener(this);
		searchwithName=new JMenuItem("按姓名查询");
		searchwithName.addActionListener(this);
		searchMenu.add(searchwithId);
		searchMenu.add(searchwithName);
		
		this.setJMenuBar(menuBar1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==baseItem1) {
			new addPet();
		}
		if(e.getSource()==baseItem2) {
			new deletePet();
		}
		if(e.getSource()==baseItem3) {
			new updatePet();
		}
		if(e.getSource()==searchwithId) {
			new searchById();
		}
		if(e.getSource()==searchwithName) {
			new searchByName();
		}
	}
}
