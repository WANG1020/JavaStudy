package Work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Class {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, ArrayList> map=new HashMap<String, ArrayList>();
		ArrayList<Student1> listofcommon=new ArrayList<Student1>();
		ArrayList<Student1> listofstrong=new ArrayList<Student1>();
		
		Student1 student1=new Student1("1702753115", "王行哲");
		Student1 student2=new Student1("1214351642", "王喜");
		Student1 student3=new Student1("1214351325", "赵强");
		Student1 student4=new Student1("1214351324", "赵理");
		
		listofcommon.add(student1);
		listofcommon.add(student2);
		
		listofstrong.add(student3);
		listofstrong.add(student4);
		
		map.put("普通班", listofcommon);
		map.put("强化班", listofstrong);
		
		System.out.println("普通班学生");
		for(String x:map.keySet()) {
			if("普通班".equals(x)) {
				ArrayList<Student1> stu=map.get(x);
				for(Student1 s:stu) {
					System.out.println(s);
				}
			}
		}
		System.out.println("强化班学生");
		for(String x:map.keySet()) {
			if("强化班".equals(x)) {
				ArrayList<Student1> stu=map.get(x);
				for(Student1 s:stu) {
					System.out.println(s);
				}
			}
		}
	}

}
