package Software.niit;

public class TheftproofDoor extends Door  implements Lock, Doorbell{

	@Override
	public void lockUp() {
		// TODO Auto-generated method stub
		System.out.println("用灵力推，门开了");
	}

	@Override
	public void openLock() {
		// TODO Auto-generated method stub
		System.out.println("轻轻拉，门关上了");
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("向右转3圈，上锁");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("向左转3圈，上锁");
	}
	@Override
	public void photogragh() {
		// TODO Auto-generated method stub
		System.out.println("咔嚓.......已拍照.......照片已存档");
	}
}
