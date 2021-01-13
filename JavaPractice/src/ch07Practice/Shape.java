package ch07Practice;

public class Shape {
	public Shape() {
		
	}
	public Shape(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.println("shape()");
	}
	private int x;
	private int y;
	public void print() {
		System.out.println("xÁÂÇ¥: "+x+" yÁÂÇ¥: "+y);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
}
