package swing.software1711;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class StudentInfo extends JFrame {
	private Student student;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	
	public StudentInfo(Student student) {
		this.student=student;
		this.setTitle("学生信息管理");
		this.setSize(800,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.BLUE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		this.setLayout(null);
		JLabel jLabel1=new JLabel("学  号:");
		jLabel1.setBounds(150, 100, 50, 30);
    	jLabel1.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel1);
		textField1=new JTextField(student.getNo());
		textField1.setBounds(250,100,150,30);
		textField1.setEditable(false);
    	Font font1=new Font("黑体", 1,15);
    	textField1.setFont(font1);
    	textField1.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textField1);
    	
    	JLabel jLabel2=new JLabel("姓  名:");
		jLabel2.setBounds(150, 150, 50, 30);
    	jLabel2.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel2);
		textField2=new JTextField(student.getName());
		textField2.setBounds(250,150,150,30);
	    textField2.setEditable(false);
		textField2.setFont(font1);
		textField2.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textField2);
    	
    	JLabel jLabel3=new JLabel("Java成绩:");
		jLabel3.setBounds(130, 200, 100, 30);
		jLabel3.setHorizontalAlignment(JTextField.CENTER);
		this.add(jLabel3);
		textField3=new JTextField(String.valueOf(student.getJava()));
		textField3.setBounds(250,200,150,30);
		textField3.setFont(font1);
		textField3.setHorizontalAlignment(JTextField.CENTER);
    	this.add(textField3);
	}
	public static void main(String[] args) {
  		// TODO Auto-generated method stub
		Student student=new Student("1702753115","王喜", "123456",90);
      	new StudentInfo(student);
  	}
	

}
