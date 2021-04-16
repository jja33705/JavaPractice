package ch15Practice;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
//stack: LIFO(Last In First Out)
public class StackTest {
	public static void main(String[] args) {
		test1();
		test2();
		checkExpression();
	}
	
	private static void checkExpression() {
		System.out.println("������ �Է��ϼ���");
		Scanner input = new Scanner(System.in);
		String exp = input.nextLine();
		
		StringTokenizer st = new StringTokenizer(exp);   //����Ʈ ������: " "
		Stack<String> stack = new Stack<>();
		while(st.hasMoreTokens()) {
			String nextVal = st.nextToken();
			if (nextVal.equals("(")) {
				stack.push("(");
			} else if (nextVal.equals(")")) {
				if(stack.isEmpty()) {
					System.out.println("�߸��� ���Դϴ�.");
					return;
				}
				stack.pop();
			}
		}
		if (stack.isEmpty()) {
			System.out.println("��ȿ�� ���Դϴ�.");
			return;
		}
		System.out.println("�߸��� ���Դϴ�.");
	}
	
	private static void test1() {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < 10; i++) {
			// auto boxing
			// stack.push(Character c);  // char�� Wrapper class
			// stack.push(char c);
			stack.push((char)('A' + i));
		}
		System.out.println(stack);
		// stack.peek(): ������ ����� ���� ������. (������ ����)
		System.out.println("������ ����� ����: " + stack.peek());
		System.out.println("������ ����� ����: " + stack.peek());
		Character nextVal = stack.pop();
		System.out.println("������ ����� ����: " + stack.peek());
		while(stack.size() > 0) {
			nextVal = stack.pop();
			System.out.println(nextVal);
		}
//		Iterator<Character> iter = stack.iterator();    Iterator�� ����ؼ� ���� LIFO�� �ƴ�. ������ �ٸ�.
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		System.out.println(stack);  //[]
	}
	
	private static void test2() {
		String str = "APPLE, GRAPE, BANANA, MELON, STRAWBERRY";
		StringTokenizer st = new StringTokenizer(str, ", ");   //String�� �����ڸ��� �߶� ��ū��� �������
		while(st.hasMoreTokens()) {    //���� ��ū�� ������ true
			System.out.println("["+st.nextToken()+"]");   //���� ��ū
		}
	}
}