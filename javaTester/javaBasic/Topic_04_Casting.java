package javaBasic;

public class Topic_04_Casting {

	// Ép kiểu ngầm định: Từ kiểu bé sang kiểu lớn , không mất dữ liệu
	public static void main(String[] args) {
		byte bNumber = 126;
		System.out.println(bNumber);
		
		short sNumber = bNumber;
		System.out.println(sNumber);
		
		int iNumber = sNumber;
		System.out.println(iNumber);
		
		long lNumber = iNumber;
		System.out.println(lNumber);
		
		float fNumber = lNumber;
		System.out.println(fNumber);
		
		double dNumber = fNumber;
		System.out.println(dNumber);
		
		
		// Kiểu tường minh: Từ kiểu lớn về kiểu bé, có thể mất dữ liệu
		double dNumber1 = 1256465465;
		System.out.println(dNumber1);
		int fNumber1 = (int) dNumber;
		System.out.println(fNumber1);
	}
}
