package ch06Practice;

public class SafeArray {
	private int[] a;
	public int length = 0;
	public SafeArray(int size) {
		a=new int[size];
		length=size;
	}
	public int get(int index) {
		if(index<length && index>=0) {
		return a[index];
		}
		return -1;
	}
	public void put(int index, int value) {
		if(index<length && index>=0) {
			a[index]=value;
		}else {
			System.out.println("잘못된 인덱스 "+index);
		}
	}
}
