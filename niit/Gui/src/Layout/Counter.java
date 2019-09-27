package Layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class Counter {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private StringBuffer sbuf=new StringBuffer();
	/**
	 * @wbp.nonvisual location=-13,107
	 */
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter window = new Counter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Counter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 258, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(20);
		
		
		
		JButton btnNewButton = new JButton("0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("0");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("1");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("2");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton_1 = new JButton("3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("3");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button_2 = new JButton("4");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("4");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(button_2);
		
		JButton button_6 = new JButton("5");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("5");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(button_6);
		
		JButton btnNewButton_2 = new JButton("6");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("6");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton button_3 = new JButton("7");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("7");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(button_3);
		
		JButton btnNewButton_3 = new JButton("8");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("8");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("9");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("9");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(btnNewButton_4);
		
		JButton button_4 = new JButton("+");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("+");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(button_4);
		
		JButton btnNewButton_5 = new JButton("-");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("-");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("*");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("*");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("/");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbuf.append("/");
				String buf=String.valueOf(sbuf);
				textField_1.setText(buf);
			}
		});
		frame.getContentPane().add(btnNewButton_7);
		
		JButton button_5 = new JButton("=");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bString=new String(sbuf);
				
			}
		});
		frame.getContentPane().add(button_5);
	}

}
