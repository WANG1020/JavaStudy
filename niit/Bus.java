package Software.niit;

public final class  Bus extends MotoVehicle{
	private int sSeatCount;

	public int getsSeatCount() {
		return sSeatCount;
	}
	public void setsSeatCount(int sSeatCount) {
		this.sSeatCount = sSeatCount;
	}
	public Bus(String sNo, String sBrand, int sMileage, String sColor, int sSeatCount) {
		super(sNo, sBrand, sMileage, sColor);
		this.sSeatCount = sSeatCount;
	}
	public Bus(String sNo, String sBrand, int sSeatCount) {
		super(sNo, sBrand);
		this.sSeatCount = sSeatCount;
	}
	public Bus(String sBrand, int sSeatCount) {
		super(sBrand);
		this.sSeatCount = sSeatCount;
	}
    public  int CalcRent(int days) {
    	int rend=0;
		if(sSeatCount<=16) {
			rend=800*days;
		}
		else {
			rend=1500*days;
		}
		return rend;
	}
}

