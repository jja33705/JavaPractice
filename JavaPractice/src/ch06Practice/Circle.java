package ch06Practice;

public class Circle {
	private int radius;
	private Point center;
	public Circle(Point center, int radius) {
		this.radius=radius;
		this.center=center;
	}
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", center=" + center + "]";
	}
}
