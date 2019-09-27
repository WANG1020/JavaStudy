package swing.software1711;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {

	private String name;
	private int integral;
	
	public Person(String name, int integral) {
		this.name = name;
		this.integral = integral;
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
	public String setPunch(String punch) {
		return punch;
	}
}
