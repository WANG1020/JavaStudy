package Software.niit;

public class TestDoor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheftproofDoor door=new TheftproofDoor(); 
		System.out.println("回家");
		door.photogragh();
		door.lockUp();
		door.open();
		System.out.println("回京");
		door.close();
		door.openLock();
	}

}
