package ch14Practice;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TryResourceTest {
	
	public static void main(String[] args) {
		writeList();
	}
	
	public static void writeList() {
		PrintWriter out = null;
		try {
			out = new PrintWriter("C:/myFile/outfile.txt");
			for (int i = 0; i < 10; i++) {
				out.println("배열 원소  " + i + " = " + i);
			}
			out.close();
			System.out.println("파일을 닫았습니다...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if(out !=null) {
				out.close();
				System.out.println("파일을 닫았습니다.");
			}
		}
		try (PrintWriter out2 = new PrintWriter("outfile.txt")) {
		for (int i = 0; i < 10; i++) {
			out2.println("배열 원소" +  i + " = " + i);
		}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}         //AutoCloseable을 구현하면 자동으로 close해줌
		try(MyResource rc = new MyResource()){
			System.out.println(rc.getValue());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
