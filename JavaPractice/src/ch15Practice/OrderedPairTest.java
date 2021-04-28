package ch15Practice;

public class OrderedPairTest {

	public static void main(String[] args) {
		OrderedPair<String, Integer> op = new OrderedPair<>("아아아아아아", 1500);
		
		System.out.println(op.getKey());
		System.out.println(op.getValue());

	}

}
