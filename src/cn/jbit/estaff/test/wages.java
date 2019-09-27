package cn.jbit.estaff.test;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.entity.Salary;

public class wages extends JFrame implements ActionListener {
	private JLabel jLabelOfJnum;
	private JTextField jTextFieldOfJnum;
	private JLabel jLabel;
	private JTextField jTextField;
	private JButton jButton;
	private JLabel lblNewLabel_1;
	
	public wages(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\员工管理图片\\图标.jfif"));
		setTitle("员工管理：工资");
		this.setSize(304, 320);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		this.setLayout(null);
		jLabelOfJnum = new JLabel("工号：");
		jLabelOfJnum.setBounds(43, 40, 54, 15);
		this.add(jLabelOfJnum);
		
		jLabel = new JLabel("基本工资：");
		jLabel.setBounds(43, 78, 84, 15);
		this.add(jLabel);
		
		jTextFieldOfJnum = new JTextField();
		jTextFieldOfJnum.setBounds(122, 37, 96, 21);
		this.add(jTextFieldOfJnum);
		
		jTextField = new JTextField();
		jTextField.setBounds(122, 75, 96, 21);
		this.add(jTextField);
		
		jButton = new JButton("设置");
		jButton.setBounds(92, 235, 93, 23);
		jButton.addActionListener(this);
		this.add(jButton);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("G:\\员工管理图片\\13.jfif"));
		lblNewLabel_1.setBounds(0, 0, 288, 282);
		getContentPane().add(lblNewLabel_1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jButton) {
			Salary salary=new Salary();
			salary.setJobOfNumber(jTextFieldOfJnum.getText());
			salary.setBaseSalary(jTextField.getText());
			SuperManagerDaoImpl sDaoImpl=new SuperManagerDaoImpl();
			if(sDaoImpl.findStaSal(salary)) {
				sDaoImpl.insertOfSalary(salary);
			}
			else{
				JOptionPane.showMessageDialog(jTextFieldOfJnum, "没有此记录（请检查你的输入,或者先插入一条记录）","查询失败",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
