package note.vo;

public class person {
	private int id;
	private String userName;
	private String password;
	private String email;
	private int flag;
	private int active;
	private String image;
	public person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public person(int id, String userName, String password, String email, int flag, int active, String image) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.flag = flag;
		this.active = active;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
