package ch15Practice;

import java.util.*;

public class PriorityQueueTest2 {
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	private static void test2() {
		/*
		 * �켱���� ť�� �� ���Ҹ� �����ϴ� ����� 2������ �ִ�.
		 * 1. �� ������ Ŭ���� Comparable �������̽��� �����ϴ� ��
		 * 2. �켱���� ť���� �� ���Ҹ� ���ϴ� ����� ���� �˷��ִ� ��
		 * 		=> Comparator �������̽��� �����ϴ� ���̴�.
		 * �����, ���Ұ� Comparable �������̽��� ������ ��ü�̰�
		 * �켱���� ť���� ���Ҹ� ���ϴ� ����� ���� �˷��ָ�
		 * ����ü � ������ �����϶�� �ǰ�? 
		 */
		Queue<Task> q = new PriorityQueue<>(new Comparator<Task>() {

			@Override
			public int compare(Task o1, Task o2) {
				return o2.priority - o1.priority;
			}
			
			@Override
			public boolean equals(Object obj) {
				return false;
			}
		});
//		Queue<Task> q = new PriorityQueue<>((a, b) -> {return a.priority - b.priority;});
		
		q.add(new Task(5, "�۾�1"));
		q.add(new Task(1, "�۾�2"));
		q.add(new Task(7, "�۾�3"));
		q.add(new Task(8, "�۾�4"));
		q.add(new Task(4, "�۾�5"));
		
		while(q.size() > 0) {
			Task task = q.poll();
			System.out.println(task);
		}
	}
	
	private static void test1() {
		Queue<Integer> q = new PriorityQueue<>();
		// �������� 1~100������ ���� 10���� ������ ����
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int val = random.nextInt(100) + 1;
			q.offer(val);
		}
		
		// ť ���� ������ ����غ���.
		System.out.println(q);
		
		//ť�� ���Ҹ� �ϳ��� ������� �� ����.
		while(q.size() > 0) {
			System.out.println(q.poll());
		}
	}
}

//class Task implements Comparable<Task> {
//	int priority;
//	String desc;
//	
//	public Task(int priority, String desc) {
//		this.priority = priority;
//		this.desc = desc;
//	}
//	
//	@Override
//	public String toString() {
//		return "[priority: " + priority + ", desc: " + desc + "]"; 
//	}
//
//	@Override
//	public int compareTo(Task o) {
//		//���� ũ�� ���, ������ 0, ���� ������ ������ ��ȯ�ϸ� �ȴ�.
//		return this.priority - o.priority;
//	}
//}

class Task {
	int priority;
	String desc;
	
	public Task(int priority, String desc) {
		this.priority = priority;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "[priority: " + priority + ", desc: " + desc + "]"; 
	}
}


