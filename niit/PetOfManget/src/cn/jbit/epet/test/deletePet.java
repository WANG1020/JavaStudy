package cn.jbit.epet.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import cn.jbit.epet.dao.petDao;
import cn.jbit.epet.daoimpl.PetDaoMySqlImpl;
import cn.jbit.epet.entity.Master;
import cn.jbit.epet.entity.Pet;
public class deletePet extends JFrame implements ActionListener {
	private Pet pet;
	
	private JTextField textFieldOfName;
	
	private JButton jButtonOfDelete;
	
	public deletePet(){
		this.setTitle("删除宠物");
		this.setSize(400,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		this.setLayout(null);
		
		JLabel jLabel=new JLabel("欢迎进入宠物管理系统",JLabel.CENTER);
		jLabel.setBounds(100, 10, 150, 30);
		jLabel.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel);
		
		Font font=new Font("黑体", 1,15);
    	
    	JLabel jLabel3=new JLabel("name:");
    	jLabel3.setBounds(100, 150, 60, 30);
    	jLabel3.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel3);
		textFieldOfName=new JTextField();
		textFieldOfName.setBounds(190,150,80,30);
		textFieldOfName.setFont(font);
		textFieldOfName.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textFieldOfName);

		jButtonOfDelete=new JButton("删除");
		jButtonOfDelete.setBounds(150,250,90,30);
		jButtonOfDelete.addActionListener(this);
    	this.add(jButtonOfDelete);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jButtonOfDelete) {
			String name=textFieldOfName.getText();
			pet=new Pet(name);
			petDao pDao=new PetDaoMySqlImpl();
			pDao.del(pet);
		}
	}
}
