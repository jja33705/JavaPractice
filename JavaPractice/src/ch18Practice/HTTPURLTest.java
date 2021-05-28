package ch18Practice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPURLTest {
	public static void main(String[] args) {
		try {
			String site = "https://www.google.com/search?q=java";
			URL url = new URL(site);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			
			int code = con.getResponseCode();
			System.out.println("Response code: " + code);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String line = "";
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
