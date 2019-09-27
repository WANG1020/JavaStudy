package Work;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClassWorkof {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		HashMap<String, String> match=new HashMap<>();
		
		match.put("1930","乌拉圭");
		match.put("1934", "意大利");
		match.put("1938", "意大利");
		match.put("1950", "乌拉圭");
		match.put("1954", "德国");
		match.put("1958", "巴西");
		match.put("1962", "巴西");
		match.put("1966", "英格兰");
		match.put("1970", "巴西");
		match.put("1974", "德国");
		match.put("1978", "阿根廷");
		match.put("1982", "意大利");
		match.put("1986", "阿根廷");
		match.put("1990", "德国");
		match.put("1990", "德国");
		match.put("1994", "巴西");
		match.put("1998", "法国");
		match.put("2002", "巴西");
		match.put("2006", "意大利");
		
		System.out.println("请输入查询的年份：");
		String date=in.next();
		if(match.containsKey(date)) {
			System.out.println(match.get(date));
		}
		else {
			System.out.println("没有举办世界杯");
		}
		System.out.println("请输入查询的国家：");
		String name=in.next();
		if(match.containsValue(name)) {
			for(String x:match.keySet()) {
				if(match.get(x).equals(name)) {
					System.out.print(x+" ");
				}
			}
		}
		else {
			System.out.print("没有获得过世界杯!");
		}
		
		
	}

}
