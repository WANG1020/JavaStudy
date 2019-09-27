package Software.niit;

import java.util.Scanner;
public class TestCircle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.print("输入圆半径：");
		double radius1=input.nextDouble();
		Circle2 circle2=new Circle2(radius1); 
		circle2.show();
		
		System.out.print("输入圆柱体半径：");
		double radius2=input.nextDouble();
		System.out.print("输入圆柱体高：");
		double hight1=input.nextDouble();
		Cylinder cylinder=new Cylinder(radius2, hight1);
		cylinder.showVolume();
		
		
	}

}
