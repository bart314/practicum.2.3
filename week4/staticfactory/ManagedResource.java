package staticfactory;

import java.util.ArrayList;
import java.util.Iterator;

// instance controlled class
public class ManagedResource {
	static ArrayList<ManagedResource> instances = new ArrayList<>();
	static final int MAX_POOL_SIZE = 10;
	
	private ManagedResource () {
		System.out.println("Creating managed resource number " +instances.size());
	}
	
	private boolean isReady() {
		System.out.println("Checking whether this resource is ready.");
		if (Math.random() < .5) {
			System.out.println("Resource busy; try again later.");
			return false;
		} else {
			System.out.println("Resource ready to be used again.");
			return true;
		}
	}
	
	
	static ManagedResource getInstance() {
		// eerst kun je bijvoorbeeld kijken of er nog slots te vergeven zijn.
		if (instances.size()<=MAX_POOL_SIZE) {
			ManagedResource foo = new ManagedResource();
			instances.add(foo);
			return foo;
		}
		
		// in het andere geval zou je iets moeten doen met 
		// lock and wait; en geef je de eerste instantie terug die niets te doen heeft
		// (dit is uiteraard een slechts realisatie, alleen voor de demonstratie)
		boolean found = false;
		ManagedResource tmp=null;;
		while (!found) {
			Iterator<ManagedResource> itr = instances.iterator();
			while(itr.hasNext()) {
				tmp = itr.next();
				if (tmp.isReady()) {
					found = true;
					break;
				}
			}
		}
		return tmp;
	}

}
