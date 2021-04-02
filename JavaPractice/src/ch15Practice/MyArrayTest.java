package ch15Practice;

public class MyArrayTest {
	public static void main(String[] args) {
		MyArrayList<Integer> list1 = new MyArrayList<>();
		for(int i = 0; i < 100; i++) {
			list1.add(i);
		}
		
		list1.add(4,9);
		list1.remove(9);
		
		for(int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
		
		MyArrayList<Integer> list3 = new MyArrayList<Integer>();
		list3.add(1);
		list3.add(2);
		list3.add(1,1);
		
		list3.remove(0);
		list3.remove(0);
		list3.remove(0);
		list3.remove(0);
		
		for(int i = 0; i < 500; i++) {
			list3.add(i);
		}
		
		for(int i = 0; i < list3.size(); i++) {
			System.out.print(list3.get(i) + " ");
		}
		
		System.out.println();
		
		MyArrayList<Student> list2 = new MyArrayList<Student>();
		for (int i = 0; i < 20; i++) {
			list2.add(new Student(i+"", (i+1)*10));
		}
		for (int i = 0; i < 20; i++) {
			System.out.println(list2.get(i));
		}
	}
}
