package ch07Practice;

public class Animal {
	private int weight;
	private String picture;
	public void eat() {
		System.out.println("eat()가 호출되었음.");
	}
	public void sleep() {
		System.out.println("sleep()가 호출되었음.");
	}
	public void sound() {
		System.out.println("Animal 클래스의 sound()");
	}
}
