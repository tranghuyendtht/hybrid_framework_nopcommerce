package javaBasic;



public class Topic_02_Data_Type {

	// Kiểu dữ liệu nguyên thủy
	
	boolean sex = true;
	byte student;
	char std = 'c';
	short x;
	int stdNumber = 23;
	long stdNumberl = 34332;
	float stdHight = 1.57f;
	double stdHightd = 1.57d;
	
	
	// Kiểu dữ liệu tham chiếu: Là sự kết hợp của nhiều kiểu nguyên thủy với nhau + Có phương thức/hàm đi kèm
	static String stdAddress = "xóm ĐỒng";
	
	String[] stdClass = {"1","2"};
	Topic_02_Data_Type t;
	// Interface
	// Collection: Hash, map, list, set
	public static void main (String[] args) {
		stdAddress.concat("");  //Có phương thức/hàm đi kèm
		
	// Cách thức lưu trữ dữ liệu:
		// Kiểu nguyên thủy: Lưu trong chính bản thân nó (vùng nhớ Stack)
		// Kiểu tham chiếu: Lưu trữ vùng nhớ chứa giá trị mà nó tham chiếu đến (vùng nhớ Heap)
	}

}
