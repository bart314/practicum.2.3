package decorator;

abstract class EncryptionDecorator implements Encryptable {
	protected Encryptable clearTxt;
	
	public EncryptionDecorator(Encryptable txt) {
		this.clearTxt = txt;
		System.out.println("EncryptionDecorator created.");
	}
	
	public String getData() {
		return this.clearTxt.getData();
	}
	
	abstract String showDecriptedData();
}
