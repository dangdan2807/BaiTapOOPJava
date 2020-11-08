package Module4.Bai5;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class KHVietNam extends KhachHang {
	private String doiTuong;
	private int dinhMuc;

	public String getDoiTuong() {
		return doiTuong;
	}

	public void setDoiTuong(String doiTuong) {
		if (doiTuong.equalsIgnoreCase("sinh hoat") || doiTuong.equalsIgnoreCase("sinh hoạt")
				|| doiTuong.equalsIgnoreCase("kinh doanh") || doiTuong.equalsIgnoreCase("san xuat")
				|| doiTuong.equalsIgnoreCase("sản xuất"))
			this.doiTuong = doiTuong;
		else
			this.doiTuong = "sinh hoạt";
	}

	public int getDinhMuc() {
		return dinhMuc;
	}

	public void setDinhMuc(int dinhMuc) {
		if (dinhMuc < 0)
			dinhMuc = 0;
		this.dinhMuc = dinhMuc;
	}

	public KHVietNam(String maKH, String hoTen, LocalDate ngayLapHD, int soKW, double donGia, String doiTuong,
			int dinhMuc) {
		super(maKH, hoTen, ngayLapHD, soKW, donGia);
		setDoiTuong(doiTuong);
		setDinhMuc(dinhMuc);
	}

	public KHVietNam() {
		this("", "", LocalDate.now(), 0, 0.0, "", 0);
	}

	@Override
	public double thanhTien() {
		double tien = 0;
		if (soKW <= dinhMuc)
			tien = soKW * donGia;
		else {
			int soKWVuot = soKW - dinhMuc;
			tien = (soKW * donGia * dinhMuc) + (soKWVuot * donGia * 2.5);
		}
		return (double) tien;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.## VND");
		DecimalFormat df2 = new DecimalFormat("#,##0");
		return super.toString()
				+ String.format("%-23s %-10s %-15s", doiTuong, df2.format(dinhMuc), df.format(thanhTien()));
	}
}
