package swing.software1711;

public class Computer {

	private String name;
	private int integral;
	
	public Computer(String name, int integral) {
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
	
	public String setPunch() {
		
		int show =(int )(Math.random()*10%3)+1;
		String punch=" ";
		switch(show){
		case 1:punch="剪刀";break;
		case 2:punch="石头";break;
		case 3:punch="布";break;
		}
		return punch;
	}
}
