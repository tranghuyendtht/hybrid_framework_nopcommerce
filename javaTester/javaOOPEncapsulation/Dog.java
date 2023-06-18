package javaOOPEncapsulation;

public class Dog extends Annimal{
	
	private int age;
	void Dog() {
		System.out.println("I am a dog!");
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age>0) {
			this.age = age;
		} else {
			System.out.println("Error age!");
		}
		
	}

}
