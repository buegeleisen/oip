package functions;

public class Easom {
	public Easom() {
		
	}
	
	public double compute(double x, double y){
		return -Math.cos(x) * Math.cos(y) * Math.exp(-(((x - Math.PI) * (x - Math.PI)) + ((y - Math.PI) * (y - Math.PI))));
	}
}
