package ch07Practice;

public class ColoredRectangle extends Rectangle{
	private String color;
	public ColoredRectangle() {
		
	}
	public ColoredRectangle(int x, int y, int width, int height, String color) {
		super(x,y,width,height);
		this.color=color;
		System.out.println("ColoredRectangle()");
	}
}
