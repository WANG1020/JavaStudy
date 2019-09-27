package Software.niit;

import java.util.Scanner;
public class TestPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		Point point1=new Point();
		Point point2=new Point();
		System.out.print("请输入点1");
		int x1=input.nextInt();
		int y1=input.nextInt();
		point1.setX(x1);
		point1.setY(y1);
	    System.out.print("请输入点2");
		int x2=input.nextInt();
		int y2=input.nextInt();
		point2.setX(x2);
		point2.setY(y2);
		System.out.print(point1.Distance(point2));
	}

}
