package swing.software1711;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.InputMismatchException;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Software.niit.TestStudent1;
/*windowsadapter*/
public class JudgeOfPrime extends JFrame implements ActionListener,WindowListener,Runnable  {
	private JLabel promptOfJLabel;
	private JButton btnOfJudge;
	private static JTextField textFieldofNumber;
	private String name;
	
	public JudgeOfPrime(String name) {
		this.name=name;
	}
	public JudgeOfPrime() {
		this.setTitle("判断素数");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.blue);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Init();
	}
	public void Init() {
		this.setLayout(null);
		
		promptOfJLabel=new JLabel("输入整数:");
		promptOfJLabel.setBounds(150, 100, 80, 30);
		promptOfJLabel.setHorizontalAlignment(JTextField.CENTER);
		this.add(promptOfJLabel);
		
		textFieldofNumber=new JTextField();
		textFieldofNumber.setBounds(240, 100, 90, 30);
		textFieldofNumber.setHorizontalAlignment(JTextField.CENTER);
		this.add(textFieldofNumber);
		
		btnOfJudge=new JButton("判断");
		btnOfJudge.setBounds(200, 200, 60, 40);
		btnOfJudge.addActionListener(this);
		this.add(btnOfJudge);
		
		this.addWindowListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JudgeOfPrime();
	}
	public  boolean judge(int number) {
		boolean flag=true;
		if(number<2) {
			return false;
		}
		for(int i=2;i<number;i++) {
			if(number%i==0) {
				flag=false;
				break;
			}
		}
		return flag;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnOfJudge) {
			if(textFieldofNumber.equals("")||textFieldofNumber.getText().length()==0) {
				JOptionPane.showMessageDialog(textFieldofNumber, "请输入一个整数","警告",JOptionPane.YES_OPTION);
			}
			else {
				int number=Integer.parseInt(textFieldofNumber.getText());
				if(judge(number)) {
					JOptionPane.showMessageDialog(null, number+"是质数！！！");
				}
				else {
					JOptionPane.showMessageDialog(null, number+"不是质数！！！");
				}
			}
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		FileWriter fw=null;
		BufferedWriter bw=null;
			//创建一个FileWrite对象
		try {
			int number=Integer.parseInt(textFieldofNumber.getText());
			fw=new FileWriter("D:\\MyFile\\result.txt",true);
			bw=new BufferedWriter(fw);
			bw.write(textFieldofNumber.getText());
			if(judge(number)) {
				bw.write("s");
			}
			else {
				bw.write("f");
			}
			bw.newLine();
			bw.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("写入成功"); 
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		new Thread(this).start();
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
