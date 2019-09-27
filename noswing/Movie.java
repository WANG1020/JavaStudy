package Work;
/*假设您有一个网络电影表和每个电影的下载数量，
 * 由一个变量HashMap< movie, Integer> downloads定义。
 * 为下载最多的方法编写标签(识别标志)和内容，该方法返回下载次数最多的电影对象。
 */
public class Movie {
	private String nameofMovie;
	private String signature;
	private String body;
	
	public Movie(String nameofMovie) {
		this.nameofMovie = nameofMovie;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String toString() {
		String string="电影名："+nameofMovie+"\n标签："+signature+"\n内容："+body;
		return string;
	}
}
