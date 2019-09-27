package swing.software1711;

import java.util.Scanner;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.omg.CORBA.PRIVATE_MEMBER;

import Software.niit.Bank;

public class ATM extends JFrame implements ActionListener{
	
	private JButton btnCreateofFind;//查询
	private JButton btnCreateofReturn;//退卡
	private JButton btnCreateofDraw;//取钱
	private JButton btnCreateofSave;//存款
	private JLabel sJLabel;
	private BankCard idBankCard;
	
	public ATM(BankCard idBankCard) {//生成ATM
		this.idBankCard=idBankCard;
		this.setTitle("中国建设银行");//设置标题
		this.setSize(800,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLUE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		this.setLayout(null);
		sJLabel=new JLabel("欢迎进入中国银行");//设置标签
		sJLabel.setBounds(250,100,300,200);
		sJLabel.setHorizontalAlignment(JTextField.CENTER);
		this.add(sJLabel);
		
		btnCreateofFind =new JButton("查询");
		btnCreateofFind.setBounds(700,90,90,30);//设置尺寸
		btnCreateofFind.addActionListener(this);
		this.add(btnCreateofFind);
		
		btnCreateofReturn=new JButton("退卡");
		btnCreateofReturn.setBounds(50,400,90,30);
		btnCreateofReturn.addActionListener(this);
		this.add(btnCreateofReturn);
		
		btnCreateofDraw=new JButton("取款");
		btnCreateofDraw.setBounds(700,180,90,30);
		btnCreateofDraw.addActionListener(this);
		this.add(btnCreateofDraw);
		
		btnCreateofSave=new JButton("存款");
		btnCreateofSave.setBounds(700,270,90,30);
		btnCreateofSave.addActionListener(this);
		this.add(btnCreateofSave);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id="王喜";
		String password="123456";
		int money=1500;
		BankCard bankCard=new BankCard(id, password, money);
		new ATM(bankCard);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnCreateofReturn)
		{
			JOptionPane.showMessageDialog(null, "欢迎下次进入");
			this.dispose();
		}
		if(e.getSource()==btnCreateofFind) {
			JOptionPane.showMessageDialog(null, "余额为"+idBankCard.getMoney());
		}
		if(e.getSource()==btnCreateofDraw) {
			Drawwith drawwith=new Drawwith(idBankCard);
		}
		if(e.getSource()==btnCreateofSave) {
			SaveWith savewith=new SaveWith(idBankCard);
		}
	}

}
