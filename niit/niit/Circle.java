package Software.niit;

public class Circle {
	private double radius;
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public Circle(double radius) 
	{
		this.radius = radius;
	}
	public Circle()
	{
	}
	
	public double area()
	{
		return Math.PI*this.radius*this.radius;
	}
	public double girth()
	{
		return 2*Math.PI*this.radius;
	}
}