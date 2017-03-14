package staticfactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// let op: er zijn verschillende libraries met JSONArray.
// org.json.JSONArray en org.json.simple.JSONArray; 
import org.json.JSONArray;
import com.thoughtworks.xstream.XStream;

public class Document {
	@SuppressWarnings("serial")
	protected Map<String, String> _data = new HashMap<String, String>(){
		{
			_data.put("locus", "woord");
			_data.put("zwitserland", "dal");
			_data.put("thee", "theepot");
			_data.put("gerotzooi", "gehannes");
			_data.put("een", "de");
			_data.put("fietspomp", "fietsventiel");
			_data.put("thee", "茶");
			_data.put("chinees", "中文电影");
		};
	};

	String sendableData="";


	static Document getDocument(String type) {
		return (type.equals("xml")) ? new XMLDocument() : new JSONDocument();
	}
}

class XMLDocument extends Document {
	XMLDocument() {
		XStream xs = new XStream();
		sendableData = xs.toXML(_data);
	}
}


class JSONDocument extends Document {
	JSONDocument() {
		JSONArray array = new JSONArray(Arrays.asList(_data));
		sendableData = array.toString();
	}
}
