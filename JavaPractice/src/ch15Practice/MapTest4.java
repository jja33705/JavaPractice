package ch15Practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest4 {

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
		
		System.out.println(getBigger(wdjbPhoneBook, "박주형", "임채환"));
		
		Set<Map.Entry<String, Map<String, String>>> entrySet = wdjPhoneBook.entrySet();
		
		Iterator<Map.Entry<String, Map<String, String>>> iter = entrySet.iterator();
		
		while(iter.hasNext()) {
			Map.Entry<String, Map<String, String>> entry = iter.next();
			System.out.println(entry.getKey());
			Map<String, String> phoneBook = entry.getValue();
			Set<Map.Entry<String, String>> entrySet2 = phoneBook.entrySet();
			Iterator<Map.Entry<String, String>> iter2 = entrySet2.iterator();
			while(iter2.hasNext()) {
				Map.Entry<String, String> entry2 = iter2.next();
				System.out.println(entry2.getKey() + ": " + entry2.getValue());
			}
		}
		

	}
	
	public static <T extends Comparable<T>> T getBigger(Map<String, T> map, String key1, String key2) {
		if(map.get(key1).compareTo(map.get(key2)) > 0) {
			return map.get(key1);
		} else return map.get(key2);
	}

}
