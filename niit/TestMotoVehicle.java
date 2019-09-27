package Software.niit;


import java.util.Scanner;
public class TestMotoVehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎来到智租行！");
		/*boolean isContinued = false;
		do {
			System.out.println("输入账号！");
			String account=input.next();
			System.out.println("输入姓名！");
			String name=input.next();
			Customer customer=new Customer(account, name);
			System.out.println("输入你想要租凭的车辆数！");
			int number=input.nextInt();
			MotoVehicle []motos=new MotoVehicle[number];
			System.out.println("输入想要租凭的车类型：（1-Car 2-Bus 3-Lorry）");
			int choice1=input.nextInt();
			if(choice1==1){
				 String sNo=input.next();
				 String sBrand=input.next();
				 
			}
			else if(choice1==2){
				 String sNo=input.next();
				 String sBrand=input.next();
				 int sSeatCount=input.nextInt();
			}
			else if(choice1==3){
				 String sNo=input.next();
				 String sBrand=input.next();
				 String tonnage=input.next();
			}
			else {
				System.out.println("输入有误！");
			}
			System.out.println("是否继续租凭（y/n）");
		    char choice2 = input.next().charAt(0);
             if (choice2 == 'y') {
                 isContinued = true;
              } else if (choice2 == 'n') {
                 isContinued = false;
              } 
	     }while (isContinued);*/


		int number=5;
		int days=5;
		MotoVehicle []motos=new MotoVehicle[number];
		motos[0] = new Car("京NY28588","宝马550i");
		motos[1] =new Car("京NNN328","宝马550i");
		motos[2]=new Car("京NY28578", "别克林荫大道");
		motos[3]=new Bus("金龙", 34);
		motos[4]=new Lorry("京NY28478", "解放", 20);
		Customer customer=new Customer("wang1647","张强");
		customer.CalcRent(motos,days);
		System.out.println("您租用了"+number+"辆车辆");
		System.out.println("总租金为："+customer.CalcRent(motos,days));
		

	}

}
