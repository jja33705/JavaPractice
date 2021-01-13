package ch06Practice;

public class BoxTest {

	public static void main(String[] args) {
		Box b;
		b=new Box(20,20,30);
		System.out.println("상자의 부피는 "+b.getVolume()+"입니다.");
		
		Box obj1=new Box(10,20,50);
		Box obj2=new Box(10,30,30);
		
		Box largest=Box.whosLargest(obj1, obj2);
		System.out.println(largest);
		
		System.out.println("obj1 == obj2: "+obj1.isSameBox(obj2));
	}

}
