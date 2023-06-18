package javaOOPPolymorphismOverriding;

public class Test {

	
	/*
	 * Khi hàm main gọi tới Class pig, nếu Pig ko ghi đè thì main sẽ thực hiện gọi tới method của cha, nếu Pig ghi đè lại thì gọi tới method của pig
	 */
	public static void main(String[] args) {
	Pig pig = new Pig();
	
	pig.eat();

	}

}
