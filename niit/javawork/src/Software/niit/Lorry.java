package Software.niit;

public final class Lorry extends MotoVehicle {
	private int tonnage;

	public Lorry(String sNo, String sBrand, int sMileage, String sColor, int tonnage) {
		super(sNo, sBrand, sMileage, sColor);
		this.tonnage = tonnage;
	}
	public Lorry(String sNo, String sBrand, int tonnage) {
		super(sNo, sBrand);
		this.tonnage = tonnage;
	}
	public int getTonnage() {
		return tonnage;
	}

	public void setTonnage(int tonnage) {
		this.tonnage = tonnage;
	}
	
	  public  int CalcRent(int days) {
			return this.tonnage*50;
		}
}
