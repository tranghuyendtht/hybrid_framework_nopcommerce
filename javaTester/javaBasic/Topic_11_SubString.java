package javaBasic;

import org.testng.annotations.Test;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_11_SubString {

	static // Khởi tạo kiểu nguyên thủy
	String stdName = "Doãn Thị Huyền Trang";

	// Khởi tạo kiểu đối tượng
	String stdName1 = new String("Doãn Thị Huyền Trang");

	public static void main(String[] args) {
		// Độ dài chuỗi
		System.out.println(stdName.length());

		// Ký tự từ vị trí thứ X
		System.out.println(stdName.charAt(2));

		// Nối chuỗi - concat
		String stdName2 = " Sơn Đồng";
		System.out.println(stdName.concat(stdName2));

		// So sánh tuyệt đối bao gồm cả vị trí vùng nhớ và giá trị chuỗi
		System.out.println(stdName.equals(stdName2));

		// So sánh tuyệt đối không quan tâm hoa thường
		System.out.println(stdName.equalsIgnoreCase("doãn Thị Huyền Trang"));

		// Startwith/Endwith/contains
		System.out.println(stdName.startsWith("T"));
		System.out.println(stdName.endsWith("g"));
		System.out.println(stdName.contains("Tr"));

		// Vị trí của từ trong chuỗi
		int index = stdName.indexOf("Huyền");
		System.out.println(index);

		// Chuỗi con từ vị trí thứ X
		String subString = stdName.substring(index);
		System.out.println(subString);

		// Chuỗi con từ vị trí X tới vị trí Y
		String subString1 = stdName.substring(9, 14);
		System.out.println(subString1);

		// Replace ký tự/chuỗi thành chuỗi ký tự khác
		String replaceString = stdName.replace("Huyền", "");
		System.out.println(replaceString);

		// Split - tách chuỗi
		String text = "Doãn Thị Huyền TRang";

		String[] splitString = text.split(" ");
		for (int i = 0; i < splitString.length; i++) {
			System.out.println("Vị trí thứ " + i + " là: " + splitString[i]);

		}
		
		
		// Trim - Cắt bỏ khoảng trắng/tab , cuối dòng, xuống dòng ở đầu và cuối chuỗi
		text = "\t \t \t Doãn Thị  Huyền Trang\n";
		System.out.println(text.trim());

		
		// Convert int/string hoặc double/string
		int number = 20;
		String value = String.valueOf(number);
		System.out.println(value);
		
		// Convert từ String về number
		String num = "20";
		int val = Integer.parseInt(num);
		System.out.println(val);
		
		
	}
	
	
}
