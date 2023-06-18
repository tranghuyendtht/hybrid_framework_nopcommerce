package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_Switch_Case {

	
	public void TC_01() {
		int iNum = 0;
		Scanner scan = new Scanner(System.in);
		iNum = scan.nextInt();
		
		switch (iNum) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;

		default:
			System.out.println("Số nhập ngoài khoảng");
			break;
		}
	}
	

	@Test
	public void TC_02() {
		String sString;
		int iNum1, iNum2;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập số nguyên thứ nhất: ");
		iNum1 = scan.nextInt();
		System.out.println("Nhập số nguyên thứ hai: ");
		iNum2 = scan.nextInt();
		System.out.println("Nhập toán tử: ");
		sString = scan.next();
		
		switch (sString) {
		case "+":
			System.out.println("Tổng: " + (iNum1+iNum2));
			break;
		case "-":
			System.out.println("Hiệu: " + (iNum1-iNum2));
			break;
		case "*":
			System.out.println("Tích: " + (iNum1*iNum2));
			break;
		case "/":
			System.out.println("Thương: " + (iNum1/iNum2));
			break;

		default:
			System.out.println("Không hợp lệ");
			break;
		}
	}
}
