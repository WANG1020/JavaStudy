package Software.niit;

import java.util.ArrayList;

public class ArrayListTofPenguin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Penguin penguin1=new Penguin("天天", 98, 96, "雄");
		Penguin penguin2=new Penguin("天青", 98, 96, "雄");
		Penguin penguin3=new Penguin("天琳", 98, 96, "雌");
		Penguin penguin4=new Penguin("天语", 98, 96, "雄");
		ArrayList<Penguin> penguins=new ArrayList<Penguin>();
		penguins.add(penguin1);
		penguins.add(penguin2);
		penguins.add(penguin3);
		penguins.add(penguin4);
		System.out.println("共计有："+penguins.size()+"只企鹅");
		System.out.println("分别是：");
		for(int i=0;i<penguins.size();i++) {
			penguins.get(i);
			System.out.println(penguins.get(i));
		}
		penguins.remove(2);
		if(penguins.contains(penguin2)) {
			penguins.remove(penguin2);
		}
		System.out.println("删除后还有"+penguins.size()+"只企鹅");
		for(int i=0;i<penguins.size();i++) {
			penguins.get(i);
			System.out.println(penguins.get(i));
		}  
	}

}
