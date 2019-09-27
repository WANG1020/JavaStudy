package cn.jbit.estaff.entity;

public class Sector {
	private String id;
	private String name;
	private String departmentManager;
	private String contctInformation;
	private String introduction ;

	public Sector(String id, String name, String departmentManager, String contctInformation, String introduction) {
		this.id = id;
		this.name = name;
		this.departmentManager = departmentManager;
		this.contctInformation = contctInformation;
		this.introduction = introduction;
	}
	public Sector() {}
	public Sector( String name) {	
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(String departmentManager) {
		this.departmentManager = departmentManager;
	}

	public String getContctInformation() {
		return contctInformation;
	}

	public void setContctInformation(String contctInformation) {
		this.contctInformation = contctInformation;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	
}
