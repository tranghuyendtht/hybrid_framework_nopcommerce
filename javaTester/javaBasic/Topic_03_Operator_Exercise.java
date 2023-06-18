package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_03_Operator_Exercise {

	String name;
	int year;

	@Test
	public void TC_01() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Mời bạn nhập vào tên: ");
		name = scan.nextLine();

		System.out.println("Mời bạn nhập vào tuổi: ");
		year = scan.nextInt();
		System.out.println("Sau 15 năm, tuổi của " + name + " là " + (year + 15));
	}

	@Test
	public void TC_02() {
		int a = 4;
		int b = 9;

		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("Giá trị của a là: " + a);
		System.out.println("Giá trị của b là: " + b);
	}

	@Test
	public void TC_03() {
		int a;
		int b;
		Scanner scan = new Scanner(System.in);

		System.out.println("Mời bạn nhập vào số thứ nhất: ");
		a = scan.nextInt();

		System.out.println("Mời bạn nhập vào số thứ hai: ");
		b = scan.nextInt();
		
		if(a>b) {
			System.out.println("true");
		} else
		{
			System.out.println("false");
		}
	}
}
