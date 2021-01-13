package ch07Practice;

public class Rectangle extends Shape{
	public Rectangle() {
		
	}
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width=width;
		this.height=height;
		System.out.println("Rectangle()");
	}
	private int width;
	private int height;
	public double area() {
		return (double)width*height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void draw() {
		System.out.println("("+getX()+","+getY()+") 위치에 가로: "+width+" 세로: "+height);
	}
}
