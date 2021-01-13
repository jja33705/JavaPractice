package ch06Practice;

public class Date {
	private int year;
	private String month;
	private int day;
	public Date(int year, String month,int day) {
		this.year=year;
		this.month=month;
		this.day=day;
	}
	public Date(int year) {
		this(year,"1¿ù",1);
	}
	public Date() {
		this(1900,"1¿ù",1);
	}
	@Override
	public String toString() {
		return "Date [year="+year+", month="+month+", day="+day+"]";
	}
}
