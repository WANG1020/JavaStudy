package Software.niit;

import java.util.Scanner;
public class ManageEmployeeSalary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner input=new Scanner(System.in);
		 boolean isContinued = false;
			do {
				System.out.println("������Ҫ��ӡ����Ա���ͣ���1-Employee 2-Manager��");
				int choice1=input.nextInt();
				if(choice1==1){
					System.out.println("����name:");
					String name=input.next();
					System.out.println("����age:");
					int age=input.nextInt();
					System.out.println("����salary:");
					double salary=input.nextDouble();
					Employee employee=new Employee(name,age,salary,"2017/08/09");
					employee.getInfo();
				}
				else if(choice1==2){
					System.out.println("����name:");
					String name=input.next();
					System.out.println("����age:");
					int age=input.nextInt();
					System.out.println("����salary:");
					double salary=input.nextDouble();
					System.out.println("����bonus:");
					double bonus=input.nextDouble();
					System.out.println("����hoildays:");
					int hoildays=input.nextInt();
					Manager manager=new Manager(name, age, salary, "2015/05/28", bonus, hoildays);
					manager.getInfo();
				}
				else {
					System.out.println("��������");
				}
				System.out.println("�Ƿ������ӡ��y/n��");
			    char choice2 = input.next().charAt(0);
                 if (choice2 == 'y') {
                     isContinued = true;
                  } else if (choice2 == 'n') {
                     isContinued = false;
                  } 
		     }while (isContinued);
	}

}

