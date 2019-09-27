package Software.niit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArrayListT {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog1=new Dog("喂", 98, 88, "德牧");
		Dog dog2=new Dog("呢", 96, 89, "中华田园");
		Dog dog3=new Dog("浩", 95, 91, "拉布拉多");
		Dog dog4=new Dog("客", 96, 96, "雪瑞拉");
		Dog dog5=new Dog("德", 94, 88, "阿拉斯加");
		
		ArrayList<Dog> dogs=new ArrayList<Dog>();
		
		dogs.add(dog1);
		dogs.add(dog2);
		dogs.add(dog3);
		dogs.add(dog4);
		dogs.add(dog5);
		System.out.println("集合中元素的个数："+dogs.size());
		for(int i=0;i<dogs.size();i++) {
			System.out.println(dogs.get(i));
		}
		dogs.remove(3);//删除dog4
		if(dogs.contains(dog3)) {		
			dogs.remove(dog3);//删除dog3
		}
		System.out.println("删除后:");
		/*for(int i=0;i<dogs.size();i++) {
			System.out.println(dogs.get(i));
		}*/
		Iterator<Dog> iterable=dogs.iterator();
		while(iterable.hasNext()) {
			Dog dog=iterable.next();
			System.out.println(dog);
		}
	}

}
