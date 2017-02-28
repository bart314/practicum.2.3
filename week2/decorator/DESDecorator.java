package decorator;

public class DESDecorator extends EncryptionDecorator {
	private String desDecrypted;

	public DESDecorator(Encryptable txt) {
		super(txt);
		desDecrypted = "\n\tDES encrypted.";
		System.out.println("DESDecorator created.");
	}

	@Override
	public String getData() {
		String rv = super.getData();
		return rv + this.desDecrypted;
	}

	@Override
	String showDecriptedData() {
		return null;
	}

}
