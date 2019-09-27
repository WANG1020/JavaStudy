package Software.niit;

import java.util.Scanner;

public class Feeder {
	
	public void feed() {
		Scanner input=new Scanner(System.in);
		System.out.print("请输入你想要喂食的动物：（1-猫 2-狗）");
		int type=input.nextInt();
		Animal animal=null;
    	if(type==1) {
    		animal=new Cat1();
    	}
    	else if(type==2) {
    		animal=new Dog1();
    	}
		Food food=null;
		if(animal instanceof Dog1) {
    		Dog1 dog=(Dog1)animal;
    		dog.eat(food);
    	}
		if(animal instanceof Cat1) {
    		Cat1 cat=(Cat1)animal;
    		cat.eat(food);
    	}
	}
}
