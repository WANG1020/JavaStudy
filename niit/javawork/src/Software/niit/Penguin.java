package Software.niit;


public class Penguin extends Pet{
	
	private String sex;
	
	public Penguin(String name, int health, int love, String sex) {
		super(name, health, love);
		this.sex = sex;
	}
	public void print() {
		System.out.println("��Һã�"+"�ҵ�������:"+super.getName()
				+";����ֵ"+super.getHealth()+";���ܶ�"+super.getLove()
				+";�Ա�"+this.sex);
	}
    public void eat() {
		if(getHealth()>=100){
			System.out.println("��첻��smile");
		}
		else {
			setHealth(getHealth()+5);
		}
	}
	public void swimming() {
		if(getHealth()<=0){
			System.out.println("����ֵ����!");
		}
		else {
			setHealth(getHealth()-10);
			setLove(getLove()+5);
		}
	}
}

