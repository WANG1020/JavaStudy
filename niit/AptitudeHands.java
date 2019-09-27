package Software.niit;

public class AptitudeHands extends Handset implements TheakePictures,Network ,PlayWiring{

	public AptitudeHands(String brand, String type) {
		super(brand, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void networkConn() {
		// TODO Auto-generated method stub
		System.out.println("网络已连接");
	}

	@Override
	public void takepicture() {
		// TODO Auto-generated method stub
		System.out.println("咔嚓.....拍照,已保存");
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

	@Override
	public void PlayWiring() {
		// TODO Auto-generated method stub
		System.out.println("播放音频");
	}
	
}
