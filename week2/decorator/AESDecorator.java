package decorator;

public class AESDecorator extends EncryptionDecorator {
	private String AESDecrypted;
	
	public AESDecorator(Encryptable txt) {
		super(txt);
		AESDecrypted = "\n\tAES Encrypted";
		System.out.println("AES Decorator created.");
	}

	@Override
	public String getData() {
		String rv = super.getData();
		return rv + this.AESDecrypted;
		
	}

	@Override
	String showDecriptedData() {
		return null;
	}

}
