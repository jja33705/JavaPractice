package ch15Practice;

public class MyArrayList <T> {
	Object[] array;
	private int capacity = 10;
	private int size = 0;
	
	public MyArrayList() {
		array = new Object[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public void add(T value) {
		if (size >= capacity) {
			int incresedCapacity = (int)(capacity * 1.5);
			Object[] tmpArray = new Object[incresedCapacity];
			System.arraycopy(array, 0, tmpArray, 0, size);
			array = tmpArray;
			capacity = incresedCapacity;
		}
		array[size++] = value;
	}
	
	public void add(T value, int idx) {
		if (size + 1 >= capacity) {
			int incresedCapacity = (int)(capacity * 1.5);
			Object[] tmpArray = new Object[incresedCapacity];
			array = tmpArray;
			capacity = incresedCapacity;
		}
		Object[] tmpArray = new Object[capacity];
		System.arraycopy(array, 0, tmpArray, 0, idx);
		System.arraycopy(array, idx, tmpArray, idx+1, size-idx);
		tmpArray[idx] = value;
		array = tmpArray;
		size++;
	}
	
	public void remove(int idx) {
		if(size <= 0) {
			return;
		}
		Object[] tmpArray = new Object[capacity];
		System.arraycopy(array, 0, tmpArray, 0, idx);
		System.arraycopy(array, idx + 1, tmpArray, idx, size-idx-1);
		array = tmpArray;
		size--;
	}
	
	public T get(int idx) {
		if(idx < size) {
			return (T)array[idx];
		} else {
			return null;
		}
	}
}
