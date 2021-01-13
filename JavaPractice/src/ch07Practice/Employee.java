package ch07Practice;

public class Employee {
	public Employee(String name, String address, int salary, int rrn) {
		this.name=name;
		this.address=address;
		this.salary=salary;
		this.rrn=rrn;
	}
	public String name;
	String address;
	protected int salary;
	private int rrn;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", salary=" + salary + ", rrn=" + rrn + "]";
	}
}
