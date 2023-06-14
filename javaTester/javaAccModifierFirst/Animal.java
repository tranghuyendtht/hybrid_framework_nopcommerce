package javaAccModifierFirst;

public class Animal {
	private String name; // Chỉ sử dụng ở trong cùng class
	String color; 	// Cho phép sử dụng trong cùng class, hoặc 1 class khác thuộc cùng package. 
					// Không cho phép truy cập từ 1 class khác package qua kế thừa hoặc khởi tạo hàm
	protected int eyeNum;	// Cho phép sử dụng trong cùng class, hoặc 1 class khác thuộc cùng package. 
							// Cho phép truy cập từ 1 class khác package qua kế thừa 
							// Không cho phép truy cập từ  khởi tạo hàm
	public int footNum;		// Cho phép sử dụng trong cùng class, hoặc 1 class khác thuộc cùng package. 
							// Cho phép truy cập từ 1 class khác package qua kế thừa 
							// Cho phép truy cập từ  khởi tạo hàm
	
	
}
