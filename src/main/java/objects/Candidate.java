package objects;
import java.util.Vector;

@SuppressWarnings("serial")
public class Candidate extends Vector<Double> {
	
	public Candidate(int dimension) {
		this.dimension = dimension;
	}
	
	
	private int dimension;
	
	
	@Override
	public synchronized void addElement(Double obj) {
		if(this.size() == dimension){
			return;
		}
		else {
			super.addElement(obj);
		}
	}
	
}
