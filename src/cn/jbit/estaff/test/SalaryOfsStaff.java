package cn.jbit.estaff.test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import cn.jbit.estaff.daoimpl.StaffDaoMysqlImpl;
import cn.jbit.estaff.entity.Salary;
import cn.jbit.estaff.entity.User;
public class SalaryOfsStaff extends JFrame {
	private User user;
	private Salary sal = new Salary();
	private DefaultTableModel DTM;
	private JTable	jTable_SalaryList ;
	private Object tableTitle[] = {"基本薪资","加班薪资","补贴","全勤奖","罚款","总计","发放日期"};
	
	public SalaryOfsStaff(User user) {
		this.user = user;
		setTitle("普通员工工资查询");
		this.setSize(600, 380);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}

	public void init(){ 
		Object tableText[][] = new Object[0][0];
		DTM=new DefaultTableModel(tableText,tableTitle);
		jTable_SalaryList=new JTable(DTM);
		JScrollPane JSP= new JScrollPane(jTable_SalaryList);
		JSP.setBounds(10, 20, 495, 210);
		getContentPane().add(JSP);
		
		StaffDaoMysqlImpl sDao=new StaffDaoMysqlImpl();
		String jobnumber=user.getJobOfNumber();
		sal.setJobOfNumber(jobnumber);
		if(sDao.findStaSal(sal) != null){
			List list = sDao.findStasl(sal);
			Object tableText1[][] = new Object[list.size()][];
			for(int i=0;i<list.size();i++)
			{
				HashMap gz = (HashMap) list.get(i);
				Object temp[]=new Object[7];
				for(Object key:gz.keySet()){
					if(key.equals("baseSalary")) {
						temp[0]=gz.get(key);
					}
					if(key.equals("overtimeSslary")) {
						temp[1]=gz.get(key);
					}
					if(key.equals("subsidy")) {
						temp[2]=gz.get(key);
					}
					if(key.equals("attendnceBonus")) {
						temp[3]=gz.get(key);
					}
					if(key.equals("penalty")) {
						temp[4]=gz.get(key);
					}
					if(key.equals("total")) {
						temp[5]=gz.get(key);
					}
					if(key.equals("issueDate")) {
						temp[6]=gz.get(key);
					}
				}	
				tableText1[i]=temp;	
			}
			DTM.setDataVector(tableText1,tableTitle);
		}
		
	 }
}
