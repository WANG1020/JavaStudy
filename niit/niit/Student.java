package Software.niit;


public class Student {

	private String sNO;
	private String sName;
	private String sSex;
	private int sAge;
	private int sJava;
	
	public String getsNO() {
		return sNO;
	}
	public void setsNO(String sNO) {
		this.sNO = sNO;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsSex() {
		return sSex;
	}
	public void setsSex(String sSex) {
		this.sSex = sSex;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	public int getsJava() {
		return sJava;
	}
	public void setsJava(int sJava) {
		this.sJava = sJava;
	}
	
	
	public Student(String sNO, String sName, String sSex, int sAge, int sJava) {
		this.sNO = sNO;
		this.sName = sName;
		this.sSex = sSex;
		this.sAge = sAge;
		this.sJava = sJava;
	}
	public Student() {
		
	}
	
	public Student(String sNO) {
		this.sNO = sNO;
	}
	
	public Student(String sNO, String sName) {
		this.sNO = sNO;
		this.sName = sName;
	}
	public Student(String sNO, String sName, String sSex) {
		this.sNO = sNO;
		this.sName = sName;
		this.sSex = sSex;
	}
	
	public Student(String sNO, String sName, String sSex, int sAge) {
		this.sNO = sNO;
		this.sName = sName;
		this.sSex = sSex;
		this.sAge = sAge;
	}
	
	public void print() {
		System.out.println("sName:"+sName+"\nsNO"+sNO+"\nsSex"+sSex+"\nsAge"+sAge+"\nsJava"+sJava);
	}
}

