package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Attendance;
import cn.jbit.estaff.entity.SignIn;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Toolkit;

public class attendance extends JFrame implements ActionListener{

	private JScrollPane JSP;
	private DefaultTableModel DTM;
	private JTable	jTable_PetList ;
	private Object tableTitle[] = {"编号","工号","姓名","签到次数","签到时间"};

	private JButton btnNewButton;
	private JLabel label;
	private JTextField textField;
	
	public attendance() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		setTitle("员工管理：考勤");
		this.setSize(493, 337);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		this.setLayout(null);
		Object tableText[][] = new Object[0][0];
		DTM=new DefaultTableModel(tableText,tableTitle);
		jTable_PetList=new JTable(DTM);
		JScrollPane JSP= new JScrollPane(jTable_PetList);
		JSP.setBounds(10, 20, 457, 233);
		getContentPane().add(JSP);
		
		btnNewButton = new JButton("查询");
		btnNewButton.setBounds(307, 263, 93, 23);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
		
		label = new JLabel("工号");
		label.setBounds(23, 267, 54, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(68, 267, 100, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnNewButton) {
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			SignIn signIn=new SignIn();
			signIn.setJobOfNumber(textField.getText());
			List list=sDaoImpl.findSing(signIn);
			Object tableText[][] = new Object[list.size()][];
			for(int i=0;i<list.size();i++)
			{
				HashMap hm = (HashMap) list.get(i);
				Object temp[]=new Object[5];
				for(Object key:hm.keySet()){
					if(key.equals("serial_number")) {
						temp[0]=hm.get(key);
					}
					if(key.equals("job_number")) {
						temp[1]=hm.get(key);
					}
					if(key.equals("name")) {
						temp[2]=hm.get(key);
					}
					if(key.equals("signedNumber")) {
						temp[3]=hm.get(key);
					}
					if(key.equals("signenTime")) {
						temp[4]=hm.get(key);
					}
				}	
				tableText[i]=temp;
			}
			DTM.setDataVector(tableText,tableTitle);
	    }
	}
}
