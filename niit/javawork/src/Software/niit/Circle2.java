package Software.niit;

public  class Circle2 {
	private double radius;

	
	
	public Circle2(double radius) {
		this.radius = radius;
	}
	public Circle2() {
		radius = 0;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public  double getArea()
	{
		return Math.PI*this.radius*this.radius;
	}
	public  double getPerimeter()
	{
		return 2*Math.PI*this.radius;
	}
	public void show() {
		System.out.println("半径为："+this.radius);
		System.out.println("面积为："+getArea());
		System.out.println("周长为："+getPerimeter());
	}
}

