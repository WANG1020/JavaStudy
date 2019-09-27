package Software.niit;

public class TestHands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AptitudeHands aptitudeHands=new AptitudeHands("苹果","AptitudeHands");
		aptitudeHands.info();
		aptitudeHands.networkConn();
		aptitudeHands.takepicture();
		aptitudeHands.sendInfo();
		aptitudeHands.PlayWiring();
		CommonHandset commonHandset=new CommonHandset("诺基亚","CommonHandset");
		commonHandset.info();
		aptitudeHands.sendInfo();
		commonHandset.PlayWiring();
	}

}
