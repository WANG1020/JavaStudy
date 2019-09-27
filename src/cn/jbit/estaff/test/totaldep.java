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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.jbit.estaff.daoimpl.ManagerDaoMysqlImpl;
import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Sector;
import cn.jbit.estaff.entity.User;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class totaldep extends JFrame implements ActionListener{

	private User user;
	private JButton button;
	
	private JScrollPane JSP;
	private DefaultTableModel DTM;
	private JTable	jTable_StaList ;
	private Object tableTitle[] = {"编号","工号","姓名","部门","职位"};
	private JLabel label;
	
	public totaldep(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		this.user=user;
		this.setSize(432, 367);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		getContentPane().setLayout(null);
		Object tableText[][] = new Object[0][0];
		DTM=new DefaultTableModel(tableText,tableTitle);
		jTable_StaList=new JTable(DTM);
		JScrollPane JSP= new JScrollPane(jTable_StaList);
		JSP.setBounds(0, 0, 416, 285);
		getContentPane().add(JSP);
		
		button = new JButton("查询");
		button.setBounds(172, 298, 93, 23);
		getContentPane().add(button);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("G:\\员工管理图片\\13.jfif"));
		label.setBounds(5, 285, 410, 44);
		getContentPane().add(label);
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ManagerDaoMysqlImpl mysqlImpl=new ManagerDaoMysqlImpl();
		String jobnum=user.getJobOfNumber();
		if(e.getSource()==button) {
			List list = mysqlImpl.totalDep(jobnum);
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
					if(key.equals("department")) {
						temp[3]=hm.get(key);
					}
					if(key.equals("position")) {
						temp[4]=hm.get(key);
					}
				}	
				tableText[i]=temp;
			}
			DTM.setDataVector(tableText,tableTitle);		    
		}
	}
}
