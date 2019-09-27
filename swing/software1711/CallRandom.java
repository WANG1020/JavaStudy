package swing.software1711;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.jar.Attributes.Name;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CallRandom extends JFrame implements ActionListener{
//定义一个文本框textFieldName，JTextField是文本框类
	private JTextField textFieldName;
	private JButton btnCreate;
	public CallRandom()
    {
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.pink);;
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("随机点名");
		this.setVisible(true);
		init();
	}
	private void init(){
		//给对象的属性（变量）赋初值
		this.setLayout(null);//窗体的布局
		textFieldName=new JTextField();
		textFieldName.setBounds(300, 150, 200, 150);
		Font font=new Font("黑体", 1, 36);
		textFieldName.setFont(font);
		textFieldName.setHorizontalAlignment(JTextField.CENTER);
		this.add(textFieldName);
		btnCreate=new JButton("开始");
		btnCreate.setBounds(350, 350, 100, 100);
		btnCreate.addActionListener(this);
		this.add(btnCreate);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CallRandom callRandom=new CallRandom();
		
		
	}
	//事件处理程序
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==btnCreate)
		{
			/*int number=(int)(Math.random()*37+1);
			textFieldName.setText(Integer.toString(number));*/
			Random rand=new Random();
			int number=rand.nextInt(38);
			textFieldName.setText( new swing.software1711.Name().getName(number));
			/*char randNumber = (char)(rand.nextInt('z'-'a'+1)+'a');
			textFieldName.setText(Character.toString(randNumber));//输出字符
*/		}
	}
}
