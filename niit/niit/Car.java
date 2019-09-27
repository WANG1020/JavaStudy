package Software.niit;

public final class  Car extends MotoVehicle{
	
	private String sType;
	
	public String getsType() {
		return sType;
	}
	public void setsType(String sType) {
		this.sType = sType;
	}
	public Car(String sNo, String sBrand, int sMileage, String sColor, String sType) {
		super(sNo, sBrand, sMileage, sColor);
		this.sType = sType;
	}
	public Car(String sNo, String sType) {
		super(sNo);
		this.sType = sType;
	}
	public  int CalcRent(int days) {
		int rent=0;
	    if("别克商务舱GL8".equals(sType)){
	    	 rent=600*days;
	    }
	    if("别克林荫大道".equals(sType)){
	    	 rent=300*days;
	    }
	    if("宝马550i".equals(sType)) {
	    	rent=500*days;
	    }

		return rent;
		
	}

}