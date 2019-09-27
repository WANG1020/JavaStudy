package Software.niit;

public class Squareness {
	private int length;
	private int width;
	public Squareness(int length, int width) {
		this.length = length;
		this.width = width;
	}
	public Squareness() {
		this.length = 0;
		this.width = 0;
	}
	public int area() {
		int squa;
		squa=this.length*this.width;
		return squa;
	}
}