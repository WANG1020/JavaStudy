package cn.jbit.estaff.entity;

public class SignIn {

	private String id;
	private String jobOfNumber;
	private String name;
	private String signedNumber;
	private String signenTime;

	public SignIn(String id, String jobOfNumber, String name, String signedNumber, String signenTime) {
	
		this.id = id;
		this.jobOfNumber = jobOfNumber;
		this.name = name;
		this.signedNumber = signedNumber;
		this.signenTime = signenTime;
	}
	public SignIn() {}
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

	public String getSignedNumber() {
		return signedNumber;
	}

	public void setSignedNumber(String signedNumber) {
		this.signedNumber = signedNumber;
	}

	public String getSignenTime() {
		return signenTime;
	}

	public void setSignenTime(String signenTime) {
		this.signenTime = signenTime;
	}

}
