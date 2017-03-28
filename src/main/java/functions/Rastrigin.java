package functions;

public class Rastrigin {
	public Rastrigin() {
		// TODO Auto-generated constructor stub
	}
	
	public double compute(double x, double y){
		return 20 + x * x + y* y - 10 * (Math.cos(2*Math.PI*x)+Math.cos(2*Math.PI*y));
	}
}
