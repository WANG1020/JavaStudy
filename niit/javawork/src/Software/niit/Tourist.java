package Software.niit;


public class Tourist {

	private String name;
	private int age;
	public Tourist(String name, int age) {	
		this.name = name;
		this.age = age;
	}
	public void show(){
		System.out.println(this.name+"������Ϊ:"+this.age+",");
		if(this.age<=18){
			System.out.println("��Ʊ�۸�Ϊ��"+10+"Ԫ��");
		}
		else if(18<this.age) {
			System.out.println("��Ʊ�۸�Ϊ��"+20+"Ԫ��");
		}
		else if(this.age>= 60){
			System.out.println("��Ʊ�۸�Ϊ��"+0+"Ԫ��");
		}
	}			
	
}