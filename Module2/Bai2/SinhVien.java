package Module2.Bai2;

public class SinhVien {
	private int maSV;
	private String hoTen;
	private float diemLT, diemTH;
	
	public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
		super();
		setMaSV(maSV);
		setHoTen(hoTen);
		setDiemLT(diemLT);
		setDiemTH(diemTH);
	}

	public SinhVien() {
		this(0, "", 0.0f, 0.0f);
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		if(maSV < 0)
			maSV = 0;
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public float getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(float diemLT) {
		if(diemLT >= 0 && diemLT <= 10)
			this.diemLT = diemLT;
		else
			this.diemLT = 0;
	}

	public float getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(float diemTH) {
		if(diemTH >= 0 && diemTH <= 10)
			this.diemTH = diemTH;
	}
	
	public float tinhDiemTB()
	{
		return (diemLT + diemTH)/2;
	}
	
	public static String tieuDe()
	{
		return String.format("%-15s %-23s %-12s %-12s %-12s", "Mã SV", "Họ và Tên", "Điểm LT", "Điểm TH", "Điêm TB");
	}
	
	public String toString()
	{
		return String.format("%-15s %-20s %9.2f %12.2f %12.2f", maSV, hoTen, diemLT, diemTH, tinhDiemTB());
	}
}
