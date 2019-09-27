package Software.niit;

import java.util.Scanner;


public class TestPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**********欢迎各位进入游戏世界**********");
		System.out.println("    **********************  ");
		System.out.println("    *******猜拳 开始*****  ");
		System.out.println("    **********************  ");
		Game game=new Game();
		game.begin();
		System.out.println("************猜拳 结束*******************");

	}
	

}