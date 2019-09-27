package Software.niit;

public class Employee extends People implements IEmployee {
	private double salary;
	private String hireday;
	
	public double getSalary() {
		return salary;
	}
	public String getHireday() {
		return hireday;
	}
	
	public Employee(String name, int age, double salary, String hireday) {
		super(name, age);
		this.salary = salary;
		this.hireday = hireday;
	}
	public Employee() {
	}
	public void getInfo() {
		System.out.println("Name:"+super.getName());
		System.out.println("I'm Employee");
		System.out.println("Age:"+super.getAge());
		System.out.println("Salary:"+this.getSalary());
		System.out.println("addSalary:"+addSalary());
		System.out.println("Hireday:"+this.hireday);
	}
	@Override
	public double addSalary() {
		// TODO Auto-generated method stub
		return getSalary()+prize;
	}
}
