package swing.software1711;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.omg.CORBA.PRIVATE_MEMBER;

public class SinginofGame extends JFrame implements ActionListener {
    private JLabel jLabel1,jLabel2,jLabel3,jLabel4;
    private JButton btnOfSingin;
    private JTextField jNameOfPerson;
    private JComboBox jNameOfComputer;
    private String []name= {"刘备","孙权","曹操"};

    public SinginofGame() {
        this.setTitle("准备阶段");
        this.setSize(800,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.blue);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        init();
    }
    public void init() {
        this.setLayout(null);

        jLabel1=new JLabel("欢迎进入猜拳大比拼");
        jLabel1.setBounds(300, 100, 150, 30);
        jLabel1.setHorizontalAlignment(JTextField.CENTER);
        this.add(jLabel1);

        jLabel2=new JLabel("猜拳 开始");
        jLabel2.setBounds(300, 150, 150, 30);
        jLabel2.setHorizontalAlignment(JTextField.CENTER);
        this.add(jLabel2);

        jLabel3=new JLabel("猜拳人员姓名:");
        jLabel3.setBounds(200, 200, 150, 30);
        jLabel3.setHorizontalAlignment(JTextField.CENTER);
        this.add(jLabel3);

        jNameOfPerson=new JTextField();
        jNameOfPerson.setBounds(350,200,150,30);
        Font font=new Font("黑体", 1,15);
        jNameOfPerson.setFont(font);

        jNameOfPerson.setHorizontalAlignment(JTextField.CENTER);
        this.add(jNameOfPerson);

        jLabel4=new JLabel("选择电脑姓名:");
        jLabel4.setBounds(200, 250, 150, 30);
        jLabel4.setHorizontalAlignment(JTextField.CENTER);
        this.add(jLabel4);
        jNameOfComputer=new JComboBox(name);
        jNameOfComputer.setEditable(false);
        jNameOfComputer.setBounds(350,250,150,30);
        this.add(jNameOfComputer);

        btnOfSingin=new JButton("开始游戏");
        btnOfSingin.setBounds(350,350,90,30);
        btnOfSingin.setMaximumSize(new Dimension(90, 30));
        btnOfSingin.setIcon(new ImageIcon("src\\swing\\software1711\\kashi.JPG"));
        btnOfSingin.addActionListener(this);
        this.add(btnOfSingin);


    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new SinginofGame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==btnOfSingin) {
            if(jNameOfPerson.equals("")||jNameOfPerson.getText().length()==0) {
                JOptionPane.showMessageDialog(jNameOfPerson, "请输入人员姓名","提示",JOptionPane.YES_OPTION);
            }
            else {
                Person person=new Person(jNameOfPerson.getText(), 0);
                String name=(String)jNameOfComputer.getSelectedItem();
                Computer computer=new Computer(name,0);
                new Game(person,computer);
            }
        }
    }
}