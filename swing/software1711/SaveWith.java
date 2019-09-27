package swing.software1711;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class SaveWith extends JFrame implements ActionListener {
	private BankCard bankCard;
	private JButton  btnCreateOfBack;//返回
	private JButton btnSaveOf1000;
	private JButton btnSaveOf500;
	private JButton btnSaveOf100;
	
	public SaveWith(BankCard bankCard) {
		this.bankCard=bankCard;
		this.setTitle("中国建设银行:存款");
		this.setSize(800,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.CYAN);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
        this.setLayout(null);
		
		btnCreateOfBack=new JButton("返回");
		btnCreateOfBack.setBounds(50,400,90,30);
		btnCreateOfBack.addActionListener(this);
		this.add(btnCreateOfBack);
		
		btnSaveOf1000=new JButton("1000");
		btnSaveOf1000.setBounds(700,90,90,30);//设置尺寸
		btnSaveOf1000.addActionListener(this);
		this.add(btnSaveOf1000 );
		
		btnSaveOf500=new JButton("500");
		btnSaveOf500.setBounds(700,180,90,30);//设置尺寸
		btnSaveOf500.addActionListener(this);
		this.add(btnSaveOf500);
		
		btnSaveOf100=new JButton("100");
		btnSaveOf100.setBounds(700,270,90,30);//设置尺寸
		btnSaveOf100.addActionListener(this);
		this.add(btnSaveOf100);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnCreateOfBack) {
			this.dispose();
		}
		if(e.getSource()==btnSaveOf1000) {
			int money=bankCard.getMoney();
			money+=1000;
			bankCard.setMoney(money);
			JOptionPane.showMessageDialog(null, "存款成功!");
		}
        if(e.getSource()==btnSaveOf500) {
        	int money=bankCard.getMoney();
			money+=500;
			bankCard.setMoney(money);
			JOptionPane.showMessageDialog(null, "存款成功!");
		}
        if(e.getSource()==btnSaveOf100) {
        	int money=bankCard.getMoney();
			money+=100;
			bankCard.setMoney(money);
			JOptionPane.showMessageDialog(null, "存款成功!");
		}
	}
}
