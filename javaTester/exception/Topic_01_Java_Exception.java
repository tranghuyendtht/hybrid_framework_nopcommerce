package exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

public class Topic_01_Java_Exception {

	//@Test
	public void TC_01_NullPoiterException() {
		
		// Con chỏ đang chỏ tới một giá trị rỗng
		String name = null;
		System.out.println(name);
	}
	
	//@Test
	public void TC_02_NumberFormatException() {
		
		// Lỗi định dạng kiểu số
		
		// FAIL
		String name = "";
		int num = Integer.parseInt(name);
		System.out.println(num);
		
		
		// PASS
		int i = Integer.parseInt("10");
		System.out.println(i);
		
		// FAIL
		float f = Float.parseFloat("4.5a");
		System.out.println(f);
	}
	
	@Test
	public void TC_03_ArrayIndexOutOfBound() {
		
		// Lỗi vượt ngoài phạm vi của mảng
		String[] stdName = {"Hiếu", "Trang"};
		System.out.println(stdName[3]);
	}
	
	@Test
	public void TC_04_FileNotFoundException() throws IOException {
		
		// Không tìm thấyl file. File Not Found Exception thuộc cả Java Exception và Checked và Unchecked
		File file = new File("E:\\TrangDTH\\automation.jpg");
		FileReader fr = new FileReader(file);
		fr.close();
		
	}
}
