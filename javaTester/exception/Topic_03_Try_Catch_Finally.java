package exception;

import org.testng.annotations.Test;

public class Topic_03_Try_Catch_Finally {

	/*
	 * 1. Khi 1 exception xảy ra trong khối lệnh try, nếu nó được ném vào catch thì
	 * chương trình sẽ vẫn chạy tiếp mà không bị dừng lại 2. 1 Try có thể có nhiều
	 * Catch hoặc không có Catch nào 3. Tại một thời điểm/1 lần run code thì chỉ 1
	 * exception được thực hiện ~ 1 khối catch được chạy 4. Khối lệnh trong finally
	 * luôn luôn được thực hiện. 1 try không có quá 1 finally 5. Finally được thực
	 * hiện để chèn lệnh "clean-up" vào chương trình như: + Đóng file + Đóng kết nối
	 * + Đóng kết nối DB + Clean data + Quit Browser Lưu ý: - Trường hợp mở 1 file
	 * để thao tác thì dù có xảy ra exception hay không thì cũng cần phải đóng file
	 * để trả lại file cho các chương trình khác xử dụng
	 *
	 */

	 @Test
	public void TC_01_catch1() {
		// Cách 1: Ghép 2 exception trong 1 catch
		try {
			int array[] = new int[10];
			array[10] = 30 / 1;
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			// In ra messsage của exception
			System.out.println(e.getMessage());

			// In ra tên của exception + message + các dòng log StackTrace
			e.printStackTrace();
			
			// toString: In ra tên lớp + nội dung message
			System.out.println(e.toString());
		}

	}

	//@Test
	public void TC_02_catch2() {
		// Cách 2: Tách riêng các exception
		try {
			int a[] = new int[5];
			a[5] = 30 / 0;
			
		} catch (ArithmeticException e) {
			e.printStackTrace();
			
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		System.out.println("Finish!");

	}

}
