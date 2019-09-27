package Software.niit;

public class Manager extends Employee implements IEmployee{
	private double bonus;
	private int hoildays;
	public Manager(String name, int age, double salary, String hireday, double bonus, int hoildays) {
		super(name, age, salary, hireday);
		this.bonus = bonus;
		this.hoildays = hoildays;
	}
	public Manager() {
	}
	public double getSalary() {
		return super.getSalary()+bonus;
	}
	public double addSalary() {
		return getSalary()+prize;
	}
	public void getInfo() {
		System.out.println("Name:"+super.getName());
		System.out.println("I'm Manager");
		System.out.println("Age:"+super.getAge());
		System.out.println("Hireday:"+super.getHireday());
		System.out.println("Salary:"+super.getSalary());
		System.out.println("bonus:"+this.bonus);
		System.out.println("addSalary:"+addSalary());
		System.out.println("Hoildays:"+this.hoildays);
	}

	
}
