package Software.niit;

public class CommonHandset extends Handset implements PlayWiring{

	public CommonHandset(String brand, String type) {
		super(brand, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void PlayWiring() {
		// TODO Auto-generated method stub
		System.out.println("播放音频");
	}

	@Override
	public void sendInfo() {
		// TODO Auto-generated method stub
		System.out.println("消息已发送");
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("电话连接中");
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("brands:"+super.getBrand()+"type:"+super.getType());
	}

}
