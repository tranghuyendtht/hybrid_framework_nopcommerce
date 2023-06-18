package javaBasic;

import java.util.Iterator;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_For_ForEach {
	Scanner scan = new Scanner(System.in);

	public void TC_01() {

		int iNum = scan.nextInt();

		for (int i = 1; i <= iNum; i++) {
			System.out.print(i + " ");

		}
	}

	public void TC_02() {
		int a = scan.nextInt();
		int b = scan.nextInt();

		for (int i = a; i <= b; i++) {

			System.out.print(i + " ");
		}

	}

	public void TC_03() {

		int count = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				count++;
			}
		}
		System.out.println(count);
	}

	public void TC_04() {
		int a = scan.nextInt();
		int b = scan.nextInt();
		int sum = 0;
		for (int i = a; i <= b; i++) {

			sum = sum + i;
		}
		System.out.println(sum);
	}

	public void TC_05() {
		int a = scan.nextInt();
		int sum = 0;
		for (int i = 0; i <= a; i++) {
			if (i % 2 != 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	
	public void TC_06() {
		int a = scan.nextInt();
		int b = scan.nextInt();

		for (int i = a; i <= b; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}

	}

	@Test
	public void TC_07() {
		int a = scan.nextInt();
		int fact = 1;
		for (int i = 1; i <= a; i++) {
			
				fact *= i;
			
		}
		System.out.println(fact);
	}
	
}
