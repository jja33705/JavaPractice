package ch18Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPURLPostTest {
	public static void main(String[] args) {
		try {
			String site = "http://127.0.0.1:8082/todos";
			
			URL url = new URL(site);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setDoInput(true);
			con.setDoOutput(true);
			
			con.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			
			String data = "id=scpark&pw=1111";
//			StringBuffer buffer = new StringBuffer();
//			buffer.append("id=scpark&pw=1111");
//			buffer.append("id=scpark").append("pw=1111");
//			data = "id=scpark" + "&pw=1111";
			
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
			
			writer.println(data);
			writer.flush();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			
		}
		
	}
}
