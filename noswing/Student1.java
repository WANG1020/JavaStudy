package Work;

public class Student1 {
	private  String id;
	private  String name;
	
	public Student1(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public   String toString() {
		String string;
		string="学号："+id+"姓名："+name;
		return string;
	}
}
