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

public class addPet extends JFrame implements ActionListener {
	private Pet pet;
	private JTextField textFieldOfId;
	private JTextField textFieldOfMasterId;
	private JTextField textFieldOfName;
	private JTextField textFieldOfHealth;
	private JTextField textFieldOfLove;
	private JTextField textFieldOfStrain;
	
	private JButton jButtonOfInsert;
	
	public addPet(){
		this.setTitle("购买宠物");
		this.setSize(800,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		this.setLayout(null);
		
		JLabel jLabel=new JLabel("欢迎进入宠物管理系统",JLabel.CENTER);
		jLabel.setBounds(190, 10, 150, 30);
		jLabel.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel);
		
		JLabel jLabel1=new JLabel("id:");
		jLabel1.setBounds(20, 100, 60, 30);
    	jLabel1.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel1);
		textFieldOfId=new JTextField();
		textFieldOfId.setBounds(100,100,80,30);
		Font font=new Font("黑体", 1,15);
		textFieldOfId.setFont(font);
		textFieldOfId.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textFieldOfId);
    	
    	JLabel jLabel2=new JLabel("master_id:");
		jLabel2.setBounds(200, 100, 80, 30);
    	jLabel2.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel2);
		textFieldOfMasterId=new JTextField();
		textFieldOfMasterId.setBounds(290,100,80,30);
		textFieldOfMasterId.setFont(font);
		textFieldOfMasterId.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textFieldOfMasterId);
    	
    	JLabel jLabel3=new JLabel("name:");
    	jLabel3.setBounds(20, 150, 60, 30);
    	jLabel3.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel3);
		textFieldOfName=new JTextField();
		textFieldOfName.setBounds(100,150,80,30);
		textFieldOfName.setFont(font);
		textFieldOfName.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textFieldOfName);
    	
    	JLabel jLabel4=new JLabel("Health:");
    	jLabel4.setBounds(200, 150, 60, 30);
    	jLabel4.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel4);
		textFieldOfHealth=new JTextField();
		textFieldOfHealth.setBounds(290,150,80,30);
		textFieldOfHealth.setFont(font);
		textFieldOfHealth.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textFieldOfHealth);
    	
    	JLabel jLabel5=new JLabel("love:");
    	jLabel5.setBounds(20, 200, 60, 30);
    	jLabel5.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel5);
		textFieldOfLove=new JTextField();
		textFieldOfLove.setBounds(100,200,80,30);
		textFieldOfLove.setFont(font);
		textFieldOfLove.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textFieldOfLove);
    	
    	JLabel jLabel6=new JLabel("strain:");
    	jLabel6.setBounds(200,200, 60, 30);
    	jLabel6.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel6);
		textFieldOfStrain=new JTextField();
		textFieldOfStrain.setBounds(290,200,80,30);
		textFieldOfStrain.setFont(font);
		textFieldOfStrain.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textFieldOfStrain);
    	
    	jButtonOfInsert=new JButton("插入");
    	jButtonOfInsert.setBounds(400,250,90,30);
    	jButtonOfInsert.addActionListener(this);
    	this.add(jButtonOfInsert);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jButtonOfInsert) {
			int id=Integer.parseInt(textFieldOfId.getText());
			int masterId=Integer.parseInt(textFieldOfMasterId.getText());
			String name=textFieldOfName.getText();
			int health=Integer.parseInt(textFieldOfHealth.getText());
			int love=Integer.parseInt(textFieldOfLove.getText());
			String strain=textFieldOfStrain.getText();
			pet=new Pet(id,masterId,name,health,love,strain);
			petDao pDao=new PetDaoMySqlImpl();
			pDao.insert(pet);
		}
	}
}
