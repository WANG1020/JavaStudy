package Software.niit;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog1=new Dog("喂", 98, 88, "德牧");
		Dog dog2=new Dog("呢", 96, 89, "中华田园");
		Dog dog3=new Dog("浩", 95, 91, "拉布拉多");
		Dog dog4=new Dog("客", 96, 96, "雪瑞拉");
		Dog dog5=new Dog("德", 94, 88, "阿拉斯加");
		LinkedList<Dog> dogs=new LinkedList<Dog>();
		dogs.add(dog1);
		dogs.add(dog2);
		dogs.add(1,dog3);
		dogs.addFirst(dog4);
		dogs.addLast(dog5);
		for(int i=0;i<dogs.size();i++) {
			dogs.get(i);
			System.out.println(dogs.get(i));
		}
		System.out.println("得到第一个:");
		Dog dog=dogs.getFirst();
		System.out.println(dog);
		
		System.out.println("得到最后一个:");
		dog=dogs.getLast();
		System.out.println(dog);
		
		System.out.println("删除第一个后:");
		dogs.removeFirst();
		for(int i=0;i<dogs.size();i++) {
			dogs.get(i);
			System.out.println(dogs.get(i));
		}
		
		System.out.println("删除最后一个后:");
		dogs.removeLast();
		for(int i=0;i<dogs.size();i++) {
			dogs.get(i);
			System.out.println(dogs.get(i));
		}
		
	}

}
