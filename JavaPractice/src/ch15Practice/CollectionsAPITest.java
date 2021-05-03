package ch15Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsAPITest {

	public static void main(String[] args) {
		sortTest();
		shuffleTest();
		binarySearch();
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		int idx = myBinarySearch(list, 24);
		if(idx > 0) {
			System.out.println((idx + 1) + "번째 위치에 있습니다.");
		} else {
			System.out.println("없습니다.");
		}
		
		List<String> list2 = new ArrayList<>();
		list2.add("scpark");
		list2.add("seungjae");
		list2.add("mb");
		list2.add("mcmh");
		Collections.sort(list2);
		System.out.println(myBinarySearch(list2, "mb"));
		
		
		test1(list);
		test1(list2);
	}
	
	public static void test1(List<? extends Object> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+ " ");
		}
		System.out.println();
	}
	
	public static <T extends Comparable<T>> int myBinarySearch(List<T> list, T key) {
		int left = 0;
		int right = list.size() - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(list.get(mid) == key) return mid;
			if(list.get(mid).compareTo(key) > 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return left * (-1);
	}
	
	public static void binarySearch() {
		// 수만개의 정수 원소를 가진 리스트에서 내가 찾고자 하는 값(예를 들면 123)
		// 이 있는지, 어디에 있는지를 찾고자 한다. 어떻게 해야하나?
		// 만약에, 리스트의 원소가 정렬되어 있다면?
		// 만개의 원소에서 내가 원하는 값 찾기를 할 때
		// 최대 몇 번의 비교를 해야할까?
		
		// 이진탐색을 하기위한 대전제 조건은?
		// 리스트의 원소가 정렬되어 있어야 한다.
		
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		
		int idx = Collections.binarySearch(list, 7);
		if (idx > 0) {
			System.out.println((idx + 1) + "번째 위치에 있습니다.");
		} else {
			System.out.println("7은 리스트에 없습니다.");
		}
	}
	
	public static void shuffleTest() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		System.out.println("After shuffling");
		Collections.shuffle(list);
		
		System.out.println(list);
	}
	
	public static void sortTest() {
		String[] sample = {"i", "walk", "The", "Line"};
		System.out.println(Arrays.toString(sample));
		System.out.println("After sorting");
		List<String> list = Arrays.asList(sample);
		Collections.sort(list, (o1, o2) -> o1.compareToIgnoreCase(o2));
		System.out.println(list);
	}

}
