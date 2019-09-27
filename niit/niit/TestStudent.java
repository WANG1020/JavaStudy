package Software.niit;


public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student []stu=new Student[5];
		
		stu[1]=new Student("1346546","无邪","男",20,84);
		
		stu[2]=new Student("1546498");
		stu[2].setsName("张强");
		stu[2].setsSex("男");
		stu[2].setsAge(21);
		stu[2].setsJava(89);
		
		stu[3]=new Student("1579645","刘明辉");
		stu[3].setsSex("��");
		stu[3].setsAge(21);
		stu[3].setsJava(75);
		
		stu[4]=new Student("1579624","王强","男");
		stu[4].setsAge(21);
		stu[4].setsJava(90);
		
		stu[0]=new Student("1579633","陈娇","女",21);
		stu[0].setsJava(96);
		for(int i=0;i<stu.length;i++)
		{
			System.out.println("学生信息为");
			stu[i].print();
		}
		double ave=0;
		for(int i=0;i<stu.length;i++)
		{
		   ave+=stu[i].getsJava();
		}
		System.out.println("java平均成绩为："+ave/5);
		
		int max=stu[0].getsJava();
		int min=stu[0].getsJava();
		String name_max=stu[0].getsName();
		String name_min=stu[0].getsName();;
		for(int i=0;i<stu.length;i++)
		{
			if(max<stu[i].getsJava()) {
				max=stu[i].getsJava();
				name_max=stu[i].getsName();
			}
			if(min>stu[i].getsJava()) {
				min=stu[i].getsJava();
				name_min=stu[i].getsName();
			}
		}
		System.out.println("最高分："+max+"名字为："+name_max);
		System.out.println("最低分："+min+"名字为："+name_min);
	}

}

