package Software.niit;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Classwork2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("1");
		list1.add("3");
		list1.add("4");
		list1.add("5");
		mirror(list1);
		System.out.println("改变后的数组列表为：");
		for(String x:mirror(list1)) {
			System.out.print(x);
		}
		/*Iterator iterator=mirror(list1).iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next());
		}*/
		//System.out.print(mirror(list1));
	}
	public static ArrayList<String> mirror(ArrayList<String> arrayList) {
		ArrayList<String> list2=new ArrayList<String>();
		int number=arrayList.size();
		for(int i=0;i<number;i++) {
			list2.add(arrayList.get(i));
		}
		for(int i=number-1;i>=0;i--) {
			String string=arrayList.get(i);
			list2.add(string);
		}
		return list2;
	}
}
