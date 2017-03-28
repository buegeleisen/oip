package functions;

public class Sphere {
	private int dimensions = 2;
	
	public Sphere() {
		
	}
	
	public Sphere(int dimensions){
		this.dimensions = dimensions;
	}
	
	public double compute(Double[] input) throws Exception{
		if(input.length != dimensions) throw new Exception("Wrong count of dimensions");
		double result = 0.0;
		for(int i = 0; i<dimensions;i++){
			result += input[i]* input[i];
		}
		return result;
	}
}
