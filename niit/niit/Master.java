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
	    		pet=new Dog("阿Q", 95, 96, "中华田园犬");
	    	}
	    	else if(type==2) {
	    		pet=new Penguin("天", 86, 85, "雄");
	    	}
	    	return pet;
	    }
	    public void play(Pet pet){
	    	if(pet instanceof Dog) {//如果此对象为dog类实例，
	    		Dog dog=(Dog)pet;//就把宠物对象强制转换成Dog类对象
	    		dog.catchingFlyDiscs();
	    	}
	    	if(pet instanceof Penguin) {
	    		Penguin penguin=(Penguin)pet;
	    		penguin.swimming();
	    	}
	    }
	}
