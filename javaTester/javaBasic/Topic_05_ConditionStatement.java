package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_05_ConditionStatement {

	public void TC_01() {
		int iNumber;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập số nguyên bất kỳ: ");
		iNumber = scan.nextInt();

		if (iNumber % 2 == 0) {
			System.out.println(iNumber + " là số chẵn.");
		} else {
			System.out.println(iNumber + " là số lẻ.");
		}

	}

	
	public void TC_02() {
		int iNumber1, iNumber2;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập số nguyên thứ nhất: ");
		iNumber1 = scan.nextInt();
		System.out.println("Nhập số nguyên thứ hai: ");
		iNumber2 = scan.nextInt();

		if (iNumber1 > iNumber2) {
			System.out.println(iNumber1 + " lớn hơn " + iNumber2);
		} else if (iNumber1 < iNumber2) {
			System.out.println(iNumber1 + " nhỏ hơn " + iNumber2);
		} else if (iNumber1 == iNumber2) {
			System.out.println(iNumber1 + " bằng" + " " + iNumber2);
		}
	}
	
	
	public void TC_03() {
		String sName1, sName2;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tên người thứ nhất: ");
		sName1 = scan.nextLine();
		System.out.println("Nhập tên người thứ hai: ");
		sName2 = scan.nextLine();
		
		if(sName1.equals(sName2)) {
			System.out.println("Hai người cùng tên");
		} else {
			System.out.println("Hai người khác tên");
		}
	}
	
	
	public void TC_04() {
		int iNumber1, iNumber2, iNumber3;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nhập số nguyên thứ nhất: ");
		iNumber1 = scan.nextInt();
		System.out.println("Nhập số nguyên thứ hai: ");
		iNumber2 = scan.nextInt();
		System.out.println("Nhập số nguyên thứ ba: ");
		iNumber3 = scan.nextInt();
		
		if (iNumber1>iNumber2 && iNumber1>iNumber3) {
			System.out.println(iNumber1+ " lớn nhất");
		} else if(iNumber2>iNumber3) {
			System.out.println(iNumber2+ " lớn nhất");
		} else {
			System.out.println(iNumber3+ " lớn nhất");
		}
	}
	
	public void TC_05() {
		int iNumber1;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nhập số nguyên: ");
		iNumber1 = scan.nextInt();
		
		if (iNumber1>=10 && iNumber1<=100) {
			System.out.println(iNumber1+ " thuộc [10,100] ");
		} else {
			System.out.println(iNumber1+ " không thuộc [10,100] ");
		}
	}
	
	@Test
	public void TC_06() {
		float fNumber;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nhập số điểm: ");
		fNumber = scan.nextFloat();
		
		if(fNumber>0 && fNumber<=5) {
			System.out.println("Điểm D");
		} else if(fNumber>5 && fNumber<=7.5) {
			System.out.println("Điểm C");
		} else if(fNumber>7.5 && fNumber<=8.5) {
			System.out.println("Điểm B");
		} else if(fNumber>8.5  && fNumber<=10) {
			System.out.println("Điểm A");
		} else {
			System.out.println("Số điểm không hợp lệ");
		}
	}
}
