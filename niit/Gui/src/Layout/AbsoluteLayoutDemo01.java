package Layout;
import javax.swing.*;
import java.awt.*;

/**
 * 上课职业
 * 绝对布局
 */

public class AbsoluteLayoutDemo01 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new JFrame(" Welcome To MLDN");
        frame.setLayout(null);
        JLabel title = new JLabel("it.niit.edu.cn");
        JButton enter = new JButton("进入");
        JButton help = new JButton("帮助");
        frame.setSize(280, 123);
        title.setBounds(45, 5, 150, 20);
        enter.setBounds(10, 30, 80, 20);
        help.setBounds(100, 30, 80, 20);
        frame.add(title);
        frame.add(enter);
        frame.add(help);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
