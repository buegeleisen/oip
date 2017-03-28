package functions;

public class Eggholder {
	public Eggholder() {
		// TODO Auto-generated constructor stub
	}
	
	public double compute(double x, double y){
		double result = (-1*(y + 47)
                    *Math.sin(Math.sqrt(Math.abs(x /2 +( y + 47)))))
                    -  Math.sin(Math.sqrt(Math.abs( x - (y+47)))) * x;
        
        return result;
	}
}
