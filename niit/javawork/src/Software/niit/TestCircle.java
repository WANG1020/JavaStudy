package Software.niit;


import java.util.Scanner;
public class TestCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle2=new Circle(10);
		System.out.println("���Ϊ��"+circle2.area());
		System.out.println("�ܳ�Ϊ��"+circle2.girth());
		
		Scanner input=new Scanner(System.in);
		System.out.print("����Բ�뾶��");
		double radius=input.nextDouble();
		Circle circle1=new Circle();
		circle1.setRadius(radius);
		
		System.out.println("���Ϊ��"+circle1.area());
		System.out.println("�ܳ�Ϊ��"+circle1.girth());
	}

}


