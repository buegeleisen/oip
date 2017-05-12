package objects;

public class Individual implements Comparable<Individual>, Cloneable {
	
	private String solutionCandidateId;
	private Double[] solutionVector;
	private Double resultValue;
	private boolean isFeasible;
	private boolean isEvaluated;
	



	public Individual(String solutionCandidateId, Double[] solutionVector, Double resultValue, boolean isFeasible, boolean isEvaluated){
		this.solutionCandidateId = solutionCandidateId;
		this.solutionVector = solutionVector;
		this.resultValue = resultValue;
		this.isFeasible = isFeasible;
		this.isEvaluated = isEvaluated;
	}

	public int compareTo(Individual i) {
		if (resultValue < i.resultValue) {
			return -1;
		} else if (resultValue > i.resultValue) {
			return 1;
		}
		return 0;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public String getSolutionCandidateId() {
		return solutionCandidateId;
	}




	public void setSolutionCandidateId(String solutionCandidateId) {
		this.solutionCandidateId = solutionCandidateId;
	}




	public Double[] getSolutionVector() {
		return solutionVector;
	}




	public void setSolutionVector(Double[] solutionVector) {
		this.solutionVector = solutionVector;
	}




	public Double getResultValue() {
		return resultValue;
	}




	public void setResultValue(Double resultValue) {
		this.resultValue = resultValue;
	}




	public boolean isFeasible() {
		return isFeasible;
	}




	public void setFeasible(boolean isFeasable) {
		this.isFeasible = isFeasable;
	}




	public boolean isEvaluated() {
		return isEvaluated;
	}




	public void setEvaluated(boolean isEvaluated) {
		this.isEvaluated = isEvaluated;
	}


	
}
