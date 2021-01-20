package ch09Practice;

public class LambdaTest {

	public static void main(String[] args) {
		MyInterface hello=(a, b)->{
			int result=a*b;
			System.out.println("계산 결과는 : "+result);
		};
		hello.calculate(10, 20);
	}

}
