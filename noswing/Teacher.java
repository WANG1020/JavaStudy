package Work;

import java.util.HashMap;
import java.util.Iterator;

public class Teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> teacher=new HashMap<>();
		teacher.put("Tom", "CoreJava");
		teacher.put("John", "Oracle");
		teacher.put("Susan", "Oracle");
		teacher.put("Jerry", "JDBC");
		teacher.put("Jim", "Unix");
		teacher.put("Kevin", "Jsp");
		teacher.put("Tom", "CoreJava");
		teacher.put("Lucy", "Jsp");
		
		teacher.put("Allen", "JDBC");//增加一个新老师
		
		if(teacher.containsKey("Lucy")) {//Lucy改教CoreJava
			teacher.remove("Lucy");
			teacher.put("Lucy", "CoreJava");
		}
		for (String x : teacher.keySet()) {
			System.out.println(x+"   "+teacher.get(x));
		}
		
		for (String x : teacher.keySet()) {
			if(teacher.get(x).equals("Jsp")) {
				 System.out.println(x+" ");
			}
			   
		}
	
	}

}
