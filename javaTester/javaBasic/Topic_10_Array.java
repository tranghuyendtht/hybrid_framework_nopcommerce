package javaBasic;

import java.io.File;
import java.util.Arrays;

import org.testng.annotations.Test;


public class Topic_10_Array {

	public void TC_01() {

		// In ra phần tử lớn nhất trong mảng
		int[] iNum = { 2, 1, 40, 21, 10, 7, 8, 9 };
		Arrays.sort(iNum);
		System.out.println(iNum[iNum.length - 1]);
	}

	public void TC_02() {
		// In ra tổng phần tử đầu tiên và cuối cùng trong mảng
		int[] iNum = { 2, 1, 40, 21, 10, 7, 8, 9 };
		System.out.println("Tổng: " + (iNum[0] + iNum[iNum.length - 1]));
	}

	public void TC_03() {
		// In ra các số chẵn
		int[] iNum = { 2, 1, 40, 21, 10, 7, 8, 9 };
		for (int i = 0; i < iNum.length; i++) {
			if (iNum[i] % 2 == 0) {
				System.out.print(iNum[i] + " ");
			}
		}

	}

	public void TC_04() {
		// In ra các số lẻ và nguyên dương
		int[] iNum = { -2, 1, -40, 21, 10, -7, 8, 9 };
		int sum = 0;
		for (int i = 0; i < iNum.length; i++) {
			if ((iNum[i] % 2 != 0) && (iNum[i] >= 0)) {
				System.out.print(iNum[i] + " ");
				sum += iNum[i];
			}
		}
		System.out.print("Tổng: " + sum);

	}

	public void TC_05() {
		// In ra các >0 và <10
		int[] iNum = { -2, 1, -40, 21, 10, -7, 8, 9 };
		for (int i = 0; i < iNum.length; i++) {
			if (iNum[i] > 0 && iNum[i] < 10) {
				System.out.print(iNum[i] + " ");
			}
		}
	}

	// @Test
	public void TC_06() {
		// In ra tổng và trung bình cộng của các số trong mảng
		int[] iNum = { -2, 1, 40, 21, 10, -7, 8, 9 };
		int sum = 0;
		for (int i = 0; i < iNum.length; i++) {
			sum += iNum[i];

		}
		System.out.println("Tổng: " + sum);
		System.out.println("Trung bình cộng: " + sum / iNum.length);
	}

	@Test
	public void TC_07() {
		String[] fileNames = {"Dress_1.jpg", "Dress_2.jpg", "Dress_3.jpg"};
		
		String filePath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;

		String fullFileName = "";
		for (String fileName : fileNames) {
			fullFileName = fullFileName + filePath + fileName + "\n";
		}
		fullFileName = fullFileName.trim();
		System.out.println(fullFileName);
	}

}