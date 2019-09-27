package swing.software1711;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Game extends JFrame implements ActionListener {
	private Person person;
	private Computer computer;
	private JTextField jpersonOfpunch,jComputerOfpunch;
	private JLabel jLabelOfPerson,jLabelOfComputer;
	private JButton jButtonOfCount,jButton;
	private ButtonGroup buttonGroup;
	private JRadioButton jRadioButton1,jRadioButton2,jRadioButton3;
	public Game(Person person,Computer computer) {
		// TODO Auto-generated constructor stub
		this.person=person;
		this.computer=computer;
		this.setTitle("猜拳开始");
		this.setSize(800,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.cyan);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		init();
	}
	public void init() {
		 this.setLayout(null);
		 jLabelOfPerson=new JLabel(person.getName()+"：出拳");
		 jLabelOfPerson.setBounds(200, 100, 150, 30);
		 jLabelOfPerson.setHorizontalAlignment(JTextField.CENTER);
		 this.add(jLabelOfPerson);
		 jpersonOfpunch=new JTextField();
		 jpersonOfpunch.setEditable(false);
		 jpersonOfpunch.setBounds(360, 100, 150, 30);
		 Font font=new Font("黑体", 1,15);
		 jpersonOfpunch.setFont(font);
		 jpersonOfpunch.setHorizontalAlignment(JTextField.CENTER);
	     this.add(jpersonOfpunch);
	     
	     jRadioButton1=new JRadioButton("石头",true);
	     jRadioButton1.setBounds(300, 150, 90, 30);
	     jRadioButton1.setIcon(new ImageIcon("src\\swing\\software1711\\shito.JPG"));
	     jRadioButton1.addActionListener(this);
	     jRadioButton2=new JRadioButton("剪刀");
	     jRadioButton2.setBounds(400, 150, 90, 30);
	     jRadioButton2.setIcon(new ImageIcon("src\\swing\\software1711\\jiandao.JPG"));
	     jRadioButton2.addActionListener(this);
	     jRadioButton3=new JRadioButton("布");
	     jRadioButton3.setBounds(500, 150, 90, 30);
	     jRadioButton3.setIcon(new ImageIcon("src\\swing\\software1711\\bu.JPG"));
	     jRadioButton3.addActionListener(this);
	     buttonGroup=new ButtonGroup();
	     buttonGroup.add(jRadioButton1);
	     buttonGroup.add(jRadioButton2);
	     buttonGroup.add(jRadioButton3);
	     this.add(jRadioButton1);
	     this.add(jRadioButton2);
	     this.add(jRadioButton3);
	     
	     jLabelOfComputer=new JLabel(computer.getName()+"：出拳");
	     jLabelOfComputer.setBounds(200, 200, 150, 30);
	     jLabelOfComputer.setHorizontalAlignment(JTextField.CENTER);
	     this.add(jLabelOfComputer);
	     jComputerOfpunch=new JTextField();
	     jComputerOfpunch.setEditable(false);
	     jComputerOfpunch.setBounds(360, 200, 150, 30);
		 jComputerOfpunch.setFont(font);
		 jComputerOfpunch.setHorizontalAlignment(JTextField.CENTER);
	     this.add(jComputerOfpunch);
	     
	     jButtonOfCount=new JButton("结算");
	     jButtonOfCount.setBounds(360, 250, 150, 30);
	     jButtonOfCount.setFont(font);
	     jButtonOfCount.addActionListener(this);
	     jButtonOfCount.setHorizontalAlignment(JTextField.CENTER);
	     this.add(jButtonOfCount);
	     
	     jButton=new JButton("返回");
	     jButton.setBounds(50,400,90,30);
	     jButton.addActionListener(this);
		 this.add(jButton);
	     
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jButton) {
			this.dispose();
		}
		if(e.getSource()==jRadioButton1) {
			String string=person.setPunch("石头");
			jpersonOfpunch.setText(string);
		    jComputerOfpunch.setText(computer.setPunch()); 
		    String punch=jComputerOfpunch.getText();
		    if(punch.equals("剪刀")) {
		    	JOptionPane.showMessageDialog(null, "你赢了");
		    	int integral=person.getIntegral();
		    	integral++;
		    	person.setIntegral(integral);
		    }
		    if(punch.equals("石头")) {
		    	JOptionPane.showMessageDialog(null, "平局");
		    }
		    if(punch.equals("布")) {
		    	JOptionPane.showMessageDialog(null, "你输了");
		    	int integral=computer.getIntegral();
		    	integral++;
		    	computer.setIntegral(integral);
		    }
		}
		if(e.getSource()==jRadioButton2) {
			String string=person.setPunch("剪刀");
			jpersonOfpunch.setText(string);
			jComputerOfpunch.setText(computer.setPunch());
			String punch=jComputerOfpunch.getText();
		    if(punch.equals("剪刀")) {
		    	JOptionPane.showMessageDialog(null, "平局");
		    }
		    if(punch.equals("石头")) {
		    	JOptionPane.showMessageDialog(null, "你输了");
		    	int integral=computer.getIntegral();
		    	integral++;
		    	computer.setIntegral(integral);
		    }
		    if(punch.equals("布")) {
		    	JOptionPane.showMessageDialog(null, "你赢了");
		    	int integral=person.getIntegral();
		    	integral++;
		    	person.setIntegral(integral);
		    }
		}
		if(e.getSource()==jRadioButton3) {
			String string=person.setPunch("布");
			jpersonOfpunch.setText(string);
			jComputerOfpunch.setText(computer.setPunch());
			String punch=jComputerOfpunch.getText();
		    if(punch.equals("剪刀")) {
		    	JOptionPane.showMessageDialog(null, "你输了");
		    	int integral=computer.getIntegral();
		    	integral++;
		    	computer.setIntegral(integral);
		    }
		    if(punch.equals("石头")) {
		    	JOptionPane.showMessageDialog(null, "你赢了");
		    	int integral=person.getIntegral();
		    	integral++;
		    	person.setIntegral(integral);
		    }
		    if(punch.equals("布")) {
		    	JOptionPane.showMessageDialog(null, "平局");
		    }
		}
		if(e.getSource()==jButtonOfCount) {
			if(person.getIntegral()>computer.getIntegral()) {
				JOptionPane.showMessageDialog(null, person.getName()+"的积分为："+person.getIntegral()
				+"\n"+computer.getName()+"的积分为："+computer.getIntegral()+"\n"+"恭喜：你赢了");
			}
			if(person.getIntegral()==computer.getIntegral()) {
				JOptionPane.showMessageDialog(null,  person.getName()+"的积分为："+person.getIntegral()
				+"\n"+computer.getName()+"的积分为："+computer.getIntegral()+"\n"+"结局：平局");
			}
			if(person.getIntegral()<computer.getIntegral()) {
				JOptionPane.showMessageDialog(null, person.getName()+"的积分为："+person.getIntegral()
				+"\n"+computer.getName()+"的积分为："+computer.getIntegral()+"\n"+ "抱歉：你输了");
			}
		}
	}
	
	
}
