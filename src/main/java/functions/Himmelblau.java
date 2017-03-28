package functions;

public class Himmelblau {
	public Himmelblau() {
		// TODO Auto-generated constructor stub
	}
	
	public double compute(double x, double y){
		return Math.pow((x * x + y - 11), 2) + Math.pow((x + y * y - 7), 2);
	}
}
