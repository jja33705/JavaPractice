package ch07Practice;

public class AnimalTest {

	public static void main(String[] args) {
		Lion lion=new Lion();
		lion.eat();
		lion.sleep();
		lion.roar();
		
		Eagle eagle=new Eagle();
		eagle.eat();
		eagle.sleep();
		eagle.fly();
		
		Animal animal=new Animal();
		Dog dog=new Dog();
		Cat cat=new Cat();
		
		Animal obj;
		
		obj=animal;
		obj.sound();
		
		obj=dog;
		obj.sound();
		
		obj=cat;
		obj.sound();
	}

}
