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
	}
	
	public static void process(ArrayList<? extends Number> list) {   //number를 상속하고 있는 타입이라면 가능
		
	}
	
	public static void process1(ArrayList<Number> list) {
		
	}
}
