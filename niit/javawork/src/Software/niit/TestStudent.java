package Software.niit;


public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student []stu=new Student[5];
		
		stu[1]=new Student("1346546","������","��",20,84);
		
		stu[2]=new Student("1546498");
		stu[2].setsName("��а");
		stu[2].setsSex("��");
		stu[2].setsAge(21);
		stu[2].setsJava(89);
		
		stu[3]=new Student("1579645","����");
		stu[3].setsSex("��");
		stu[3].setsAge(21);
		stu[3].setsJava(75);
		
		stu[4]=new Student("1579624","���","��");
		stu[4].setsAge(21);
		stu[4].setsJava(90);
		
		stu[0]=new Student("1579633","��ɽ","��",21);
		stu[0].setsJava(96);
		for(int i=0;i<stu.length;i++)
		{
			System.out.println("��ѧ����ѧ����ϢΪ��");
			stu[i].print();
		}
		double ave=0;
		for(int i=0;i<stu.length;i++)
		{
		   ave+=stu[i].getsJava();
		}
		System.out.println("�����ѧ����ƽ���ɼ�Ϊ��"+ave/5);
		
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
		System.out.println("��߳ɼ�Ϊ��"+max+"����Ϊ��"+name_max);
		System.out.println("��ͳɼ�Ϊ��"+min+"����Ϊ��"+name_min);
	}

}

