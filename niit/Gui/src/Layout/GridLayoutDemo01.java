package Layout;

import javax.swing.*;
import java.awt.*;

/**
 * 网格布局
 * 上课实现
 */
public class GridLayoutDemo01 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame =new JFrame("welcome To MLDN");
        frame.setLayout(new GridLayout(3,5,3,3));
        JButton but=null;
        for(int i=0;i<13;i++){
            but=new JButton("按钮-"+i);
            frame.add(but);
        }
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
