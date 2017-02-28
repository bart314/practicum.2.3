package factory;

public class Demo {
	public static void main(String[] args) {
		// depending on requirements, I can easy change the type
		// of document I want. I can also easy add a new kind of 
		// document to this architecture.
		
		DocumentFactory factory = new JSONFactory();
		Document foo = factory.makeDocument();
		
		
		// this never has to change, so long as the interface
		// stay the same.
		foo.open();
		foo.save("Nieuwe_naam");
		foo.close();
	}

}
