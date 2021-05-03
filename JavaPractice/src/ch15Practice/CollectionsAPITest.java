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
			System.out.println((idx + 1) + "��° ��ġ�� �ֽ��ϴ�.");
		} else {
			System.out.println("�����ϴ�.");
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
		// �������� ���� ���Ҹ� ���� ����Ʈ���� ���� ã���� �ϴ� ��(���� ��� 123)
		// �� �ִ���, ��� �ִ����� ã���� �Ѵ�. ��� �ؾ��ϳ�?
		// ���࿡, ����Ʈ�� ���Ұ� ���ĵǾ� �ִٸ�?
		// ������ ���ҿ��� ���� ���ϴ� �� ã�⸦ �� ��
		// �ִ� �� ���� �񱳸� �ؾ��ұ�?
		
		// ����Ž���� �ϱ����� ������ ������?
		// ����Ʈ�� ���Ұ� ���ĵǾ� �־�� �Ѵ�.
		
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		
		int idx = Collections.binarySearch(list, 7);
		if (idx > 0) {
			System.out.println((idx + 1) + "��° ��ġ�� �ֽ��ϴ�.");
		} else {
			System.out.println("7�� ����Ʈ�� �����ϴ�.");
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
