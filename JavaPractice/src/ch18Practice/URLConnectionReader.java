package ch18Practice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
	
	public static void main(String[] args) {
		try {
			// 1. URL ��ü�� ����
			URL site = new URL("https://www.naver.com");
			
			// 2. ���� ����
			URLConnection con = site.openConnection();
		
			// 3. ����κ��� ��Ʈ���� ���� �Ѵ�.
			
			InputStream stream = con.getInputStream();
			
			InputStreamReader streamReader = new InputStreamReader(stream);
			
			BufferedReader reader = new BufferedReader(streamReader);
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
