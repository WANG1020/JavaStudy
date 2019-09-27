package Software.niit;


public class Penguin extends Pet{
	
	private String sex;
	
	public Penguin(String name, int health, int love, String sex) {
		super(name, health, love);
		this.sex = sex;
	}
	public void print() {
		System.out.println("大家好！"+"我的名字是:"+super.getName()
				+";健康值"+super.getHealth()+";亲密度"+super.getLove()
				+";性别"+this.sex);
	}
    public void eat() {
		if(getHealth()>=100){
			System.out.println("企鹅不饿smile");
		}
		else {
			setHealth(getHealth()+5);
		}
	}
	public void swimming() {
		if(getHealth()<=0){
			System.out.println("健康值不足!");
		}
		else {
			setHealth(getHealth()-10);
			setLove(getLove()+5);
		}
	}
}

