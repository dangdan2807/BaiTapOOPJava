package Module4.Bai5;

import java.text.*;
import java.time.*;
import java.time.format.*;

public abstract class KhachHang {
	protected String maKH;
	protected String hoTen;
	protected LocalDate ngayLapHD;
	protected int soKW;
	protected double donGia;

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		if (maKH.length() == 0)
			maKH = "Chưa xác định";
		this.maKH = maKH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		if (hoTen.length() == 0)
			hoTen = "Chưa xác định";
		this.hoTen = hoTen;
	}

	public LocalDate getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(LocalDate ngayLapHD) {
		if (ngayLapHD.isAfter(LocalDate.now()))
			ngayLapHD = LocalDate.now();
		this.ngayLapHD = ngayLapHD;
	}

	public int getSoKW() {
		return soKW;
	}

	public void setSoKW(int soKW) {
		if (soKW < 0)
			soKW = 0;
		this.soKW = soKW;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if (donGia < 0)
			donGia = 0;
		this.donGia = donGia;
	}

	public KhachHang(String maKH, String hoTen, LocalDate ngayLapHD, int soKW, double donGia) {
		setMaKH(maKH);
		setHoTen(hoTen);
		setNgayLapHD(ngayLapHD);
		setSoKW(soKW);
		setDonGia(donGia);
	}

	public KhachHang() {
		this("", "", LocalDate.now(), 0, 0.0f);
	}

	public abstract double thanhTien();

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.##");
		return String.format("%-16s %-23s %-12s %-7s %-12s ", maKH, hoTen, dtf.format(ngayLapHD), df.format(soKW),
				df.format(donGia));
	}
}
