package Software.niit;

public class Dog extends Pet{

	//����
	private String strain;
	
	public Dog(String name, int health, int love, String strain) {
		super(name, health, love);//���ø���Ĺ��췽��
		this.strain = strain;
	}
	//��Ҫ�������Ǳ����ʵ��
	public void print() {
		System.out.println("��Һã�"+"�ҵ�������:"+super.getName()
		+";����ֵ"+super.getHealth()+";���ܶ�"+super.getLove()
		+";Ʒ��"+this.strain);
	}
	public void eat() {
		if(getHealth()>=100){
			System.out.println("��������smile!");
		}
		else {
			setHealth(getHealth()+3);
		}
	}
	public void catchingFlyDiscs() {
		if(getHealth()<=0){
			System.out.println("����ֵ����!");
		}
		else {
			setHealth(getHealth()-10);
			setLove(getLove()+5);
		}
	}
}
