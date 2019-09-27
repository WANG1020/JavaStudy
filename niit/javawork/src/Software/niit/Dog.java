package Software.niit;

public class Dog extends Pet{

	//属性
	private String strain;
	
	public Dog(String name, int health, int love, String strain) {
		super(name, health, love);//调用父类的构造方法
		this.strain = strain;
	}
	//主要操作的是本类的实例
	public void print() {
		System.out.println("大家好！"+"我的名字是:"+super.getName()
		+";健康值"+super.getHealth()+";亲密度"+super.getLove()
		+";品种"+this.strain);
	}
	public void eat() {
		if(getHealth()>=100){
			System.out.println("狗狗不饿smile!");
		}
		else {
			setHealth(getHealth()+3);
		}
	}
	public void catchingFlyDiscs() {
		if(getHealth()<=0){
			System.out.println("健康值不足!");
		}
		else {
			setHealth(getHealth()-10);
			setLove(getLove()+5);
		}
	}
}
