package ch15Practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Test1 {
	
	public static void main(String[] args) {
		test();
	}
	
	private void test0() {
		List<String> list = new ArrayList<>();
		list.add("Milk");
		list.add("Bread");
		list.add("Butter");
		System.out.println(list);
		
		list.add(1, "Apple");
		System.out.println(list);
		
		list.set(2, "Grape");
		System.out.println(list);
		
		list.remove(3);
		System.out.println(list);
		
		List<String> list2 = new LinkedList<>();
		list2.add("Milk");
		list2.add("Bread");
		list2.add("Butter");
		System.out.println(list2);
		
		list2.add(1, "Apple");
		System.out.println(list2);
		
		list2.set(2, "Grape");
		System.out.println(list2);
		
		list2.remove(3);
		System.out.println(list2);
		
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i) + " ");
		}
		System.out.println(list2);
		
		for (String s : list2) {
			System.out.println(s+ " ");
		}
		System.out.println(list2);
		
		Iterator<String> iter = list2.iterator();
		
		while(iter.hasNext()) {    //아직 접근하지 않은 원소가 남아있는지 반환
			System.out.println(iter.next());  //하나씩 가져온다
		}
	}
	
	private static void test() {
		List<Integer> list = new LinkedList<>();
		
		IntStream.rangeClosed(1, 100000).forEach(i -> list.add(i));
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			list.add(100, (i+1)*1000);
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("elapsed time: " + (endTime-startTime));
	}
}