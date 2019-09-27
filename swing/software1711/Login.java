package swing.software1711;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.xml.bind.ParseConversionEvent;

public class Login extends JFrame implements ActionListener {
	private JTextField textFiled;
//	private JTextField text
    private JPasswordField password;
    private JButton btnSingin;
    
    public Login(){
		// TODO Auto-generated constructor stub
    	this.setTitle("学生管理系统");
		this.setSize(800,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLUE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
    public void init(){
    	this.setLayout(null);
    	
    	textFiled=new JTextField();
    	JLabel jLabel1=new JLabel("用户名: ");
    	jLabel1.setBounds(190, 100, 50, 30);
    	jLabel1.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel1);
    	textFiled=new JTextField();
    	textFiled.setBounds(250,100,150,30);
    	Font font1=new Font("黑体", 1,15);
    	textFiled.setFont(font1);
    	textFiled.setHorizontalAlignment(JTextField.CENTER);
    	textFiled.addActionListener(this);
    	this.add(textFiled);
    	
    	JLabel jLabel2=new JLabel("密码：");
    	jLabel2.setBounds(190, 150, 50, 30);
    	jLabel2.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel2);
    	password=new JPasswordField();
    	password.setBounds(250,150,150,30);
    	password.setEchoChar('*');
    	password.setHorizontalAlignment(JTextField.CENTER);
    	password.addActionListener(this);
    	this.add(password);
    	
    	btnSingin=new JButton("登录");
    	btnSingin.setBounds(270,350,90,30);
    	btnSingin.addActionListener(this);
    	this.add(btnSingin);
    }
    public static void main(String[] args) {
  		// TODO Auto-generated method stub
      	new Login();
  	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 String no=textFiled.getText();
		 String pass=new String(password.getPassword());
		 Student student=new Student(no,"王喜", pass,90);  
		if(e.getSource()==btnSingin) {
			if(no.equals("1702753115")&&pass.equals("123456")) {
				new StudentInfo(student);;
			}
			else {
				JOptionPane.showMessageDialog(null, "无此用户!");
			}
		}
	}

}
