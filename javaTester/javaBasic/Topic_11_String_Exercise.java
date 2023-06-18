package javaBasic;

import org.testng.annotations.Test;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_11_String_Exercise {

	public void TC_01() {
		Scanner scan = new Scanner(System.in);
		String text1 = scan.nextLine();

		char[] splitString = text1.toCharArray();
		int count = 0;
		for (int i = 0; i < splitString.length; i++) {
			if ((splitString[i] >= 'A') && (splitString[i] <= 'Z')) {
				count++;
			}
		}
		System.out.println(count);
	}

	
	public void TC_02() {
		String textS = "Automation Testing 345 Tutorials Online 789";

		// Đếm số ký tự "a"
		String texts = textS.toLowerCase();
		char[] splitString = textS.toCharArray();
		int count = 0;
		for (int i = 0; i < splitString.length; i++) {
			if (splitString[i] == 'a') {
				count++;
			}
		}
		System.out.println(count);

		// Kiểm tra chuỗi có từ "Testing" hay không
		System.out.println(textS.contains("Testing"));

		// Kiểm tra chuỗi có bắt đầu bằng "Automation" hay không
		System.out.println(textS.startsWith("Automation"));
		
		// Kiểm tra chuỗi có kết thúc bằng "Online" hay không
		System.out.println(textS.endsWith("Online"));
		
		// Lấy vị trí của từ "Tutorials"
		System.out.println(textS.indexOf("Tutorials"));
		
		// Thay thế từ "Online" thành "Offline"
		System.out.println(textS.replace("Online","Offline"));
		
		// Đếm các ký tự là số
		
		char[] splitString1 = textS.toCharArray();
		System.out.println (splitString1.length);
		int count1 = 0;
		for (int i = 0; i < splitString1.length; i++) {
			 int num = Character.getNumericValue (splitString1[i]);
			if (num >= 0 && num <= 9) {
				System.out.println ("Ký tự là số: " +splitString1[i]);
				count1++;
			}
		}
		System.out.println("Số lượng ký tự là số: " +count1);
	}
	
	@Test
	public void TC_03() {
		// Đảo ngược chuỗi ký tự
		Scanner scan = new Scanner(System.in);
		String t = scan.nextLine();
		char[] splitString1 = t.toCharArray();
		for (int i = splitString1.length-1; i >=0; i--) {
			System.out.print(splitString1[i]);
		}
	}
}
