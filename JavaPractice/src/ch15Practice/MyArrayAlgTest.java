package ch15Practice;

import java.util.Arrays;

public class MyArrayAlgTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = i;
		}
		swap(arr, 1, 2);
		System.out.println(Arrays.toString(arr));
		
	}
	
	private static <T> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
