package cn.jbit.estaff.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.jbit.estaff.daoimpl.ManagerDaoMysqlImpl;
import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Salary;
import cn.jbit.estaff.entity.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class wageOfMan extends JFrame implements ActionListener{
	private User user;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel lblNewLabel_2;

	public wageOfMan(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		setTitle("员工管理：工资管理");
		this.user=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(463, 342);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("工号：");
		lblNewLabel.setBounds(28, 75, 56, 23);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(94, 75, 109, 23);
		getContentPane().add(textField);
		
		JLabel label = new JLabel("基本薪资：");
		label.setBounds(28, 157, 78, 15);
		getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 154, 66, 21);
		getContentPane().add(textField_1);
		
		JLabel label_1 = new JLabel("加班薪资：");
		label_1.setBounds(29, 200, 66, 15);
		getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 197, 66, 21);
		getContentPane().add(textField_2);
		
		JLabel label_2 = new JLabel("补贴：");
		label_2.setBounds(241, 48, 54, 15);
		getContentPane().add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(317, 45, 66, 21);
		getContentPane().add(textField_3);
		
		JLabel label_3 = new JLabel("全勤奖：");
		label_3.setBounds(241, 83, 54, 15);
		getContentPane().add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(317, 76, 66, 21);
		getContentPane().add(textField_4);
		
		JLabel label_4 = new JLabel("罚款：");
		label_4.setBounds(241, 111, 54, 15);
		getContentPane().add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(317, 107, 66, 21);
		getContentPane().add(textField_5);
		
		JLabel label_5 = new JLabel("总计：");
		label_5.setBounds(241, 157, 54, 15);
		getContentPane().add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(317, 154, 66, 21);
		getContentPane().add(textField_6);
		
		JLabel label_6 = new JLabel("发放日期：");
		label_6.setBounds(241, 196, 66, 23);
		getContentPane().add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(317, 197, 85, 18);
		getContentPane().add(textField_7);
		
		btnNewButton = new JButton("修改");
		btnNewButton.setBounds(183, 270, 93, 23);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("编号：");
		lblNewLabel_1.setBounds(28, 43, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField_8 = new JTextField();
		textField_8.setBounds(94, 44, 93, 23);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_7 = new JLabel("姓名：");
		label_7.setBounds(28, 111, 54, 15);
		getContentPane().add(label_7);
		
		textField_9 = new JTextField();
		textField_9.setBounds(94, 108, 66, 21);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("G:\\员工管理图片\\13.jpg"));
		lblNewLabel_2.setBounds(1, 2, 447, 301);
		getContentPane().add(lblNewLabel_2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnNewButton) {
			Salary salary=new Salary();
			salary.setId(textField_8.getText());
			salary.setJobOfNumber(textField.getText());
			salary.setName(textField_9.getText());
			salary.setBaseSalary(textField_1.getText());
			salary.setOvertimeSslary(textField_2.getText());
			salary.setSubsidy(textField_3.getText());
			salary.setAttendnceBonus(textField_4.getText());
			salary.setPenalty(textField_5.getText());
			salary.setTotal(textField_6.getText());
			salary.setIssueDate(textField_7.getText());
			ManagerDaoMysqlImpl mysqlImpl=new ManagerDaoMysqlImpl();
			mysqlImpl.insertOfSalary(salary);
			
		}
	}
}
