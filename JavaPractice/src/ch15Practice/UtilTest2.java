package ch15Practice;

import java.util.ArrayList;

public class UtilTest2 {
	public static void main(String[] args) {
		Number n = Integer.valueOf(100); //Number�� Integer���̿��� �θ��ڽİ��谡 �����Ѵ�.
		
		// ArrayList<Number> list = new ArrayList<Integer>();  ArrayList<Number>�� ArrayList<Integer>���̿��� �������� ����.
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		// process1(list);      ArrayList<Number>�� ArrayList<Integer>���̿��� �������� ����.
		
		ArrayList<Double> list2 = new ArrayList<Double>();
		// process1(list2);     ArrayList<Number>�� ArrayList<Double>���̿��� �������� ����.
		
		process(list);
		process(list2);
	}
	
	public static void process(ArrayList<? extends Number> list) {   //number�� ����ϰ� �ִ� Ÿ���̶�� ����
		
	}
	
	public static void process1(ArrayList<Number> list) {
		
	}
}
