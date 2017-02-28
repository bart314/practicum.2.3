package factory;

public interface Document {
	public void open();
	public void close();
	public void save(String filename);
}

