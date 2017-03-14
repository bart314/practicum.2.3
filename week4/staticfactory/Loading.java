package staticfactory;

public class Loading {
	private String lazyParam;
	
	protected String getParam() {
		if (lazyParam.equals("")) {
			setParam("default value");
		}
		
		return lazyParam;
	}
	
	protected void setParam(String val) {
		lazyParam = val;
	}
	

}
