package ch15Practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
	public static void main(String[] args) {
		String[] str = {"To", "be", "or", "not", "to", "be", "is", "a", "problem"};
		/*
		 * map���ٰ� �ܾ Ű��, �� �ܾ ������ Ƚ���� ������ ����.
		 * Generic�� Ÿ�� �Ķ���ͷδ� �⺻ Ÿ���� ������� �ʴ´�.
		 */
		Map<String, Integer> map = new HashMap<>();
		/*
		 * str �迭�� �� ���ҿ� ���ؼ� �� ���Ҹ� key�� ����.
		 * �� ���Ҹ� Ű(key)�� ������ ��Ʈ���� �ִ��� �˻�
		 * ���࿡ �׷��� ��Ʈ���� ������ +1
		 * ���࿡ �׷��� ��Ʈ���� ������ �� key�� �ش��ϴ� �ܾ�� ó�� ���°Ŵ�. �׷� map�� �߰��ϸ� �ȴ�.
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
