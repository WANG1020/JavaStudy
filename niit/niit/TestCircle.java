package Software.niit;


import java.util.Scanner;
public class TestCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle2=new Circle(10);
		System.out.println("面积为："+circle2.area());
		System.out.println("周长为："+circle2.girth());
		
		Scanner input=new Scanner(System.in);
		System.out.print("输入圆半径：");
		double radius=input.nextDouble();
		Circle circle1=new Circle();
		circle1.setRadius(radius);
		
		System.out.println("面积为："+circle1.area());
		System.out.println("周长为："+circle1.girth());
	}

}


