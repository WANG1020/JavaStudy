package Software.niit;

import java.util.HashMap;
import java.util.Iterator;

public class HashM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> nations=new HashMap<>();
		nations.put("CN", "China");
		nations.put("US", "America");
		nations.put("JP", "Japan");
		nations.put("UK", "England");
		System.out.println("Map中数据:");
		//System.out.println(nations);
		for(String x:nations.keySet()) {
		 //增强型for循环
			System.out.println(nations.get(x));
		}
	    /*Iterator it=nations.keySet().iterator();
	    while(it.hasNext()) {
	    	System.out.println(nations.get(it.next()));
	    }*/
		System.out.println("Map中一共有"+nations.size()+"组数据");
		System.out.println(nations.remove("JP"));
		System.out.println("Map中一共有"+nations.size()+"组数据");
		System.out.println(nations.get("UK"));
		
		if(nations.containsKey("CN")) {
			System.out.println(nations.get("CN"));
		}
		System.out.println(nations.keySet());
		System.out.println(nations.values());
		
	}

}
