package Software.niit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class Singin extends JFrame implements ActionListener{

	private JTextField textFiled;
    private JPasswordField password;
    private JButton btnSingin;
    private JComboBox jComboBox;
    public  Singin() {
		// TODO Auto-generated constructor stub
    	this.setTitle("员工工资管理系统");
		this.setSize(800,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLUE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
    	
    	JLabel jLabel3=new JLabel("人员类型:");
    	jLabel3.setBounds(180, 200, 50, 30);
    	jLabel3.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel3);
		Object []teStrings= {"员工","经理","财务"};
		
		jComboBox=new JComboBox(teStrings);
    	this.add(jComboBox);
    	
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
		if(e.getSource()==btnSingin) {
			
		}
	}

}
