package Software.niit;


public class Master {
	private String name;
	private int money;
	
	public Master(String name, int money) {
		this.name = name;
		this.money = money;
	}
	/*public void feedOfDog(Dog dog){
		dog.eat();
	}
    public void feedOfPenguin(Penguin penguin){
		penguin.eat();
	}*/
    public void feed(Pet pet) {
    	pet.eat();
    }
    public Pet getPet(int type){
    	Pet pet=null;
    	if(type==1) {
    		pet=new Dog("��Q", 95, 96, "�л���԰Ȯ");
    	}
    	else if(type==2) {
    		pet=new Penguin("��", 86, 85, "��");
    	}
    	return pet;
    }
    public void play(Pet pet){
    	if(pet instanceof Dog) {//����˶���Ϊdog��ʵ����
    		Dog dog=(Dog)pet;//�Ͱѳ������ǿ��ת����Dog�����
    		dog.catchingFlyDiscs();
    	}
    	if(pet instanceof Penguin) {
    		Penguin penguin=(Penguin)pet;
    		penguin.swimming();
    	}
    }
}

