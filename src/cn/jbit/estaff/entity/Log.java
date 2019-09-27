package cn.jbit.estaff.entity;


public class Log {
	private String id;
	private String jobOfNumber;
	private String name;
	private String operation;
	private String operationTime;


	public Log(String id, String jobOfNumber, String name, String operation, String operationTime) {
		this.id = id;
		this.jobOfNumber = jobOfNumber;
		this.name = name;
		this.operation = operation;
		this.operationTime = operationTime;
	}
	public Log() {}
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


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}


	public String getOperationTime() {
		return operationTime;
	}


	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}


	
}
