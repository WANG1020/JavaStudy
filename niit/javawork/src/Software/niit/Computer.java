package Software.niit;

import java.util.Scanner;

public class Computer {
	private String name;
	private int integral;
	
	public Computer(String name, int integral) {
		this.name = name;
		this.integral = integral;
	}
	public Computer( int integral) {
		this.integral = integral;
	}
	public Computer( ) {
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	int show;
	public int setPunch() {
		show =(int )(Math.random()*10%3)+1;
		String punch=" ";
		switch(show){
		case 1:punch="����";break;
		case 2:punch="ʯͷ";break;
		case 3:punch="��";break;
		}
		System.out.println("�Է���ȭ��"+punch);
		return show;
	}
	public int getPunch() {
		return show;
	}
}
