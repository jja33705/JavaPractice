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
		 * 합집합: addAll()
		 * 교집합: retainAll()
		 * 차집합: removeAll()
		 */
		/*
		 * set1: {1, 3, 4, 5, 7, 9, 10}
		 * set2: {2, 4, 10}
		 * set1 차집합 set2 : {1, 2, 3, 4, 5, 7, 9, 10}
		 * set1 교집합 set2: {4, 10}
		 * set1 차집합 set2: {1, 3, 5, 7, 9}
		 */
		Integer[] arr1 = {1, 3, 4, 5, 7, 9, 10};
		List<Integer> list1 = Arrays.asList(arr1);  //어레이리스트로 바꿔 줌
		Set<Integer> set1 = new HashSet<>(list1);
		
		Integer[] arr2 = {2, 4, 10};
		List<Integer> list2 = Arrays.asList(arr2);
		Set<Integer> set2 = new HashSet<>(list2);
		
		//합집합
		//set1.addAll(set2); 원본 데이터가 변경됨
		Set<Integer> unionSet = new HashSet<>(set1);
		unionSet.addAll(set2);
		System.out.println("합집합: " + unionSet);
		
		//교집합
		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
		System.out.println("교집합: " + intersectionSet);
		
		//차집합
		Set<Integer> diffSet = new HashSet<>(set1);
		diffSet.removeAll(set2);
		System.out.println(diffSet);
		
		boolean flag = set1.containsAll(set2);
		if (flag) {
			System.out.printf("집합 %s는 집합 %s의 모든 월소를 포함합니다.", set1, set2);
		} else {
			System.out.printf("집합 %s는 집합 %s의 모든 월소를 포함하지 않습니다.", set1, set2);
		}
	}
}
