package ch15Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Test1 {
	
	public static void main(String[] args) {
		test();
		test1();
		test2();
//		test3();
		test4();
		countDistinctWord();
		countDistinctWord2();
	}
	
	private static void countDistinctWord() {
		Set<String> set = new HashSet<>();
		File file = new File("wordbook.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String s = null;
			while((s = br.readLine()) != null) {
				set.add(s);
			}
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("�ߺ����� ���� �ܾ� ��: " + set.size());
	}
	
	private static void countDistinctWord2() {
		Map<String, Integer> map = new HashMap<>();
		File file = new File("wordbook.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String s = null;
			while((s = br.readLine()) != null) {
				Integer n = map.get(s);
				if(n == null) {
					map.put(s, 1);
				} else {
					map.put(s, n+1);
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println(key + ":" + value);
		}
	}
	
	private static void test1() {
		//HashSet
		//��������, �ߺ��������� �ʴ� ���� HashSet....
		Set<String> set = new HashSet<>();
		String[] strArr = {"�ܾ�", "�ߺ�", "��ö", "�ߺ�"}; //set�� �ߺ����� ������� �����Ƿ� �ߺ��� �ϳ��� ��
		for (String s : strArr) {
			set.add(s);
		}
		System.out.println(set);
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+ " ");
		}
		System.out.println();
		iter = set.iterator(); //�ѹ� �� ���� �� Iterator�� �� ������ �� ����. �ٽ� ������ ��� �Ѵ�.
		System.out.println(iter.next());
		System.out.println("��....");
	}
	
	private static void test2() {
		//LinkedHashSet�� �ߺ��� ������� ������ �Էµ� ������ �����ȴ�. (�Էµ� ������ ��µȴ�)
		Set<String> set = new LinkedHashSet<>();
		String[] strArr = {"�ܾ�", "�ߺ�", "��ö", "�ߺ�"}; //set�� �ߺ����� ������� �����Ƿ� �ߺ��� �ϳ��� ��
		for (String s : strArr) {
			set.add(s);
		}
		System.out.println(set);
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+ " ");
		}
		System.out.println();
		iter = set.iterator(); //�ѹ� �� ���� �� Iterator�� �� ������ �� ����. �ٽ� ������ ��� �Ѵ�.
		System.out.println(iter.next());
		System.out.println("��....");
	}
	
	private static void test3() {
		//TreeSet�� �ߺ��� ������� ������ ���� ���� �����Ѵ�.(���� ������� ��µȴ�)
//		Set<String> set = new TreeSet<>(new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});
//		String[] strArr = {"�ܾ�", "�ߺ�", "��ö", "�ߺ�"}; //set�� �ߺ����� ������� �����Ƿ� �ߺ��� �ϳ��� ��
//		for (String s : strArr) {
//			if(set.add(s) == false) { //add�ϸ鼭 �̹� �����ϴ� ������ �ƴ��� boolean���� ������ �ش�.
//				System.out.println(s + "�� �̹� �����ϴ� ��...!");
//			}
//		}
//		System.out.println(set);
//		Iterator<String> iter = set.iterator();
//		while(iter.hasNext()) {
//			System.out.print(iter.next()+ " ");
//		}
//		System.out.println();
//		iter = set.iterator(); //�ѹ� �� ���� �� Iterator�� �� ������ �� ����. �ٽ� ������ ��� �Ѵ�.
//		System.out.println(iter.next());
//		System.out.println("��....");
	}
	
	private static void test4() {
		Set<Integer> set = new TreeSet<>();
		Random random = new Random(System.currentTimeMillis());
		while(set.size() < 6) {
			set.add(random.nextInt(45) + 1);
		}
		System.out.println(set);
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
		
		while(iter.hasNext()) {    //���� �������� ���� ���Ұ� �����ִ��� ��ȯ
			System.out.println(iter.next());  //�ϳ��� �����´�
		}
	}
	
	private static void test() {
		List<Integer> list = new ArrayList<>();
		
		IntStream.rangeClosed(1, 100000).forEach(i -> list.add(i));
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
//			list.add(100, (i+1)*1000);
			list.get(i);
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("elapsed time: " + (endTime-startTime));
		//�߰��� �����ϴ� ���� ���� ���� LinkedList�� �����ϰ�, ���� �������� ���� ������ ArrayList�� �����ϴ�.
	}
}