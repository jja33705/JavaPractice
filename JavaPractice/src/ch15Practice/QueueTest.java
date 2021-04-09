package ch15Practice;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {    //FIFO
	public static void main(String[] args) {
		testPriorityQueue();
		testDeque();
	}
	private static void testPriorityQueue() {
//		Queue<Integer> queue = new PriorityQueue<>(new MyComparator());
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int i = 10; i > 0; i--) {
			queue.offer(i);
		}
		System.out.println(queue);
		for (Integer n : queue) System.out.print(n + " ");
		System.out.println();
		
		int length = queue.size();
		for (int i = 0; i < length; i ++) {
			System.out.println((i+1)+"번째 원소: " + queue.poll()); //정렬되어서 나온다.
		}
	}
	
	private static void testDeque() {
		Deque<Integer> dq = new ArrayDeque<>();
		
		for (int i = 1; i <= 10; i++) {
			dq.add(i);        
//			dq.addLast(i);               //= dq.add(i);
//			dq.push(i);
//			dq.addFirst(i);              //= dq.push(i);
		}
		
		while(dq.size() > 0) {
			Integer val = dq.poll();  // = pollFirst();
			System.out.print(val + " ");
		}
		System.out.println();
	}
}

class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}
	
}
