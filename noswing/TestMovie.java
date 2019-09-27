package Work;
/*假设您有一个网络电影表和每个电影的下载数量，
 * 由一个变量HashMap< movie, Integer> downloads定义。
 * 为下载最多的方法编写签名和主体，该方法返回下载次数最多的电影对象。
 */
import java.util.HashMap;
import java.util.Scanner;

public class TestMovie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Movie, Integer> downloads=new HashMap<>();
		Movie movie1=new Movie("无双");
		Movie movie2=new Movie("影");
		Movie movie3=new Movie("雪怪大冒险");
		Movie movie4=new Movie("无敌原始人");
		
		downloads.put(movie1, 8050);
		downloads.put(movie2,5605);
		downloads.put(movie3, 6000);
		downloads.put(movie4, 8222);
		System.out.print(Write(downloads));
	}
	public static Movie Write(HashMap<Movie, Integer> download) {
		Scanner in=new Scanner(System.in);
		int maxOfDownload=0;
		for(Movie movie:download.keySet()) {
			if(maxOfDownload<download.get(movie)) {
				maxOfDownload=download.get(movie);
			}
		}
		Movie tempofMovie = null;
		for(Movie movie:download.keySet()) {
			if(download.get(movie)==maxOfDownload) {
				System.out.print("输入电影标签：");
				String tempOfSignature=in.next();
				System.out.print("输入电影内容简介：");
				String tempOfBody=in.next();
				System.out.print("\n ");
				movie.setSignature(tempOfSignature);
				movie.setBody(tempOfBody);
				tempofMovie=movie;
			}
		}
		return tempofMovie;
		
	}
}
