package Module2.Bai4;

public class Xe {
	private String chuXe;
	private String loaiXe;
	private long triGiaXe;
	private int dungTich;

	public Xe() {
		super();
	}

	public Xe(String chuXe, String loaiXe, long triGiaXe, int dungTich) {
		super();
		this.chuXe = chuXe;
		this.loaiXe = loaiXe;
		setTriGiaXe(triGiaXe);
		setDungTich(dungTich);
	}

	public String getChuXe() {
		return chuXe;
	}

	public void setChuXe(String chuXe) {
		this.chuXe = chuXe;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public long getTriGiaXe() {
		return triGiaXe;
	}

	public void setTriGiaXe(long triGiaXe2) {
		if (triGiaXe2 < 0)
			triGiaXe2 = 0;
		this.triGiaXe = triGiaXe2;
	}

	public int getDungTich() {
		return dungTich;
	}

	public void setDungTich(int dungTich) {
		if (dungTich < 0)
			dungTich = 0;
		this.dungTich = dungTich;
	}

	public double tinhThue() {
		double thue = 0;
		if (dungTich < 100)
			thue = triGiaXe * 0.01;
		else if (dungTich >= 100 && dungTich <= 200)
			thue = triGiaXe * 0.03;
		else if (dungTich > 200)
			thue = triGiaXe * 0.05;
		return thue;
	}

	public static String TieuDe() {
		return String.format("%-20s %-15s %-15s %-15s %-15s", "Ten Chu Xe", "Loai Xe", "Dung Tich", "Tri Gia",
				"Thue phai nop");
	}

	public String toString() {
		return String.format("%-20s %-15s %10d %15d %15.2f", chuXe, loaiXe, dungTich, triGiaXe, tinhThue());
	}
}
