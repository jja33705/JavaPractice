package ch15Practice;

public class MyArrayAlg {

	public static void main(String[] args) {
		String[] list = {"xyz", "abc", "def"};
		String max = getMax(list);
		System.out.println(max);
	}
	
	public static <T extends Comparable<T>> T getMax(T[] arr) {
		if (arr.length == 0 || arr == null) return null;
		int max = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[max].compareTo(arr[i]) < 0) {
				max = i;
			}
		}
		return arr[max];
	}
	

}
