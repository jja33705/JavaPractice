package ch06Practice;

public class Box {
	private int width;
	private int length;
	private int height;
	private int volume;
	public int getVolume() {
		return volume;
	}
	public Box(int w, int l, int h) {
		width=w;
		length=l;
		height=h;
		volume=width*length*height;
	}
	public static Box whosLargest(Box box1, Box box2) {
		if(box1.volume > box2.volume) {
			return box1;
		}else {
			return box2;
		}
	}
	public boolean isSameBox(Box box) {
		if(this.width==box.width && this.length==box.length && this.height==box.height) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "Box [width=" + width + ", length=" + length + ", height=" + height + ", volume=" + volume + "]";
	}
}
