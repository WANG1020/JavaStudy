package Layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import sun.reflect.generics.tree.VoidDescriptor;

public class jFrame {

	private JFrame frame;
	private JTextArea textArea;
	private JTextField textField_1;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField_2;
	private JPanel panel_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JPanel panel_2;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JComboBox<?> comboBox;
	private JComboBox<String> comboBox_1;
	private JButton btnNewButton;
    private StringBuffer stf;
    private String string1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrame window = new jFrame();
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
	public jFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(0, 0, 207, 261);
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		textArea.setColumns(30);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 0, 191, 261);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		panel = new JPanel(new GridLayout(7, 7));
		panel.setBounds(212, 0, 222, 261);
		frame.getContentPane().add(panel);
		
		lblNewLabel = new JLabel("1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setText("姓名");
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(rdbtnNewRadioButton.isSelected())
					string1=rdbtnNewRadioButton.getText();
			}
		});
		panel_1.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(rdbtnNewRadioButton_1.isSelected())
					string1=rdbtnNewRadioButton_1.getText();
			}
		});
		panel_1.add(rdbtnNewRadioButton_1);
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		
		stf=new StringBuffer();
		chckbxNewCheckBox = new JCheckBox("阅读");
		chckbxNewCheckBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(chckbxNewCheckBox.isSelected())
					stf.append(chckbxNewCheckBox.getText()+",");
			}
		});
		panel_2.add(chckbxNewCheckBox);
		
		
		chckbxNewCheckBox_1 = new JCheckBox("绘画");
		chckbxNewCheckBox_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(chckbxNewCheckBox_1.isSelected())
					stf.append(chckbxNewCheckBox_1.getText()+",");
			}
		});
		panel_2.add(chckbxNewCheckBox_1);
		
		
		chckbxNewCheckBox_2 = new JCheckBox("音乐");
		chckbxNewCheckBox_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(chckbxNewCheckBox_2.isSelected())
					stf.append(chckbxNewCheckBox_2.getText()+",");
			}
		});
		panel_2.add(chckbxNewCheckBox_2);
		
		
		Object privence[]= {"江苏省", "浙江省"};
		comboBox = new JComboBox(privence);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getSelectedIndex()==0) {
						comboBox_1.removeAllItems();
						comboBox_1.addItem("南京市");
						comboBox_1.addItem("淮安市");
						comboBox_1.addItem("无锡市");
				}
			   if(comboBox.getSelectedIndex()==1) {
					comboBox_1.removeAllItems();
					comboBox_1.addItem("杭州市");
					comboBox_1.addItem("宁波市");
					comboBox_1.addItem("温州市");
				}
			}
		});
		panel.add(comboBox);
		

		Object citys[]= {"南京市","淮安市","徐州市"};
		comboBox_1 = new JComboBox(citys);
		panel.add(comboBox_1);
		
		btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string=String.valueOf(stf);
				String stringf=lblNewLabel.getText()+","+textField_2.getText()+","+string1+","+stf+comboBox.getSelectedItem()+","+comboBox_1.getSelectedItem()+"\n";
				textArea.append(stringf);
				int number=1;
				if(btnNewButton.isEnabled()){
					number++;
				}
				String nString=Integer.toString(number);
				lblNewLabel.setText(nString);
			}
		});
		panel.add(btnNewButton);
	}
}
