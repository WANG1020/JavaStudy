package Software.niit;


import java.util.Scanner;
public class TestMotoVehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("��ӭ���������У�");
		/*boolean isContinued = false;
		do {
			System.out.println("�����˺ţ�");
			String account=input.next();
			System.out.println("����������");
			String name=input.next();
			Customer customer=new Customer(account, name);
			System.out.println("��������Ҫ��ƾ�ĳ�������");
			int number=input.nextInt();
			MotoVehicle []motos=new MotoVehicle[number];
			System.out.println("������Ҫ��ƾ�ĳ����ͣ���1-Car 2-Bus 3-Lorry��");
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
				System.out.println("��������");
			}
			System.out.println("�Ƿ������ƾ��y/n��");
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
		motos[0] = new Car("��NY28588","����550i");
		motos[1] =new Car("��NNN328","����550i");
		motos[2]=new Car("��NY28578", "���������");
		motos[3]=new Bus("����", 34);
		motos[4]=new Lorry("��NY28478", "���", 20);
		Customer customer=new Customer("wang1647","��ǿ");
		customer.CalcRent(motos,days);
		System.out.println("��������"+number+"������");
		System.out.println("�����Ϊ��"+customer.CalcRent(motos,days));
		

	}

}
