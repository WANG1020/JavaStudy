package Software.niit;


public class TestBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      Bank account1=new Bank("123456789123","行尼","000000",1234567890);
	      System.out.println("account1的当前余额为："+account1.inquiry());
	      account1.save(100);
	      System.out.println("account1的当前余额为："+account1.inquiry());
	      account1.draw(199);
	      System.out.println("account1的当前余额为："+account1.inquiry());
	      account1.inquiry();
	      Bank account2=new Bank();
	      account2.setCard("1255852");
	      account2.setName("wangxingzhe");
	      account2.setPassword("1455258");
	      account2.setBalance(46516481);
	     System.out.println("当前账户："+account2.getCard());
	     System.out.println("当前客户名："+account2.getName());
	     System.out.println("当前账号密码："+account2.getPassword());
	     System.out.println("当前客户余额："+account2.getBalance());
	}

}

