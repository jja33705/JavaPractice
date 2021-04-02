package ch15Practice;

import java.util.ArrayList;

public class StaticTest {
	private int n1, n2;
	
	public StaticTest(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public int sum() {
		return n1+n2;
	}
	//멤버메소드(매개변수에 접근하는 메소드)는 제네릭 클래스로 구현해야 한다.
	
	public static <T extends Number> Double sum(T a, T b) {
		return a.doubleValue() + b.doubleValue();
	}
	//스태틱메소드(매개변수에 접근하지 않는 메소드)일 경우에는 제네릭 메소드로 구현할 수 있다.
	
	public static <T extends Number> Double sum(ArrayList<T> arr) {
		Double total = 0.0;
		for (int i = 0; i < arr.size(); i++) {
			total += arr.get(i).doubleValue();
		}
		return total;
	}
	
	public static Double sum2(ArrayList<? extends Number> arr) {
		Double total = 0.0;
		for (int i = 0; i < arr.size(); i++) {
			total += arr.get(i).doubleValue();
		}
		return total;
	}
	
	public static void main(String[] args) {
		StaticTest st = new StaticTest(10, 30);
		System.out.println(st.sum());
		
		System.out.println(StaticTest.sum(10, 20));
	}
}
