package javaOOPPolymorphismCasting;

public class Pig extends Annimal{
	
	/*
	 * Phương thức ghi đè
	 * Class Pig có method eat, giống hệt method của class Annimal mà nó kế thừa
	 * Pig thực hiện viết lại method này ==> Đó là overriding
	 */
	@Override
	public void eat() {
		System.out.println("I am a Pig");
	}
}
