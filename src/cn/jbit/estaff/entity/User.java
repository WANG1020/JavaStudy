package cn.jbit.estaff.entity;

public class User {
	private String id;
	private String jobOfNumber;
	private String userOfname;
	private String password;
	private String post;//身份，三种身份，超级管理员，普通管理员，管理员
	
	public User(String id, String jobOfNumber, String userOfname, String password, String post) {
		super();
		this.id = id;
		this.jobOfNumber = jobOfNumber;
		this.userOfname = userOfname;
		this.password = password;
		this.post = post;
	}
	public User(String jobOfNumber, String userOfname) {
		this.jobOfNumber = jobOfNumber;
		this.userOfname = userOfname;
	}
	public User(String jobOfNumber) {
		this.jobOfNumber = jobOfNumber;
	}
	public User() {
	
	}
	public User(String jobOfNumber,String password, String post) {
		this.jobOfNumber = jobOfNumber;
		this.password = password;
		this.post = post;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJobOfNumber() {
		return jobOfNumber;
	}
	public void setJobOfNumber(String jobOfNumber) {
		this.jobOfNumber = jobOfNumber;
	}
	public String getName() {
		return userOfname;
	}
	public void setName(String name) {
		this.userOfname = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
}
