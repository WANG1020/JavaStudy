package swing.software1711;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.channels.NonWritableChannelException;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.util.Scanner;
import Software.niit.Bank;

public class Singin extends JFrame implements ActionListener{
	
    private JTextField textFiled;
    private JPasswordField password;
    private JButton btnSingin;
    
    public  Singin() {
		// TODO Auto-generated constructor stub
    	this.setTitle("中国建设银行:登录界面");
		this.setSize(800,500);
		
		/*ImageIcon background = new ImageIcon("D:\\MyFile\\background.jpg");
		// 把背景图片显示在一个标签里面
		JLabel label = new JLabel(background);
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// 把背景图片添加到分层窗格的最底层作为背景
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));*/
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLUE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
	}
    public  void init() {
		// TODO Auto-generated method stub
    	this.setLayout(null);
    	
    	JLabel jLabel1=new JLabel("用户名:");
    	jLabel1.setBounds(180, 100, 50, 30);
    	jLabel1.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel1);
    	textFiled=new JTextField();
    	textFiled.setBounds(250,100,150,30);
    	Font font1=new Font("黑体", 1,15);
    	textFiled.setFont(font1);
    	textFiled.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textFiled);
    	
    	JLabel jLabel2=new JLabel("密码:");
    	jLabel2.setBounds(180, 150, 50, 30);
    	jLabel2.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel2);
    	password=new JPasswordField();
    	password.setBounds(250,150,150,30);
    	password.setEchoChar('*');
    	password.setHorizontalAlignment(JTextField.CENTER);
    	this.add(password);
    	
    	btnSingin=new JButton("登录");
    	btnSingin.setBounds(270,350,90,30);
    	btnSingin.addActionListener(this);
    	this.add(btnSingin);
    	
	}
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	new Singin();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=textFiled.getText();
		String pass=new String(password.getPassword());
		BankCard bankCard=new BankCard(id, pass, 1500);
		if(e.getSource()==btnSingin) {
			if(id.equals("王喜")&&pass.equals("123456")){
			   ATM atm=new ATM(bankCard);
			}
			else {
				JOptionPane.showMessageDialog(null, "无此用户!");
			}
		   }		
	}

	
}
