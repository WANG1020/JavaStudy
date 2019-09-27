package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.jbit.estaff.daoimpl.ManagerDaoMysqlImpl;
import cn.jbit.estaff.daoimpl.StaffDaoMysqlImpl;
import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Salary;
import cn.jbit.estaff.entity.Staff;
import cn.jbit.estaff.entity.User;
import java.awt.Toolkit;

public class QuerySta extends JFrame implements ActionListener{
	private User user;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	
	private JScrollPane JSP;
	private DefaultTableModel DTM;
	private JTable	jTable_PetList ;
	private Object tableTitle[] = {"编号","工号","姓名","性别","年龄","所属部门","职位","入职日期","离职日期","工龄","证件号码","学历","家庭住址","电话号码","邮箱","照片"};
	
	public QuerySta(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		this.user=user;
		setTitle("员工查询");
		this.setSize(909, 706);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray); 
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		Object tableText[][] = new Object[0][0];
		DTM=new DefaultTableModel(tableText,tableTitle);
		jTable_PetList=new JTable(DTM);
		JScrollPane JSP= new JScrollPane(jTable_PetList);
		JSP.setBounds(10, 5, 873, 632);
		getContentPane().add(JSP);
		JSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().setLayout(null);
		JLabel label = new JLabel("工号：");
		label.setBounds(58, 647, 54, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(122, 644, 106, 18);
		getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("姓名：");
		label_1.setBounds(272, 647, 54, 15);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(309, 644, 93, 18);
		getContentPane().add(textField_1);
		
		button = new JButton("查询");
		button.setBounds(440, 643, 93, 23);
		button.addActionListener(this);
		getContentPane().add(button);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ManagerDaoMysqlImpl mysqlImpl=new ManagerDaoMysqlImpl();
		String jnum=new String(textField.getText());
		String name=new String(textField_1.getText());
		Staff staff=new Staff();
		staff.setJobOfNumber(jnum);
		staff.setName(name);
		String jsString=user.getJobOfNumber();
		if(e.getSource()==button) {
			if(mysqlImpl.finSta(staff,jsString)) {
				List list = mysqlImpl.findStaInfor(staff);
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
				JOptionPane.showMessageDialog(textField, "请检查您输入的工号及姓名！","查询失败",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
