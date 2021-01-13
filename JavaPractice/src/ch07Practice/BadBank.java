package ch07Practice;

public class BadBank extends Bank{
	@Override
	public double getInterestRate() {
		return 10.0;
	}
}
