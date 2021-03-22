package ch14Practice;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			int num = Integer.parseInt("ABC");
			System.out.println(num);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormat 예외 발생");
		}
	}
}
