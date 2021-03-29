package ch15Practice;

import javax.swing.JFrame;

public class MyBoxTest {
	public static void main(String[] args) {
		MyBox<String> box1 = new MyBox<String>();   //box의 타입을 스트링으로 지정해줌.
		box1.setValue("홍길동");
//		box1.setValue(100);
//		box1.setValue(123.4);
//		box1.setValue(new JFrame());
		openBox(box1);
	
		print(Integer.valueOf(100));
		
		MyBox<Integer> box2 = new MyBox<>();
		box2.setValue(12);
	}
	
	private static void print(int val) {  //랩퍼클래스로 자동으로 오토박싱해줌
		System.out.println(val);
	}
	
	private static void openBox(MyBox<String> box) {
		String d = box.getValue();
		System.out.println(d);
	}
}
