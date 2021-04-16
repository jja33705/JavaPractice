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
		System.out.println("수식을 입력하세요");
		Scanner input = new Scanner(System.in);
		String exp = input.nextLine();
		
		StringTokenizer st = new StringTokenizer(exp);   //디폴트 구분자: " "
		Stack<String> stack = new Stack<>();
		while(st.hasMoreTokens()) {
			String nextVal = st.nextToken();
			if (nextVal.equals("(")) {
				stack.push("(");
			} else if (nextVal.equals(")")) {
				if(stack.isEmpty()) {
					System.out.println("잘못된 식입니다.");
					return;
				}
				stack.pop();
			}
		}
		if (stack.isEmpty()) {
			System.out.println("유효한 식입니다.");
			return;
		}
		System.out.println("잘못된 식입니다.");
	}
	
	private static void test1() {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < 10; i++) {
			// auto boxing
			// stack.push(Character c);  // char의 Wrapper class
			// stack.push(char c);
			stack.push((char)('A' + i));
		}
		System.out.println(stack);
		// stack.peek(): 다음에 인출될 원소 엿보기. (꺼내지 않음)
		System.out.println("다음에 인출될 원소: " + stack.peek());
		System.out.println("다음에 인출될 원소: " + stack.peek());
		Character nextVal = stack.pop();
		System.out.println("다음에 인출될 원소: " + stack.peek());
		while(stack.size() > 0) {
			nextVal = stack.pop();
			System.out.println(nextVal);
		}
//		Iterator<Character> iter = stack.iterator();    Iterator을 사용해서 빼면 LIFO가 아님. 순서가 다름.
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		System.out.println(stack);  //[]
	}
	
	private static void test2() {
		String str = "APPLE, GRAPE, BANANA, MELON, STRAWBERRY";
		StringTokenizer st = new StringTokenizer(str, ", ");   //String을 구분자마다 잘라서 토큰들로 만들어줌
		while(st.hasMoreTokens()) {    //다음 토큰이 있으면 true
			System.out.println("["+st.nextToken()+"]");   //다음 토큰
		}
	}
}