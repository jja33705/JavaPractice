package ch14Practice;

import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {
		while(true) {
			try {
				int val = getInput();
				switch(val) {
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
						System.out.println("5������ ��: " + val);
					case 6:
					case 7:
					case 8:
					case 9:
					case 10:
						System.out.println("5�ʰ� 10������ ��: " + val);
					default:
						System.out.println("1~10������ ���� �Է��ϼ���.");
				}
			} catch (Exception e) {
				System.out.println("�Ϲ� ���� ���� ����!!!");
			}
		}
	}
	
	private static int getInput() {
		Scanner input = new Scanner(System.in);
//		String val = input.nextLine();
//		for(int i = 0; i < val.length(); i++) {
//			if(val.charAt(i) < '0' || val.charAt(i) > '9')
//				return -1;
//		}
		System.out.println("1~10������ ���� �Է��ϼ���.");
		return input.nextInt();
		
	}
}
