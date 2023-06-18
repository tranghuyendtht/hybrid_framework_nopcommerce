package javaBasic;

import java.util.Scanner;

public class Topic_01_Variable {

	// Biến toàn cục - nếu ko gán gì thì sẽ đc gán giá trị mặc định
	String studentName = "Doãn Thị Huyền Trang";
	int studentId;
	
	// Biến tĩnh - giống toàn cục, khác là có thêm static
	static String studentAdd = "37 - Xóm Đồng";
	
	// Biến final - constant
	static final String PI = "3,14"; // Không thay đổi trong suốt chương trình
	static final String BROWSER_NAME = "Chrome"; // Tên biến viết hoa toàn bộ, giữa 2 từ thì có dấu _
	
	public static void main(String[] args) {
		// Biến cục bộ
		int studentMark = 5; // Có màu vàng, nếu ko gán gì thì ko có giá trị mặc định
		
		System.out.println(studentMark);
		
		// In biến constant
		System.out.println(PI);
		System.out.println(BROWSER_NAME);
		
		// In biến tĩnh
		System.out.println(Topic_01_Variable.studentAdd);
		
		// In biến toàn cục
		Topic_01_Variable topic_01 = new Topic_01_Variable();
		System.out.println(topic_01.studentName);
		
		
		// Console
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println(name);
		System.out.println(name);
		System.out.print(name);
		System.out.print(name);

	}

}
