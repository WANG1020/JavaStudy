package Software.niit;

import java.util.Scanner;
public class Game {
	private Person person;
	private Computer computer;
	private int number;
	
	public Game(Person person, Computer computer, int number) {
		this.person = person;
		this.computer = computer;
		this.number = number;
	}
	public Game() {
	}
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person=person;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public void begin() {
		Scanner input=new Scanner(System.in);
		Game game=new Game();
	    System.out.println("��ȭ����1.���� 2.ʯͷ 3.��");
		System.out.print("���������������");
	    Person person=new Person(0);
	    String name=input.next();
	    person.setName(name);
	    game.person=person;	
		System.out.print("��ѡ��Է���ɫ��1.���� 2.��Ȩ 3.�ܲ٣�");
		int choice1=input.nextInt();
		Computer computer=new Computer(0);
		if(choice1==1) {
			computer.setName("����");
		}
		else if(choice1==2) {
			computer.setName("��Ȩ");
		}
		else if(choice1==3) {
			computer.setName("�ܲ�");
		}
		game.computer=computer;
		System.out.println(person.getName()+" vs "+computer.getName());
		System.out.print("\nҪ��ʼ��(1-��ʼ 0-����ʼ)");
		int choice2=input.nextInt();
		int time=0;
		if(choice2==1) {
			 boolean isContinued = false;
			 do {
				 time++;
				 System.out.print("\n���ȭ1.���� 2.ʯͷ 3.����");
				 person.setPunch();
				 computer.setPunch();
				 if(person.getPunch()-computer.getPunch()==1||person.getPunch()-computer.getPunch()==-2)
					{	
						System.out.println("�������ϲ����Ӯ��");
						int score=0;
						score++;
						person.setIntegral(score);
					}
					else if(person.getPunch()-computer.getPunch()==-1||
							person.getPunch()-computer.getPunch()==2)
					{
						System.out.println("��������ź���������");
						int score=0;
						score++;
						computer.setIntegral(score);
					}
					else 
					{
						System.out.println("�����ƽ��");
					}
				System.out.println("�Ƿ�ʼ��һ�䣿(y-��ʼ n-����)");
				 char choice3 = input.next().charAt(0);
	            if (choice3 == 'y') {
	                isContinued = true;
	            } else if (choice3 == 'n') {
	                isContinued = false;
	            } 
			 }while (isContinued);
			 System.out.println(person.getName()+" vs "+computer.getName());
			 System.out.println("��ս���Σ�"+time);
			 System.out.println("\n����  "+"   ����  " );
			 System.out.println(person.getName()+"	"+person.getIntegral());
			 System.out.println(computer.getName()+"	"+computer.getIntegral());
			 if(person.getIntegral()>computer.getIntegral()) {
				 System.out.println("���:��Ӯ��");
			 }
			 else if(person.getIntegral()<computer.getIntegral()) {
				 System.out.println("���:������");
			}
			else {
				 System.out.println("���:ƽ��");
			}
    
		}		
	}
}