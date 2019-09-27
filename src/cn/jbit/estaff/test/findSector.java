package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.jbit.estaff.dao.SuperManagerDao;
import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Sector;
import java.awt.Toolkit;


public class findSector extends JFrame implements ActionListener {

	private JScrollPane JSP;
	private DefaultTableModel DTM;
	private JTable	jTable_SecList ;
	private Object tableTitle[] = {"编号","名称","部门管理员","部门联系方式","部门简介"};

	private JButton jButton_Query;
	private JLabel 	jLabel_Note_NAME;
	private JTextField	jTextField_NAME;
	private JButton button;

	public findSector(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Java上课图片\\图标.jfif"));
		setTitle("部门管理：查询部门信息");
		this.setSize(550,320);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		init();
	}
	private void init(){
		
		Object tableText[][] = new Object[0][0];
		DTM=new DefaultTableModel(tableText,tableTitle);
		jTable_SecList=new JTable(DTM);
		JScrollPane JSP= new JScrollPane(jTable_SecList);
		JSP.setBounds(3, 4, 525, 241);
		getContentPane().add(JSP);



		jLabel_Note_NAME = new JLabel();
		jLabel_Note_NAME.setText("部门名称");
		getContentPane().add(jLabel_Note_NAME);
		jLabel_Note_NAME.setBounds(10, 244, 150, 25);


		jTextField_NAME = new JTextField();
		jTextField_NAME.setBounds(85, 245, 60, 25);
		getContentPane().add(jTextField_NAME);


		jButton_Query = new JButton("查询");
		jButton_Query.addActionListener(this);
		jButton_Query.setBounds(170,241,245,25);
		getContentPane().add(jButton_Query);
		
		button = new JButton("返回");
		button.setBounds(441, 258, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
		String name=jTextField_NAME.getText();
		Sector sector=new Sector(name);
		if(e.getSource()==jButton_Query) {
		    if(sDaoImpl.findexistSec(sector)) {
		    	List list = sDaoImpl.findSector(sector);
				Object tableText[][] = new Object[list.size()][];
				for(int i=0;i<list.size();i++)
				{
					HashMap hm = (HashMap) list.get(i);
					Object temp[]=new Object[5];
					for(Object key:hm.keySet()){
						if(key.equals("serial_number")) {
							temp[0]=hm.get(key);
						}
						if(key.equals("name")) {
							temp[1]=hm.get(key);
						}
						if(key.equals("departmentManager")) {
							temp[2]=hm.get(key);
						}
						if(key.equals("contctInformation")) {
							temp[3]=hm.get(key);
						}
						if(key.equals("introduction")) {
							temp[4]=hm.get(key);
						}
					}	
					tableText[i]=temp;
				}
				DTM.setDataVector(tableText,tableTitle);
		    }
		    else {
		    	JOptionPane.showMessageDialog(jTextField_NAME, "没有此部门（请检查你输入的部门）","查询失败",JOptionPane.WARNING_MESSAGE);
		    }
		}
		if(e.getSource()==button) {
			this.dispose();
		}
	}
}
