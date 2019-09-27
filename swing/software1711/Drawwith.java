package swing.software1711;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Drawwith extends JFrame implements ActionListener{
	private BankCard bankCard;
	private JButton  btnCreateOfBack;//返回
	private JButton btnDrawOf1000;//取1000元
	private JButton btnDrawOf500;
	private JButton btnDrawOf100;
	
	
	public Drawwith(BankCard bankCard) {
		this.bankCard=bankCard;
		this.setTitle("中国建设银行:取款");
		this.setSize(800,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLUE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		this.setLayout(null);
		
		btnCreateOfBack=new JButton("返回");
		btnCreateOfBack.setBounds(50,400,90,30);
		btnCreateOfBack.addActionListener(this);
		this.add(btnCreateOfBack);
		
		btnDrawOf1000=new JButton("1000");
		btnDrawOf1000.setBounds(700,90,90,30);//设置尺寸
		btnDrawOf1000.addActionListener(this);
		this.add(btnDrawOf1000 );
		
		btnDrawOf500=new JButton("500");
		btnDrawOf500.setBounds(700,180,90,30);//设置尺寸
		btnDrawOf500.addActionListener(this);
		this.add(btnDrawOf500);
		
		btnDrawOf100=new JButton("100");
		btnDrawOf100.setBounds(700,270,90,30);//设置尺寸
		btnDrawOf100.addActionListener(this);
		this.add(btnDrawOf100);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnCreateOfBack) {
			this.dispose();
		}
		if(e.getSource()==btnDrawOf1000) {
			int money=bankCard.getMoney();
			if(bankCard.getMoney()>1000) {
				money-=1000;
				bankCard.setMoney(money);
				JOptionPane.showMessageDialog(null, "取款成功!");
			}
			else {
				JOptionPane.showMessageDialog(null, "金额不足!");
			}
		}
        if(e.getSource()==btnDrawOf500) {
        	int money=bankCard.getMoney();
			if(bankCard.getMoney()>500) {
				money-=500;
				bankCard.setMoney(money);
				JOptionPane.showMessageDialog(null, "取款成功!");
			}
			else {
				JOptionPane.showMessageDialog(null, "金额不足!");
			}
		}
        if(e.getSource()==btnDrawOf100) {
        	int money=bankCard.getMoney();
			if(bankCard.getMoney()>100) {
				money-=100;
				bankCard.setMoney(money);
				JOptionPane.showMessageDialog(null, "取款成功!");
			}
			else {
				JOptionPane.showMessageDialog(null, "金额不足!");
			}
			
		}
	}
}
