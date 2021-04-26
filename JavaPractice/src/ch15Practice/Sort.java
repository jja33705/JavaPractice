package ch15Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sort {
	
	public static void main(String[] args) {
		test1();
	}
	
	private static void test1() {
		List<Student2> list = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(new Student2("이름" + i, random.nextInt(100) + 1));
		}
		System.out.println(list);
//		Collections.sort(list);
		sort(list);
		System.out.println("정렬 후.....");
		System.out.println(list);
	}
	
	private static <T extends Comparable<T>>void sort(List<T> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			int min = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(min).compareTo(list.get(j)) > 0) {
					min = j;
				}
			}
			swap(list, min, i);
		}
	}
	
	private static <T extends Comparable<T>>void swap(List<T> list, int min, int i) {
		T temp = list.get(i);
		list.set(i, list.get(min));
		list.set(min, temp);
	}
}

class Student2 implements Comparable<Student2>{
	
	private String name;
	private int grade;
	
	public Student2(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public int compareTo(Student2 o) {
		return this.grade - o.grade;
	}
	
	@Override
	public String toString() {
		return "[name: " + name + ", grade: " + grade + "]";
	}
}

