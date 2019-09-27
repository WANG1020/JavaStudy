package cn.jbit.epet.test;

import cn.jbit.epet.daoimpl.PetDaoMySqlImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class searchById extends JFrame implements ActionListener {

	private JScrollPane JSP;
	private DefaultTableModel DTM;
	private JTable	jTable_PetList ;
	private Object tableTitle[] = {"ID","masterID","昵称","健康值","亲密度","品种"};

	private JButton jButton_Query;
	private JLabel 	jLabel_Note_ID;
	private JTextField	jTextField_ID;

	public searchById(){
		this.setSize(550,320);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		init();
	}
	private void init(){
		Object tableText[][] = new Object[0][0];
		DTM=new DefaultTableModel(tableText,tableTitle);
		jTable_PetList=new JTable(DTM);
		JScrollPane JSP= new JScrollPane(jTable_PetList);
		JSP.setBounds(10, 20, 495, 210);
		this.add(JSP);



		jLabel_Note_ID = new JLabel();
		jLabel_Note_ID.setText("按照ID查询");
		this.add(jLabel_Note_ID);
		jLabel_Note_ID.setBounds(10, 230, 150, 25);


		jTextField_ID = new JTextField();
		jTextField_ID.setBounds(170, 230, 60, 25);
		this.add(jTextField_ID);


		jButton_Query = new JButton("查询");
		jButton_Query.addActionListener(this);
		jButton_Query.setBounds(260,230,245,25);
		this.add(jButton_Query);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PetDaoMySqlImpl pdss = new PetDaoMySqlImpl();
		int petID;
		if(e.getSource() == jButton_Query){
			petID=Integer.parseInt(jTextField_ID.getText());
			List list = pdss.findById(petID);
			Object tableText[][] = new Object[list.size()][];
			for(int i=0;i<list.size();i++)
			{
				HashMap hm = (HashMap) list.get(i);
				Object temp[]=new Object[6];
				for(Object key:hm.keySet())
				{
					if(key.equals("id"))
					{
						temp[0]=hm.get(key);
					}
					if(key.equals("master_id"))
					{
						temp[1]=hm.get(key);
					}
					if(key.equals("name"))
					{
						temp[2]=hm.get(key);
					}
					if(key.equals("health"))
					{
						temp[3]=hm.get(key);
					}
					if(key.equals("love"))
					{
						temp[4]=hm.get(key);
					}
					if(key.equals("strain"))
					{
						temp[5]=hm.get(key);
					}
				}
				tableText[i]=temp;
			}
			DTM.setDataVector(tableText,tableTitle);

		}
	}
}
