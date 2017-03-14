package staticfactory;

public class Demo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// static factory methods have names
		PrimeNumber p1 = PrimeNumber.getNormalPrime();
		PrimeNumber p2 = PrimeNumber.getMersennePrime();
		PrimeNumber p3 = PrimeNumber.getWoodallPrime();
		
		// static factory methods allow for managed control
		for (int i=0;i<15; i++) {
			ManagedResource.getInstance();
		}
		
		// static factory methodes can return any of the subclasses of the instance:
		Document xml = Document.getDocument("xml");
		Document json = Document.getDocument("json");
	}
}
