package cn.jbit.estaff.test;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.jbit.estaff.daoimpl.StaffDaoMysqlImpl;
import cn.jbit.estaff.entity.Salary;
import cn.jbit.estaff.entity.Staff;
import cn.jbit.estaff.entity.User;

public class InforOfsStaff  extends JFrame implements ActionListener{
	 private Staff sSt;
	 private JScrollPane JSP;
	 private DefaultTableModel DTM;
	 private JTable	jTable_imforList ;
	 private Object tableTitle[] = {"姓名","性别","部门","职位","电话","邮箱"};
     
	 private JButton jButton_Query;
	 private JLabel 	jLabel_Note_NAME;
	 private JTextField	jTextField_num;
	 private JButton button;
	 
	  public InforOfsStaff() {
		  setTitle("员工信息查询");
		  this.setSize(600,350);
		  this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		  getContentPane().setLayout(null);
		  this.setLocationRelativeTo(null);
		  this.setVisible(true);
		  init();	
	  }
		private void init(){
			
			Object tableText[][] = new Object[0][0];
			DTM=new DefaultTableModel(tableText,tableTitle);
			jTable_imforList=new JTable(DTM);
			JScrollPane JSP= new JScrollPane(jTable_imforList);
			JSP.setBounds(10, 20, 495, 210);
			getContentPane().add(JSP);



			jLabel_Note_NAME = new JLabel();
			jLabel_Note_NAME.setText("工号:");
			getContentPane().add(jLabel_Note_NAME);
			jLabel_Note_NAME.setBounds(10, 230, 60, 25);


			jTextField_num = new JTextField();
			jTextField_num.setBounds(70, 230, 100, 25);
			getContentPane().add(jTextField_num);


			jButton_Query = new JButton("查询");
			jButton_Query.addActionListener(this);
			jButton_Query.setBounds(170,230,245,25);
			getContentPane().add(jButton_Query);
			
			button = new JButton("返回");
			button.setBounds(441, 258, 93, 23);
			button.addActionListener(this);
			getContentPane().add(button);

		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		StaffDaoMysqlImpl sDao=new StaffDaoMysqlImpl(); 
		String num=jTextField_num.getText();
		sSt=new Staff();
		sSt.setJobOfNumber(num);
		Salary sal=new Salary();
		if(e.getSource()==jButton_Query) {
		    if(sDao.finSta(sSt)) {
		    	List list = sDao.findStaInfor(sSt);
				Object tableText[][] = new Object[list.size()][];
				for(int i=0;i<list.size();i++)
				{
					HashMap hm = (HashMap) list.get(i);
					Object temp[]=new Object[6];
					for(Object key:hm.keySet()){
						if(key.equals("name")) {
							temp[0]=hm.get(key);
						}
						if(key.equals("sex")) {
							temp[1]=hm.get(key);
						}
						if(key.equals("department")) {
							temp[2]=hm.get(key);
						}
						if(key.equals("position")) {
							temp[3]=hm.get(key);
						}
						if(key.equals("honeNumber")) {
							temp[4]=hm.get(key);
						}
						if(key.equals("mailBox")) {
							temp[5]=hm.get(key);
						}
					}	
					tableText[i]=temp;
				}
				DTM.setDataVector(tableText,tableTitle);
		    }
		    else {
				JOptionPane.showMessageDialog(jTextField_num, "没有此人（请检查你输入的工号）","查询失败",JOptionPane.YES_OPTION);
		    }
		}
		if(e.getSource()==button) {
			this.dispose();
		}
	}



}
