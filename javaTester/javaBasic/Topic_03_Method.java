package javaBasic;

public class Topic_03_Method {

	
	/* 
	 * Thực hiện một chức năng cụ thể của chương trình
	 * Có thể trả về dữ liệu hoặc không
	 * Giúp code dễ đọc, dễ bảo trì, tái sử dụng được, tránh dư thừa bộ nhớ
	 * Có thể gọi đi gọi lại nhiều lần - tái sử dụng
	 * Không cần viết nhiều dòng code
	 * Dễ debug
	*/
	
	/*
	 * Khai báo:
	 * Access modifier: public/private/protected/default
	 * Return Type: Kiểu dữ liệu trả về (có hoặc không)
	 * Method name: Camel case (viết thường chữ cái đầu tiên, các chữ cái sau viết hoa). Ex: getNumber, clickToElement, moveToElement
	 * Parameter List: Tham số truyền vào
	 * Method body: Xử lý code
	 * Exception: Exception trả về
	 * 
	 */
	
	
	int a = 3;
	int b = 5;
	public int sumNumber() {
		return a+b;
	}
}
