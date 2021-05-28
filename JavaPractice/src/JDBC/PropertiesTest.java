package JDBC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {

	public static void main(String[] args) {
//		Map<String, String> env = System.getenv();
//		Set<String> keySet = env.keySet();
//		for (String key : keySet) {
//			System.out.println(key + ": " + env.get(key));
//		}
		Properties props = new Properties();
		try (FileReader reader = new FileReader("dict.props")) {
			props.load(reader);
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
//		props.put("name", "È«±æµ¿");
//		props.put("age", "20");
//		
		Set<Object> keySet2 = props.keySet();
		for (Object key : keySet2) {
			System.out.println(key + " : " + props.get(key));
		}
		
		props.put("³ª¹«", "tree");
		
		try (PrintWriter out = new PrintWriter(new File("dict.props"))){
			props.store(out, "My Dictionary");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
