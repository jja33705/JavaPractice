package ch07Practice;

public class Manager extends Employee{
	public Manager(String name, String address, int salary, int rrn, int bonus) {
		super(name, address, salary, rrn);
		this.bonus=bonus;
	}
	private int bonus;
	public void test() {
		System.out.println("name="+name);
		System.out.println("address="+address);
		System.out.println("salary="+salary);
	}
}
