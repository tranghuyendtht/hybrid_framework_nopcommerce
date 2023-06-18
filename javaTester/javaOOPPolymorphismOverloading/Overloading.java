package javaOOPPolymorphismOverloading;

public class Overloading {
	
	/* Nạp chồng:
	// Một class có nhiều method tên giống nhau, khác nhau về kiểu hoặc số lượng tham số truyền vào
	// Đa hình trong lúc Compiler 
	//- Lúc viết code (Nghĩa là khi viết code, trình biên dịch hiểu mình đang lựa chọn method nào để ấn định và chọn luôn chức năng của method đó
	 * 
	 */
	public void run() {
		System.out.println("Run 1");
	}

	public void run(String a) {
		System.out.println("Run " + a);
	}

	public void run(String a, int b) {
		System.out.println("Run " + a + b + "year!");
	}

	public static void main(String[] args) {

		Overloading ove = new Overloading();
		ove.run();
		ove.run("Lu");
	}

}
