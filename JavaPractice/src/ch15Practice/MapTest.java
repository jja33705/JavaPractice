package ch15Practice;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		/*
		 * Map�� �������̽��̰� ����� ������ ���� Ŭ������ HashMap, TreeMay, LinkedHashMap 3���� �ִ�. �׷��� MapŸ���� ������
		 * ���� 3�� Ÿ���� ��ü�� ������ �� �ִ�.
		 * Map�� ���� <key, value> ������ �����Ѵ�.
		 * Map�� Generic�̴�.
		 * Ŭ����, �޼ҵ� ���ο��� ����� ������ Ÿ���� ������ �ʰ� ���� �� Ŭ������ ��ü�� ����ų� �޼ҵ带 ȣ���� �� ����� ������ Ÿ����
		 * �Ķ���ͷ� �޾Ƽ� ó���ϴ� ��.
		 * ���ڿ� Ÿ���� �й��� Ű��, Student ��ü�� ������ Map�� ����.
		 */
		Map<String, MyStudent> map = new HashMap<>();
		/*
		 * Map�� ����(<key, value>�� ������ entry)�� ���� ���� put�޼ҵ带 ���.
		 * put�޼ҵ�� ���� ���԰� ���濡 ��� ���ȴ�. (�̹� �����ϴ� Ű ������ put�ϸ� ���� ���Ҹ� replace�ϰ� �ȴ�.)
		 * Map���� ����(��Ʈ��)�� ���� ���� get(key) �޼ҵ带 ���.
		 */
		map.put("20201234", new MyStudent(20201234, "ȫ�浿"));
		map.put("20201235", new MyStudent(20201235, "������"));
		map.put("20201236", new MyStudent(20201236, "������"));
		map.put("20201237", new MyStudent(20201237, "�̸���"));
		map.put("20201238", new MyStudent(20201238, "����"));
		
		//���Ұ��� ���� ���� Ű ���� ��� �Ѵ�.
		MyStudent std = map.get("20201237");
		System.out.println(std);
		
		//map ��ü���� �ϰ� ���� key���� �� ��
		
		Set<String> keyset = map.keySet();
		//keyset�� �ִ� �� ���Ҹ� ���ؼ� map���� ���� �䱸�ϸ� �ȴ�.
		//�ֳ��ϸ� �� ���Ұ� map�� ����� ���� key�ϱ�.
		
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			std = map.get(key);
			System.out.println(std);
		}
		//Entry: <key, value> pair
		Set<Map.Entry<String, MyStudent>> entrySet = map.entrySet(); //Enrty�� Map�������̽��� ���� �������̽�.
		
		Iterator<Map.Entry<String, MyStudent>> iter2 = entrySet.iterator();
		while(iter2.hasNext()) {
			Map.Entry<String, MyStudent> entry = iter2.next();
			String key = entry.getKey();
			MyStudent mystd = entry.getValue();
			System.out.println("key: " + key + ", value: " + mystd);
		}
		
		for(Map.Entry<String, MyStudent> entry : entrySet) {
			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
		}
	}
}

class MyStudent {
	private int number;
	private String name;
	
	public MyStudent(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[number: " + number + ", name: " + name + "]";
	}
}

