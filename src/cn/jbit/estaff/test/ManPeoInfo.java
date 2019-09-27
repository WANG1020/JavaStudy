package cn.jbit.estaff.test;

import java.awt.BorderLayout;
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

import cn.jbit.estaff.daoimpl.ManagerDaoMysqlImpl;
import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Staff;
import cn.jbit.estaff.entity.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class ManPeoInfo extends JFrame implements ActionListener{

	private User user;
	private JScrollPane JSP;
	private DefaultTableModel DTM;
	private JTable	jTable_StaList ;
	private Object tableTitle[] = {"编号","工号","姓名","性别","年龄","所属部门","职位","入职日期","离职日期","工龄","证件号码","学历","家庭住址","电话号码","邮箱","照片"};
	private JButton button;
	
	public ManPeoInfo(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		this.user=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(928,719);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		init();
	}
	public void init() {
		Object tableText[][] = new Object[0][0];
		DTM=new DefaultTableModel(tableText,tableTitle);
		jTable_StaList=new JTable(DTM);
		JScrollPane JSP= new JScrollPane(jTable_StaList);
		JSP.setBounds(10, 5, 873, 632);
		getContentPane().add(JSP);
		JSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		button = new JButton("查询");
		button.setBounds(392, 647, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ManagerDaoMysqlImpl mysqlImpl=new ManagerDaoMysqlImpl();
		Staff staff=new Staff();
		staff.setJobOfNumber(user.getJobOfNumber());
		String nString=user.getJobOfNumber();
		if(e.getSource()==button) {
			if(mysqlImpl.finSta(staff)) {
				List list = mysqlImpl.findStaInfor(nString);
				Object tableText[][] = new Object[list.size()][];
				for(int i=0;i<list.size();i++)
				{
					HashMap hm = (HashMap) list.get(i);
					Object temp[]=new Object[16];
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
						if(key.equals("sex")) {
							temp[3]=hm.get(key);
						}
						if(key.equals("age")) {
							temp[4]=hm.get(key);
						}
						if(key.equals("department")) {
							temp[5]=hm.get(key);
						}
						if(key.equals("position")) {
							temp[6]=hm.get(key);
						}
						if(key.equals("dateOnBoard")) {
							temp[7]=hm.get(key);
						}
						if(key.equals("departureDate")) {
							temp[8]=hm.get(key);
						}
						if(key.equals("workingYears")) {
							temp[9]=hm.get(key);
						}
						if(key.equals("idNumber")) {
							temp[10]=hm.get(key);
						}
						if(key.equals("educationBackground")) {
							temp[11]=hm.get(key);
						}
						if(key.equals("address")) {
							temp[12]=hm.get(key);
						}
						if(key.equals("honeNumber")) {
							temp[13]=hm.get(key);
						}
						if(key.equals("mailBox")) {
							temp[14]=hm.get(key);
						}
						if(key.equals("picture")) {
							temp[15]=hm.get(key);
						}
					}	
					tableText[i]=temp;
				}
				DTM.setDataVector(tableText,tableTitle);
			}
			else {
				JOptionPane.showMessageDialog(null, "没有此记录（请检查你的输入）","查询失败",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
