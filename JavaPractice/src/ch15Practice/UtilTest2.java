package ch15Practice;

import java.util.ArrayList;

public class UtilTest2 {
	public static void main(String[] args) {
		Number n = Integer.valueOf(100); //Number와 Integer사이에는 부모자식관계가 성립한다.
		
		// ArrayList<Number> list = new ArrayList<Integer>();  ArrayList<Number>와 ArrayList<Integer>사이에는 성립하지 않음.
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		// process1(list);      ArrayList<Number>와 ArrayList<Integer>사이에는 성립하지 않음.
		
		ArrayList<Double> list2 = new ArrayList<Double>();
		// process1(list2);     ArrayList<Number>와 ArrayList<Double>사이에는 성립하지 않음.
		
		process(list);
		process(list2);
		
		/*Generic은 왜 쓰노?
			로직은 같고 내부적으로 사용사는 데이터의 타입만 다른 경우에도, 하나의 클래스만 생성해서 사용할 수 있도록 하기 위해서.
			실제로 사용할 데이터 타입은 객체 생성 시에 type parameter로 받아서 처리. 그리고, 명시적인 type casting도 안해도 되도록 하기 위해서.
		*/
	}
	
	public static void process(ArrayList<? extends Number> list) {   //number를 상속하고 있는 타입이라면 가능
		
	}
	
	public static void process1(ArrayList<Number> list) {
		
	}
}
