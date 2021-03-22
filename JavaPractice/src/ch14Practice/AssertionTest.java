package ch14Practice;

import java.util.Scanner;

public class AssertionTest {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)){
			System.out.println("날짜를 입력하시오: ");
			int date = input.nextInt(); //run configurations에서 VM arguments에 -ea 입력
			assert date >=1 && date <=31 : "잘못된 날짜: " + date;
			System.out.printf("입력된 날짜는 %d 입니다.\n", date); //formatted text
		}
	}
}
