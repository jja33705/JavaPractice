package ch15Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcard {

	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1, 2, 3);
		System.out.println("sum: " + sumOfList(li));
		
		List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
		System.out.println("sum: " + sumOfList(ld));
		
		
		List<Integer> li2 = Arrays.asList(1, 2, 3);
		printList(li2);
		
		List<String> ls = Arrays.asList("one", "two", "three");
		printList(ls);
		
		List<Integer> li3 = new ArrayList<>();
		addNumbers(li3);
		System.out.println(li3);
	}
	
	public static double sumOfList(List<? extends Number> list) {
		double sum = 0;
		for(Number n : list) {
			sum += n.doubleValue();
		}
		return sum;
	}
	
	public static void printList(List<?> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void addNumbers(List<? super Integer> list) {
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
	}
		
}
