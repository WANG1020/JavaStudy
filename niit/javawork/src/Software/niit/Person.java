package Software.niit;

import java.util.Scanner;

public class Person {
	private String name;
	private int integral;
	
	public Person(String name, int integral) {
		this.name = name;
		this.integral = integral;
	}
	public Person( int integral) {
		this.integral = integral;
	}
	public Person() {
	
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
		Scanner input=new Scanner(System.in);
		show=input.nextInt();
		String punch=" ";
		switch(show){
		case 1:punch="����";break;
		case 2:punch="ʯͷ";break;
		case 3:punch="��";break;
		}
		System.out.println("���ȭ��"+punch);
		return show;
	}
	public int getPunch() {
		return show;
	}
	
}
