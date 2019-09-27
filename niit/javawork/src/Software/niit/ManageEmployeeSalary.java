package Software.niit;

import java.util.Scanner;
public class ManageEmployeeSalary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner input=new Scanner(System.in);
		 boolean isContinued = false;
			do {
				System.out.println("输入想要打印的人员类型：（1-Employee 2-Manager）");
				int choice1=input.nextInt();
				if(choice1==1){
					System.out.println("输入name:");
					String name=input.next();
					System.out.println("输入age:");
					int age=input.nextInt();
					System.out.println("输入salary:");
					double salary=input.nextDouble();
					Employee employee=new Employee(name,age,salary,"2017/08/09");
					employee.getInfo();
				}
				else if(choice1==2){
					System.out.println("输入name:");
					String name=input.next();
					System.out.println("输入age:");
					int age=input.nextInt();
					System.out.println("输入salary:");
					double salary=input.nextDouble();
					System.out.println("输入bonus:");
					double bonus=input.nextDouble();
					System.out.println("输入hoildays:");
					int hoildays=input.nextInt();
					Manager manager=new Manager(name, age, salary, "2015/05/28", bonus, hoildays);
					manager.getInfo();
				}
				else {
					System.out.println("输入有误！");
				}
				System.out.println("是否继续打印（y/n）");
			    char choice2 = input.next().charAt(0);
                 if (choice2 == 'y') {
                     isContinued = true;
                  } else if (choice2 == 'n') {
                     isContinued = false;
                  } 
		     }while (isContinued);
	}

}

