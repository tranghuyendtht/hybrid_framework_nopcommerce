package javaBasic;

public class Topic_02_Variable_Property {

	// Instance variable (global variable) - Biến toàn cục dùng ở mọi nơi trong class, set luôn giá trị tại thời điểm khởi tạo biến
	final String nameStd = "Trang";
	
	// Property: Cũng là 1 biến nhưng không set giá trị luôn mà sẽ dùng trong các hàm setter, getter
	private int age;
	
	// Dùng trong phạm vi class này
	private static String phoneNumber = "035887982";
	
	// Final variable: Không cho phép gán lại giá trị, ko cho override lại
	// Cố định dữ liệu trong suốt quá trình chạy
	
	final float piNumber = 3.14f;
	
	// Khi đi final với static thì thành constant variable - HẰNG SỐ (FINAL STATIC)
	// Không được ghi đè
	// Có thể dùng rộng rãi trong các instance/thread
	final static float PI_NUMBER = 3.14f;
	
	// Access modifier : default
	int num = 3;
	

	//Hàm get giá trị
	public int getAge() {
		return age;
	}

	// Hàm set giá trị
	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		
		//Local variable: Khởi tạo trong hàm, khối lệnh
		float scoreStd = 7.5f;
		System.out.println(scoreStd);
	}
	
	
	
	
	
}
