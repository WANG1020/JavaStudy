package Software.niit;

public class Person1 {
	private String name;
	private char sex;
	private int age;
	
	public Person1(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public Person1() {
		
	}
    public Person1(String name) {
		this.name=name;
	}
    
    public void setSex(char sex) {
		this.sex = sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public int getAge() {
		return age;
	}

	
	public String toString() {
		String string;
		string ="姓名"+name+"性别"+sex+"年龄"+age;
		return string;
	}
}
