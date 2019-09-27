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
	    System.out.println("出拳规则1.剪刀 2.石头 3.布");
		System.out.print("请输入你的姓名：");
	    Person person=new Person(0);
	    String name=input.next();
	    person.setName(name);
	    game.person=person;	
		System.out.print("请选择对方角色：1.刘备 2.孙权 3.曹操：");
		int choice1=input.nextInt();
		Computer computer=new Computer(0);
		if(choice1==1) {
			computer.setName("刘备");
		}
		else if(choice1==2) {
			computer.setName("孙权");
		}
		else if(choice1==3) {
			computer.setName("曹操");
		}
		game.computer=computer;
		System.out.println(person.getName()+" vs "+computer.getName());
		System.out.print("\n要开始吗？(1-开始 0-不开始)");
		int choice2=input.nextInt();
		int time=0;
		if(choice2==1) {
			 boolean isContinued = false;
			 do {
				 time++;
				 System.out.print("\n请出拳1.剪刀 2.石头 3.布：");
				 person.setPunch();
				 computer.setPunch();
				 if(person.getPunch()-computer.getPunch()==1||person.getPunch()-computer.getPunch()==-2)
					{	
						System.out.println("结果：恭喜，你赢了");
						int score=0;
						score++;
						person.setIntegral(score);
					}
					else if(person.getPunch()-computer.getPunch()==-1||
							person.getPunch()-computer.getPunch()==2)
					{
						System.out.println("结果：很遗憾，你输了");
						int score=0;
						score++;
						computer.setIntegral(score);
					}
					else 
					{
						System.out.println("结果：平局");
					}
				System.out.println("是否开始下一句？(y-开始 n-结束)");
				 char choice3 = input.next().charAt(0);
	            if (choice3 == 'y') {
	                isContinued = true;
	            } else if (choice3 == 'n') {
	                isContinued = false;
	            } 
			 }while (isContinued);
			 System.out.println(person.getName()+" vs "+computer.getName());
			 System.out.println("对战场次："+time);
			 System.out.println("\\n姓名   "+"   积分  " );
			 System.out.println(person.getName()+"	"+person.getIntegral());
			 System.out.println(computer.getName()+"	"+computer.getIntegral());
			 if(person.getIntegral()>computer.getIntegral()) {
				 System.out.println("结果:你赢了");
			 }
			 else if(person.getIntegral()<computer.getIntegral()) {
				 System.out.println("结果:你输了");
			}
			else {
				 System.out.println("结果:平局");
			}
    
		}		
	}
}