package Software.niit;

import java.util.Scanner;
public class TestPet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		Master mm=new Master("mn", 10000);
		
		
		System.out.println("请输入领养宠物的类型");
		int type=input.nextInt();
		Pet pet=mm.getPet(type);
		if(pet!=null){
			System.out.println("领养成功！");
			pet.print();
			mm.feed(pet);
			mm.play(pet);
			pet.print();
		}
		else {
			System.out.println("领养失败，无此类宠物！");
		}
	}

}
