package javaBasic;

public class Topic_01_Class_Object {

	private int maSV;
	private String name;
	private float lT;
	private float tH;
	
	
	// Hàm constructor
	public Topic_01_Class_Object(int maSV, String name, float lT, float tH) {
		super();
		this.maSV = maSV;
		this.name = name;
		this.lT = lT;
		this.tH = tH;
	}
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getLT() {
		return lT;
	}
	public void setLT(float lT) {
		lT = lT;
	}
	public float getTH() {
		return tH;
	}
	public void setTH(float tH) {
		tH = tH;
	}
	protected float avgScore(float lT, float tH) {
		return (float) ((lT +tH*2)/3);
	}
	
	protected void showInforSV() {
		System.out.println("Mã SV: " + getMaSV());
		System.out.println("Tên SV: " + getName());
		System.out.println("Điểm LT: " + getLT());
		System.out.println("Điểm TH: " + getTH());
		System.out.println("Điểm trung bình:  " + avgScore(getLT(),getTH()));
		System.out.println("-------------------------------------------");
	}
	
	public static void main(String[] args) {
		Topic_01_Class_Object sv1 = new Topic_01_Class_Object(100, "Trang", 7.7f, 5.5f);
		sv1.showInforSV();
		Topic_01_Class_Object sv2 = new Topic_01_Class_Object(200, "Hiếu", 8, 10);
		sv2.showInforSV();
		Topic_01_Class_Object sv3 = new Topic_01_Class_Object(300, "Dũng", 10, 10);
		sv3.showInforSV();
		
	}
	
	
}
