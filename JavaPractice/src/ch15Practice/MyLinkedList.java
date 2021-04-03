package ch15Practice;

import java.util.stream.IntStream;

public class MyLinkedList {
	private Node head = null;
	private int size = 0;
	
	public void add(Integer value) {
		Node newNode = new Node();
		newNode.value = value;
		if (head == null) {
			head = newNode;
		} else {
			Node tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = newNode;
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	private class Node {
		Integer value;
		Node next;
	}
	
	public Integer get(int index) {
		if (index >= size) return null;
		int idx = 0;
		Node tmp = head;
		while (idx < index) {
			tmp = tmp.next;
			idx++;
		}
		return tmp.value;
	}
	
	public void remove() {
		Node tmp = head;
		if (size <= 1) {
			head = null;
			size = 0;
			return;
		}
		while(tmp.next.next != null) {
			tmp = tmp.next;
		}
		tmp.next = null;
		size = size-1;
	}
	
	@Override
	public String toString() {
		if(size == 0) return null;
		String result = "[";
		Node tmp = head;
		for (int i = 0; i < size() - 1; i++) {
			result +=tmp.value + ", ";
			tmp = tmp.next;
		}
		result += tmp.value + "]";
		return result;
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		IntStream.rangeClosed(1, 10).forEach(i -> list.add(i));
		System.out.println(list);
		for (int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i) + " ");
		}
		while(list.size != 0) {
			list.remove();
			System.out.println(list);
		}
		
	}
}
