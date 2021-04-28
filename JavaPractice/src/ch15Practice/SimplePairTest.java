package ch15Practice;

public class SimplePairTest {

	public static void main(String[] args) {
		SimplePair<String> simplePair = new SimplePair<>("apple", "tomato");
		System.out.println(simplePair.getFirst());
		System.out.println(simplePair.getSecond());

	}

}
