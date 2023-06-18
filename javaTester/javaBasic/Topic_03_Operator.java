package javaBasic;

public class Topic_03_Operator {

	public static void main( String[] args) {
		int firstV = 5;
		int secondV = 7;
		int result = firstV++ + ++secondV - 8;
		
		
		// Các bước thực hiện:
		// 1. Ưu tiên xử lý prefix trước ++secondV
		// 2. THực hiện tính toán phép toán result
		// 3. Gán kết quả cho result
		// 4. Xử lý postfix firstV++
		
		System.out.println("FirstV: " + firstV );
		System.out.println("SecondV: " + secondV );
		System.out.println("Result: " + result );
	}
}
