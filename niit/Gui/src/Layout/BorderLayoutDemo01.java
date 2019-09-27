package Layout;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 上课布局实现
 * 边界布局
 */
public class BorderLayoutDemo01 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame =new JFrame("welcome To MLDN");
        frame.setLayout(new BorderLayout(3,3));
        frame.add(new JButton("EAST"),BorderLayout.EAST);
        frame.add(new JButton("WEST"),BorderLayout.WEST);
        frame.add(new JButton("SOUTH"),BorderLayout.SOUTH);
        frame.add(new JButton("NORTH"),BorderLayout.NORTH);
        frame.add(new JButton("CENTER"),BorderLayout.CENTER);
        frame.setSize(280,123);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
