package Software.niit;

import java.util.ArrayList;

public class Classwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> object=new ArrayList<String>();
		object.add("one");
		object.add("peach");
		object.add("pear");
		object.add("plum");
		countEvens(object);
		System.out.println("包含的偶数字符数量为"+countEvens(object));
	}
	public static int countEvens(ArrayList<String> obj) {
		int number=0;
		//Iterator<String> iterable=dogs.iterator();
		/*while(iterable.hasNext()) {
			String string=iterable.next();
			if(string.length()%2==0){
			    number++;
			}
		}*/
		for(int i=0;i<obj.size();i++) {
			obj.get(i);
			if(obj.get(i).length()%2==0) {
				number++;
			}
		}
		return number;
	}
}
