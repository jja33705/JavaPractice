package ch15Practice;

public class SimplePair<T> {
	
	T data1;
	T data2;
	
	public SimplePair(T data1, T data2) {
		this.data1 = data1;
		this.data2 = data2;
	}
	
	public T getFirst() {
		return data1;
	}
	
	public T getSecond() {
		return data2;
	}
	
	public void setFirst(T data) {
		this.data1 = data;
	}
	
	public void setSecond(T data) {
		this.data2 = data;
	}
	
	public static void main(String[] args) {
		

	}

}
