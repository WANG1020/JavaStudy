package cn.jbit.epet.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import cn.jbit.epet.dao.petDao;
import cn.jbit.epet.daoimpl.PetDaoMySqlImpl;
import cn.jbit.epet.entity.Pet;

public class updatePet extends JFrame implements ActionListener {
	private Pet pet;
	private JTextField textFieldOfId;
	private JTextField textFieldOfName;
	
	private JButton jButtonOfUpdate;
	
	public updatePet(){
		this.setTitle("更改宠物信息");
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
    	
		JLabel jLabel1=new JLabel("id:");
		jLabel1.setBounds(20, 100, 60, 30);
    	jLabel1.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel1);
		textFieldOfId=new JTextField();
		textFieldOfId.setBounds(160,100,80,30);
		Font font=new Font("黑体", 1,15);
		textFieldOfId.setFont(font);
		textFieldOfId.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textFieldOfId);
    	
    	JLabel jLabel3=new JLabel("更改后的name:");
    	jLabel3.setBounds(40, 150, 100, 30);
    	jLabel3.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel3);
		textFieldOfName=new JTextField();
		textFieldOfName.setBounds(160,150,80,30);
		textFieldOfName.setFont(font);
		textFieldOfName.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textFieldOfName);

		jButtonOfUpdate=new JButton("更改");
		jButtonOfUpdate.setBounds(140,250,90,30);
		jButtonOfUpdate.addActionListener(this);
    	this.add(jButtonOfUpdate);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jButtonOfUpdate) {
			int id=Integer.parseInt(textFieldOfId.getText());
			String name=textFieldOfName.getText();
			pet=new Pet(id,name);
			petDao pDao=new PetDaoMySqlImpl();
			pDao.update(pet);
		}
	}
}
