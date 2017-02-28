package decorator;

public class ClearText implements Encryptable {
	private String txt;
	
	ClearText(String foo) {
		txt = foo;
	}
	
	public String getData() {
		return txt;
	}
}
