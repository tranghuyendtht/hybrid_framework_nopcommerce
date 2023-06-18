package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_Break_Continue {
	
	public void TC_01() {
		Scanner scan = new Scanner (System.in);
		int iMonth;
		iMonth = scan.nextInt();
		switch (iMonth) {
		case 1:
			System.out.println("JAN");
			break;
		case 2:
			System.out.println("FEB");
			break;
		case 3:
			System.out.println("MAR");
			break;
		case 4:
			System.out.println("APR");
			break;
		case 5:
			System.out.println("MAY");
			break;
		case 6:
			System.out.println("JUN");
			break;
		case 7:
			System.out.println("JUL");
			break;
		case 8:
			System.out.println("AUG");
			break;
		case 9:
			System.out.println("SEP");
			break;
		case 10:
			System.out.println("OCT");
			break;
		case 11:
			System.out.println("NOV");
			break;
		case 12:
			System.out.println("DEC");
			break;

		default:
			break;
		}
	}
	
	@Test
	public void TC_02() {
		Scanner scan = new Scanner (System.in);
		String browserName;
		browserName = scan.nextLine();

		switch (browserName) {
		case "Chrome":
			System.out.println("Chrome");
			break;
		case "Firefox":
			System.out.println("Firefox");
			break;
		case "Edge":
			System.out.println("Edge");
			break;
		case "IE":
			break;
		case "Safari":
			System.out.println("Safari");	
			break;
		default:
			break;
		}
}
}
