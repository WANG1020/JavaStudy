package Software.niit;

public abstract class MotoVehicle {
	private String sNo;
	private String sBrand;
	private int sMileage;//¿Ô≥Ã
	private String sColor;
	
	public MotoVehicle(String sNo, String sBrand, int sMileage, String sColor) {
		this.sNo = sNo;
		this.sBrand = sBrand;
		this.sMileage = sMileage;
		this.sColor = sColor;
	}
	public MotoVehicle(String sNo, String sBrand) {
		this.sNo = sNo;
		this.sBrand = sBrand;
		this.sMileage = sMileage;
		this.sColor = sColor;
	}
	public MotoVehicle(String sNo) {
		this.sNo = sNo;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getsBrand() {
		return sBrand;
	}
	public void setsBrand(String sBrand) {
		this.sBrand = sBrand;
	}
	public int getsMileage(){
		return sMileage;
	}
	public void setsMileage(int sMileage) {
		this.sMileage = sMileage;
	}
	public String getsColor() {
		return sColor;
	}
	public void setsColor(String sColor) {
		this.sColor = sColor;
	}
	public abstract int CalcRent(int days) ;
	
	
}