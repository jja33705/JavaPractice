package ch15Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Map<String, Map<String, String>> wdjPhoneBook = new HashMap<>();
		
		Map<String, String> wdjaPhoneBook = new HashMap<>();
		wdjaPhoneBook.put("�ڵ���", "010-6212-6487");
		wdjaPhoneBook.put("������", "010-3369-7430");
		
		Map<String, String> wdjbPhoneBook = new HashMap<>();
		wdjbPhoneBook.put("������", "010-6565-6561");
		wdjbPhoneBook.put("��äȯ", "010-5616-5646");
	
		wdjPhoneBook.put("WDJ-A", wdjaPhoneBook);
		wdjPhoneBook.put("WDJ-B", wdjbPhoneBook);
		
		while(true) {
			System.out.println("���� �Է��ϼ���");
			String ban = input.nextLine();
			Map<String, String> phoneBook = null;
			
			if(wdjPhoneBook.get(ban) == null) {
				System.out.println("���� ���Դϴ�.");
			}  else {
				phoneBook = wdjPhoneBook.get(ban);
			}
			
			System.out.println("�̸��� �Է��ϼ���");
			String name = input.nextLine();
			
			if(phoneBook.get(name) == null) {
				System.out.println("���� �̸��Դϴ�.");
			} else {
				System.out.println(phoneBook.get(name));
			}
		}
	}

}
