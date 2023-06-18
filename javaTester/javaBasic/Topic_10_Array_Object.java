package javaBasic;

public class Topic_10_Array_Object {

	String idStd;
	String nameStd;
	int ageStd;
	float scoreStd;
	
	// Hàm khởi tạo giá trị
	public Topic_10_Array_Object(String idStd, String nameStd,int ageStd, float scoreStd) {
		this.idStd = idStd;
		this.nameStd = nameStd;
		this.ageStd = ageStd;
		this.scoreStd = scoreStd;
	}
	
	// Phương thức display in ra console
	public void display() {
		System.out.println("Id:" + idStd);
		System.out.println("Name:" + nameStd);
		System.out.println("Age:" + ageStd);
		System.out.println("Score:" + scoreStd);
	}
	
	public static void main(String[] args) {
		Topic_10_Array_Object[] std = new Topic_10_Array_Object[3];
		std[0] = new Topic_10_Array_Object("123", "Trang", 18, 9.5f);
		std[1] = new Topic_10_Array_Object("12345", "Dũng", 18, 10f);
		std[2] = new Topic_10_Array_Object("1233334534", "Hiếu", 20, 9.5f);
		for(int i = 0; i<3; i++) {
			std[i].display();
		}
	}
}