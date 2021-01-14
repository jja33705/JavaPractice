package ch07Practice;

public class Car {
	private String model;
	public Car(String model) {
		this.model=model;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Car) {
			return model.equals(((Car)obj).model);
		}else {
			return false;
		}
	}
	public static int test() {
		return 3;
	}
}
