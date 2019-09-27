package cn.jbit.estaff.entity;

public class Salary {

	private String id;
	private String jobOfNumber;
	private String name;
	private String baseSalary;
	private String overtimeSslary;
	private String subsidy;
	private String attendnceBonus;
	private String penalty;
	private String total;
	private String issueDate;
	
	
	public Salary(String id, String jobOfNumber, String name, String baseSalary, String overtimeSslary, String subsidy,
			String attendnceBonus, String penalty, String total, String issueDate) {
		super();
		this.id = id;
		this.jobOfNumber = jobOfNumber;
		this.name = name;
		this.baseSalary = baseSalary;
		this.overtimeSslary = overtimeSslary;
		this.subsidy = subsidy;
		this.attendnceBonus = attendnceBonus;
		this.penalty = penalty;
		this.total = total;
		this.issueDate = issueDate;
	}
	public Salary() {}
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


	public String getBaseSalary() {
		return baseSalary;
	}


	public void setBaseSalary(String baseSalary) {
		this.baseSalary = baseSalary;
	}


	public String getOvertimeSslary() {
		return overtimeSslary;
	}


	public void setOvertimeSslary(String overtimeSslary) {
		this.overtimeSslary = overtimeSslary;
	}


	public String getSubsidy() {
		return subsidy;
	}


	public void setSubsidy(String subsidy) {
		this.subsidy = subsidy;
	}


	public String getAttendnceBonus() {
		return attendnceBonus;
	}


	public void setAttendnceBonus(String attendnceBonus) {
		this.attendnceBonus = attendnceBonus;
	}


	public String getPenalty() {
		return penalty;
	}


	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public String getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

}
