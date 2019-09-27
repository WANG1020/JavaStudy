package cn.jbit.estaff.test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.jbit.estaff.dao.LogDao;
import cn.jbit.estaff.dao.ManagerDao;
import cn.jbit.estaff.dao.SuperManagerDao;
import cn.jbit.estaff.dao.UserDao;
import cn.jbit.estaff.daoimpl.LogDaoimpl;
import cn.jbit.estaff.daoimpl.SuperManagerDaoImpl;
import cn.jbit.estaff.daoimpl.UserDaoImpl;
import cn.jbit.estaff.entity.Log;
import cn.jbit.estaff.entity.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
/**
 * -大二第一学期实训
 * --企业员工管理系统
 * @author asus
 *
 */
public class Login extends JFrame implements ActionListener {

	private User user;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton buttonofLogin;
	private JComboBox comboBox;

	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Java上课图片\\图标.jfif"));
		user=new User();
		setTitle("企业员工管理系统：用户登录");
		this.setSize(465, 319);
		this.setVisible(true);//设置可见
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.lightGray);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void  init() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("员工工号：");
		label.setBounds(84, 65, 71, 25);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("登录密码：");
		label_1.setBounds(84, 100, 71, 23);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(180, 67, 108, 23);
		getContentPane().add(textField);
		//textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 101, 108, 22);
		getContentPane().add(passwordField);
		
		JLabel label_2 = new JLabel("员工职务：");
		label_2.setBounds(84, 136, 71, 25);
		getContentPane().add(label_2);
		
	
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"超级管理员", "普通管理员", "员工"}));
		comboBox.setBounds(180, 133, 108, 31);
		getContentPane().add(comboBox);
		
		buttonofLogin = new JButton("登录");
		buttonofLogin.setBounds(162, 202, 93, 23);
		buttonofLogin.addActionListener(this);
		getContentPane().add(buttonofLogin);
		
		JLabel lblNewLabel = new JLabel("欢迎进入员工管理系统");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 424, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel label_3 = new JLabel("有任何问题请电联：188888");
		label_3.setBounds(254, 255, 185, 15);
		getContentPane().add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("G:\\员工管理图片\\登录界面.png"));
		lblNewLabel_1.setBounds(10, 0, 439, 270);
		getContentPane().add(lblNewLabel_1);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setJobOfNumber(textField.getText());
		log.setOperation("登录");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.setOperationTime(df.format(new Date()));
		LogDaoimpl lDao=new LogDaoimpl();
		lDao.insertLog(log);
		
		if(e.getSource()==buttonofLogin) {
			String id=textField.getText();
			String password=new String(passwordField.getPassword());
			user.setJobOfNumber(id);
			user.setPassword(password);
			String poString=(String)comboBox.getSelectedItem();
			user.setPost(poString);
			UserDao userDao=new UserDaoImpl();
			
			if(userDao.CheckUser(user)){
				this.dispose();
				if(user.getPost()=="超级管理员") {
					new SuManager(user);
				}
				else if(comboBox.getSelectedItem()=="普通管理员") {
					new PManager(user);
				}
				else if(comboBox.getSelectedItem()=="员工") {
					new sStaff(user);
				}
			}
			else {
				JOptionPane.showMessageDialog(textField, "请检查您的密码和账号信息","登录失败",JOptionPane.YES_OPTION);
			}
		}
	}
}
