package swing.software1711;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DTimeFrame extends JFrame implements Runnable{
	private JFrame frame;
	private JPanel timePanel;
	private JLabel timeLabel;
	private JLabel displayArea;
	private String DEFAULF_TIME_EORMAT="yyyy-MM-dd HH:mm:ss";
	private int ONE_SECOND=1000;
	
	public DTimeFrame() {
		timePanel=new JPanel();
		 
		timeLabel=new JLabel("当前时间是：");
		timeLabel.setForeground(Color.red);
		
		displayArea=new JLabel();
		
		timePanel.add(timeLabel);
		timePanel.add(displayArea);
		this.add(timePanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(250, 80));
		this.setLocationRelativeTo(null);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			SimpleDateFormat dateFormat=new SimpleDateFormat(DEFAULF_TIME_EORMAT);
			displayArea.setText(dateFormat.format(Calendar.getInstance().getTime()));
			try {
				Thread.sleep(ONE_SECOND);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				displayArea.setText("Error!!!");
			}
		}
	}
	public JPanel getTimePanel() {
		return timePanel;
	}
	public void setTimePanel(JPanel timePanel) {
		this.timePanel=timePanel;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DTimeFrame df2=new DTimeFrame();
		df2.setVisible(true);
		
		Thread thread1=new Thread(df2);
		thread1.start();
	}

}
