package staticfactory;

public class PrimeNumber {
	private Integer prime;
	
	private PrimeNumber(Integer p) {
		prime = p;
	}
	
	protected Integer nextPrime(){
		// doe ingewikkelde mathematische dingen
		return prime + 96;
	}
	
	
	static PrimeNumber getNormalPrime() {
		return new PrimeNumber(5);
	}
	
	static PrimeNumber getMersennePrime() {
		return new PrimeNumber(31);
	}
	
	static PrimeNumber getWoodallPrime() {
		return new PrimeNumber(7);
	}

}
