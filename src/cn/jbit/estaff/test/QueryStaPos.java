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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.jbit.estaff.daoimpl.ManagerDaoMysqlImpl;
import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Sector;
import cn.jbit.estaff.entity.User;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class QueryStaPos extends JFrame implements ActionListener{

	private User user;
	private JScrollPane JSP;
	private DefaultTableModel DTM;
	private JTable	jTable_PetList ;
	private Object tableTitle[] = {"编号","工号","姓名","职位","身份"};
	
	private JButton button;
	private JLabel lblNewLabel;
	
	public QueryStaPos(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		this.user=user;
		setTitle("数据统计");
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
		jTable_PetList=new JTable(DTM);
		JScrollPane JSP= new JScrollPane(jTable_PetList);
		JSP.setBounds(0, 0, 416, 285);
		getContentPane().add(JSP);
	
		
		button = new JButton("查询");
		button.setBackground(new Color(0, 0, 51));
		button.setBounds(174, 295, 93, 23);
		getContentPane().add(button);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\员工管理图片\\13.jpg"));
		lblNewLabel.setBounds(1, 286, 415, 41);
		getContentPane().add(lblNewLabel);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ManagerDaoMysqlImpl mysqlImpl=new ManagerDaoMysqlImpl();
		String jobnum=user.getJobOfNumber();
		if(e.getSource()==button) {
			List list = mysqlImpl.total(jobnum);
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
					if(key.equals("position")) {
						temp[3]=hm.get(key);
					}
					if(key.equals("identity")) {
						temp[4]=hm.get(key);
					}
				}	
				tableText[i]=temp;
			}
			DTM.setDataVector(tableText,tableTitle);
		    
		}
	}

}
