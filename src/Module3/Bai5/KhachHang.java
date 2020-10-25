package Module3.Bai5;

import java.text.*;
import java.time.*;
import java.time.format.*;

public class KhachHang {
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
			maKH = "";
		this.maKH = maKH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		if (hoTen.length() == 0)
			hoTen = "";
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

	public KhachHang(String maKH, String hoTen, LocalDate ngayLapHD, int soKW,
			double donGia) {
		setMaKH(maKH);
		setHoTen(hoTen);
		setNgayLapHD(ngayLapHD);
		setSoKW(soKW);
		setDonGia(donGia);
	}

	public KhachHang() {
		this("", "", LocalDate.now(), 0, 0.0f);
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00");
		DecimalFormat df2 = new DecimalFormat("#,##0");
		return String.format("%-10s %-25s %-12s %-7s %-12s ", maKH, hoTen, dtf.format(ngayLapHD), df2.format(soKW), df.format(donGia));
	}
}
