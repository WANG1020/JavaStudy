package cn.jbit.estaff.entity;

public class Attendance {

	private String id;
	private String jobOfNumber;
	private String name;
	private String workday ;
	
	public Attendance(String id, String jobOfNumber, String name, String workday) {
	
		this.id = id;
		this.jobOfNumber = jobOfNumber;
		this.name = name;
		this.workday = workday;
	}
	public Attendance() {}
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

	public String getWorkday() {
		return workday;
	}

	public void setWorkday(String workday) {
		this.workday = workday;
	}
}
