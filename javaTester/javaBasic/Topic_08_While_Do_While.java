package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_While_Do_While {
	Scanner scan = new Scanner(System.in);
	
	public void TC_01() {
		
		
		int iNum = scan.nextInt();

		while (iNum<=100) {
			if(iNum%2==0) {
				System.out.print(iNum +" ");
			}
			iNum++;
			
		}
	}
	
	
	public void TC_02() {
		int iNum1 = scan.nextInt();
		int iNum2 = scan.nextInt();
		while (iNum1<=iNum2) {
			if((iNum1%3==0)&&(iNum1%5==0)) {
				System.out.print(iNum1 +" ");
			}
			iNum1++;
			
		}
	}
	
	
	public void TC_03() {
		int iNum = scan.nextInt();
		
		int sum = 0;
		while (iNum>0) {
			if(iNum%2!=0) {
				System.out.print(iNum + " ");
				sum = sum +iNum;
				
			}
			iNum--;
			
		}
		System.out.println("\nTổng:"+ sum);
	}
	
	
	public void TC_04() {
		int iNum = scan.nextInt();
		int fact = 1;
		while (iNum>0) {
			
				System.out.print(iNum + " ");
				fact = fact *iNum;
				
			
			iNum--;
			
		}
		System.out.println("\nGiai thừa:"+ fact);
	}
	
	@Test
	public void TC_05() {
		int iNum =1;
		int sum = 0;
		while(iNum<=10) {
			if(iNum%2==0) {
				System.out.print(iNum + " ");
				sum +=iNum;
			}
			iNum++;
		}
		System.out.println("\nTổng:"+ sum);
	}
}
