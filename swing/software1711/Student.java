package swing.software1711;

public class Student {
	private String no;
	private String name;
	private String password;
	private int java;
	
	public Student(String no, String name, String password, int java) {
		this.no = no;
		this.name = name;
		this.password = password;
		this.java = java;
	}
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}
	
}
