package ch14Practice;

import java.util.Scanner;

public class AssertionTest {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)){
			System.out.println("��¥�� �Է��Ͻÿ�: ");
			int date = input.nextInt(); //run configurations���� VM arguments�� -ea �Է�
			assert date >=1 && date <=31 : "�߸��� ��¥: " + date;
			System.out.printf("�Էµ� ��¥�� %d �Դϴ�.\n", date); //formatted text
		}
	}
}
