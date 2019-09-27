package Work;

import java.util.ArrayList;
import java.util.List;


public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list=new ArrayList<Student>();
		list.add(new Student("Tom", 18, 100, "class05"));
		list.add(new Student("Jerry", 22, 70, "class04"));
		list.add(new Student("Owen", 25, 90, "class05"));
		list.add(new Student("Jim", 30,80 ,"class05"));
		list.add(new Student("Steve", 28, 66, "class06"));
		
		int sumofAge=0;
		int sumofScore=0;
		for(int i=0;i<list.size();i++){
			sumofAge+=list.get(i).getAge();
		}
		for(int i=0;i<list.size();i++){
			sumofScore+=list.get(i).getScore();
		}
		System.out.println("平均年龄为:"+sumofAge/5);
		System.out.println("平均年龄为:"+sumofScore/5);
	}
	

}
