package Software.niit;

public class Dog extends Pet{

	//品种
	private String strain;
	
	public Dog(String name, int health, int love, String strain) {
		super(name, health, love);//调用父类构造方法
		this.strain = strain;
	}
	public void print() {
		System.out.println("大家好!"+"我的名字是:"+super.getName()
		+";我的健康值ֵ"+super.getHealth()+";亲密度"+super.getLove()
		+";我的品种"+this.strain);
	}
	public String toString() {
		String s="大家好!"+"我的名字是:"+super.getName()
		+";我的健康值ֵ为"+super.getHealth()+";亲密度为"+super.getLove()
		+";我的品种是"+this.strain;
		return s;
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
			System.out.println("体力不足!");
		}
		else {
			setHealth(getHealth()-10);
			setLove(getLove()+5);
		}
	}
}
