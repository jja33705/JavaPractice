package ch15Practice;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		/*
		 * Map은 인터페이스이고 요놈을 구현한 구현 클래스가 HashMap, TreeMay, LinkedHashMap 3개가 있다. 그래서 Map타입의 변수는
		 * 위의 3개 타입의 객체를 수용할 수 있다.
		 * Map은 값을 <key, value> 쌍으로 저장한다.
		 * Map은 Generic이다.
		 * 클래스, 메소드 내부에서 사용할 데이터 타입을 정하지 않고 실제 그 클래스의 객체를 만들거나 메소드를 호출할 때 사용할 데이터 타입을
		 * 파라미터로 받아서 처리하는 것.
		 * 문자열 타입의 학번을 키로, Student 객체를 값으로 Map에 저장.
		 */
		Map<String, MyStudent> map = new HashMap<>();
		/*
		 * Map에 원소(<key, value>로 구성된 entry)를 넣을 때는 put메소드를 사용.
		 * put메소드는 원소 삽입과 변경에 모두 사용된다. (이미 존재하는 키 값으로 put하면 기존 원소를 replace하게 된다.)
		 * Map에서 원소(엔트리)를 읽을 때는 get(key) 메소드를 사용.
		 */
		map.put("20201234", new MyStudent(20201234, "홍길동"));
		map.put("20201235", new MyStudent(20201235, "일지매"));
		map.put("20201236", new MyStudent(20201236, "성춘향"));
		map.put("20201237", new MyStudent(20201237, "이몽룡"));
		map.put("20201238", new MyStudent(20201238, "월매"));
		
		//원소값을 읽을 때는 키 값을 줘야 한다.
		MyStudent std = map.get("20201237");
		System.out.println(std);
		
		//map 객체에게 니가 가진 key값을 다 줘
		
		Set<String> keyset = map.keySet();
		//keyset에 있는 각 원소를 통해서 map에게 값을 요구하면 된다.
		//왜냐하면 그 원소가 map에 저장된 값의 key니까.
		
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			std = map.get(key);
			System.out.println(std);
		}
		//Entry: <key, value> pair
		Set<Map.Entry<String, MyStudent>> entrySet = map.entrySet(); //Enrty는 Map인테페이스의 내부 인터페이스.
		
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

