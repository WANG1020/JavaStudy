package cn.jbit.epet.entity;

public class Master {
	private int id;//主人id
	private String name;//主人姓名
	private String password;//登录密码
	private int money;//资金
	public Master(int id, String name, String password, int money) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.money = money;
	}
	public Master() {
	}
	public Master(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}
