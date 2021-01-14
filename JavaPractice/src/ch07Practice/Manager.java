package ch07Practice;

public class Manager extends Employee{
	public Manager(String name, String address, int salary, int rrn, Date date, int bonus) {
		super(name, address, salary, rrn, date);
		this.bonus=bonus;
	}
	private int bonus;
	public void test() {
		System.out.println("name="+name);
		System.out.println("address="+address);
		System.out.println("salary="+salary);
	}
}
