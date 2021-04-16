package ch15Practice;

import java.util.*;

public class PriorityQueueTest2 {
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	private static void test2() {
		/*
		 * 우선순위 큐에 들어갈 원소를 정렬하는 방법은 2가지가 있다.
		 * 1. 그 원소의 클래스 Comparable 인터페이스를 구현하는 것
		 * 2. 우선순위 큐에게 그 원소를 비교하는 방법을 따로 알려주는 것
		 * 		=> Comparator 인터페이스를 구현하는 것이다.
		 * 참고로, 원소가 Comparable 인터페이스를 구현한 객체이고
		 * 우선순위 큐에서 원소를 비교하는 방법도 따로 알려주면
		 * 도대체 어떤 순서로 정렬하라는 건가? 
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
		
		q.add(new Task(5, "작업1"));
		q.add(new Task(1, "작업2"));
		q.add(new Task(7, "작업3"));
		q.add(new Task(8, "작업4"));
		q.add(new Task(4, "작업5"));
		
		while(q.size() > 0) {
			Task task = q.poll();
			System.out.println(task);
		}
	}
	
	private static void test1() {
		Queue<Integer> q = new PriorityQueue<>();
		// 무작위로 1~100사이의 정수 10개의 정수를 넣자
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int val = random.nextInt(100) + 1;
			q.offer(val);
		}
		
		// 큐 안의 내용을 출력해보고.
		System.out.println(q);
		
		//큐의 원소를 하나씩 순서대로 빼 보자.
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
//		//내가 크면 양수, 같으면 0, 내가 작으면 음수를 반환하면 된다.
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


