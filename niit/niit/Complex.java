package Software.niit;

public class Complex {
	private double real;
	private double imag;
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	public Complex() {
	}
	public Complex add(Complex complex) {
		Complex com=new Complex();
		com.real=this.real+complex.real;
		com.imag=this.imag+complex.imag;
		return com;
	}
	public Complex sub(Complex complex) {
		Complex com=new Complex();
		com.real=this.real-complex.real;
		com.imag=this.imag-complex.imag;
		return com;
	}

}
