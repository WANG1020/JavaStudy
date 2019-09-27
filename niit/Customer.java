package Software.niit;

public class Customer {
	private String account; 
	private String name;
	
	public Customer(String account, String name) {
		this.account = account;
		this.name = name;
	}

	
	
	public int CalcRent(MotoVehicle[]motos,int days){
		
		int totalRent=0;
		for(int i=0;i<motos.length;i++)
		{
			if(motos[i] instanceof Car ) {
				Car car=(Car) motos[i];
				totalRent+=car.CalcRent(days);
			}
			if(motos[i] instanceof Bus ) {
				Bus bus=(Bus) motos[i];
				totalRent+=bus.CalcRent(days);
			}
			if(motos[i] instanceof Lorry) {
				Lorry lorry=(Lorry) motos[i];
				totalRent+=lorry.CalcRent(days);
			}
		}
	    return totalRent;
	}
}