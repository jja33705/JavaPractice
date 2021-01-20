package ch09Practice;

public class Rectangle implements Comparable{

	private int width;
	private int height;
	public Rectangle(int width, int height) {
		this.width=width;
		this.height=height;
		System.out.println(this);
	}
	public int getArea() {
		return width*height;
	}
	@Override
	public int compareTo(Object other) {
		Rectangle otherRect=(Rectangle)other;
		if(this.getArea()<otherRect.getArea()) {
			return -1;
		}else if(this.getArea()>otherRect.getArea()) {
			return 1;
		}else {
			return 0;
		}
	}
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}

}
