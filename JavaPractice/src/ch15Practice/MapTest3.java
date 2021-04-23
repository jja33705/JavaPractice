package ch15Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MapTest3 {
	public static void main(String[] args) {
//		test();
//		test2();   //TreeMap으로 정렬
		test3();   //ArrayList로 정렬
//		test4();   //PriorityQueue로 정렬
	}
	private static void test() {
		String sample = "What a radical idea, the great gift that our Founders gave to us. " +
				"The freedom to chase our individual dreams through our sweat, and toil, " +
				"and imagination — and the imperative to strive together as well, to achieve a common good, a greater good. " +
				"For 240 years, our nation’s call to citizenship has given work and purpose to each new generation. " + 
				"It’s what led patriots to choose republic over tyranny, pioneers to trek west, slaves to brave that makeshift railroad to freedom. " +
				"It’s what pulled immigrants and refugees across oceans and the Rio Grande. " + 
				"It’s what pushed women to reach for the ballot. It’s what powered workers to organize. " +
				"It’s why GIs gave their lives at Omaha Beach and Iwo Jima; " +
				"Iraq and Afghanistan — and why men and women from Selma to Stonewall were prepared to give theirs as well.";
		/*
		 * 한 문자열을 각 단어별로 쪼개보자.
		 * stringTorkenizer 이용, split
		 */
		StringTokenizer st = new StringTokenizer(sample, " .,;-—");  //delimiter를 공백, 마침표, 쉽표, 세미콜론, 대쉬(-)
		//st가 위의 구분자로 분리된 토큰들을 품고 있다
		//하나씩 곶감 빼먹듯이 빼먹어 보자
		//예의바르게. 있어요? 라고 물어보고, 있으면 달라고 해야된다.
		//Map이라는 자료구조를 이용해서, 각 단어가 몇 번 출현했는지 그 빈도를 저장하고자 한다.
		//Map은 <key, value>의 쌍으로 저장한다.
		//Map은 generic인테페이스다. 이 의미는 객체생성할 때 내부에서 사용할 데이터 타입을 파라미터로 명시해야한다.
		//예를 들면 ArrayList<String> list = new ArrayList<>(); ArrayList<Integer> list2 = new ArrayList<>();
		//map<> map = new HashMap<>();
		//map<String, Integer> map = new HashMap<>();
		Map<String, Integer> map = new HashMap<>();
		while(st.hasMoreTokens()) {   //hasMoreTokens(), st.hasMoreElements() 둘다 가능
			String str = st.nextToken();
			if(map.get(str) == null) {  //지금 처음 나온 단어
				map.put(str, 1);
			} else {   //이미 이전에 나와서 추가할 단어
				map.put(str, map.get(str) + 1);
			}
		}
		Set<String> keySet = map.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str + ": " + map.get(str) );
		}
//		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//		Iterator<Map.Entry<String, Integer>> iter = entrySet.iterator();
//		while(iter.hasNext()) {
//			Map.Entry<String, Integer> entry = iter.next();
//			System.out.println(entry.getKey() + ": " + entry.getValue());
//		}
//		for(Map.Entry<String, Integer> entry : entrySet) {
//			System.out.println(entry.getKey() + ": " + entry.getValue());
//		}
		
	}
	private static void test2() {
		String sample = "What a radical idea, the great gift that our Founders gave to us. " +
				"The freedom to chase our individual dreams through our sweat, and toil, " +
				"and imagination — and the imperative to strive together as well, to achieve a common good, a greater good. " +
				"For 240 years, our nation’s call to citizenship has given work and purpose to each new generation. " + 
				"It’s what led patriots to choose republic over tyranny, pioneers to trek west, slaves to brave that makeshift railroad to freedom. " +
				"It’s what pulled immigrants and refugees across oceans and the Rio Grande. " + 
				"It’s what pushed women to reach for the ballot. It’s what powered workers to organize. " +
				"It’s why GIs gave their lives at Omaha Beach and Iwo Jima; " +
				"Iraq and Afghanistan — and why men and women from Selma to Stonewall were prepared to give theirs as well.";
		StringTokenizer st = new StringTokenizer(sample, " .,;-—");
		Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {  //TreeMap 기본: key값을 기준으로 정렬
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		while(st.hasMoreTokens()) {   //hasMoreTokens(), st.hasMoreElements() 둘다 가능
			String str = st.nextToken();
			if(map.get(str) == null) {  //지금 처음 나온 단어
				map.put(str, 1);
			} else {   //이미 이전에 나와서 추가할 단어
				map.put(str, map.get(str) + 1);
			}
		}
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key + ": " + map.get(key));
		}
	}
	private static void test3() {
		String sample = "What a radical idea, the great gift that our Founders gave to us. " +
				"The freedom to chase our individual dreams through our sweat, and toil, " +
				"and imagination — and the imperative to strive together as well, to achieve a common good, a greater good. " +
				"For 240 years, our nation’s call to citizenship has given work and purpose to each new generation. " + 
				"It’s what led patriots to choose republic over tyranny, pioneers to trek west, slaves to brave that makeshift railroad to freedom. " +
				"It’s what pulled immigrants and refugees across oceans and the Rio Grande. " + 
				"It’s what pushed women to reach for the ballot. It’s what powered workers to organize. " +
				"It’s why GIs gave their lives at Omaha Beach and Iwo Jima; " +
				"Iraq and Afghanistan — and why men and women from Selma to Stonewall were prepared to give theirs as well.";
		StringTokenizer st = new StringTokenizer(sample, " .,;-—");
		Map<String, Integer> map = new HashMap<>();
		while(st.hasMoreTokens()) {   //hasMoreTokens(), st.hasMoreElements() 둘다 가능
			String str = st.nextToken();
			if(map.get(str) == null) {  //지금 처음 나온 단어
				map.put(str, 1);
			} else {   //이미 이전에 나와서 추가할 단어
				map.put(str, map.get(str) + 1);
			}
		}
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : entrySet) {
			entryList.add(entry);
		}
		Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		for(Map.Entry<String, Integer> entry : entryList) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	private static void test4() {
		String sample = "What a radical idea, the great gift that our Founders gave to us. " +
				"The freedom to chase our individual dreams through our sweat, and toil, " +
				"and imagination — and the imperative to strive together as well, to achieve a common good, a greater good. " +
				"For 240 years, our nation’s call to citizenship has given work and purpose to each new generation. " + 
				"It’s what led patriots to choose republic over tyranny, pioneers to trek west, slaves to brave that makeshift railroad to freedom. " +
				"It’s what pulled immigrants and refugees across oceans and the Rio Grande. " + 
				"It’s what pushed women to reach for the ballot. It’s what powered workers to organize. " +
				"It’s why GIs gave their lives at Omaha Beach and Iwo Jima; " +
				"Iraq and Afghanistan — and why men and women from Selma to Stonewall were prepared to give theirs as well.";
		StringTokenizer st = new StringTokenizer(sample, " .,;-—");
		Map<String, Integer> map = new HashMap<>();
		while(st.hasMoreTokens()) {   //hasMoreTokens(), st.hasMoreElements() 둘다 가능
			String str = st.nextToken();
			if(map.get(str) == null) {  //지금 처음 나온 단어
				map.put(str, 1);
			} else {   //이미 이전에 나와서 추가할 단어
				map.put(str, map.get(str) + 1);
			}
		}
		Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		queue.addAll(entrySet);
		while(!queue.isEmpty()) {
			Map.Entry<String, Integer> entry = queue.poll();
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
