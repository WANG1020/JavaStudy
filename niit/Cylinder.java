package Software.niit;

public  final  class Cylinder extends Circle2 {
	private double hight;

	public Cylinder(double radius, double hight) {
		super(radius);
		this.hight = hight;
	}
	public double getVolume(){
		return this.hight*super.getArea();
	}
	public void showVolume() {
		System.out.print("圆的体积"+this.getVolume());
	}
}