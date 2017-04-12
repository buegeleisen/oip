package functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rastrigin {
	private int a = 20;
	
	public Rastrigin() {
		// TODO Auto-generated constructor stub
	}
	
	public Rastrigin(int a){
		this.a = a;
	}
	
	public double compute(double x, double y){
		double result = a + x * x + y* y - 10 * (Math.cos(2*Math.PI*x)+Math.cos(2*Math.PI*y));
		return round(result, 4);
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
