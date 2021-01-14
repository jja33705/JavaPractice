package ch07Practice;

public class Employee {
	public Employee(String name, String address, int salary, int rrn, Date birthDate) {
		this.name=name;
		this.address=address;
		this.salary=salary;
		this.rrn=rrn;
		this.birthDate=birthDate;
	}
	public Date birthDate;
	public String name;
	String address;
	protected int salary;
	private int rrn;
	@Override
	public String toString() {
		return "Employee [birthDate=" + birthDate + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", rrn=" + rrn + "]";
	}
}
