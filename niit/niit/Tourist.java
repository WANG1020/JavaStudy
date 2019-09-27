package Software.niit;


public class Tourist {

	private String name;
	private int age;
	public Tourist(String name, int age) {	
		this.name = name;
		this.age = age;
	}
	public void show(){
		System.out.println(this.name+"年龄为:"+this.age+",");
		if(this.age<=18){
			System.out.println("门票价格"+10+"元");
		}
		else if(18<this.age) {
			System.out.println("门票价格"+20+"元");
		}
		else if(this.age>= 60){
			System.out.println("门票价格"+0+"元");
		}
	}			
	
}