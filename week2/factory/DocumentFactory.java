package factory;

interface DocumentFactory {
	
	Document makeDocument();

}

class JSONFactory implements DocumentFactory {

	@Override
	public Document makeDocument() {
		System.out.println("Let's make an awesome JSON document.");
		return new JSONDocument();
	}
	
}


class HTMLFactory implements DocumentFactory {

	@Override
	public Document makeDocument() {
		System.out.println("This is making a HTML document.");
		return new HTMLDocument();
	}
	
}


class TEXFactory implements DocumentFactory {

	@Override
	public Document makeDocument() {
		System.out.println("This to to make a TeX Document");
		return new TEXDocument();
	}
	
}