package cn.jbit.epet.entity;

public class Pet {
	private int id;
	private int masterId;
	private String name;
	private int health;
	private int love;
	private String strain;
	public Pet(int id, int masterId, String name, int health, int love, String strain) {
		this.id = id;
		this.masterId = masterId;
		this.name = name;
		this.health = health;
		this.love = love;
		this.strain = strain;
	}
	public Pet( String name) {
		this.name = name;
	}
	public Pet(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Pet(int id) {
		this.id = id;
	}
	public Pet() {
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}

	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}
}
