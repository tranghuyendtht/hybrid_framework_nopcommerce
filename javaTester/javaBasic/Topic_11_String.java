package javaBasic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_11_String {

	static // Khởi tạo kiểu nguyên thủy
	String stdName = "Doãn Thị Huyền Trang";
	static String textID = "id=Doãn Thị Huyền Trang";
	static String textCSS = "css=Doãn Thị Huyền Trang";
	static String textXpath = "xpath=Doãn Thị Huyền Trang";
	static String textclass = "class=Doãn Thị Huyền Trang";
	// Khởi tạo kiểu đối tượng
	String stdName1 = new String("Doãn Thị Huyền Trang");

	public static void main(String[] args) {
		
		// Chuỗi con từ vị trí thứ X
		String subString = textID.substring(3);
		System.out.println(subString);
		String subString1 = textCSS.substring(4);
		System.out.println(subString1);
		String subString2 = textXpath.substring(6);
		System.out.println(subString2);
		String subString3 = textclass.substring(6);
		System.out.println(subString3);
		System.out.println(getByLocator(textclass));
		
		
		
	}
	private static By getByLocator (String locatorType) {
		 By by = null;
		 if(locatorType.startsWith("id=")||locatorType.startsWith("Id=")||locatorType.startsWith("ID=")) {
			 locatorType = locatorType.substring(3);
			 by = by.id(locatorType);
		 } else if (locatorType.startsWith("css=")||locatorType.startsWith("Css=")||locatorType.startsWith("CSS=")) {
			 locatorType = locatorType.substring(4);
			 by = by.cssSelector(locatorType);
		 } else if (locatorType.startsWith("xpath=")||locatorType.startsWith("XPath=")||locatorType.startsWith("XPATH=")) {
			 locatorType = locatorType.substring(6);
			 by = by.xpath(locatorType);
		 } else if (locatorType.startsWith("name=")||locatorType.startsWith("Name=")||locatorType.startsWith("NAME=")) {
			 locatorType = locatorType.substring(5);
			 by = by.name(locatorType);
		 } else if (locatorType.startsWith("class=")||locatorType.startsWith("Class=")||locatorType.startsWith("CLASS=")) {
			 locatorType = locatorType.substring(6);
			 by = by.className(locatorType);
		 } else {
			 throw new RuntimeException("Locator type is not supported");
		 }
		 return by;
	 }
	
}
