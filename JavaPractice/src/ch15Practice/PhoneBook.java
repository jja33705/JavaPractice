package ch15Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Map<String, Map<String, String>> wdjPhoneBook = new HashMap<>();
		
		Map<String, String> wdjaPhoneBook = new HashMap<>();
		wdjaPhoneBook.put("박동현", "010-6212-6487");
		wdjaPhoneBook.put("예승재", "010-3369-7430");
		
		Map<String, String> wdjbPhoneBook = new HashMap<>();
		wdjbPhoneBook.put("박주형", "010-6565-6561");
		wdjbPhoneBook.put("임채환", "010-5616-5646");
	
		wdjPhoneBook.put("WDJ-A", wdjaPhoneBook);
		wdjPhoneBook.put("WDJ-B", wdjbPhoneBook);
		
		while(true) {
			System.out.println("반을 입력하세요");
			String ban = input.nextLine();
			Map<String, String> phoneBook = null;
			
			if(wdjPhoneBook.get(ban) == null) {
				System.out.println("없는 반입니다.");
			}  else {
				phoneBook = wdjPhoneBook.get(ban);
			}
			
			System.out.println("이름을 입력하세요");
			String name = input.nextLine();
			
			if(phoneBook.get(name) == null) {
				System.out.println("없는 이름입니다.");
			} else {
				System.out.println(phoneBook.get(name));
			}
		}
	}

}
