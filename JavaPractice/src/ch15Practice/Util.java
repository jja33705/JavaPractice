package ch15Practice;

import java.util.List;

public class Util {
	
	public static <T extends Comparable<T>> T getMax(T[] arr) {  //제네릭에 쓸떄는 인테페이스도 extends
		T max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(max.compareTo(arr[i])<0) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static <T extends Number> void printValueOf5Times(T value) {
		Double result = value.doubleValue() * 5;
		System.out.println(result);
	}
	
	public static <T extends Number> void printSum(List<T> list) {
		Double sum = 0.0;
		for(T val : list) {
			sum += val.doubleValue();
		}
		System.out.println("sum: " + sum);
	}
	
	public static void printSum2(List<? extends Number> list) {  //와일드카드 .넘버아래면 뭐라도 좋다.
		Double sum = 0.0;
		for(Number val : list) {           //와일드카드를 사용했기에 넘버타입에 넣을 수 있다는게 보장된다.
			sum += val.doubleValue();
		}
		System.out.println("sum: " + sum);
	}
	
	public static void printSum3(List<Number> list) {
		Double sum = 0.0;
		for(Number val : list) {
			sum += val.doubleValue();
		}
		System.out.println("sum: " + sum);
	}
	
	public static <T> void println(T[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}
}
