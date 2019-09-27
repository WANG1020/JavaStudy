package Work;

public class Worker {
	private String name;
	private int age;
	private double salary;
	
	public Worker() {}
	public Worker(String name,int age, double salary) {
		this.age = age;
		this.name = name;
		this.salary = salary;
	}
	
	public int getAge() {
		return age;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean equals(Worker worker1) {
		if(this.name==worker1.name&&this.age==worker1.age) {
			return true;
		}
		else {
			return false;
		}
	}
	public void work() {
		System.out.println(name+"work");
	}
}
