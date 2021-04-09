package ch15Practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		test1();
	}
	private static void test1() {
		/*
		 * ������: addAll()
		 * ������: retainAll()
		 * ������: removeAll()
		 */
		/*
		 * set1: {1, 3, 4, 5, 7, 9, 10}
		 * set2: {2, 4, 10}
		 * set1 ������ set2 : {1, 2, 3, 4, 5, 7, 9, 10}
		 * set1 ������ set2: {4, 10}
		 * set1 ������ set2: {1, 3, 5, 7, 9}
		 */
		Integer[] arr1 = {1, 3, 4, 5, 7, 9, 10};
		List<Integer> list1 = Arrays.asList(arr1);  //��̸���Ʈ�� �ٲ� ��
		Set<Integer> set1 = new HashSet<>(list1);
		
		Integer[] arr2 = {2, 4, 10};
		List<Integer> list2 = Arrays.asList(arr2);
		Set<Integer> set2 = new HashSet<>(list2);
		
		//������
		//set1.addAll(set2); ���� �����Ͱ� �����
		Set<Integer> unionSet = new HashSet<>(set1);
		unionSet.addAll(set2);
		System.out.println("������: " + unionSet);
		
		//������
		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
		System.out.println("������: " + intersectionSet);
		
		//������
		Set<Integer> diffSet = new HashSet<>(set1);
		diffSet.removeAll(set2);
		System.out.println(diffSet);
		
		boolean flag = set1.containsAll(set2);
		if (flag) {
			System.out.printf("���� %s�� ���� %s�� ��� ���Ҹ� �����մϴ�.", set1, set2);
		} else {
			System.out.printf("���� %s�� ���� %s�� ��� ���Ҹ� �������� �ʽ��ϴ�.", set1, set2);
		}
	}
}
