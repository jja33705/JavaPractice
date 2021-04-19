package ch15Practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
	public static void main(String[] args) {
		String[] str = {"To", "be", "or", "not", "to", "be", "is", "a", "problem"};
		/*
		 * map에다가 단어를 키로, 그 단어가 출현한 횟수를 값으로 저장.
		 * Generic의 타입 파라미터로는 기본 타입을 허용하지 않는다.
		 */
		Map<String, Integer> map = new HashMap<>();
		/*
		 * str 배열에 각 원소에 대해서 각 원소를 key라 하자.
		 * 그 원소를 키(key)로 가지는 엔트리가 있는지 검사
		 * 만약에 그러한 엔트리가 있으면 +1
		 * 만약에 그러한 엔트리가 없으면 이 key에 해당하는 단어는 처음 나온거다. 그럼 map에 추가하면 된다.
		 * 
		 */
		for(String s : str) {
			if(map.get(s) == null) {
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1);
			}
		}
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for(Map.Entry<String, Integer> entry : set) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		System.out.println("-----------------------------------------------------");
		
		Set<String> keySet = map.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ": " + map.get(key));
		}
		
		System.out.println("------------------------------------------------------");
		
		for(String key : keySet) {
			System.out.println(key + ": " + map.get(key));
		}
		
	}
}
