package javaOOPAbstraction;

public abstract class Dog extends Annimal implements Runnable{
	
	/*
	 * Class - Class: Extends
	 * Class - Interface: Implements
	 * Khi class implements interface thì cần override lại toàn bộ method của interface đó
	 */

	@Override
	public void eat() {
		System.out.println("Dogs eat!");
		
	}

	@Override
	public void run() {
		System.out.println("Dogs run!");
		
	}
	
	public static void main(String[] args) {
		
		feed();
	}

}
