package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_DataType_Exercise {
	int number = 8;

	@Test
	public void TC_01_Primitive () {
		// Thực hành kiểu nguyên thủy
		int x = 10;
		int y = x;
		System.out.println("Before: " + x);
		System.out.println("Before: " + y);
		
		y = 8;
		System.out.println("After: " + x);
		System.out.println("After: " + y);
	}
	@Test
	public void TC_02_Reference () {
		
		Topic_02_DataType_Exercise variable_1 = new Topic_02_DataType_Exercise();
		Topic_02_DataType_Exercise variable_2 = variable_1;
		System.out.println("Before: " + variable_1.number);
		System.out.println("Before: " + variable_2.number);
		
		variable_2.number = 10;
		System.out.println("After: " + variable_1.number);
		System.out.println("After: " + variable_2.number);
		
	}
	
	@Test
	public void TC_03_Exercise () {
		int a = 6;
		int b = 2;
		System.out.println("Tổng: " + (a+b));
		System.out.println("Hiệu: " + (a-b));
		System.out.println("Tích: " + (a*b));
		System.out.println("Thương: " + (a/b));
	}
	
	@Test
	public void TC_04_Exercise () {
		float length = 7.5f;
		float width = 3.8f;
		System.out.println("Diện tích HCN là: " + (length*width));
		
	}
	
	@Test
	public void TC_05_Exercise () {
		String textWelcome = "Automation Testing";
		System.out.println("Hello " + textWelcome);
		
	}
}

