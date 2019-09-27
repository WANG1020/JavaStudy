package Layout;

import javax.swing.*;
import java.awt.*;

/**
 * 流布局
 * 上课实现
 */
public class FlowLayoutCardDemo01 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame =new JFrame("welcome To MLDN");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,3,3));
        JButton but=null;
        for(int i=0;i<9;i++) {
            but=new JButton("按钮-"+(i+1));
            frame.add(but);
        }
        frame.setSize(288,153);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
