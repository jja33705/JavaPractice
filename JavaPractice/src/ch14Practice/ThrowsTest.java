package ch14Practice;

import java.io.IOException;

public class ThrowsTest {

	public static void main(String[] args) {
		try {
			System.out.println(readString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String readString() throws IOException {
		byte[] buf = new byte[100];
		System.out.println("���ڿ��� �Է��Ͻÿ�: ");
		System.in.read(buf);
		return new String(buf);
	}

}
