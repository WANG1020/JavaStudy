package Software.niit;

public class Bank {
	


	private String card;//���ԣ�ʵ��������
	private String name;
	private String password;
	private int balance;
	
    public Bank(String card, String name, String password, int balance) {
		this.card = card;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}
    public Bank() {
    	
	}
    //���Է���
	public String getCard() {
		return card;
	}



	public void setCard(String card) {
		this.card = card;
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



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public void save(int money) {
		this.balance+=money;
	}
	
	public void draw(int money) {
		if(this.balance<money) {
			System.out.println("���㣡��");
		}else {
		this.balance-=money;
		}
	}
	
	public int inquiry() {
		return this.balance;
	}
}

