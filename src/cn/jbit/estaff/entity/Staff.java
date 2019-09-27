package cn.jbit.estaff.entity;


public class Staff  extends User{

	private String id;
	private String jobOfNumber;
	private String name;
	private String sex;
	private int age;
	private String department;
	private String position;
	private String dateOnBoard;
	private String departureDate;
	private int workingYears;
	private String idNumber;
	private String educationBackground;
	private String familyAddress;
	private String phoneNumber;
	private String mailBox;
	private String picture;
	
	public Staff(String id, String jobOfNumber, String userOfname, String password, String post, String id2,
			String jobOfNumber2, String name, String sex, int age, String department, String position,
			String dateOnBoard, String departureDate, int workingYears, String idNumber, String educationBackground,
			String familyAddress, String phoneNumber, String mailBox, String picture) {
		super(id, jobOfNumber, userOfname, password, post);
		id = id2;
		jobOfNumber = jobOfNumber2;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.department = department;
		this.position = position;
		this.dateOnBoard = dateOnBoard;
		this.departureDate = departureDate;
		this.workingYears = workingYears;
		this.idNumber = idNumber;
		this.educationBackground = educationBackground;
		this.familyAddress = familyAddress;
		this.phoneNumber = phoneNumber;
		this.mailBox = mailBox;
		this.picture = picture;
	}
	
	public Staff(String jobOfNumber, String UserOfnamee) {
		this.jobOfNumber = jobOfNumber;
		this.name = name;
		
	}
	public Staff() {}
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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDateOnBoard() {
		return dateOnBoard;
	}

	public void setDateOnBoard(String dateOnBoard) {
		this.dateOnBoard = dateOnBoard;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public int getWorkingYears() {
		return workingYears;
	}

	public void setWorkingYears(int workingYears) {
		this.workingYears = workingYears;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getEducationBackground() {
		return educationBackground;
	}

	public void setEducationBackground(String educationBackground) {
		this.educationBackground = educationBackground;
	}

	public String getFamilyAddress() {
		return familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMailBox() {
		return mailBox;
	}

	public void setMailBox(String mailBox) {
		this.mailBox = mailBox;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	
	
}
