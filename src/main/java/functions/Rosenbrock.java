package functions;

public class Rosenbrock {
	private int a = 1;
	private int b = 100;
	
	public Rosenbrock() {
		// TODO Auto-generated constructor stub
	}
	
	public Rosenbrock(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public double compute(double x, double y) { 
		  final int a=1; 
		  final int b=100; 
		  return Math.pow(a-x,2)+b*Math.pow((y-Math.pow(x,2)),2); 
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	} 
	
	
}
