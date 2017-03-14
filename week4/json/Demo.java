package json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Demo {
	public static void main(String[] args) throws Exception {
		JSONParser parser = new JSONParser();
		String data = "";
		data = getData("http://localhost/~bart/demo.json");

		JSONObject obj = (JSONObject)parser.parse(data);
		// see http://stackoverflow.com/questions/4296496/type-safety-warning-with-json-iterator
		Iterator<?> keys = obj.keySet().iterator();

		while (keys.hasNext()) {
			// wat is er mis met de twee onderstaande regels?
			String key = (String)keys.next();
			JSONObject foo = (JSONObject)obj.get(key);
			System.out.println(foo.get("quote"));
		}
	}

	static String getData(String url) throws IOException {
		InputStream str = new URL(url).openStream();
		String rv;

		BufferedReader rd = new BufferedReader(new InputStreamReader(str, Charset.forName("UTF-8")));
		StringBuilder builder = new StringBuilder();
		int input;
		while ((input = rd.read()) != -1) {
			builder.append((char)input);
		}
		rv = builder.toString();

		return rv;
	}
}
