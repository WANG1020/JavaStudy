package swing.software1711;

public class BankCard {
	private String id;
	private String password;
	private int money;
	
	public BankCard(String id, String password, int money) {
		this.id = id;
		this.password = password;
		this.money = money;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
