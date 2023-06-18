package javaOOPPolymorphismCasting;

public class Test {

	
	/* Khi sử dụng phương thức Casting trong đa hình: 
	 * Biến thuộc lớp cha (ann) cũng có thể tham chiếu tới đối tượng của lớp con (Pig và Bird)
	 * 
	 */
	public static void main(String[] args) {
	Annimal ann = new Annimal();
	
	ann.eat();
	
	ann = new Pig();
	ann.eat();
	
	ann = new Bird();
	ann.eat();

	}

}
