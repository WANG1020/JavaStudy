package Work;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Iterator;

public class TestWorker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Worker> list=new ArrayList<>();
		list.add(new Worker("zhang3",18,3000));
		list.add(new Worker("li4",25,3500));
		list.add(new Worker("wang5",20,15300));
		list.add(1, new Worker("zhao6",24,3300));
		list.remove(3);
		for(int i=0;i<list.size();i++) {
			System.out.println("姓名:"+list.get(i).getName()+"年龄:"
		                +list.get(i).getAge()+"薪水:"+list.get(i).getSalary());
		}
		for(Worker x:list) {
			x.work();
		}
		Worker worker1=new Worker("zhang3",18,3000);
		Worker worker2=new Worker("zhang3",18,3000);
		Worker worker3=new Worker("wang5",20,15300);
		System.out.println(worker1.equals(worker2));
		System.out.println(worker1.equals(worker3));
	}

}
