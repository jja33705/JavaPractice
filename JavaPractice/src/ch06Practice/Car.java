package ch06Practice;

public class Car {
	String color;
	int gear;
	int speed;
	@Override
	public String toString() {
		return "Car [color="+color+", speed="+speed+", gear="+gear+"]";
	}
	void changeGear(int g) {
		gear=g;
	}
	void speedUp() {
		speed=speed+10;
	}
	void speedDown() {
		speed=speed-10;
	}
}
