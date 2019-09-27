package Layout;

import javax.swing.*;
import java.awt.*;

/**
 * 卡片布局
 * 上课实现
 */
public class CardLayoutDemo01 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame =new JFrame("welcome To MLDN");
        CardLayout card=new CardLayout();
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,3,3));
        frame.setLayout(card);
        Container con=frame.getContentPane();
        con.add(new JLabel("标签-A",JLabel.CENTER),"first");
        con.add(new JLabel("标签-B",JLabel.CENTER),"second");
        con.add(new JLabel("标签-C",JLabel.CENTER),"third");
        con.add(new JLabel("标签-D",JLabel.CENTER),"fourth");
        con.add(new JLabel("标签-E",JLabel.CENTER),"fifth");
        frame.pack();//将窗体设置成最佳大小
        frame.setSize(300,153);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        card.show(con,"third");
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(3000);
            }catch(InterruptedException e){ }
            card.next(con);

        }


    }
}
