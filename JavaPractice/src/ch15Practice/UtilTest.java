package ch15Practice;

import java.util.Arrays;

public class UtilTest {
	public static void main(String[] args) {
		Integer[] arr = {3, 4, 2, 10, 38, 76, 92, 124, 13, 24};
		System.out.println("�迭�� ��");
		Util.println(arr);
		System.out.println("�ִ밪: "+Util.getMax(arr));
		
		Double[] arr2 = {3.0, 4.0, 38.0, 76.0};
		System.out.println("�迭�� ��");
		Util.println(arr2);
		System.out.println("�ִ밪: "+Util.getMax(arr2));
		
		String[] arr3 = {"���ع���", "��λ���", "������", "�⵵��"};
		System.out.println("�迭�� ��");
		Util.println(arr3);
		System.out.println("�ִ밪: "+Util.getMax(arr3));
		
		Student[] arr4 = {new Student("��", 78), new Student("��", 88), new Student("��", 66), new Student("��", 56)};
		System.out.println("�迭�� ��");
		Util.println(arr4);
		System.out.println("�ִ밪: "+Util.getMax(arr4));
		
		Util.printValueOf5Times(12);
		Util.printValueOf5Times(349.9);
		
		Util.printSum(Arrays.asList(arr));
	}
}
