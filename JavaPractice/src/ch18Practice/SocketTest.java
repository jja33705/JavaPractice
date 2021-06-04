package ch18Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketTest {
	public static void main(String[] args) {
		try (Socket socket = new Socket("time-c.nist.gov", 13)) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("종료합니다...");
	}
}
