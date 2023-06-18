package javaBasic;

public class Topic_03_Static_Non_Static {

	
	// Static method
	static void staticMethod() {
		System.out.println("A static method");
	}
	
	// Non static method
	public void nonStaticMethod() {
		System.out.println("A non static method");
	}
	
	public static void main (String[] args) {
		// Khi gọi method static, chỉ cần gọi trực tiếp
		staticMethod();
		
		// Khi gọi method non static, cần khởi tạo 1 instance để gọi
		Topic_03_Static_Non_Static nonStatic = new Topic_03_Static_Non_Static();
		nonStatic.nonStaticMethod();
		
		
		
	}
}
